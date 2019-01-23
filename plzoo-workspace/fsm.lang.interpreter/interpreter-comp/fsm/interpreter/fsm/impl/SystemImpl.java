package fsm.interpreter.fsm.impl;

import fsm.interpreter.fsm.Buffer;
import fsm.interpreter.fsm.FSM;
import fsm.interpreter.fsm.FsmPackage;
import fsm.interpreter.fsm.System;
import java.lang.Object;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

public class SystemImpl extends MinimalEObjectImpl.Container implements System {
  protected EList<FSM> ownedFsms;

  protected EList<Buffer> ownedBuffers;

  protected SystemImpl() {
    super();
  }

  public EList<FSM> getOwnedFsms() {
    if(ownedFsms == null) {
    	ownedFsms = new EObjectContainmentEList<FSM>(fsm.interpreter.fsm.FSM.class, this, FsmPackage.SYSTEM__OWNED_FSMS);
    }
    return ownedFsms;
  }

  public EList<Buffer> getOwnedBuffers() {
    if(ownedBuffers == null) {
    	ownedBuffers = new EObjectContainmentEList<Buffer>(fsm.interpreter.fsm.Buffer.class, this, FsmPackage.SYSTEM__OWNED_BUFFERS);
    }
    return ownedBuffers;
  }

  protected EClass eStaticClass() {
    return FsmPackage.Literals.SYSTEM;}

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

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case FsmPackage.SYSTEM__OWNED_FSMS:
    return getOwnedFsms();
    case FsmPackage.SYSTEM__OWNED_BUFFERS:
    return getOwnedBuffers();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case FsmPackage.SYSTEM__OWNED_FSMS:
    	return ownedFsms != null && !ownedFsms.isEmpty();
    case FsmPackage.SYSTEM__OWNED_BUFFERS:
    	return ownedBuffers != null && !ownedBuffers.isEmpty();
    }
    return super.eIsSet(featureID);
  }

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
    for(fsm.interpreter.fsm.FSM fsm: this.getOwnedFsms()) {
          fsm.initialize();
        }
        for(fsm.interpreter.fsm.Buffer b: this.getOwnedBuffers()) {
          b.initialize();
        }
        ;
  }

  public void main() {
    this.intialize();
        boolean anFSMRan = ((boolean)true);
        int cptr = ((int)0);
        while (((anFSMRan) && ((cptr) < (50000000)))) {
          anFSMRan = false;
          for(fsm.interpreter.fsm.FSM fsm: this.getOwnedFsms()) {
            if(!(fsm.getInputBuffer().bisEmpty())) {
              fsm.run();
              anFSMRan = true;
            }
            cptr = (cptr) + (1);
          }
        }
        ;
  }
}
