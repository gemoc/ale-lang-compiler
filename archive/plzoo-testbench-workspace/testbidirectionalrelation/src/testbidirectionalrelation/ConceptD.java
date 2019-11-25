/**
 */
package testbidirectionalrelation;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concept D</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link testbidirectionalrelation.ConceptD#getConcepte <em>Concepte</em>}</li>
 * </ul>
 *
 * @see testbidirectionalrelation.TestbidirectionalrelationPackage#getConceptD()
 * @model
 * @generated
 */
public interface ConceptD extends EObject {
	/**
	 * Returns the value of the '<em><b>Concepte</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link testbidirectionalrelation.ConceptE#getConceptd <em>Conceptd</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concepte</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concepte</em>' reference.
	 * @see #setConcepte(ConceptE)
	 * @see testbidirectionalrelation.TestbidirectionalrelationPackage#getConceptD_Concepte()
	 * @see testbidirectionalrelation.ConceptE#getConceptd
	 * @model opposite="conceptd"
	 * @generated
	 */
	ConceptE getConcepte();

	/**
	 * Sets the value of the '{@link testbidirectionalrelation.ConceptD#getConcepte <em>Concepte</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Concepte</em>' reference.
	 * @see #getConcepte()
	 * @generated
	 */
	void setConcepte(ConceptE value);

} // ConceptD
