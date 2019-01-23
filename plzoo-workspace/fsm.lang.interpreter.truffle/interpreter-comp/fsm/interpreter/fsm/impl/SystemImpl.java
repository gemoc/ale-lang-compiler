package fsm.interpreter.fsm.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.Node.Children;
import com.oracle.truffle.api.nodes.NodeInfo;
import fsm.interpreter.fsm.Buffer;
import fsm.interpreter.fsm.FSM;
import fsm.interpreter.fsm.FsmPackage;
import fsm.interpreter.fsm.System;
import java.lang.Object;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecoretools.ale.compiler.truffle.MinimalTruffleEObjectImpl;

@NodeInfo(
    description = "System"
)
public class SystemImpl extends MinimalTruffleEObjectImpl.TruffleContainer implements System {
  protected EList<FSM> ownedFsms;

  protected EList<Buffer> ownedBuffers;

  @Children
  private Buffer[] ownedBuffersArr;

  @Children
  private FSM[] ownedFsmsArr;

  @Child
  private FSMDispatchRun dispatchFSMRun;

  protected SystemImpl() {
    super();
    this.dispatchFSMRun = fsm.interpreter.fsm.impl.FSMDispatchRunNodeGen.create(); 
  }

  @TruffleBoundary
  public EList<FSM> getOwnedFsms() {
    if(ownedFsms == null) {
    	ownedFsms = new EObjectContainmentEList<FSM>(fsm.interpreter.fsm.FSM.class, this, FsmPackage.SYSTEM__OWNED_FSMS);
    }
    return ownedFsms;
  }

  @TruffleBoundary
  public EList<Buffer> getOwnedBuffers() {
    if(ownedBuffers == null) {
    	ownedBuffers = new EObjectContainmentEList<Buffer>(fsm.interpreter.fsm.Buffer.class, this, FsmPackage.SYSTEM__OWNED_BUFFERS);
    }
    return ownedBuffers;
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return FsmPackage.Literals.SYSTEM;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case FsmPackage.SYSTEM__OWNED_FSMS:
    	getOwnedFsms().clear();
    	getOwnedFsms().addAll((java.util.Collection<? extends fsm.interpreter.fsm.FSM>) newValue);
    return;
    case FsmPackage.SYSTEM__OWNED_BUFFERS:
    	getOwnedBuffers().clear();
    	getOwnedBuffers().addAll((java.util.Collection<? extends fsm.interpreter.fsm.Buffer>) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case FsmPackage.SYSTEM__OWNED_FSMS:
    	getOwnedFsms().clear();
    return;
    case FsmPackage.SYSTEM__OWNED_BUFFERS:
    	getOwnedBuffers().clear();
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case FsmPackage.SYSTEM__OWNED_FSMS:
    return getOwnedFsms();
    case FsmPackage.SYSTEM__OWNED_BUFFERS:
    return getOwnedBuffers();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case FsmPackage.SYSTEM__OWNED_FSMS:
    	return ownedFsms != null && !ownedFsms.isEmpty();
    case FsmPackage.SYSTEM__OWNED_BUFFERS:
    	return ownedBuffers != null && !ownedBuffers.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case fsm.interpreter.fsm.FsmPackage.SYSTEM__OWNED_FSMS:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getOwnedFsms()).basicRemove(otherEnd, msgs);
    case fsm.interpreter.fsm.FsmPackage.SYSTEM__OWNED_BUFFERS:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getOwnedBuffers()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public void intialize() {
    if(this.ownedBuffersArr == null) {
        				com.oracle.truffle.api.CompilerDirectives.transferToInterpreterAndInvalidate();
        				if(this.ownedBuffers != null) this.ownedBuffersArr = this.ownedBuffers.toArray(new fsm.interpreter.fsm.Buffer[0]);
        				else this.ownedBuffersArr = new fsm.interpreter.fsm.Buffer[] {};
        				
        			};
    if(this.ownedFsmsArr == null) {
        				com.oracle.truffle.api.CompilerDirectives.transferToInterpreterAndInvalidate();
        				if(this.ownedFsms != null) this.ownedFsmsArr = this.ownedFsms.toArray(new fsm.interpreter.fsm.FSM[0]);
        				else this.ownedFsmsArr = new fsm.interpreter.fsm.FSM[] {};
        				
        			};
    for(fsm.interpreter.fsm.FSM fsm: this.ownedFsmsArr) {
          fsm.initialize();
        }
        for(fsm.interpreter.fsm.Buffer b: this.ownedBuffersArr) {
          b.initialize();
        }
        ;
  }

  public void main() {
    if(this.ownedBuffersArr == null) {
        				com.oracle.truffle.api.CompilerDirectives.transferToInterpreterAndInvalidate();
        				if(this.ownedBuffers != null) this.ownedBuffersArr = this.ownedBuffers.toArray(new fsm.interpreter.fsm.Buffer[0]);
        				else this.ownedBuffersArr = new fsm.interpreter.fsm.Buffer[] {};
        				
        			};
    if(this.ownedFsmsArr == null) {
        				com.oracle.truffle.api.CompilerDirectives.transferToInterpreterAndInvalidate();
        				if(this.ownedFsms != null) this.ownedFsmsArr = this.ownedFsms.toArray(new fsm.interpreter.fsm.FSM[0]);
        				else this.ownedFsmsArr = new fsm.interpreter.fsm.FSM[] {};
        				
        			};
    this.intialize();
        boolean anFSMRan = ((boolean)true);
        int cptr = ((int)0);
        while (((anFSMRan) && ((cptr) < (50000000)))) {
          anFSMRan = false;
          for(fsm.interpreter.fsm.FSM fsm: this.ownedFsmsArr) {
            if(!(fsm.getInputBuffer().bisEmpty())) {
              dispatchFSMRun.executeDispatch(fsm.getCachedRun(), new Object[] {});
              anFSMRan = true;
            }
            cptr = (cptr) + (1);
          }
        }
        ;
  }
}
