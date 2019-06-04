/**
 */
package testaccessors;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EAcc</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link testaccessors.EAcc#isB <em>B</em>}</li>
 *   <li>{@link testaccessors.EAcc#getI <em>I</em>}</li>
 *   <li>{@link testaccessors.EAcc#getBs <em>Bs</em>}</li>
 *   <li>{@link testaccessors.EAcc#getIs <em>Is</em>}</li>
 * </ul>
 *
 * @see testaccessors.TestaccessorsPackage#getEAcc()
 * @model
 * @generated
 */
public interface EAcc extends EObject {
	/**
	 * Returns the value of the '<em><b>B</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>B</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>B</em>' attribute.
	 * @see #setB(boolean)
	 * @see testaccessors.TestaccessorsPackage#getEAcc_B()
	 * @model
	 * @generated
	 */
	boolean isB();

	/**
	 * Sets the value of the '{@link testaccessors.EAcc#isB <em>B</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>B</em>' attribute.
	 * @see #isB()
	 * @generated
	 */
	void setB(boolean value);

	/**
	 * Returns the value of the '<em><b>I</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>I</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>I</em>' attribute.
	 * @see #setI(int)
	 * @see testaccessors.TestaccessorsPackage#getEAcc_I()
	 * @model
	 * @generated
	 */
	int getI();

	/**
	 * Sets the value of the '{@link testaccessors.EAcc#getI <em>I</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>I</em>' attribute.
	 * @see #getI()
	 * @generated
	 */
	void setI(int value);

	/**
	 * Returns the value of the '<em><b>Bs</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Boolean}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bs</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bs</em>' attribute list.
	 * @see testaccessors.TestaccessorsPackage#getEAcc_Bs()
	 * @model
	 * @generated
	 */
	EList<Boolean> getBs();

	/**
	 * Returns the value of the '<em><b>Is</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is</em>' attribute list.
	 * @see testaccessors.TestaccessorsPackage#getEAcc_Is()
	 * @model
	 * @generated
	 */
	EList<Integer> getIs();

} // EAcc
