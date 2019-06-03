package interpreter.imp.interpreter.imp.impl;

import interpreter.imp.interpreter.imp.ImpPackage;
import interpreter.imp.interpreter.imp.Store;
import interpreter.imp.interpreter.imp.Value;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

public class StoreImpl extends MinimalEObjectImpl.Container implements Store {
	protected EMap<String, Value> values;

	protected StoreImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return ImpPackage.Literals.STORE;
	}

	public EMap<String, Value> getValues() {
		if (values == null) {
			values = new EcoreEMap<String, Value>(ImpPackage.Literals.STRING_TO_VALUE_MAP, StringToValueMapImpl.class, this, ImpPackage.STORE__VALUES);
		}
		return values;
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case ImpPackage.STORE__VALUES :
				return ((InternalEList<?>) getValues()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImpPackage.STORE__VALUES :
				if (coreType) return getValues();
				else return getValues().map();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ImpPackage.STORE__VALUES :
				((Setting)getValues()).set(newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ImpPackage.STORE__VALUES :
				getValues().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ImpPackage.STORE__VALUES :
				return values != null && !values.isEmpty();
		}
		return super.eIsSet(featureID);
	}
}
