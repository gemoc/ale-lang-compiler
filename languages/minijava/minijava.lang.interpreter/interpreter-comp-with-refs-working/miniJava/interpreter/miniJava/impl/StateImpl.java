package miniJava.interpreter.miniJava.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

import miniJava.interpreter.miniJava.ArrayInstance;
import miniJava.interpreter.miniJava.Call;
import miniJava.interpreter.miniJava.Context;
import miniJava.interpreter.miniJava.Frame;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.ObjectInstance;
import miniJava.interpreter.miniJava.OutputStream;
import miniJava.interpreter.miniJava.State;

public class StateImpl extends MinimalEObjectImpl.Container implements State {
	protected EList<ArrayInstance> arraysHeap;

	protected Context contextCache;

	protected Frame frameCache;

	protected EList<ObjectInstance> objectsHeap;

	protected OutputStream outputStream;

	protected Frame rootFrame;

	protected StateImpl() {
		super();
	}

	public NotificationChain basicSetOutputStream(OutputStream newOutputStream, NotificationChain msgs) {
		OutputStream oldOutputStream = outputStream;
		outputStream = newOutputStream;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					MiniJavaPackage.STATE__OUTPUT_STREAM, oldOutputStream, newOutputStream);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public NotificationChain basicSetRootFrame(Frame newRootFrame, NotificationChain msgs) {
		Frame oldRootFrame = rootFrame;
		rootFrame = newRootFrame;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					MiniJavaPackage.STATE__ROOT_FRAME, oldRootFrame, newRootFrame);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MiniJavaPackage.STATE__ROOT_FRAME:
			return getRootFrame();
		case MiniJavaPackage.STATE__OBJECTS_HEAP:
			return getObjectsHeap();
		case MiniJavaPackage.STATE__OUTPUT_STREAM:
			return getOutputStream();
		case MiniJavaPackage.STATE__ARRAYS_HEAP:
			return getArraysHeap();
		case MiniJavaPackage.STATE__CONTEXT_CACHE:
			return getContextCache();
		case MiniJavaPackage.STATE__FRAME_CACHE:
			return getFrameCache();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MiniJavaPackage.STATE__ROOT_FRAME:
			return basicSetRootFrame(null, msgs);
		case MiniJavaPackage.STATE__OBJECTS_HEAP:
			return ((org.eclipse.emf.ecore.util.InternalEList<?>) getObjectsHeap()).basicRemove(otherEnd, msgs);
		case MiniJavaPackage.STATE__OUTPUT_STREAM:
			return basicSetOutputStream(null, msgs);
		case MiniJavaPackage.STATE__ARRAYS_HEAP:
			return ((org.eclipse.emf.ecore.util.InternalEList<?>) getArraysHeap()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case MiniJavaPackage.STATE__ROOT_FRAME:
			return rootFrame != null;
		case MiniJavaPackage.STATE__OBJECTS_HEAP:
			return objectsHeap != null && !objectsHeap.isEmpty();
		case MiniJavaPackage.STATE__OUTPUT_STREAM:
			return outputStream != null;
		case MiniJavaPackage.STATE__ARRAYS_HEAP:
			return arraysHeap != null && !arraysHeap.isEmpty();
		case MiniJavaPackage.STATE__CONTEXT_CACHE:
			return contextCache != null;
		case MiniJavaPackage.STATE__FRAME_CACHE:
			return frameCache != null;
		}
		return super.eIsSet(featureID);
	}

	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case MiniJavaPackage.STATE__ROOT_FRAME:
			setRootFrame((Frame) newValue);
			return;
		case MiniJavaPackage.STATE__OBJECTS_HEAP:
			getObjectsHeap().clear();
			getObjectsHeap().addAll((java.util.Collection<? extends ObjectInstance>) newValue);
			return;
		case MiniJavaPackage.STATE__OUTPUT_STREAM:
			setOutputStream((OutputStream) newValue);
			return;
		case MiniJavaPackage.STATE__ARRAYS_HEAP:
			getArraysHeap().clear();
			getArraysHeap().addAll((java.util.Collection<? extends ArrayInstance>) newValue);
			return;
		case MiniJavaPackage.STATE__CONTEXT_CACHE:
			setContextCache((Context) newValue);
			return;
		case MiniJavaPackage.STATE__FRAME_CACHE:
			setFrameCache((Frame) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.STATE;
	}

	public void eUnset(int featureID) {
		switch (featureID) {
		case MiniJavaPackage.STATE__ROOT_FRAME:
			setRootFrame((Frame) null);
			return;
		case MiniJavaPackage.STATE__OBJECTS_HEAP:
			getObjectsHeap().clear();
			return;
		case MiniJavaPackage.STATE__OUTPUT_STREAM:
			setOutputStream((OutputStream) null);
			return;
		case MiniJavaPackage.STATE__ARRAYS_HEAP:
			getArraysHeap().clear();
			return;
		case MiniJavaPackage.STATE__CONTEXT_CACHE:
			setContextCache((Context) null);
			return;
		case MiniJavaPackage.STATE__FRAME_CACHE:
			setFrameCache((Frame) null);
			return;
		}
		super.eUnset(featureID);
	}

	public Context findCurrentContext() {
		Context result;
		if (java.util.Objects.equals((this.contextCache), (null))) {
			this.setContextCache(this.rootFrame.findCurrentContext());
		}
		result = this.contextCache;
		;
		return result;
	}

	public Frame findCurrentFrame() {
		Frame result;
		if (java.util.Objects.equals((this.frameCache), (null))) {
			this.setFrameCache(this.rootFrame.findCurrentFrame());
		}
		result = this.frameCache;
		;
		return result;
	}

	public EList<ArrayInstance> getArraysHeap() {
		if (arraysHeap == null) {
			arraysHeap = new EObjectContainmentEList<ArrayInstance>(ArrayInstance.class, this,
					MiniJavaPackage.STATE__ARRAYS_HEAP);
		}
		return arraysHeap;
	}

	public Context getContextCache() {
		return contextCache;
	}

	public Frame getFrameCache() {
		return frameCache;
	}

	public EList<ObjectInstance> getObjectsHeap() {
		if (objectsHeap == null) {
			objectsHeap = new EObjectContainmentEList<ObjectInstance>(ObjectInstance.class, this,
					MiniJavaPackage.STATE__OBJECTS_HEAP);
		}
		return objectsHeap;
	}

	public OutputStream getOutputStream() {
		return outputStream;
	}

	public Frame getRootFrame() {
		return rootFrame;
	}

	public void popCurrentContext() {
		Context currContext = ((Context) this.findCurrentContext());
		Context newCurrent = ((Context) currContext.getParentContext());
		currContext.setParentContext(null);
		this.setContextCache(newCurrent);
		;
	}

	public void popCurrentFrame() {
		Frame newCurrent = ((Frame) this.findCurrentFrame().getParentFrame());
		this.findCurrentFrame().setParentFrame(null);
		this.setContextCache(null);
		this.setFrameCache(newCurrent);
		;
	}

	public void println(String str) {
		org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log(str);
		this.outputStream.getStream().add(str);
		;
	}

	public void pushNewContext() {
		Context newContext = ((Context) MiniJavaFactory.eINSTANCE.createContext());
		Context currCtx = ((Context) this.findCurrentContext());
		if ((currCtx) != (null)) {
			currCtx.setChildContext(newContext);
		} else {
			Frame cf = ((Frame) this.findCurrentFrame());
			cf.setRootContext(newContext);
		}
		this.setContextCache(newContext);
		;
	}

	public void pushNewFrame(ObjectInstance receiver, Call c, Context newContext) {
		Frame newFrame = ((Frame) MiniJavaFactory.eINSTANCE.createFrame());
		newFrame.setInstance(receiver);
		newFrame.setCall(c);
		newFrame.setRootContext(newContext);
		this.findCurrentFrame().setChildFrame(newFrame);
		this.setFrameCache(newFrame);
		this.setContextCache(null);
		;
	}

	public void setContextCache(Context newContextCache) {
		Context oldContextCache = contextCache;
		contextCache = newContextCache;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.STATE__CONTEXT_CACHE, oldContextCache,
					contextCache));
	}

	public void setFrameCache(Frame newFrameCache) {
		Frame oldFrameCache = frameCache;
		frameCache = newFrameCache;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.STATE__FRAME_CACHE, oldFrameCache,
					frameCache));
	}

	public void setOutputStream(OutputStream newOutputStream) {
		if (newOutputStream != outputStream) {
			NotificationChain msgs = null;
			if (outputStream != null)
				msgs = ((InternalEObject) outputStream).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - MiniJavaPackage.STATE__OUTPUT_STREAM, null, msgs);
			if (newOutputStream != null)
				msgs = ((InternalEObject) newOutputStream).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - MiniJavaPackage.STATE__OUTPUT_STREAM, null, msgs);
			msgs = basicSetOutputStream(newOutputStream, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.STATE__OUTPUT_STREAM, newOutputStream,
					newOutputStream));
	}

	public void setRootFrame(Frame newRootFrame) {
		if (newRootFrame != rootFrame) {
			NotificationChain msgs = null;
			if (rootFrame != null)
				msgs = ((InternalEObject) rootFrame).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - MiniJavaPackage.STATE__ROOT_FRAME, null, msgs);
			if (newRootFrame != null)
				msgs = ((InternalEObject) newRootFrame).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - MiniJavaPackage.STATE__ROOT_FRAME, null, msgs);
			msgs = basicSetRootFrame(newRootFrame, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.STATE__ROOT_FRAME, newRootFrame,
					newRootFrame));
	}
}
