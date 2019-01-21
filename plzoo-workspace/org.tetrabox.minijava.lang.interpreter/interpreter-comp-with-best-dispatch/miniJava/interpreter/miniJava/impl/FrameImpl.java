package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import miniJava.interpreter.miniJava.Call;
import miniJava.interpreter.miniJava.Context;
import miniJava.interpreter.miniJava.Frame;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.ObjectInstance;
import miniJava.interpreter.miniJava.Value;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecoretools.ale.compiler.truffle.MinimalTruffleEObjectImpl;

public class FrameImpl extends MinimalTruffleEObjectImpl.TruffleContainer implements Frame {
  protected Call call;

  protected ObjectInstance instance;

  protected Frame childFrame;

  protected Context rootContext;

  protected Value returnValue;

  protected FrameImpl() {
    super();
  }

  @TruffleBoundary
  public void setCall(Call newCall) {
    if (newCall != call) {
    	NotificationChain msgs = null;
    	if (call != null)
    		msgs = ((InternalEObject)call).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.FRAME__CALL, null, msgs);
    	if (newCall != null)
    		msgs = ((InternalEObject)newCall).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.FRAME__CALL, null, msgs);
    	msgs = basicSetCall(newCall, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.FRAME__CALL, newCall, newCall));
  }

  @TruffleBoundary
  public NotificationChain basicSetCall(Call newCall, NotificationChain msgs) {
    Call oldCall = call;
    call = newCall;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.FRAME__CALL, oldCall, newCall);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Call getCall() {
    return call;
  }

  @TruffleBoundary
  public void setInstance(ObjectInstance newInstance) {
    ObjectInstance oldInstance = instance;
    instance = newInstance;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.FRAME__INSTANCE, oldInstance, instance));
  }

  @TruffleBoundary
  public ObjectInstance getInstance() {
    if (instance != null && instance.eIsProxy()) {
    	InternalEObject oldinstance = (InternalEObject) instance;
    	instance = (ObjectInstance) eResolveProxy(oldinstance);
    	if (instance != oldinstance) {
    		if (eNotificationRequired())
    			eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.FRAME__INSTANCE,
    					oldinstance, instance));
    	}
    }
    return instance;
  }

  @TruffleBoundary
  public void setChildFrame(Frame newChildFrame) {
    if (newChildFrame != childFrame) {
    	NotificationChain msgs = null;
    	if (childFrame != null)
    		msgs = ((InternalEObject) childFrame).eInverseRemove(this, MiniJavaPackage.FRAME__PARENT_FRAME, miniJava.interpreter.miniJava.Frame.class, msgs);
    	if (newChildFrame != null)
    		msgs = ((InternalEObject) newChildFrame).eInverseAdd(this, MiniJavaPackage.FRAME__PARENT_FRAME, miniJava.interpreter.miniJava.Frame.class,
    				msgs);
    	msgs = basicSetChildFrame(newChildFrame, msgs);
    	if (msgs != null)
    		msgs.dispatch();
    } else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.FRAME__CHILD_FRAME, newChildFrame, newChildFrame));
  }

  @TruffleBoundary
  private NotificationChain basicSetChildFrame(Frame newChildFrame, NotificationChain msgsp) {
    NotificationChain msgs = msgsp;
    Frame oldChildFrame = childFrame;
    childFrame = newChildFrame;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniJavaPackage.FRAME__CHILD_FRAME,
    			oldChildFrame, newChildFrame);
    	if (msgs == null)
    		msgs = notification;
    	else
    		msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Frame getChildFrame() {
    return childFrame;
  }

  @TruffleBoundary
  public void setParentFrame(Frame newParentFrame) {
    if (newParentFrame != eInternalContainer() || (eContainerFeatureID() != MiniJavaPackage.FRAME__PARENT_FRAME && newParentFrame != null)) {
    	if (EcoreUtil.isAncestor(this, newParentFrame))
    		throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
    	NotificationChain msgs = null;
    	if (eInternalContainer() != null)
    		msgs = eBasicRemoveFromContainer(msgs);
    	if (newParentFrame != null)
    		msgs = ((InternalEObject)newParentFrame).eInverseAdd(this, MiniJavaPackage.FRAME__CHILD_FRAME , Frame.class, msgs);
    	msgs = basicSetParentFrame(newParentFrame, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.FRAME__PARENT_FRAME , newParentFrame, newParentFrame));
  }

  @TruffleBoundary
  public NotificationChain basicSetParentFrame(Frame newParentFrame, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newParentFrame, MiniJavaPackage.FRAME__PARENT_FRAME, msgs);
    return msgs;
  }

  @TruffleBoundary
  public Frame getParentFrame() {
    if (eContainerFeatureID() != MiniJavaPackage.FRAME__PARENT_FRAME) return null;
    return (Frame)eInternalContainer();
  }

  @TruffleBoundary
  public void setRootContext(Context newRootContext) {
    if (newRootContext != rootContext) {
    	NotificationChain msgs = null;
    	if (rootContext != null)
    		msgs = ((InternalEObject)rootContext).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.FRAME__ROOT_CONTEXT, null, msgs);
    	if (newRootContext != null)
    		msgs = ((InternalEObject)newRootContext).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.FRAME__ROOT_CONTEXT, null, msgs);
    	msgs = basicSetRootContext(newRootContext, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.FRAME__ROOT_CONTEXT, newRootContext, newRootContext));
  }

  @TruffleBoundary
  public NotificationChain basicSetRootContext(Context newRootContext, NotificationChain msgs) {
    Context oldRootContext = rootContext;
    rootContext = newRootContext;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.FRAME__ROOT_CONTEXT, oldRootContext, newRootContext);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Context getRootContext() {
    return rootContext;
  }

  @TruffleBoundary
  public void setReturnValue(Value newReturnValue) {
    if (newReturnValue != returnValue) {
    	NotificationChain msgs = null;
    	if (returnValue != null)
    		msgs = ((InternalEObject)returnValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.FRAME__RETURN_VALUE, null, msgs);
    	if (newReturnValue != null)
    		msgs = ((InternalEObject)newReturnValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.FRAME__RETURN_VALUE, null, msgs);
    	msgs = basicSetReturnValue(newReturnValue, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.FRAME__RETURN_VALUE, newReturnValue, newReturnValue));
  }

  @TruffleBoundary
  public NotificationChain basicSetReturnValue(Value newReturnValue, NotificationChain msgs) {
    Value oldReturnValue = returnValue;
    returnValue = newReturnValue;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.FRAME__RETURN_VALUE, oldReturnValue, newReturnValue);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Value getReturnValue() {
    return returnValue;
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.FRAME;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.FRAME__CALL:
    	setCall((miniJava.interpreter.miniJava.Call) newValue);
    return;
    case MiniJavaPackage.FRAME__INSTANCE:
    	setInstance((miniJava.interpreter.miniJava.ObjectInstance) newValue);
    return;
    case MiniJavaPackage.FRAME__CHILD_FRAME:
    	setChildFrame((miniJava.interpreter.miniJava.Frame) newValue);
    return;
    case MiniJavaPackage.FRAME__PARENT_FRAME:
    	setParentFrame((miniJava.interpreter.miniJava.Frame) newValue);
    return;
    case MiniJavaPackage.FRAME__ROOT_CONTEXT:
    	setRootContext((miniJava.interpreter.miniJava.Context) newValue);
    return;
    case MiniJavaPackage.FRAME__RETURN_VALUE:
    	setReturnValue((miniJava.interpreter.miniJava.Value) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.FRAME__CALL:
    	setCall((miniJava.interpreter.miniJava.Call) null);
    return;
    case MiniJavaPackage.FRAME__INSTANCE:
    	setInstance((miniJava.interpreter.miniJava.ObjectInstance) null);
    return;
    case MiniJavaPackage.FRAME__CHILD_FRAME:
    	setChildFrame((miniJava.interpreter.miniJava.Frame) null);
    return;
    case MiniJavaPackage.FRAME__PARENT_FRAME:
    	setParentFrame((miniJava.interpreter.miniJava.Frame) null);
    return;
    case MiniJavaPackage.FRAME__ROOT_CONTEXT:
    	setRootContext((miniJava.interpreter.miniJava.Context) null);
    return;
    case MiniJavaPackage.FRAME__RETURN_VALUE:
    	setReturnValue((miniJava.interpreter.miniJava.Value) null);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.FRAME__CALL:
    return getCall();
    case MiniJavaPackage.FRAME__INSTANCE:
    return getInstance();
    case MiniJavaPackage.FRAME__CHILD_FRAME:
    return getChildFrame();
    case MiniJavaPackage.FRAME__PARENT_FRAME:
    return getParentFrame();
    case MiniJavaPackage.FRAME__ROOT_CONTEXT:
    return getRootContext();
    case MiniJavaPackage.FRAME__RETURN_VALUE:
    return getReturnValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.FRAME__CALL:
    	return call != null;
    case MiniJavaPackage.FRAME__INSTANCE:
    	return instance != null;
    case MiniJavaPackage.FRAME__CHILD_FRAME:
    	return childFrame != null;
    case MiniJavaPackage.FRAME__PARENT_FRAME:
    	return getParentFrame() != null;
    case MiniJavaPackage.FRAME__ROOT_CONTEXT:
    	return rootContext != null;
    case MiniJavaPackage.FRAME__RETURN_VALUE:
    	return returnValue != null;
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case miniJava.interpreter.miniJava.MiniJavaPackage.FRAME__CALL:
    	return basicSetCall(null, msgs);
    case miniJava.interpreter.miniJava.MiniJavaPackage.FRAME__CHILD_FRAME:
    	return basicSetChildFrame(null, msgs);
    case miniJava.interpreter.miniJava.MiniJavaPackage.FRAME__PARENT_FRAME:
    	return basicSetParentFrame(null, msgs);
    case miniJava.interpreter.miniJava.MiniJavaPackage.FRAME__ROOT_CONTEXT:
    	return basicSetRootContext(null, msgs);
    case miniJava.interpreter.miniJava.MiniJavaPackage.FRAME__RETURN_VALUE:
    	return basicSetReturnValue(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  @TruffleBoundary
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
      NotificationChain msgs2) {
    NotificationChain msgs = msgs2;
    switch (featureID) {

    case MiniJavaPackage.FRAME__CHILD_FRAME:
    	if (childFrame != null)
    		msgs = ((org.eclipse.emf.ecore.InternalEObject) childFrame).eInverseRemove(this, MiniJavaPackage.FRAME__PARENT_FRAME, Frame.class,
    				msgs);
    	return basicSetChildFrame((miniJava.interpreter.miniJava.Frame) otherEnd, msgs);

    case MiniJavaPackage.FRAME__PARENT_FRAME:
    	if (eInternalContainer() != null)
    			msgs = eBasicRemoveFromContainer(msgs);
    		return basicSetParentFrame((miniJava.interpreter.miniJava.Frame)otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  @TruffleBoundary
  public Context findCurrentContext() {
    Context result;
    if((this.childFrame) != (null)) {
          result = this.childFrame.findCurrentContext();
        }
        else {
          if((this.rootContext) != (null)) {
            result = this.rootContext.findCurrentContext();
          }
          else {
            result = null;
          }
        }
        ;
    return result;
  }

  @TruffleBoundary
  public Frame findCurrentFrame() {
    Frame result;
    if((this.childFrame) != (null)) {
          result = this.childFrame.findCurrentFrame();
        }
        else {
          result = this;
        }
        ;
    return result;
  }
}
