package fsm.interpreter.fsm.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import fsm.interpreter.fsm.Buffer;
import fsm.interpreter.fsm.FSM;
import fsm.interpreter.fsm.FsmPackage;
import java.lang.Object;
import java.lang.String;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecoretools.ale.compiler.truffle.MinimalTruffleEObjectImpl;

@NodeInfo(
    description = "Buffer"
)
public class BufferImpl extends MinimalTruffleEObjectImpl.TruffleContainer implements Buffer {
  protected static final String INITIALVALUE_EDEFAULT = null;

  protected static final String NAME_EDEFAULT = null;

  protected static final String CURRENTVALUES_EDEFAULT = null;

  protected String initialValue = INITIALVALUE_EDEFAULT;

  protected String name = NAME_EDEFAULT;

  protected String currentValues = CURRENTVALUES_EDEFAULT;

  protected FSM outgoingFSM;

  protected FSM incomingFSM;

  protected BufferImpl() {
    super();
  }

  public String getInitialValue() {
    return initialValue;}

  public void setInitialValue(String initialValue) {
    this.initialValue = initialValue;}

  public String getName() {
    return name;}

  public void setName(String name) {
    this.name = name;}

  public String getCurrentValues() {
    return currentValues;}

  public void setCurrentValues(String currentValues) {
    this.currentValues = currentValues;}

  @TruffleBoundary
  public void setOutgoingFSM(FSM newOutgoingFSM) {
    if (newOutgoingFSM != outgoingFSM) {
    	NotificationChain msgs = null;
    	if (outgoingFSM != null)
    		msgs = ((InternalEObject) outgoingFSM).eInverseRemove(this, FsmPackage.FSM__INPUT_BUFFER, fsm.interpreter.fsm.FSM.class, msgs);
    	if (newOutgoingFSM != null)
    		msgs = ((InternalEObject) newOutgoingFSM).eInverseAdd(this, FsmPackage.FSM__INPUT_BUFFER, fsm.interpreter.fsm.FSM.class,
    				msgs);
    	msgs = basicSetOutgoingFSM(newOutgoingFSM, msgs);
    	if (msgs != null)
    		msgs.dispatch();
    } else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.BUFFER__OUTGOING_FSM, newOutgoingFSM, newOutgoingFSM));
  }

  @TruffleBoundary
  private NotificationChain basicSetOutgoingFSM(FSM newOutgoingFSM, NotificationChain msgsp) {
    NotificationChain msgs = msgsp;
    FSM oldOutgoingFSM = outgoingFSM;
    outgoingFSM = newOutgoingFSM;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FsmPackage.BUFFER__OUTGOING_FSM,
    			oldOutgoingFSM, newOutgoingFSM);
    	if (msgs == null)
    		msgs = notification;
    	else
    		msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public FSM getOutgoingFSM() {
    if (outgoingFSM != null && outgoingFSM.eIsProxy()) {
    	InternalEObject oldoutgoingFSM = (InternalEObject) outgoingFSM;
    	outgoingFSM = (FSM) eResolveProxy(oldoutgoingFSM);
    	if (outgoingFSM != oldoutgoingFSM) {
    		if (eNotificationRequired())
    			eNotify(new ENotificationImpl(this, Notification.RESOLVE, FsmPackage.BUFFER__OUTGOING_FSM,
    					oldoutgoingFSM, outgoingFSM));
    	}
    }
    return outgoingFSM;
  }

  @TruffleBoundary
  public void setIncomingFSM(FSM newIncomingFSM) {
    if (newIncomingFSM != incomingFSM) {
    	NotificationChain msgs = null;
    	if (incomingFSM != null)
    		msgs = ((InternalEObject) incomingFSM).eInverseRemove(this, FsmPackage.FSM__OUTPUT_BUFFER, fsm.interpreter.fsm.FSM.class, msgs);
    	if (newIncomingFSM != null)
    		msgs = ((InternalEObject) newIncomingFSM).eInverseAdd(this, FsmPackage.FSM__OUTPUT_BUFFER, fsm.interpreter.fsm.FSM.class,
    				msgs);
    	msgs = basicSetIncomingFSM(newIncomingFSM, msgs);
    	if (msgs != null)
    		msgs.dispatch();
    } else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.BUFFER__INCOMING_FSM, newIncomingFSM, newIncomingFSM));
  }

  @TruffleBoundary
  private NotificationChain basicSetIncomingFSM(FSM newIncomingFSM, NotificationChain msgsp) {
    NotificationChain msgs = msgsp;
    FSM oldIncomingFSM = incomingFSM;
    incomingFSM = newIncomingFSM;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FsmPackage.BUFFER__INCOMING_FSM,
    			oldIncomingFSM, newIncomingFSM);
    	if (msgs == null)
    		msgs = notification;
    	else
    		msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public FSM getIncomingFSM() {
    if (incomingFSM != null && incomingFSM.eIsProxy()) {
    	InternalEObject oldincomingFSM = (InternalEObject) incomingFSM;
    	incomingFSM = (FSM) eResolveProxy(oldincomingFSM);
    	if (incomingFSM != oldincomingFSM) {
    		if (eNotificationRequired())
    			eNotify(new ENotificationImpl(this, Notification.RESOLVE, FsmPackage.BUFFER__INCOMING_FSM,
    					oldincomingFSM, incomingFSM));
    	}
    }
    return incomingFSM;
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return FsmPackage.Literals.BUFFER;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case FsmPackage.BUFFER__INITIAL_VALUE:
    	setInitialValue((java.lang.String) newValue);
    return;
    case FsmPackage.BUFFER__OUTGOING_FSM:
    	setOutgoingFSM((fsm.interpreter.fsm.FSM) newValue);
    return;
    case FsmPackage.BUFFER__INCOMING_FSM:
    	setIncomingFSM((fsm.interpreter.fsm.FSM) newValue);
    return;
    case FsmPackage.BUFFER__NAME:
    	setName((java.lang.String) newValue);
    return;
    case FsmPackage.BUFFER__CURRENT_VALUES:
    	setCurrentValues((java.lang.String) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case FsmPackage.BUFFER__INITIAL_VALUE:
    	setInitialValue(INITIALVALUE_EDEFAULT);
    return;
    case FsmPackage.BUFFER__OUTGOING_FSM:
    	setOutgoingFSM((fsm.interpreter.fsm.FSM) null);
    return;
    case FsmPackage.BUFFER__INCOMING_FSM:
    	setIncomingFSM((fsm.interpreter.fsm.FSM) null);
    return;
    case FsmPackage.BUFFER__NAME:
    	setName(NAME_EDEFAULT);
    return;
    case FsmPackage.BUFFER__CURRENT_VALUES:
    	setCurrentValues(CURRENTVALUES_EDEFAULT);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case FsmPackage.BUFFER__INITIAL_VALUE:
    return getInitialValue();
    case FsmPackage.BUFFER__OUTGOING_FSM:
    return getOutgoingFSM();
    case FsmPackage.BUFFER__INCOMING_FSM:
    return getIncomingFSM();
    case FsmPackage.BUFFER__NAME:
    return getName();
    case FsmPackage.BUFFER__CURRENT_VALUES:
    return getCurrentValues();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case FsmPackage.BUFFER__INITIAL_VALUE:
    	return initialValue != INITIALVALUE_EDEFAULT;
    case FsmPackage.BUFFER__OUTGOING_FSM:
    	return outgoingFSM != null;
    case FsmPackage.BUFFER__INCOMING_FSM:
    	return incomingFSM != null;
    case FsmPackage.BUFFER__NAME:
    	return name != NAME_EDEFAULT;
    case FsmPackage.BUFFER__CURRENT_VALUES:
    	return currentValues != CURRENTVALUES_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case fsm.interpreter.fsm.FsmPackage.BUFFER__OUTGOING_FSM:
    	return basicSetOutgoingFSM(null, msgs);
    case fsm.interpreter.fsm.FsmPackage.BUFFER__INCOMING_FSM:
    	return basicSetIncomingFSM(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  @TruffleBoundary
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
      NotificationChain msgs2) {
    NotificationChain msgs = msgs2;
    switch (featureID) {

    case FsmPackage.BUFFER__OUTGOING_FSM:
    	if (outgoingFSM != null)
    		msgs = ((org.eclipse.emf.ecore.InternalEObject) outgoingFSM).eInverseRemove(this, FsmPackage.FSM__INPUT_BUFFER, FSM.class,
    				msgs);
    	return basicSetOutgoingFSM((fsm.interpreter.fsm.FSM) otherEnd, msgs);

    case FsmPackage.BUFFER__INCOMING_FSM:
    	if (incomingFSM != null)
    		msgs = ((org.eclipse.emf.ecore.InternalEObject) incomingFSM).eInverseRemove(this, FsmPackage.FSM__OUTPUT_BUFFER, FSM.class,
    				msgs);
    	return basicSetIncomingFSM((fsm.interpreter.fsm.FSM) otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  public void initialize() {
    if((this.initialValue) != (null)) {
          this.setCurrentValues(this.initialValue);
        }
        else {
          this.setCurrentValues("'empty'");
        }
        ;
  }

  public boolean bisEmpty() {
    boolean result;
    result = ((org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService.equals((org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(this.currentValues)), (0))) || (org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService.equals((this.currentValues), ("'empty'"))));
        ;
    return result;
  }

  public void enqueue(String v) {
    if(this.bisEmpty()) {
          this.setCurrentValues(v);
        }
        else {
          this.setCurrentValues(((this.currentValues) + (",")) + (v));
        }
        ;
  }

  public String dequeue() {
    String result;
    java.lang.String res = ((java.lang.String)"");
        int firstComma = ((int)this.currentValues.indexOf(","));
        if((firstComma) < (0)) {
          res = this.currentValues;
          this.setCurrentValues("'empty'");
          result = res;
        }
        else {
          res = this.currentValues.substring(0,firstComma);
          this.setCurrentValues(this.currentValues.substring((firstComma) + (1),org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(this.currentValues)));
          result = res;
        }
        ;
    return result;
  }
}
