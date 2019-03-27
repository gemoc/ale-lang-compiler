/**
 */
package testoperationbody;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Main</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link testoperationbody.Main#getListint <em>Listint</em>}</li>
 *   <li>{@link testoperationbody.Main#getListconcepta <em>Listconcepta</em>}</li>
 *   <li>{@link testoperationbody.Main#isSinglebool <em>Singlebool</em>}</li>
 *   <li>{@link testoperationbody.Main#getSingleconcepta <em>Singleconcepta</em>}</li>
 *   <li>{@link testoperationbody.Main#getChildren <em>Children</em>}</li>
 * </ul>
 *
 * @see testoperationbody.TestoperationbodyPackage#getMain()
 * @model
 * @generated
 */
public interface Main extends EObject {
	/**
	 * Returns the value of the '<em><b>Listint</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Listint</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Listint</em>' attribute list.
	 * @see testoperationbody.TestoperationbodyPackage#getMain_Listint()
	 * @model
	 * @generated
	 */
	EList<Integer> getListint();

	/**
	 * Returns the value of the '<em><b>Listconcepta</b></em>' containment reference list.
	 * The list contents are of type {@link testoperationbody.ConceptA}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Listconcepta</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Listconcepta</em>' containment reference list.
	 * @see testoperationbody.TestoperationbodyPackage#getMain_Listconcepta()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConceptA> getListconcepta();

	/**
	 * Returns the value of the '<em><b>Singlebool</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Singlebool</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Singlebool</em>' attribute.
	 * @see #setSinglebool(boolean)
	 * @see testoperationbody.TestoperationbodyPackage#getMain_Singlebool()
	 * @model
	 * @generated
	 */
	boolean isSinglebool();

	/**
	 * Sets the value of the '{@link testoperationbody.Main#isSinglebool <em>Singlebool</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Singlebool</em>' attribute.
	 * @see #isSinglebool()
	 * @generated
	 */
	void setSinglebool(boolean value);

	/**
	 * Returns the value of the '<em><b>Singleconcepta</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Singleconcepta</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Singleconcepta</em>' reference.
	 * @see #setSingleconcepta(ConceptA)
	 * @see testoperationbody.TestoperationbodyPackage#getMain_Singleconcepta()
	 * @model
	 * @generated
	 */
	ConceptA getSingleconcepta();

	/**
	 * Sets the value of the '{@link testoperationbody.Main#getSingleconcepta <em>Singleconcepta</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Singleconcepta</em>' reference.
	 * @see #getSingleconcepta()
	 * @generated
	 */
	void setSingleconcepta(ConceptA value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link testoperationbody.Parent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see testoperationbody.TestoperationbodyPackage#getMain_Children()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parent> getChildren();

} // Main
