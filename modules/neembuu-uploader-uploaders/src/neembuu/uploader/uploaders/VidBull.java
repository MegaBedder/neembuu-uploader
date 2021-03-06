/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package neembuu.uploader.uploaders;

import shashaank.smallmodule.SmallModule;
import neembuu.uploader.interfaces.Uploader;
import neembuu.uploader.interfaces.Account;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import neembuu.uploader.accounts.VidBullAccount;
import neembuu.uploader.exceptions.NUException;
import neembuu.uploader.exceptions.uploaders.NUFileExtensionException;
import neembuu.uploader.exceptions.uploaders.NUMaxFileSizeException;
import neembuu.uploader.httpclient.NUHttpClient;
import neembuu.uploader.httpclient.httprequest.NUHttpPost;
import neembuu.uploader.interfaces.UploadStatus;
import neembuu.uploader.interfaces.UploaderAccountNecessary;
import neembuu.uploader.interfaces.abstractimpl.AbstractUploader;
import neembuu.uploader.uploaders.common.FileUtils;
import neembuu.uploader.utils.NUHttpClientUtils;
import neembuu.uploader.utils.NULogger;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.util.Random;
import neembuu.uploader.uploaders.common.StringUtils;

/**
 *
 * @author Paralytic
 */
@SmallModule(
    exports={VidBull.class,VidBullAccount.class},
    interfaces={Uploader.class,Account.class},
    name="VidBull.com"
)
public class VidBull extends AbstractUploader implements UploaderAccountNecessary{
    
    VidBullAccount vidBullAccount = (VidBullAccount) getAccountsProvider().getAccount("VidBull.com");
    
    private final HttpClient httpclient = NUHttpClient.getHttpClient();
    private HttpContext httpContext = new BasicHttpContext();
    private HttpResponse httpResponse;
    private NUHttpPost httpPost;
    private String responseString;
    private Document doc;
    private String uploadURL;
    private String userType;
    private String sessionID = "";
    private String srv_tmp_url = "";
    private String uploadid_s = "";
    private String upload_fn = "";
    
    private String downloadlink = "";
    private String deletelink = "";
	private final ArrayList<String> allowedVideoExtensions = new ArrayList<String>();

    public VidBull() {
        downURL = UploadStatus.PLEASEWAIT.getLocaleSpecificString();
        delURL = UploadStatus.PLEASEWAIT.getLocaleSpecificString();
        host = "VidBull.com";
        if (vidBullAccount.loginsuccessful) {
            host = vidBullAccount.username + " | VidBull.com";
        }
        maxFileSizeLimit = 4294967296L; // 4 GB (default)
        
    }

    private void initialize() throws Exception {
        responseString = NUHttpClientUtils.getData("http://vidbull.com", httpContext);
        
        doc = Jsoup.parse(responseString);
        uploadURL = doc.select("form[name=file]").attr("action");
        srv_tmp_url = doc.select("form[name=file]").select("input[name=srv_tmp_url]").attr("value");
        sessionID = doc.select("form[name=file]").select("input[name=sess_id]").attr("value");
    }

    @Override
    public void run() {
        try {
            if (vidBullAccount.loginsuccessful) {
                userType = "reg";
                httpContext = vidBullAccount.getHttpContext();
                maxFileSizeLimit = 4294967296L; // 4 GB
            } else {
                host = "VidBull.com";
                uploadInvalid();
                return;
            }

            addExtensions();
            //Check extension
            if(!FileUtils.checkFileExtension(allowedVideoExtensions, file)){
                throw new NUFileExtensionException(file.getName(), host);
            }
			
            if (file.length() > maxFileSizeLimit) {
                throw new NUMaxFileSizeException(maxFileSizeLimit, file.getName(), host);
            }
            uploadInitialising();
            initialize();

            long uploadID;
            Random random = new Random();
            uploadID = Math.round(random.nextFloat() * Math.pow(10,12));
            uploadid_s = String.valueOf(uploadID);
            
            uploadURL = StringUtils.stringUntilString(uploadURL, "upload.cgi");
            uploadURL += "upload.cgi?upload_id=";
            uploadURL += uploadid_s + "&js_on=1&utype=" + userType + "&upload_type=file";
            // http://50.7.161.74/cgi-bin/upload.cgi?utype=reg&upload_id=
            // http://50.7.161.74/cgi-bin/
            // http://50.7.161.74/cgi-bin/upload.cgi?upload_id=
            // http://50.7.161.74/cgi-bin/upload.cgi?upload_id=318584132136&js_on=1&utype=reg&upload_type=file
            httpPost = new NUHttpPost(uploadURL);
            MultipartEntity mpEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
            mpEntity.addPart("upload_type", new StringBody("file"));
            mpEntity.addPart("sess_id", new StringBody(sessionID));
            mpEntity.addPart("srv_tmp_url", new StringBody(srv_tmp_url));
            mpEntity.addPart("file_0", createMonitoredFileBody());
            mpEntity.addPart("tos", new StringBody("1"));
            httpPost.setEntity(mpEntity);
            
            NULogger.getLogger().log(Level.INFO, "executing request {0}", httpPost.getRequestLine());
            NULogger.getLogger().info("Now uploading your file into VidBull.com");
            uploading();
            httpResponse = httpclient.execute(httpPost, httpContext);
            responseString = EntityUtils.toString(httpResponse.getEntity());
            
            System.out.println(responseString);
            doc = Jsoup.parse(responseString);
            
            //Read the links
            gettingLink();

            upload_fn = doc.select("textarea[name=fn]").val();
            if (upload_fn != null) {
                httpPost = new NUHttpPost("http://vidbull.com/");
                List<NameValuePair> formparams = new ArrayList<NameValuePair>();
                formparams.add(new BasicNameValuePair("fn", upload_fn));
                formparams.add(new BasicNameValuePair("op", "upload_result"));
                formparams.add(new BasicNameValuePair("st", "OK"));
                
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "UTF-8");
                httpPost.setEntity(entity);
                httpResponse = httpclient.execute(httpPost, httpContext);
                responseString = EntityUtils.toString(httpResponse.getEntity());
                
                System.out.println(responseString);
                doc = Jsoup.parse(responseString);
                downloadlink = doc.select("textarea").first().val();
                deletelink = doc.select("textarea").eq(3).val();
                
                NULogger.getLogger().log(Level.INFO, "Delete link : {0}", deletelink);
                NULogger.getLogger().log(Level.INFO, "Download link : {0}", downloadlink);
                downURL = downloadlink;
                delURL = deletelink;
                
                uploadFinished();
            }
        } catch(NUException ex){
            ex.printError();
            uploadInvalid();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);

            uploadFailed();
        }
    }
    
    /**
     * Add all the allowed extensions.
     * var ext_allowed='BIN|AVI|DIVX|FLV|MP4|MPEG|MKV|MPG|WMV|DIVX|vob|mov|m2v|xvid|3gp|webm|ogv|.torrent';
     */
    private void addExtensions(){
        allowedVideoExtensions.add("bin");
        allowedVideoExtensions.add("avi");
        allowedVideoExtensions.add("divx");
        allowedVideoExtensions.add("flv");
        allowedVideoExtensions.add("mp4");
        allowedVideoExtensions.add("mpeg");
        allowedVideoExtensions.add("mkv");
        allowedVideoExtensions.add("mpg");
        allowedVideoExtensions.add("wmv");
        allowedVideoExtensions.add("divx");
        allowedVideoExtensions.add("vob");
        allowedVideoExtensions.add("mov");
        allowedVideoExtensions.add("m2v");
        allowedVideoExtensions.add("xvid");
        allowedVideoExtensions.add("3gp");
        allowedVideoExtensions.add("webm");
        allowedVideoExtensions.add("ogv");
        allowedVideoExtensions.add("torrent");
    }
}
