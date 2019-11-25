/**
 */
package testbidirectionalrelation;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concept B</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link testbidirectionalrelation.ConceptB#getConceptc <em>Conceptc</em>}</li>
 * </ul>
 *
 * @see testbidirectionalrelation.TestbidirectionalrelationPackage#getConceptB()
 * @model
 * @generated
 */
public interface ConceptB extends EObject {
	/**
	 * Returns the value of the '<em><b>Conceptc</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link testbidirectionalrelation.ConceptC#getConceptb <em>Conceptb</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conceptc</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conceptc</em>' reference.
	 * @see #setConceptc(ConceptC)
	 * @see testbidirectionalrelation.TestbidirectionalrelationPackage#getConceptB_Conceptc()
	 * @see testbidirectionalrelation.ConceptC#getConceptb
	 * @model opposite="conceptb"
	 * @generated
	 */
	ConceptC getConceptc();

	/**
	 * Sets the value of the '{@link testbidirectionalrelation.ConceptB#getConceptc <em>Conceptc</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conceptc</em>' reference.
	 * @see #getConceptc()
	 * @generated
	 */
	void setConceptc(ConceptC value);

} // ConceptB
