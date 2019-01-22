package miniJava.interpreter.miniJava.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;

import miniJava.interpreter.miniJava.ArrayInstance;
import miniJava.interpreter.miniJava.Call;
import miniJava.interpreter.miniJava.Context;
import miniJava.interpreter.miniJava.Frame;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.ObjectInstance;
import miniJava.interpreter.miniJava.OutputStream;
import miniJava.interpreter.miniJava.State;

@NodeInfo(
    description = "State"
)
public class StateImpl extends MinimalEObjectImpl.Container implements State {
  
  protected Frame rootFrame;

  protected EList<ObjectInstance> objectsHeap;

  
  protected OutputStream outputStream;

  protected EList<ArrayInstance> arraysHeap;

  protected Context contextCache;

  protected Frame frameCache;

  protected StateImpl() {
    super();
  }

  @TruffleBoundary
  public void setRootFrame(Frame newRootFrame) {
    if (newRootFrame != rootFrame) {
    	NotificationChain msgs = null;
    	if (rootFrame != null)
    		msgs = ((InternalEObject)rootFrame).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.STATE__ROOT_FRAME, null, msgs);
    	if (newRootFrame != null)
    		msgs = ((InternalEObject)newRootFrame).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.STATE__ROOT_FRAME, null, msgs);
    	msgs = basicSetRootFrame(newRootFrame, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.STATE__ROOT_FRAME, newRootFrame, newRootFrame));
  }

  @TruffleBoundary
  public NotificationChain basicSetRootFrame(Frame newRootFrame, NotificationChain msgs) {
    Frame oldRootFrame = rootFrame;
    rootFrame = newRootFrame;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.STATE__ROOT_FRAME, oldRootFrame, newRootFrame);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Frame getRootFrame() {
    return rootFrame;
  }

  @TruffleBoundary
  public EList<ObjectInstance> getObjectsHeap() {
    if(objectsHeap == null) {
    	objectsHeap = new EObjectContainmentEList<ObjectInstance>(miniJava.interpreter.miniJava.ObjectInstance.class, this, MiniJavaPackage.STATE__OBJECTS_HEAP);
    }
    return objectsHeap;
  }

  @TruffleBoundary
  public void setOutputStream(OutputStream newOutputStream) {
    if (newOutputStream != outputStream) {
    	NotificationChain msgs = null;
    	if (outputStream != null)
    		msgs = ((InternalEObject)outputStream).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.STATE__OUTPUT_STREAM, null, msgs);
    	if (newOutputStream != null)
    		msgs = ((InternalEObject)newOutputStream).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.STATE__OUTPUT_STREAM, null, msgs);
    	msgs = basicSetOutputStream(newOutputStream, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.STATE__OUTPUT_STREAM, newOutputStream, newOutputStream));
  }

  @TruffleBoundary
  public NotificationChain basicSetOutputStream(OutputStream newOutputStream,
      NotificationChain msgs) {
    OutputStream oldOutputStream = outputStream;
    outputStream = newOutputStream;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.STATE__OUTPUT_STREAM, oldOutputStream, newOutputStream);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public OutputStream getOutputStream() {
    return outputStream;
  }

  @TruffleBoundary
  public EList<ArrayInstance> getArraysHeap() {
    if(arraysHeap == null) {
    	arraysHeap = new EObjectContainmentEList<ArrayInstance>(miniJava.interpreter.miniJava.ArrayInstance.class, this, MiniJavaPackage.STATE__ARRAYS_HEAP);
    }
    return arraysHeap;
  }

  @TruffleBoundary
  public void setContextCache(Context newContextCache) {
    Context oldContextCache = contextCache;
    contextCache = newContextCache;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.STATE__CONTEXT_CACHE, oldContextCache, contextCache));
  }

  @TruffleBoundary
  public Context getContextCache() {
    if (contextCache != null && contextCache.eIsProxy()) {
    	InternalEObject oldcontextCache = (InternalEObject) contextCache;
    	contextCache = (Context) eResolveProxy(oldcontextCache);
    	if (contextCache != oldcontextCache) {
    		if (eNotificationRequired())
    			eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.STATE__CONTEXT_CACHE,
    					oldcontextCache, contextCache));
    	}
    }
    return contextCache;
  }

  @TruffleBoundary
  public void setFrameCache(Frame newFrameCache) {
    Frame oldFrameCache = frameCache;
    frameCache = newFrameCache;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.STATE__FRAME_CACHE, oldFrameCache, frameCache));
  }

  @TruffleBoundary
  public Frame getFrameCache() {
    if (frameCache != null && frameCache.eIsProxy()) {
    	InternalEObject oldframeCache = (InternalEObject) frameCache;
    	frameCache = (Frame) eResolveProxy(oldframeCache);
    	if (frameCache != oldframeCache) {
    		if (eNotificationRequired())
    			eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.STATE__FRAME_CACHE,
    					oldframeCache, frameCache));
    	}
    }
    return frameCache;
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.STATE;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.STATE__ROOT_FRAME:
    	setRootFrame((miniJava.interpreter.miniJava.Frame) newValue);
    return;
    case MiniJavaPackage.STATE__OBJECTS_HEAP:
    	getObjectsHeap().clear();
    	getObjectsHeap().addAll((java.util.Collection<? extends miniJava.interpreter.miniJava.ObjectInstance>) newValue);
    return;
    case MiniJavaPackage.STATE__OUTPUT_STREAM:
    	setOutputStream((miniJava.interpreter.miniJava.OutputStream) newValue);
    return;
    case MiniJavaPackage.STATE__ARRAYS_HEAP:
    	getArraysHeap().clear();
    	getArraysHeap().addAll((java.util.Collection<? extends miniJava.interpreter.miniJava.ArrayInstance>) newValue);
    return;
    case MiniJavaPackage.STATE__CONTEXT_CACHE:
    	setContextCache((miniJava.interpreter.miniJava.Context) newValue);
    return;
    case MiniJavaPackage.STATE__FRAME_CACHE:
    	setFrameCache((miniJava.interpreter.miniJava.Frame) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.STATE__ROOT_FRAME:
    	setRootFrame((miniJava.interpreter.miniJava.Frame) null);
    return;
    case MiniJavaPackage.STATE__OBJECTS_HEAP:
    	getObjectsHeap().clear();
    return;
    case MiniJavaPackage.STATE__OUTPUT_STREAM:
    	setOutputStream((miniJava.interpreter.miniJava.OutputStream) null);
    return;
    case MiniJavaPackage.STATE__ARRAYS_HEAP:
    	getArraysHeap().clear();
    return;
    case MiniJavaPackage.STATE__CONTEXT_CACHE:
    	setContextCache((miniJava.interpreter.miniJava.Context) null);
    return;
    case MiniJavaPackage.STATE__FRAME_CACHE:
    	setFrameCache((miniJava.interpreter.miniJava.Frame) null);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
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

  @TruffleBoundary
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

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case miniJava.interpreter.miniJava.MiniJavaPackage.STATE__ROOT_FRAME:
    	return basicSetRootFrame(null, msgs);
    case miniJava.interpreter.miniJava.MiniJavaPackage.STATE__OBJECTS_HEAP:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getObjectsHeap()).basicRemove(otherEnd, msgs);
    case miniJava.interpreter.miniJava.MiniJavaPackage.STATE__OUTPUT_STREAM:
    	return basicSetOutputStream(null, msgs);
    case miniJava.interpreter.miniJava.MiniJavaPackage.STATE__ARRAYS_HEAP:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getArraysHeap()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public Frame findCurrentFrame() {
    Frame result;
    if(org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService.equals((this.frameCache), (null))) {
          this.setFrameCache(this.rootFrame.findCurrentFrame());
        }
        result = this.frameCache;
        ;
    return result;
  }

  public Context findCurrentContext() {
    Context result;
    if(org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService.equals((this.contextCache), (null))) {
          this.setContextCache(this.rootFrame.findCurrentContext());
        }
        result = this.contextCache;
        ;
    return result;
  }

  public void pushNewContext() {
    miniJava.interpreter.miniJava.Context newContext = ((miniJava.interpreter.miniJava.Context)miniJava.interpreter.miniJava.MiniJavaFactory.eINSTANCE.createContext());
        miniJava.interpreter.miniJava.Context currCtx = ((miniJava.interpreter.miniJava.Context)this.findCurrentContext());
        if((currCtx) != (null)) {
          currCtx.setChildContext(newContext);
        }
        else {
          miniJava.interpreter.miniJava.Frame cf = ((miniJava.interpreter.miniJava.Frame)this.findCurrentFrame());
          cf.setRootContext(newContext);
        }
        this.setContextCache(newContext);
        ;
  }

  public void popCurrentContext() {
    miniJava.interpreter.miniJava.Context currContext = ((miniJava.interpreter.miniJava.Context)this.findCurrentContext());
        miniJava.interpreter.miniJava.Context newCurrent = ((miniJava.interpreter.miniJava.Context)currContext.getParentContext());
        currContext.setParentContext(null);
        this.setContextCache(newCurrent);
        ;
  }

  public void println(String str) {
    org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log(str);
        this.outputStream.getStream().add(str);
        ;
  }

  public void pushNewFrame(ObjectInstance receiver, Call c, Context newContext) {
    miniJava.interpreter.miniJava.Frame newFrame = ((miniJava.interpreter.miniJava.Frame)miniJava.interpreter.miniJava.MiniJavaFactory.eINSTANCE.createFrame());
        newFrame.setInstance(receiver);
        newFrame.setCall(c);
        newFrame.setRootContext(newContext);
        this.findCurrentFrame().setChildFrame(newFrame);
        this.setFrameCache(newFrame);
        this.setContextCache(null);
        ;
  }

  public void popCurrentFrame() {
    miniJava.interpreter.miniJava.Frame newCurrent = ((miniJava.interpreter.miniJava.Frame)this.findCurrentFrame().getParentFrame());
        this.findCurrentFrame().setParentFrame(null);
        this.setContextCache(null);
        this.setFrameCache(newCurrent);
        ;
  }
}
