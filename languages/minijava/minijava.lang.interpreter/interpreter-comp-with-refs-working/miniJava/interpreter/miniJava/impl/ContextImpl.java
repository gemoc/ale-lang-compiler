package miniJava.interpreter.miniJava.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.EcoreUtil;

import miniJava.interpreter.miniJava.Context;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.Symbol;
import miniJava.interpreter.miniJava.SymbolBinding;

public class ContextImpl extends MinimalEObjectImpl.Container implements Context {
	protected EList<SymbolBinding> bindings;

	protected EMap<Symbol, SymbolBinding> cache;

	protected Context childContext;

	protected ContextImpl() {
		super();
	}

	private NotificationChain basicSetChildContext(Context newChildContext, NotificationChain msgsp) {
		NotificationChain msgs = msgsp;
		Context oldChildContext = childContext;
		childContext = newChildContext;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					MiniJavaPackage.CONTEXT__CHILD_CONTEXT, oldChildContext, newChildContext);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public NotificationChain basicSetParentContext(Context newParentContext, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newParentContext, MiniJavaPackage.CONTEXT__PARENT_CONTEXT, msgs);
		return msgs;
	}

	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MiniJavaPackage.CONTEXT__BINDINGS:
			return getBindings();
		case MiniJavaPackage.CONTEXT__PARENT_CONTEXT:
			return getParentContext();
		case MiniJavaPackage.CONTEXT__CHILD_CONTEXT:
			return getChildContext();
		case MiniJavaPackage.CONTEXT__CACHE:
			if (coreType)
				return getCache();
			else
				return getCache().map();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs2) {
		NotificationChain msgs = msgs2;
		switch (featureID) {

		case MiniJavaPackage.CONTEXT__PARENT_CONTEXT:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetParentContext((Context) otherEnd, msgs);

		case MiniJavaPackage.CONTEXT__CHILD_CONTEXT:
			if (childContext != null)
				msgs = ((org.eclipse.emf.ecore.InternalEObject) childContext).eInverseRemove(this,
						MiniJavaPackage.CONTEXT__PARENT_CONTEXT, Context.class, msgs);
			return basicSetChildContext((Context) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MiniJavaPackage.CONTEXT__BINDINGS:
			return ((org.eclipse.emf.ecore.util.InternalEList<?>) getBindings()).basicRemove(otherEnd, msgs);
		case MiniJavaPackage.CONTEXT__PARENT_CONTEXT:
			return basicSetParentContext(null, msgs);
		case MiniJavaPackage.CONTEXT__CHILD_CONTEXT:
			return basicSetChildContext(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case MiniJavaPackage.CONTEXT__BINDINGS:
			return bindings != null && !bindings.isEmpty();
		case MiniJavaPackage.CONTEXT__PARENT_CONTEXT:
			return getParentContext() != null;
		case MiniJavaPackage.CONTEXT__CHILD_CONTEXT:
			return childContext != null;
		case MiniJavaPackage.CONTEXT__CACHE:
			return cache != null && !cache.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case MiniJavaPackage.CONTEXT__BINDINGS:
			getBindings().clear();
			getBindings().addAll((java.util.Collection<? extends SymbolBinding>) newValue);
			return;
		case MiniJavaPackage.CONTEXT__PARENT_CONTEXT:
			setParentContext((Context) newValue);
			return;
		case MiniJavaPackage.CONTEXT__CHILD_CONTEXT:
			setChildContext((Context) newValue);
			return;
		case MiniJavaPackage.CONTEXT__CACHE:
			((org.eclipse.emf.ecore.EStructuralFeature.Setting) getCache()).set(newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.CONTEXT;
	}

	public void eUnset(int featureID) {
		switch (featureID) {
		case MiniJavaPackage.CONTEXT__BINDINGS:
			getBindings().clear();
			return;
		case MiniJavaPackage.CONTEXT__PARENT_CONTEXT:
			setParentContext((Context) null);
			return;
		case MiniJavaPackage.CONTEXT__CHILD_CONTEXT:
			setChildContext((Context) null);
			return;
		case MiniJavaPackage.CONTEXT__CACHE:
			getCache().clear();
			return;
		}
		super.eUnset(featureID);
	}

	public SymbolBinding findBinding(Symbol symbol) {
		SymbolBinding result;
		if (!(minijava.MapService.containsKey(this.getCache(), symbol))) {
			SymbolBinding binding = ((SymbolBinding) org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService
					.head(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.select(this.getBindings(),
							(x) -> java.util.Objects.equals((x.getSymbol()), (symbol)))));
			if ((binding) != (null)) {
				minijava.MapService.put(this.getCache(), symbol, binding);
			} else {
				if ((this.getParentContext()) != (null)) {
					SymbolBinding binding2 = ((SymbolBinding) this.getParentContext().findBinding(symbol));
					minijava.MapService.put(this.getCache(), symbol, binding2);
				} else {
					org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log(("No binding for symbol ") + (symbol));
				}
			}
		}
		result = this.getCache().get(symbol);
		;
		return result;
	}

	public Context findCurrentContext() {
		Context result;
		if ((this.childContext) != (null)) {
			result = this.childContext.findCurrentContext();
		} else {
			result = this;
		}
		;
		return result;
	}

	public EList<SymbolBinding> getBindings() {
		if (bindings == null) {
			bindings = new EObjectContainmentEList<SymbolBinding>(SymbolBinding.class, this,
					MiniJavaPackage.CONTEXT__BINDINGS);
		}
		return bindings;
	}

	public EMap<Symbol, SymbolBinding> getCache() {
		if (cache == null) {
			cache = new EcoreEMap<Symbol, SymbolBinding>(MiniJavaPackage.Literals.SYMBOL_TO_SYMBOL_BINDING_MAP,
					SymbolToSymbolBindingMapImpl.class, this, MiniJavaPackage.CONTEXT__CACHE);
		}
		return cache;
	}

	public Context getChildContext() {
		return childContext;
	}

	public Context getParentContext() {
		if (eContainerFeatureID() != MiniJavaPackage.CONTEXT__PARENT_CONTEXT)
			return null;
		return (Context) eInternalContainer();
	}

	public void setChildContext(Context newChildContext) {
		if (newChildContext != childContext) {
			NotificationChain msgs = null;
			if (childContext != null)
				msgs = ((InternalEObject) childContext).eInverseRemove(this, MiniJavaPackage.CONTEXT__PARENT_CONTEXT,
						Context.class, msgs);
			if (newChildContext != null)
				msgs = ((InternalEObject) newChildContext).eInverseAdd(this, MiniJavaPackage.CONTEXT__PARENT_CONTEXT,
						Context.class, msgs);
			msgs = basicSetChildContext(newChildContext, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.CONTEXT__CHILD_CONTEXT,
					newChildContext, newChildContext));
	}

	public void setParentContext(Context newParentContext) {
		if (newParentContext != eInternalContainer()
				|| (eContainerFeatureID() != MiniJavaPackage.CONTEXT__PARENT_CONTEXT && newParentContext != null)) {
			if (EcoreUtil.isAncestor(this, newParentContext))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentContext != null)
				msgs = ((InternalEObject) newParentContext).eInverseAdd(this, MiniJavaPackage.CONTEXT__CHILD_CONTEXT,
						Context.class, msgs);
			msgs = basicSetParentContext(newParentContext, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.CONTEXT__PARENT_CONTEXT,
					newParentContext, newParentContext));
	}
}
