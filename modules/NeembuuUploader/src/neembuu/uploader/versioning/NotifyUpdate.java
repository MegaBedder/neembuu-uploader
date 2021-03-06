/* 
 * Copyright (C) 2015 Shashank Tulsyan <shashaank at neembuu.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package neembuu.uploader.versioning;

import neembuu.uploader.external.CheckMajorUpdate;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import neembuu.uploader.NeembuuUploader;
import neembuu.uploader.translation.Translation;
import neembuu.uploader.utils.NULogger;

/** This class is used to display Update Notification window.
 *
 * @author vigneshwaran
 */
public class NotifyUpdate extends javax.swing.JFrame {

    /** Creates new form NotifyUpdate */
    public NotifyUpdate(float availablever, float currentver) {
        NULogger.getLogger().info("Displaying Update Notification");
        //First initialize the components
        initComponents();
        
        //Set the component relative to the main window
        setLocationRelativeTo(NeembuuUploader.getInstance());
        
        //Set the labels with the local language
        newversionLabel.setText("<html>"+ Translation.T().newversionlabel() + ": <b>" + availablever +"</b></html>");
        currentversionLabel.setText("<html>"+ Translation.T().currentversionlabel() + ": <b>" + currentver +"</b></html>");
        clickLabel.setText("<html>"+ Translation.T().clicklabel()+ ": <a href=http://neembuuuploader.sf.net>http://neembuuuploader.sf.net</a></html>");
        
        NULogger.getLogger().log(Level.INFO, "{0}Setting Editor Pane", NotifyUpdate.class.getName());
        //Set the editor pane to display the newfeatures.html page.
        try {
            htmlPane.setPage("http://www.neembuu.com/uploader/newfeatures.html");
            // http://neembuuuploader.sourceforge.net/newfeatures.html
        } catch (IOException ex) {
            Logger.getLogger(NotifyUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Pack to fit the size of the new language neatly.
        pack();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newversionLabel = new javax.swing.JLabel();
        clickLabel = new javax.swing.JLabel();
        closeButton = new javax.swing.JButton();
        currentversionLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        htmlPane = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Update notifier");
        setIconImage(Toolkit.getDefaultToolkit().getImage((getClass().getResource("/neembuuuploader/resources/Icon.png"))));

        newversionLabel.setText("Latest available version of Neembuu Uploader: ");

        clickLabel.setText("<html>Download the latest version from here: <a href=http://neembuuuploader.sf.net>http://neembuuuploader.sf.net</a></html>");
        clickLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clickLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickLabelMouseClicked(evt);
            }
        });

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        currentversionLabel.setText("Your outdated Neembuu Uploader version:");

        htmlPane.setEditable(false);
        jScrollPane1.setViewportView(htmlPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(closeButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(currentversionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
                    .addComponent(clickLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
                    .addComponent(newversionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newversionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(currentversionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(clickLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(closeButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the window
     * @param evt 
     */
    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
       dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    /**
     * Open the homepage when the label is clicked.
     * @param evt 
     */
    private void clickLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickLabelMouseClicked
        if(!Desktop.isDesktopSupported())
            return;
        try {
            NULogger.getLogger().log(Level.INFO, "{0}: Link clicked.. Opening the homepage..", getClass().getName());
            Desktop.getDesktop().browse(new URI("http://neembuu.com/uploader/downloads.html"));
            // http://neembuuuploader.sourceforge.net/
        } catch (Exception ex) {
            NULogger.getLogger().severe(ex.toString());
        }
    }//GEN-LAST:event_clickLabelMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel clickLabel;
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel currentversionLabel;
    private javax.swing.JEditorPane htmlPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel newversionLabel;
    // End of variables declaration//GEN-END:variables

}
