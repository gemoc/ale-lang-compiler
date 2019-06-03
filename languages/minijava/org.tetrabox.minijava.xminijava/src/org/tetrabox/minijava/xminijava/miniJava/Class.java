/**
 */
package org.tetrabox.minijava.xminijava.miniJava;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.tetrabox.minijava.xminijava.miniJava.Class#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.tetrabox.minijava.xminijava.miniJava.Class#getSuperClass <em>Super Class</em>}</li>
 * </ul>
 *
 * @see org.tetrabox.minijava.xminijava.miniJava.MiniJavaPackage#getClass_()
 * @model
 * @generated
 */
public interface Class extends TypeDeclaration {
	/**
	 * Returns the value of the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract</em>' attribute.
	 * @see #setAbstract(boolean)
	 * @see org.tetrabox.minijava.xminijava.miniJava.MiniJavaPackage#getClass_Abstract()
	 * @model
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link org.tetrabox.minijava.xminijava.miniJava.Class#isAbstract <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract</em>' attribute.
	 * @see #isAbstract()
	 * @generated
	 */
	void setAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>Super Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Class</em>' reference.
	 * @see #setSuperClass(Class)
	 * @see org.tetrabox.minijava.xminijava.miniJava.MiniJavaPackage#getClass_SuperClass()
	 * @model
	 * @generated
	 */
	Class getSuperClass();

	/**
	 * Sets the value of the '{@link org.tetrabox.minijava.xminijava.miniJava.Class#getSuperClass <em>Super Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Class</em>' reference.
	 * @see #getSuperClass()
	 * @generated
	 */
	void setSuperClass(Class value);

} // Class
