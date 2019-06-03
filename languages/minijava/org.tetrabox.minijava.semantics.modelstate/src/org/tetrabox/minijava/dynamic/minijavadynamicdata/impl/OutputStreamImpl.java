/**
 */
package org.tetrabox.minijava.dynamic.minijavadynamicdata.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.tetrabox.minijava.dynamic.minijavadynamicdata.MinijavadynamicdataPackage;
import org.tetrabox.minijava.dynamic.minijavadynamicdata.OutputStream;

public class OutputStreamImpl extends MinimalEObjectImpl.Container implements OutputStream {
	protected EList<String> stream;

	protected OutputStreamImpl() {
		super();
	}

	public EList<String> getStream() {
		if (stream == null) {
			stream = new EDataTypeEList<String>(String.class, this, MinijavadynamicdataPackage.OUTPUT_STREAM__STREAM);
		}
		return stream;
	}

	protected EClass eStaticClass() {
		return MinijavadynamicdataPackage.Literals.OUTPUT_STREAM;
	}

	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case MinijavadynamicdataPackage.OUTPUT_STREAM__STREAM:
			getStream().clear();
			getStream().addAll((Collection<? extends String>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}
	
	public void eUnset(int featureID) {
		switch (featureID) {
		case MinijavadynamicdataPackage.OUTPUT_STREAM__STREAM:
			getStream().clear();
			return;
		}
		super.eUnset(featureID);
	}

	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MinijavadynamicdataPackage.OUTPUT_STREAM__STREAM:
			return getStream();
		}
		return super.eGet(featureID, resolve, coreType);
	}
	
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case MinijavadynamicdataPackage.OUTPUT_STREAM__STREAM:
			return stream != null && !stream.isEmpty();
		}
		return super.eIsSet(featureID);
	}


	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (stream: ");
		result.append(stream);
		result.append(')');
		return result.toString();
	}

} // OutputStreamImpl
