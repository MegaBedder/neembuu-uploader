/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package nz.mega.sdk;

class MegaListener {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected MegaListener(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(MegaListener obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  protected synchronized void delete() {   
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        megaJNI.delete_MegaListener(swigCPtr);
      }
      swigCPtr = 0;
    }
}

  protected void swigDirectorDisconnect() {
    swigCMemOwn = false;
    delete();
  }

  public void swigReleaseOwnership() {
    swigCMemOwn = false;
    megaJNI.MegaListener_change_ownership(this, swigCPtr, false);
  }

  public void swigTakeOwnership() {
    swigCMemOwn = true;
    megaJNI.MegaListener_change_ownership(this, swigCPtr, true);
  }

  public void onRequestStart(MegaApi api, MegaRequest request) {
    if (getClass() == MegaListener.class) megaJNI.MegaListener_onRequestStart(swigCPtr, this, MegaApi.getCPtr(api), api, MegaRequest.getCPtr(request), request); else megaJNI.MegaListener_onRequestStartSwigExplicitMegaListener(swigCPtr, this, MegaApi.getCPtr(api), api, MegaRequest.getCPtr(request), request);
  }

  public void onRequestFinish(MegaApi api, MegaRequest request, MegaError e) {
    if (getClass() == MegaListener.class) megaJNI.MegaListener_onRequestFinish(swigCPtr, this, MegaApi.getCPtr(api), api, MegaRequest.getCPtr(request), request, MegaError.getCPtr(e), e); else megaJNI.MegaListener_onRequestFinishSwigExplicitMegaListener(swigCPtr, this, MegaApi.getCPtr(api), api, MegaRequest.getCPtr(request), request, MegaError.getCPtr(e), e);
  }

  public void onRequestUpdate(MegaApi api, MegaRequest request) {
    if (getClass() == MegaListener.class) megaJNI.MegaListener_onRequestUpdate(swigCPtr, this, MegaApi.getCPtr(api), api, MegaRequest.getCPtr(request), request); else megaJNI.MegaListener_onRequestUpdateSwigExplicitMegaListener(swigCPtr, this, MegaApi.getCPtr(api), api, MegaRequest.getCPtr(request), request);
  }

  public void onRequestTemporaryError(MegaApi api, MegaRequest request, MegaError error) {
    if (getClass() == MegaListener.class) megaJNI.MegaListener_onRequestTemporaryError(swigCPtr, this, MegaApi.getCPtr(api), api, MegaRequest.getCPtr(request), request, MegaError.getCPtr(error), error); else megaJNI.MegaListener_onRequestTemporaryErrorSwigExplicitMegaListener(swigCPtr, this, MegaApi.getCPtr(api), api, MegaRequest.getCPtr(request), request, MegaError.getCPtr(error), error);
  }

  public void onTransferStart(MegaApi api, MegaTransfer transfer) {
    if (getClass() == MegaListener.class) megaJNI.MegaListener_onTransferStart(swigCPtr, this, MegaApi.getCPtr(api), api, MegaTransfer.getCPtr(transfer), transfer); else megaJNI.MegaListener_onTransferStartSwigExplicitMegaListener(swigCPtr, this, MegaApi.getCPtr(api), api, MegaTransfer.getCPtr(transfer), transfer);
  }

  public void onTransferFinish(MegaApi api, MegaTransfer transfer, MegaError error) {
    if (getClass() == MegaListener.class) megaJNI.MegaListener_onTransferFinish(swigCPtr, this, MegaApi.getCPtr(api), api, MegaTransfer.getCPtr(transfer), transfer, MegaError.getCPtr(error), error); else megaJNI.MegaListener_onTransferFinishSwigExplicitMegaListener(swigCPtr, this, MegaApi.getCPtr(api), api, MegaTransfer.getCPtr(transfer), transfer, MegaError.getCPtr(error), error);
  }

  public void onTransferUpdate(MegaApi api, MegaTransfer transfer) {
    if (getClass() == MegaListener.class) megaJNI.MegaListener_onTransferUpdate(swigCPtr, this, MegaApi.getCPtr(api), api, MegaTransfer.getCPtr(transfer), transfer); else megaJNI.MegaListener_onTransferUpdateSwigExplicitMegaListener(swigCPtr, this, MegaApi.getCPtr(api), api, MegaTransfer.getCPtr(transfer), transfer);
  }

  public void onTransferTemporaryError(MegaApi api, MegaTransfer transfer, MegaError error) {
    if (getClass() == MegaListener.class) megaJNI.MegaListener_onTransferTemporaryError(swigCPtr, this, MegaApi.getCPtr(api), api, MegaTransfer.getCPtr(transfer), transfer, MegaError.getCPtr(error), error); else megaJNI.MegaListener_onTransferTemporaryErrorSwigExplicitMegaListener(swigCPtr, this, MegaApi.getCPtr(api), api, MegaTransfer.getCPtr(transfer), transfer, MegaError.getCPtr(error), error);
  }

  public void onUsersUpdate(MegaApi api, MegaUserList users) {
    if (getClass() == MegaListener.class) megaJNI.MegaListener_onUsersUpdate(swigCPtr, this, MegaApi.getCPtr(api), api, MegaUserList.getCPtr(users), users); else megaJNI.MegaListener_onUsersUpdateSwigExplicitMegaListener(swigCPtr, this, MegaApi.getCPtr(api), api, MegaUserList.getCPtr(users), users);
  }

  public void onNodesUpdate(MegaApi api, MegaNodeList nodes) {
    if (getClass() == MegaListener.class) megaJNI.MegaListener_onNodesUpdate(swigCPtr, this, MegaApi.getCPtr(api), api, MegaNodeList.getCPtr(nodes), nodes); else megaJNI.MegaListener_onNodesUpdateSwigExplicitMegaListener(swigCPtr, this, MegaApi.getCPtr(api), api, MegaNodeList.getCPtr(nodes), nodes);
  }

  public void onReloadNeeded(MegaApi api) {
    if (getClass() == MegaListener.class) megaJNI.MegaListener_onReloadNeeded(swigCPtr, this, MegaApi.getCPtr(api), api); else megaJNI.MegaListener_onReloadNeededSwigExplicitMegaListener(swigCPtr, this, MegaApi.getCPtr(api), api);
  }

  public MegaListener() {
    this(megaJNI.new_MegaListener(), true);
    megaJNI.MegaListener_director_connect(this, swigCPtr, swigCMemOwn, true);
  }

}
