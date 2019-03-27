/**
 */
package testbidirectionalrelation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concept E</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link testbidirectionalrelation.ConceptE#getConceptd <em>Conceptd</em>}</li>
 * </ul>
 *
 * @see testbidirectionalrelation.TestbidirectionalrelationPackage#getConceptE()
 * @model
 * @generated
 */
public interface ConceptE extends EObject {
	/**
	 * Returns the value of the '<em><b>Conceptd</b></em>' reference list.
	 * The list contents are of type {@link testbidirectionalrelation.ConceptD}.
	 * It is bidirectional and its opposite is '{@link testbidirectionalrelation.ConceptD#getConcepte <em>Concepte</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conceptd</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conceptd</em>' reference list.
	 * @see testbidirectionalrelation.TestbidirectionalrelationPackage#getConceptE_Conceptd()
	 * @see testbidirectionalrelation.ConceptD#getConcepte
	 * @model opposite="concepte"
	 * @generated
	 */
	EList<ConceptD> getConceptd();

} // ConceptE
