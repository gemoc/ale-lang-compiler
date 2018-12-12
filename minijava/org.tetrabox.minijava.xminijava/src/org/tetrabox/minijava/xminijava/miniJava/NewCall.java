/**
 */
package org.tetrabox.minijava.xminijava.miniJava;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>New Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.tetrabox.minijava.xminijava.miniJava.NewCall#getNew <em>New</em>}</li>
 * </ul>
 *
 * @see org.tetrabox.minijava.xminijava.miniJava.MiniJavaPackage#getNewCall()
 * @model
 * @generated
 */
public interface NewCall extends Call {
	/**
	 * Returns the value of the '<em><b>New</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New</em>' reference.
	 * @see #setNew(NewObject)
	 * @see org.tetrabox.minijava.xminijava.miniJava.MiniJavaPackage#getNewCall_New()
	 * @model required="true"
	 * @generated
	 */
	NewObject getNew();

	/**
	 * Sets the value of the '{@link org.tetrabox.minijava.xminijava.miniJava.NewCall#getNew <em>New</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New</em>' reference.
	 * @see #getNew()
	 * @generated
	 */
	void setNew(NewObject value);

} // NewCall
