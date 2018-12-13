package miniJava.interpreter.miniJava.impl;

import java.lang.IllegalArgumentException;
import java.lang.Object;
import miniJava.interpreter.miniJava.Context;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.Symbol;
import miniJava.interpreter.miniJava.SymbolBinding;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class ContextImpl extends MinimalEObjectImpl.Container implements Context {
  protected EList<SymbolBinding> bindings;

  protected Context childContext;

  protected ContextImpl() {
    super();
  }

  public EList<SymbolBinding> getBindings() {
    if(bindings == null) {
    	bindings = new EObjectContainmentEList<SymbolBinding>(miniJava.interpreter.miniJava.SymbolBinding.class, this, MiniJavaPackage.CONTEXT__BINDINGS);
    }
    return bindings;
  }

  public void setParentContext(Context newParentContext) {
    if (newParentContext != eInternalContainer() || (eContainerFeatureID() != MiniJavaPackage.CONTEXT__PARENT_CONTEXT && newParentContext != null)) {
    	if (EcoreUtil.isAncestor(this, newParentContext))
    		throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
    	NotificationChain msgs = null;
    	if (eInternalContainer() != null)
    		msgs = eBasicRemoveFromContainer(msgs);
    	if (newParentContext != null)
    		msgs = ((InternalEObject)newParentContext).eInverseAdd(this, MiniJavaPackage.CONTEXT__CHILD_CONTEXT , Context.class, msgs);
    	msgs = basicSetParentContext(newParentContext, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.CONTEXT__PARENT_CONTEXT , newParentContext, newParentContext));
  }

  public NotificationChain basicSetParentContext(Context newParentContext, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newParentContext, MiniJavaPackage.CONTEXT__PARENT_CONTEXT, msgs);
    return msgs;
  }

  public Context getParentContext() {
    if (eContainerFeatureID() != MiniJavaPackage.CONTEXT__PARENT_CONTEXT) return null;
    return (Context)eInternalContainer();
  }

  public void setChildContext(Context newChildContext) {
    if (newChildContext != childContext) {
    	NotificationChain msgs = null;
    	if (childContext != null)
    		msgs = ((InternalEObject) childContext).eInverseRemove(this, MiniJavaPackage.CONTEXT__PARENT_CONTEXT, miniJava.interpreter.miniJava.Context.class, msgs);
    	if (newChildContext != null)
    		msgs = ((InternalEObject) newChildContext).eInverseAdd(this, MiniJavaPackage.CONTEXT__PARENT_CONTEXT, miniJava.interpreter.miniJava.Context.class,
    				msgs);
    	msgs = basicSetChildContext(newChildContext, msgs);
    	if (msgs != null)
    		msgs.dispatch();
    } else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.CONTEXT__CHILD_CONTEXT, newChildContext, newChildContext));
  }

  private NotificationChain basicSetChildContext(Context newChildContext, NotificationChain msgsp) {
    NotificationChain msgs = msgsp;
    Context oldChildContext = childContext;
    childContext = newChildContext;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniJavaPackage.CONTEXT__CHILD_CONTEXT,
    			oldChildContext, newChildContext);
    	if (msgs == null)
    		msgs = notification;
    	else
    		msgs.add(notification);
    }
    return msgs;
  }

  public Context getChildContext() {
    return childContext;}

  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.CONTEXT;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.CONTEXT__BINDINGS:
    	getBindings().clear();
    	getBindings().addAll((java.util.Collection<? extends miniJava.interpreter.miniJava.SymbolBinding>) newValue);
    return;
    case MiniJavaPackage.CONTEXT__PARENT_CONTEXT:
    	setParentContext((miniJava.interpreter.miniJava.Context) newValue);
    return;
    case MiniJavaPackage.CONTEXT__CHILD_CONTEXT:
    	setChildContext((miniJava.interpreter.miniJava.Context) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.CONTEXT__BINDINGS:
    	getBindings().clear();
    return;
    case MiniJavaPackage.CONTEXT__PARENT_CONTEXT:
    	setParentContext((miniJava.interpreter.miniJava.Context) null);
    return;
    case MiniJavaPackage.CONTEXT__CHILD_CONTEXT:
    	setChildContext((miniJava.interpreter.miniJava.Context) null);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.CONTEXT__BINDINGS:
    return getBindings();
    case MiniJavaPackage.CONTEXT__PARENT_CONTEXT:
    return getParentContext();
    case MiniJavaPackage.CONTEXT__CHILD_CONTEXT:
    return getChildContext();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.CONTEXT__BINDINGS:
    	return bindings != null && !bindings.isEmpty();
    case MiniJavaPackage.CONTEXT__PARENT_CONTEXT:
    	return getParentContext() != null;
    case MiniJavaPackage.CONTEXT__CHILD_CONTEXT:
    	return childContext != null;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case miniJava.interpreter.miniJava.MiniJavaPackage.CONTEXT__BINDINGS:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getBindings()).basicRemove(otherEnd, msgs);
    case miniJava.interpreter.miniJava.MiniJavaPackage.CONTEXT__PARENT_CONTEXT:
    	return basicSetParentContext(null, msgs);
    case miniJava.interpreter.miniJava.MiniJavaPackage.CONTEXT__CHILD_CONTEXT:
    	return basicSetChildContext(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
      NotificationChain msgs2) {
    NotificationChain msgs = msgs2;
    switch (featureID) {

    case MiniJavaPackage.CONTEXT__PARENT_CONTEXT:
    	if (eInternalContainer() != null)
    			msgs = eBasicRemoveFromContainer(msgs);
    		return basicSetParentContext((miniJava.interpreter.miniJava.Context)otherEnd, msgs);

    case MiniJavaPackage.CONTEXT__CHILD_CONTEXT:
    	if (childContext != null)
    		msgs = ((org.eclipse.emf.ecore.InternalEObject) childContext).eInverseRemove(this, MiniJavaPackage.CONTEXT__PARENT_CONTEXT, Context.class,
    				msgs);
    	return basicSetChildContext((miniJava.interpreter.miniJava.Context) otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  public SymbolBinding findBinding(Symbol symbol) {
    SymbolBinding result;
    org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log("TODO findBinding");
        result = null;
        ;
    return result;
  }

  public Context findCurrentContext() {
    Context result;
    if((this.childContext) != (null)) {
          result = this.childContext.findCurrentContext();
        }
        else {
          result = this;
        }
        ;
    return result;
  }
}
