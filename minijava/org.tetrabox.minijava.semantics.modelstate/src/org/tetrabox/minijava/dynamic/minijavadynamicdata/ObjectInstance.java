/**
 */
package org.tetrabox.minijava.dynamic.minijavadynamicdata;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.tetrabox.minijava.dynamic.minijavadynamicdata.ObjectInstance#getFieldbindings <em>Fieldbindings</em>}</li>
 *   <li>{@link org.tetrabox.minijava.dynamic.minijavadynamicdata.ObjectInstance#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.tetrabox.minijava.dynamic.minijavadynamicdata.MinijavadynamicdataPackage#getObjectInstance()
 * @model
 * @generated
 */
public interface ObjectInstance extends EObject {
	/**
	 * Returns the value of the '<em><b>Fieldbindings</b></em>' containment reference list.
	 * The list contents are of type {@link org.tetrabox.minijava.dynamic.minijavadynamicdata.FieldBinding}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fieldbindings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fieldbindings</em>' containment reference list.
	 * @see org.tetrabox.minijava.dynamic.minijavadynamicdata.MinijavadynamicdataPackage#getObjectInstance_Fieldbindings()
	 * @model containment="true"
	 * @generated
	 */
	EList<FieldBinding> getFieldbindings();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(org.tetrabox.minijava.xtext.miniJava.Class)
	 * @see org.tetrabox.minijava.dynamic.minijavadynamicdata.MinijavadynamicdataPackage#getObjectInstance_Type()
	 * @model required="true"
	 * @generated
	 */
	org.tetrabox.minijava.xtext.miniJava.Class getType();

	/**
	 * Sets the value of the '{@link org.tetrabox.minijava.dynamic.minijavadynamicdata.ObjectInstance#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(org.tetrabox.minijava.xtext.miniJava.Class value);

} // ObjectInstance
