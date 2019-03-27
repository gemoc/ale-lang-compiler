/**
 */
package testbidirectionalrelation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concept G</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link testbidirectionalrelation.ConceptG#getConceptf <em>Conceptf</em>}</li>
 * </ul>
 *
 * @see testbidirectionalrelation.TestbidirectionalrelationPackage#getConceptG()
 * @model
 * @generated
 */
public interface ConceptG extends EObject {
	/**
	 * Returns the value of the '<em><b>Conceptf</b></em>' reference list.
	 * The list contents are of type {@link testbidirectionalrelation.ConceptF}.
	 * It is bidirectional and its opposite is '{@link testbidirectionalrelation.ConceptF#getConceptg <em>Conceptg</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conceptf</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conceptf</em>' reference list.
	 * @see testbidirectionalrelation.TestbidirectionalrelationPackage#getConceptG_Conceptf()
	 * @see testbidirectionalrelation.ConceptF#getConceptg
	 * @model opposite="conceptg"
	 * @generated
	 */
	EList<ConceptF> getConceptf();

} // ConceptG
