package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.util.Collection;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;

public class ContextImpl extends MinimalEObjectImpl.Container {
	protected EList<SymbolBindingImpl> bindings;

	protected ContextImpl childContext;

	protected EMap<SymbolImpl, SymbolBindingImpl> cache;

	private SymbolBindingImpl[] bindingsArr;

	protected ContextImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.CONTEXT;
	}

	@TruffleBoundary
	public EList<SymbolBindingImpl> getBindings() {
		if (bindings == null) {
			bindings = new EObjectContainmentEList<SymbolBindingImpl>(SymbolBindingImpl.class, this, MiniJavaPackage.CONTEXT__BINDINGS);
		}
		return bindings;
	}

	@TruffleBoundary
	public ContextImpl getParentContext() {
		if (eContainerFeatureID() != MiniJavaPackage.CONTEXT__PARENT_CONTEXT)
			return null;
		return (ContextImpl) eInternalContainer();
	}

	public NotificationChain basicSetParentContext(ContextImpl newParentContext,
			NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newParentContext, MiniJavaPackage.CONTEXT__PARENT_CONTEXT, msgs);
		return msgs;
	}

	@TruffleBoundary
	public void setParentContext(ContextImpl newParentContext) {
		if (newParentContext != eInternalContainer() || (eContainerFeatureID() != MiniJavaPackage.CONTEXT__PARENT_CONTEXT && newParentContext != null)) {
			if (EcoreUtil.isAncestor(this, newParentContext))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentContext != null)
				msgs = ((InternalEObject) newParentContext).eInverseAdd(this, MiniJavaPackage.CONTEXT__CHILD_CONTEXT, ContextImpl.class, msgs);
			msgs = basicSetParentContext(newParentContext, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.CONTEXT__PARENT_CONTEXT, newParentContext, newParentContext));
	}

	@TruffleBoundary
	public ContextImpl getChildContext() {
		return childContext;
	}

	@TruffleBoundary
	public NotificationChain basicSetChildContext(ContextImpl newChildContext,
			NotificationChain msgs) {
		ContextImpl oldChildContext = childContext;
		childContext = newChildContext;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniJavaPackage.CONTEXT__CHILD_CONTEXT, oldChildContext, newChildContext);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setChildContext(ContextImpl newChildContext) {
		if (newChildContext != childContext) {
			NotificationChain msgs = null;
			if (childContext != null)
				msgs = ((InternalEObject) childContext).eInverseRemove(this, MiniJavaPackage.CONTEXT__PARENT_CONTEXT, ContextImpl.class, msgs);
			if (newChildContext != null)
				msgs = ((InternalEObject) newChildContext).eInverseAdd(this, MiniJavaPackage.CONTEXT__PARENT_CONTEXT, ContextImpl.class, msgs);
			msgs = basicSetChildContext(newChildContext, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.CONTEXT__CHILD_CONTEXT, newChildContext, newChildContext));
	}

	@TruffleBoundary
	public EMap<SymbolImpl, SymbolBindingImpl> getCache() {
		if (cache == null) {
			cache = new EcoreEMap<SymbolImpl, SymbolBindingImpl>(MiniJavaPackage.Literals.SYMBOL_TO_SYMBOL_BINDING_MAP, SymbolToSymbolBindingMapImpl.class, this, MiniJavaPackage.CONTEXT__CACHE);
		}
		return cache;
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case MiniJavaPackage.CONTEXT__PARENT_CONTEXT :
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentContext((ContextImpl) otherEnd, msgs);
			case MiniJavaPackage.CONTEXT__CHILD_CONTEXT :
				if (childContext != null)
					msgs = ((InternalEObject) childContext).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.CONTEXT__CHILD_CONTEXT, null, msgs);
				return basicSetChildContext((ContextImpl) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case MiniJavaPackage.CONTEXT__BINDINGS :
				return ((InternalEList<?>) getBindings()).basicRemove(otherEnd, msgs);
			case MiniJavaPackage.CONTEXT__PARENT_CONTEXT :
				return basicSetParentContext(null, msgs);
			case MiniJavaPackage.CONTEXT__CHILD_CONTEXT :
				return basicSetChildContext(null, msgs);
			case MiniJavaPackage.CONTEXT__CACHE :
				return ((InternalEList<?>) getCache()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case MiniJavaPackage.CONTEXT__PARENT_CONTEXT :
				return eInternalContainer().eInverseRemove(this, MiniJavaPackage.CONTEXT__CHILD_CONTEXT, ContextImpl.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MiniJavaPackage.CONTEXT__BINDINGS :
				return getBindings();
			case MiniJavaPackage.CONTEXT__PARENT_CONTEXT :
				return getParentContext();
			case MiniJavaPackage.CONTEXT__CHILD_CONTEXT :
				return getChildContext();
			case MiniJavaPackage.CONTEXT__CACHE :
				if (coreType) return getCache();
				else return getCache().map();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MiniJavaPackage.CONTEXT__BINDINGS :
				getBindings().clear();
				getBindings().addAll((Collection<? extends SymbolBindingImpl>) newValue);
				return;
			case MiniJavaPackage.CONTEXT__PARENT_CONTEXT :
				setParentContext((ContextImpl) newValue);
				return;
			case MiniJavaPackage.CONTEXT__CHILD_CONTEXT :
				setChildContext((ContextImpl) newValue);
				return;
			case MiniJavaPackage.CONTEXT__CACHE :
				((Setting)getCache()).set(newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.CONTEXT__BINDINGS :
				getBindings().clear();
				return;
			case MiniJavaPackage.CONTEXT__PARENT_CONTEXT :
				setParentContext((ContextImpl) null);
				return;
			case MiniJavaPackage.CONTEXT__CHILD_CONTEXT :
				setChildContext((ContextImpl) null);
				return;
			case MiniJavaPackage.CONTEXT__CACHE :
				getCache().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.CONTEXT__BINDINGS :
				return bindings != null && !bindings.isEmpty();
			case MiniJavaPackage.CONTEXT__PARENT_CONTEXT :
				return getParentContext() != null;
			case MiniJavaPackage.CONTEXT__CHILD_CONTEXT :
				return childContext != null;
			case MiniJavaPackage.CONTEXT__CACHE :
				return cache != null && !cache.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@TruffleBoundary
	public SymbolBindingImpl findBinding(SymbolImpl symbol) {
		SymbolBindingImpl result;
		if (this.bindingsArr == null) {
			CompilerDirectives.transferToInterpreterAndInvalidate();
			if (this.bindings != null) this.bindingsArr = this.bindings.toArray(new SymbolBindingImpl[0]);
			else this.bindingsArr = new SymbolBindingImpl[] {};
		}
		if (!(this.getCache().containsKey((SymbolImpl) (symbol)))) {
			SymbolBindingImpl binding = ((SymbolBindingImpl) (CollectionService.head(CollectionService.select(this.bindingsArr, (x) -> EqualService.equals((x.getSymbol()), (symbol))))));
			if (!EqualService.equals((binding), (null))) {
				this.getCache().put((SymbolImpl) (symbol), (SymbolBindingImpl) (binding));
			}
			else {
				if (!EqualService.equals((this.getParentContext()), (null))) {
					SymbolBindingImpl binding2 = ((SymbolBindingImpl) (((ContextImpl) (this.getParentContext())).findBinding((SymbolImpl) (symbol))));
					this.getCache().put((SymbolImpl) (symbol), (SymbolBindingImpl) (binding2));
				}
				else {
					LogService.log(("No binding for symbol ") + (symbol));
				}
			}
		}
		result = (SymbolBindingImpl) (this.getCache().get((SymbolImpl) (symbol))) ;

		return result;
	}

	@TruffleBoundary
	public ContextImpl findCurrentContext() {
		ContextImpl result;
		if (this.bindingsArr == null) {
			CompilerDirectives.transferToInterpreterAndInvalidate();
			if (this.bindings != null) this.bindingsArr = this.bindings.toArray(new SymbolBindingImpl[0]);
			else this.bindingsArr = new SymbolBindingImpl[] {};
		}
		if (!EqualService.equals((this.getChildContext()), (null))) {
			result = (ContextImpl) (((ContextImpl) (this.getChildContext())).findCurrentContext()) ;
		}
		else {
			result = (ContextImpl) (this) ;
		}

		return result;
	}
}
