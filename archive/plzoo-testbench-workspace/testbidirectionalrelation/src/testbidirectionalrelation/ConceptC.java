/**
 */
package testbidirectionalrelation;

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
 *   <li>{@link testbidirectionalrelation.ConceptC#getConceptb <em>Conceptb</em>}</li>
 * </ul>
 *
 * @see testbidirectionalrelation.TestbidirectionalrelationPackage#getConceptC()
 * @model
 * @generated
 */
public interface ConceptC extends EObject {
	/**
	 * Returns the value of the '<em><b>Conceptb</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link testbidirectionalrelation.ConceptB#getConceptc <em>Conceptc</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conceptb</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conceptb</em>' reference.
	 * @see #setConceptb(ConceptB)
	 * @see testbidirectionalrelation.TestbidirectionalrelationPackage#getConceptC_Conceptb()
	 * @see testbidirectionalrelation.ConceptB#getConceptc
	 * @model opposite="conceptc"
	 * @generated
	 */
	ConceptB getConceptb();

	/**
	 * Sets the value of the '{@link testbidirectionalrelation.ConceptC#getConceptb <em>Conceptb</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conceptb</em>' reference.
	 * @see #getConceptb()
	 * @generated
	 */
	void setConceptb(ConceptB value);

} // ConceptC
