/**
 */
package testbidirectionalrelation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concept F</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link testbidirectionalrelation.ConceptF#getConceptg <em>Conceptg</em>}</li>
 * </ul>
 *
 * @see testbidirectionalrelation.TestbidirectionalrelationPackage#getConceptF()
 * @model
 * @generated
 */
public interface ConceptF extends EObject {
	/**
	 * Returns the value of the '<em><b>Conceptg</b></em>' reference list.
	 * The list contents are of type {@link testbidirectionalrelation.ConceptG}.
	 * It is bidirectional and its opposite is '{@link testbidirectionalrelation.ConceptG#getConceptf <em>Conceptf</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conceptg</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conceptg</em>' reference list.
	 * @see testbidirectionalrelation.TestbidirectionalrelationPackage#getConceptF_Conceptg()
	 * @see testbidirectionalrelation.ConceptG#getConceptf
	 * @model opposite="conceptf"
	 * @generated
	 */
	EList<ConceptG> getConceptg();

} // ConceptF
