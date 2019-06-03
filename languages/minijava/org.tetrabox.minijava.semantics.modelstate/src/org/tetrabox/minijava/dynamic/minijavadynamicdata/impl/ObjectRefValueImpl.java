/**
 */
package org.tetrabox.minijava.dynamic.minijavadynamicdata.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.tetrabox.minijava.dynamic.minijavadynamicdata.MinijavadynamicdataPackage;
import org.tetrabox.minijava.dynamic.minijavadynamicdata.ObjectInstance;
import org.tetrabox.minijava.dynamic.minijavadynamicdata.ObjectRefValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Ref Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.tetrabox.minijava.dynamic.minijavadynamicdata.impl.ObjectRefValueImpl#getInstance <em>Instance</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ObjectRefValueImpl extends ValueImpl implements ObjectRefValue {
	/**
	 * The cached value of the '{@link #getInstance() <em>Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstance()
	 * @generated
	 * @ordered
	 */
	protected ObjectInstance instance;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectRefValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MinijavadynamicdataPackage.Literals.OBJECT_REF_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectInstance getInstance() {
		if (instance != null && instance.eIsProxy()) {
			InternalEObject oldInstance = (InternalEObject)instance;
			instance = (ObjectInstance)eResolveProxy(oldInstance);
			if (instance != oldInstance) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MinijavadynamicdataPackage.OBJECT_REF_VALUE__INSTANCE, oldInstance, instance));
			}
		}
		return instance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectInstance basicGetInstance() {
		return instance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstance(ObjectInstance newInstance) {
		ObjectInstance oldInstance = instance;
		instance = newInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MinijavadynamicdataPackage.OBJECT_REF_VALUE__INSTANCE, oldInstance, instance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MinijavadynamicdataPackage.OBJECT_REF_VALUE__INSTANCE:
				if (resolve) return getInstance();
				return basicGetInstance();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MinijavadynamicdataPackage.OBJECT_REF_VALUE__INSTANCE:
				setInstance((ObjectInstance)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MinijavadynamicdataPackage.OBJECT_REF_VALUE__INSTANCE:
				setInstance((ObjectInstance)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MinijavadynamicdataPackage.OBJECT_REF_VALUE__INSTANCE:
				return instance != null;
		}
		return super.eIsSet(featureID);
	}

} //ObjectRefValueImpl
