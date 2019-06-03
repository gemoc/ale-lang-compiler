package miniJava.interpreter.miniJava.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.This;

public class ThisImpl extends ExpressionImpl implements This {
	protected ThisImpl() {
		super();
	}

	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		}
		return super.eGet(featureID, resolve, coreType);
	}

	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	public boolean eIsSet(int featureID) {
		switch (featureID) {
		}
		return super.eIsSet(featureID);
	}

	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		}
		super.eSet(featureID, newValue);
	}

	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.THIS;
	}

	public void eUnset(int featureID) {
		switch (featureID) {
		}
		super.eUnset(featureID);
	}
}
