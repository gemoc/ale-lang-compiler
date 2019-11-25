/**
 */
package x.y.z.functioncall;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concept C</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link x.y.z.functioncall.ConceptC#getConcepta2 <em>Concepta2</em>}</li>
 *   <li>{@link x.y.z.functioncall.ConceptC#getConcepta1 <em>Concepta1</em>}</li>
 *   <li>{@link x.y.z.functioncall.ConceptC#getConceptb <em>Conceptb</em>}</li>
 * </ul>
 *
 * @see x.y.z.functioncall.FunctioncallPackage#getConceptC()
 * @model
 * @generated
 */
public interface ConceptC extends EObject {
	/**
	 * Returns the value of the '<em><b>Concepta2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concepta2</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concepta2</em>' containment reference.
	 * @see #setConcepta2(ConceptA)
	 * @see x.y.z.functioncall.FunctioncallPackage#getConceptC_Concepta2()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ConceptA getConcepta2();

	/**
	 * Sets the value of the '{@link x.y.z.functioncall.ConceptC#getConcepta2 <em>Concepta2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Concepta2</em>' containment reference.
	 * @see #getConcepta2()
	 * @generated
	 */
	void setConcepta2(ConceptA value);

	/**
	 * Returns the value of the '<em><b>Concepta1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concepta1</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concepta1</em>' containment reference.
	 * @see #setConcepta1(ConceptA)
	 * @see x.y.z.functioncall.FunctioncallPackage#getConceptC_Concepta1()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ConceptA getConcepta1();

	/**
	 * Sets the value of the '{@link x.y.z.functioncall.ConceptC#getConcepta1 <em>Concepta1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Concepta1</em>' containment reference.
	 * @see #getConcepta1()
	 * @generated
	 */
	void setConcepta1(ConceptA value);

	/**
	 * Returns the value of the '<em><b>Conceptb</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conceptb</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conceptb</em>' containment reference.
	 * @see #setConceptb(ConceptB)
	 * @see x.y.z.functioncall.FunctioncallPackage#getConceptC_Conceptb()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ConceptB getConceptb();

	/**
	 * Sets the value of the '{@link x.y.z.functioncall.ConceptC#getConceptb <em>Conceptb</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conceptb</em>' containment reference.
	 * @see #getConceptb()
	 * @generated
	 */
	void setConceptb(ConceptB value);

} // ConceptC
