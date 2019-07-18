package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import org.eclipse.emf.ecoretools.ale.compiler.truffle.MinimalTruffleEObjectImpl;

@NodeInfo(
		description = "State"
)
public class StateImpl extends MinimalTruffleEObjectImpl.TruffleContainer {
	protected FrameImpl rootFrame;

	protected EList<ObjectInstanceImpl> objectsHeap;

	@Child
	protected OutputStreamImpl outputStream;

	protected EList<ArrayInstanceImpl> arraysHeap;

	protected ContextImpl contextCache;

	protected FrameImpl frameCache;

	protected StateImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.STATE;
	}

	@TruffleBoundary
	public FrameImpl getRootFrame() {
		return rootFrame;
	}

	@TruffleBoundary
	public NotificationChain basicSetRootFrame(FrameImpl newRootFrame, NotificationChain msgs) {
		FrameImpl oldRootFrame = rootFrame;
		rootFrame = newRootFrame;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniJavaPackage.STATE__ROOT_FRAME, oldRootFrame, newRootFrame);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setRootFrame(FrameImpl newRootFrame) {
		if (newRootFrame != rootFrame) {
			NotificationChain msgs = null;
			if (rootFrame != null)
				msgs = ((InternalEObject) rootFrame).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.STATE__ROOT_FRAME, null, msgs);
			if (newRootFrame != null)
				msgs = ((InternalEObject) newRootFrame).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.STATE__ROOT_FRAME, null, msgs);
			msgs = basicSetRootFrame(newRootFrame, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.STATE__ROOT_FRAME, newRootFrame, newRootFrame));
	}

	@TruffleBoundary
	public EList<ObjectInstanceImpl> getObjectsHeap() {
		if (objectsHeap == null) {
			objectsHeap = new EObjectContainmentEList<ObjectInstanceImpl>(ObjectInstanceImpl.class, this, MiniJavaPackage.STATE__OBJECTS_HEAP);
		}
		return objectsHeap;
	}

	@TruffleBoundary
	public OutputStreamImpl getOutputStream() {
		return outputStream;
	}

	@TruffleBoundary
	public NotificationChain basicSetOutputStream(OutputStreamImpl newOutputStream,
			NotificationChain msgs) {
		OutputStreamImpl oldOutputStream = outputStream;
		outputStream = newOutputStream;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniJavaPackage.STATE__OUTPUT_STREAM, oldOutputStream, newOutputStream);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setOutputStream(OutputStreamImpl newOutputStream) {
		if (newOutputStream != outputStream) {
			NotificationChain msgs = null;
			if (outputStream != null)
				msgs = ((InternalEObject) outputStream).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.STATE__OUTPUT_STREAM, null, msgs);
			if (newOutputStream != null)
				msgs = ((InternalEObject) newOutputStream).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.STATE__OUTPUT_STREAM, null, msgs);
			msgs = basicSetOutputStream(newOutputStream, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.STATE__OUTPUT_STREAM, newOutputStream, newOutputStream));
	}

	@TruffleBoundary
	public EList<ArrayInstanceImpl> getArraysHeap() {
		if (arraysHeap == null) {
			arraysHeap = new EObjectContainmentEList<ArrayInstanceImpl>(ArrayInstanceImpl.class, this, MiniJavaPackage.STATE__ARRAYS_HEAP);
		}
		return arraysHeap;
	}

	@TruffleBoundary
	public ContextImpl getContextCache() {
		if (contextCache != null && contextCache.eIsProxy()) {
			InternalEObject oldContextCache = (InternalEObject) contextCache;
			contextCache = (ContextImpl) eResolveProxy(oldContextCache);
			if (contextCache != oldContextCache) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.STATE__CONTEXT_CACHE, oldContextCache, contextCache));
			}
		}
		return contextCache;
	}

	public ContextImpl basicGetContextCache() {
		return contextCache;
	}

	@TruffleBoundary
	public void setContextCache(ContextImpl newContextCache) {
		ContextImpl oldContextCache = contextCache;
		contextCache = newContextCache;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.STATE__CONTEXT_CACHE, oldContextCache, contextCache));
	}

	@TruffleBoundary
	public FrameImpl getFrameCache() {
		if (frameCache != null && frameCache.eIsProxy()) {
			InternalEObject oldFrameCache = (InternalEObject) frameCache;
			frameCache = (FrameImpl) eResolveProxy(oldFrameCache);
			if (frameCache != oldFrameCache) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.STATE__FRAME_CACHE, oldFrameCache, frameCache));
			}
		}
		return frameCache;
	}

	public FrameImpl basicGetFrameCache() {
		return frameCache;
	}

	@TruffleBoundary
	public void setFrameCache(FrameImpl newFrameCache) {
		FrameImpl oldFrameCache = frameCache;
		frameCache = newFrameCache;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.STATE__FRAME_CACHE, oldFrameCache, frameCache));
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case MiniJavaPackage.STATE__ROOT_FRAME :
				return basicSetRootFrame(null, msgs);
			case MiniJavaPackage.STATE__OBJECTS_HEAP :
				return ((InternalEList<?>) getObjectsHeap()).basicRemove(otherEnd, msgs);
			case MiniJavaPackage.STATE__OUTPUT_STREAM :
				return basicSetOutputStream(null, msgs);
			case MiniJavaPackage.STATE__ARRAYS_HEAP :
				return ((InternalEList<?>) getArraysHeap()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MiniJavaPackage.STATE__ROOT_FRAME :
				return getRootFrame();
			case MiniJavaPackage.STATE__OBJECTS_HEAP :
				return getObjectsHeap();
			case MiniJavaPackage.STATE__OUTPUT_STREAM :
				return getOutputStream();
			case MiniJavaPackage.STATE__ARRAYS_HEAP :
				return getArraysHeap();
			case MiniJavaPackage.STATE__CONTEXT_CACHE :
				if (resolve)
					return getContextCache();
				return basicGetContextCache();
			case MiniJavaPackage.STATE__FRAME_CACHE :
				if (resolve)
					return getFrameCache();
				return basicGetFrameCache();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MiniJavaPackage.STATE__ROOT_FRAME :
				setRootFrame((FrameImpl) newValue);
				return;
			case MiniJavaPackage.STATE__OBJECTS_HEAP :
				getObjectsHeap().clear();
				getObjectsHeap().addAll((Collection<? extends ObjectInstanceImpl>) newValue);
				return;
			case MiniJavaPackage.STATE__OUTPUT_STREAM :
				setOutputStream((OutputStreamImpl) newValue);
				return;
			case MiniJavaPackage.STATE__ARRAYS_HEAP :
				getArraysHeap().clear();
				getArraysHeap().addAll((Collection<? extends ArrayInstanceImpl>) newValue);
				return;
			case MiniJavaPackage.STATE__CONTEXT_CACHE :
				setContextCache((ContextImpl) newValue);
				return;
			case MiniJavaPackage.STATE__FRAME_CACHE :
				setFrameCache((FrameImpl) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.STATE__ROOT_FRAME :
				setRootFrame((FrameImpl) null);
				return;
			case MiniJavaPackage.STATE__OBJECTS_HEAP :
				getObjectsHeap().clear();
				return;
			case MiniJavaPackage.STATE__OUTPUT_STREAM :
				setOutputStream((OutputStreamImpl) null);
				return;
			case MiniJavaPackage.STATE__ARRAYS_HEAP :
				getArraysHeap().clear();
				return;
			case MiniJavaPackage.STATE__CONTEXT_CACHE :
				setContextCache((ContextImpl) null);
				return;
			case MiniJavaPackage.STATE__FRAME_CACHE :
				setFrameCache((FrameImpl) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.STATE__ROOT_FRAME :
				return rootFrame != null;
			case MiniJavaPackage.STATE__OBJECTS_HEAP :
				return objectsHeap != null && !objectsHeap.isEmpty();
			case MiniJavaPackage.STATE__OUTPUT_STREAM :
				return outputStream != null;
			case MiniJavaPackage.STATE__ARRAYS_HEAP :
				return arraysHeap != null && !arraysHeap.isEmpty();
			case MiniJavaPackage.STATE__CONTEXT_CACHE :
				return contextCache != null;
			case MiniJavaPackage.STATE__FRAME_CACHE :
				return frameCache != null;
		}
		return super.eIsSet(featureID);
	}

	public FrameImpl findCurrentFrame() {
		FrameImpl result;
		if (EqualService.equals((this.getFrameCache()), (null))) {
			this.setFrameCache(((FrameImpl) (this.getRootFrame())).findCurrentFrame());
		}
		result = (FrameImpl) (this.getFrameCache()) ;
		return result;
	}

	public ContextImpl findCurrentContext() {
		ContextImpl result;
		if (EqualService.equals((this.getContextCache()), (null))) {
			this.setContextCache(((FrameImpl) (this.getRootFrame())).findCurrentContext());
		}
		result = (ContextImpl) (this.getContextCache()) ;
		return result;
	}

	public void pushNewContext() {
		ContextImpl newContext = ((ContextImpl) (MiniJavaFactory.eINSTANCE.createContext()));
		ContextImpl currCtx = ((ContextImpl) (((StateImpl) (this)).findCurrentContext()));
		if (!EqualService.equals((currCtx), (null))) {
			currCtx.setChildContext(newContext);
		}
		else {
			FrameImpl cf = ((FrameImpl) (((StateImpl) (this)).findCurrentFrame()));
			cf.setRootContext(newContext);
		}
		this.setContextCache(newContext);
	}

	public void popCurrentContext() {
		ContextImpl currContext = ((ContextImpl) (((StateImpl) (this)).findCurrentContext()));
		ContextImpl newCurrent = ((ContextImpl) (currContext.getParentContext()));
		currContext.setParentContext(null);
		this.setContextCache(newCurrent);
	}

	public void println(String str) {
		LogService.log(str);
		this.getOutputStream().getStream().add(str);
	}

	public void pushNewFrame(ObjectInstanceImpl receiver, CallImpl c, ContextImpl newContext) {
		FrameImpl newFrame = ((FrameImpl) (MiniJavaFactory.eINSTANCE.createFrame()));
		newFrame.setInstance(receiver);
		newFrame.setCall(c);
		newFrame.setRootContext(newContext);
		((StateImpl) (this)).findCurrentFrame().setChildFrame(newFrame);
		this.setFrameCache(newFrame);
		this.setContextCache(null);
	}

	public void popCurrentFrame() {
		FrameImpl newCurrent = ((FrameImpl) (((StateImpl) (this)).findCurrentFrame().getParentFrame()));
		((StateImpl) (this)).findCurrentFrame().setParentFrame(null);
		this.setContextCache(null);
		this.setFrameCache(newCurrent);
	}
}
