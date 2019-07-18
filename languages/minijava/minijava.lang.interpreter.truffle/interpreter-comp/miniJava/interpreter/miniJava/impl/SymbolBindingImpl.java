package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import java.lang.Object;
import java.lang.Override;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public class SymbolBindingImpl extends MinimalEObjectImpl.Container {
	protected ValueImpl value;

	protected SymbolImpl symbol;

	protected SymbolBindingImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.SYMBOL_BINDING;
	}

	@TruffleBoundary
	public ValueImpl getValue() {
		return value;
	}

	@TruffleBoundary
	public NotificationChain basicSetValue(ValueImpl newValue, NotificationChain msgs) {
		ValueImpl oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniJavaPackage.SYMBOL_BINDING__VALUE, oldValue, newValue);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setValue(ValueImpl newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject) value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.SYMBOL_BINDING__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject) newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.SYMBOL_BINDING__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.SYMBOL_BINDING__VALUE, newValue, newValue));
	}

	@TruffleBoundary
	public SymbolImpl getSymbol() {
		if (symbol != null && symbol.eIsProxy()) {
			InternalEObject oldSymbol = (InternalEObject) symbol;
			symbol = (SymbolImpl) eResolveProxy(oldSymbol);
			if (symbol != oldSymbol) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.SYMBOL_BINDING__SYMBOL, oldSymbol, symbol));
			}
		}
		return symbol;
	}

	public SymbolImpl basicGetSymbol() {
		return symbol;
	}

	@TruffleBoundary
	public void setSymbol(SymbolImpl newSymbol) {
		SymbolImpl oldSymbol = symbol;
		symbol = newSymbol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.SYMBOL_BINDING__SYMBOL, oldSymbol, symbol));
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case MiniJavaPackage.SYMBOL_BINDING__VALUE :
				return basicSetValue(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MiniJavaPackage.SYMBOL_BINDING__VALUE :
				return getValue();
			case MiniJavaPackage.SYMBOL_BINDING__SYMBOL :
				if (resolve)
					return getSymbol();
				return basicGetSymbol();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MiniJavaPackage.SYMBOL_BINDING__VALUE :
				setValue((ValueImpl) newValue);
				return;
			case MiniJavaPackage.SYMBOL_BINDING__SYMBOL :
				setSymbol((SymbolImpl) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.SYMBOL_BINDING__VALUE :
				setValue((ValueImpl) null);
				return;
			case MiniJavaPackage.SYMBOL_BINDING__SYMBOL :
				setSymbol((SymbolImpl) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.SYMBOL_BINDING__VALUE :
				return value != null;
			case MiniJavaPackage.SYMBOL_BINDING__SYMBOL :
				return symbol != null;
		}
		return super.eIsSet(featureID);
	}
}
