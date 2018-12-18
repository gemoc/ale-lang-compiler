package miniJava.interpreter.miniJava.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;

import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.OutputStream;

public class OutputStreamImpl extends MinimalEObjectImpl.Container implements OutputStream {
	protected EList<String> stream;

	protected OutputStreamImpl() {
		super();
	}

	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MiniJavaPackage.OUTPUT_STREAM__STREAM:
			return getStream();
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
		case MiniJavaPackage.OUTPUT_STREAM__STREAM:
			return stream != null && !stream.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case MiniJavaPackage.OUTPUT_STREAM__STREAM:
			getStream().clear();
			getStream().addAll((java.util.Collection<? extends String>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.OUTPUT_STREAM;
	}

	public void eUnset(int featureID) {
		switch (featureID) {
		case MiniJavaPackage.OUTPUT_STREAM__STREAM:
			getStream().clear();
			return;
		}
		super.eUnset(featureID);
	}

	public EList<String> getStream() {
		if (stream == null) {
			stream = new EDataTypeEList<String>(String.class, this, MiniJavaPackage.OUTPUT_STREAM__STREAM);
		}
		return stream;
	}
}
