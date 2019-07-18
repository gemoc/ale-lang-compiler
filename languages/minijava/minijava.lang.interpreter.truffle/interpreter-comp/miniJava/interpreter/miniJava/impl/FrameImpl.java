package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

public class FrameImpl extends MinimalEObjectImpl.Container {
	protected CallImpl call;

	protected ObjectInstanceImpl instance;

	protected FrameImpl childFrame;

	protected ContextImpl rootContext;

	protected ValueImpl returnValue;

	protected FrameImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.FRAME;
	}

	@TruffleBoundary
	public CallImpl getCall() {
		return call;
	}

	@TruffleBoundary
	public NotificationChain basicSetCall(CallImpl newCall, NotificationChain msgs) {
		CallImpl oldCall = call;
		call = newCall;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniJavaPackage.FRAME__CALL, oldCall, newCall);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setCall(CallImpl newCall) {
		if (newCall != call) {
			NotificationChain msgs = null;
			if (call != null)
				msgs = ((InternalEObject) call).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.FRAME__CALL, null, msgs);
			if (newCall != null)
				msgs = ((InternalEObject) newCall).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.FRAME__CALL, null, msgs);
			msgs = basicSetCall(newCall, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.FRAME__CALL, newCall, newCall));
	}

	@TruffleBoundary
	public ObjectInstanceImpl getInstance() {
		if (instance != null && instance.eIsProxy()) {
			InternalEObject oldInstance = (InternalEObject) instance;
			instance = (ObjectInstanceImpl) eResolveProxy(oldInstance);
			if (instance != oldInstance) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.FRAME__INSTANCE, oldInstance, instance));
			}
		}
		return instance;
	}

	public ObjectInstanceImpl basicGetInstance() {
		return instance;
	}

	@TruffleBoundary
	public void setInstance(ObjectInstanceImpl newInstance) {
		ObjectInstanceImpl oldInstance = instance;
		instance = newInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.FRAME__INSTANCE, oldInstance, instance));
	}

	@TruffleBoundary
	public FrameImpl getChildFrame() {
		return childFrame;
	}

	@TruffleBoundary
	public NotificationChain basicSetChildFrame(FrameImpl newChildFrame, NotificationChain msgs) {
		FrameImpl oldChildFrame = childFrame;
		childFrame = newChildFrame;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniJavaPackage.FRAME__CHILD_FRAME, oldChildFrame, newChildFrame);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setChildFrame(FrameImpl newChildFrame) {
		if (newChildFrame != childFrame) {
			NotificationChain msgs = null;
			if (childFrame != null)
				msgs = ((InternalEObject) childFrame).eInverseRemove(this, MiniJavaPackage.FRAME__PARENT_FRAME, FrameImpl.class, msgs);
			if (newChildFrame != null)
				msgs = ((InternalEObject) newChildFrame).eInverseAdd(this, MiniJavaPackage.FRAME__PARENT_FRAME, FrameImpl.class, msgs);
			msgs = basicSetChildFrame(newChildFrame, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.FRAME__CHILD_FRAME, newChildFrame, newChildFrame));
	}

	@TruffleBoundary
	public FrameImpl getParentFrame() {
		if (eContainerFeatureID() != MiniJavaPackage.FRAME__PARENT_FRAME)
			return null;
		return (FrameImpl) eInternalContainer();
	}

	public NotificationChain basicSetParentFrame(FrameImpl newParentFrame, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newParentFrame, MiniJavaPackage.FRAME__PARENT_FRAME, msgs);
		return msgs;
	}

	@TruffleBoundary
	public void setParentFrame(FrameImpl newParentFrame) {
		if (newParentFrame != eInternalContainer() || (eContainerFeatureID() != MiniJavaPackage.FRAME__PARENT_FRAME && newParentFrame != null)) {
			if (EcoreUtil.isAncestor(this, newParentFrame))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentFrame != null)
				msgs = ((InternalEObject) newParentFrame).eInverseAdd(this, MiniJavaPackage.FRAME__CHILD_FRAME, FrameImpl.class, msgs);
			msgs = basicSetParentFrame(newParentFrame, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.FRAME__PARENT_FRAME, newParentFrame, newParentFrame));
	}

	@TruffleBoundary
	public ContextImpl getRootContext() {
		return rootContext;
	}

	@TruffleBoundary
	public NotificationChain basicSetRootContext(ContextImpl newRootContext, NotificationChain msgs) {
		ContextImpl oldRootContext = rootContext;
		rootContext = newRootContext;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniJavaPackage.FRAME__ROOT_CONTEXT, oldRootContext, newRootContext);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setRootContext(ContextImpl newRootContext) {
		if (newRootContext != rootContext) {
			NotificationChain msgs = null;
			if (rootContext != null)
				msgs = ((InternalEObject) rootContext).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.FRAME__ROOT_CONTEXT, null, msgs);
			if (newRootContext != null)
				msgs = ((InternalEObject) newRootContext).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.FRAME__ROOT_CONTEXT, null, msgs);
			msgs = basicSetRootContext(newRootContext, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.FRAME__ROOT_CONTEXT, newRootContext, newRootContext));
	}

	@TruffleBoundary
	public ValueImpl getReturnValue() {
		return returnValue;
	}

	@TruffleBoundary
	public NotificationChain basicSetReturnValue(ValueImpl newReturnValue, NotificationChain msgs) {
		ValueImpl oldReturnValue = returnValue;
		returnValue = newReturnValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniJavaPackage.FRAME__RETURN_VALUE, oldReturnValue, newReturnValue);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setReturnValue(ValueImpl newReturnValue) {
		if (newReturnValue != returnValue) {
			NotificationChain msgs = null;
			if (returnValue != null)
				msgs = ((InternalEObject) returnValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.FRAME__RETURN_VALUE, null, msgs);
			if (newReturnValue != null)
				msgs = ((InternalEObject) newReturnValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.FRAME__RETURN_VALUE, null, msgs);
			msgs = basicSetReturnValue(newReturnValue, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.FRAME__RETURN_VALUE, newReturnValue, newReturnValue));
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case MiniJavaPackage.FRAME__CHILD_FRAME :
				if (childFrame != null)
					msgs = ((InternalEObject) childFrame).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.FRAME__CHILD_FRAME, null, msgs);
				return basicSetChildFrame((FrameImpl) otherEnd, msgs);
			case MiniJavaPackage.FRAME__PARENT_FRAME :
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentFrame((FrameImpl) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case MiniJavaPackage.FRAME__CALL :
				return basicSetCall(null, msgs);
			case MiniJavaPackage.FRAME__CHILD_FRAME :
				return basicSetChildFrame(null, msgs);
			case MiniJavaPackage.FRAME__PARENT_FRAME :
				return basicSetParentFrame(null, msgs);
			case MiniJavaPackage.FRAME__ROOT_CONTEXT :
				return basicSetRootContext(null, msgs);
			case MiniJavaPackage.FRAME__RETURN_VALUE :
				return basicSetReturnValue(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case MiniJavaPackage.FRAME__PARENT_FRAME :
				return eInternalContainer().eInverseRemove(this, MiniJavaPackage.FRAME__CHILD_FRAME, FrameImpl.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MiniJavaPackage.FRAME__CALL :
				return getCall();
			case MiniJavaPackage.FRAME__INSTANCE :
				if (resolve)
					return getInstance();
				return basicGetInstance();
			case MiniJavaPackage.FRAME__CHILD_FRAME :
				return getChildFrame();
			case MiniJavaPackage.FRAME__PARENT_FRAME :
				return getParentFrame();
			case MiniJavaPackage.FRAME__ROOT_CONTEXT :
				return getRootContext();
			case MiniJavaPackage.FRAME__RETURN_VALUE :
				return getReturnValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MiniJavaPackage.FRAME__CALL :
				setCall((CallImpl) newValue);
				return;
			case MiniJavaPackage.FRAME__INSTANCE :
				setInstance((ObjectInstanceImpl) newValue);
				return;
			case MiniJavaPackage.FRAME__CHILD_FRAME :
				setChildFrame((FrameImpl) newValue);
				return;
			case MiniJavaPackage.FRAME__PARENT_FRAME :
				setParentFrame((FrameImpl) newValue);
				return;
			case MiniJavaPackage.FRAME__ROOT_CONTEXT :
				setRootContext((ContextImpl) newValue);
				return;
			case MiniJavaPackage.FRAME__RETURN_VALUE :
				setReturnValue((ValueImpl) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.FRAME__CALL :
				setCall((CallImpl) null);
				return;
			case MiniJavaPackage.FRAME__INSTANCE :
				setInstance((ObjectInstanceImpl) null);
				return;
			case MiniJavaPackage.FRAME__CHILD_FRAME :
				setChildFrame((FrameImpl) null);
				return;
			case MiniJavaPackage.FRAME__PARENT_FRAME :
				setParentFrame((FrameImpl) null);
				return;
			case MiniJavaPackage.FRAME__ROOT_CONTEXT :
				setRootContext((ContextImpl) null);
				return;
			case MiniJavaPackage.FRAME__RETURN_VALUE :
				setReturnValue((ValueImpl) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.FRAME__CALL :
				return call != null;
			case MiniJavaPackage.FRAME__INSTANCE :
				return instance != null;
			case MiniJavaPackage.FRAME__CHILD_FRAME :
				return childFrame != null;
			case MiniJavaPackage.FRAME__PARENT_FRAME :
				return getParentFrame() != null;
			case MiniJavaPackage.FRAME__ROOT_CONTEXT :
				return rootContext != null;
			case MiniJavaPackage.FRAME__RETURN_VALUE :
				return returnValue != null;
		}
		return super.eIsSet(featureID);
	}

	@TruffleBoundary
	public ContextImpl findCurrentContext() {
		ContextImpl result;
		if (!EqualService.equals((this.getChildFrame()), (null))) {
			result = (ContextImpl) (((FrameImpl) (this.getChildFrame())).findCurrentContext()) ;
		}
		else {
			if (!EqualService.equals((this.getRootContext()), (null))) {
				result = (ContextImpl) (((ContextImpl) (this.getRootContext())).findCurrentContext()) ;
			}
			else {
				result = (ContextImpl) (null) ;
			}
		}
		return result;
	}

	@TruffleBoundary
	public FrameImpl findCurrentFrame() {
		FrameImpl result;
		if (!EqualService.equals((this.getChildFrame()), (null))) {
			result = (FrameImpl) (((FrameImpl) (this.getChildFrame())).findCurrentFrame()) ;
		}
		else {
			result = (FrameImpl) (this) ;
		}
		return result;
	}
}
