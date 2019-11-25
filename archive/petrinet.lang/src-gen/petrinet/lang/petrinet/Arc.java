/**
 */
package petrinet.lang.petrinet;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Arc</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link petrinet.lang.petrinet.Arc#getTarget <em>Target</em>}</li>
 *   <li>{@link petrinet.lang.petrinet.Arc#getSource <em>Source</em>}</li>
 * </ul>
 *
 * @see petrinet.lang.petrinet.PetrinetPackage#getArc()
 * @model
 * @generated
 */
public interface Arc extends EObject {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link petrinet.lang.petrinet.Node#getIncomming <em>Incomming</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Node)
	 * @see petrinet.lang.petrinet.PetrinetPackage#getArc_Target()
	 * @see petrinet.lang.petrinet.Node#getIncomming
	 * @model opposite="incomming" required="true"
	 * @generated
	 */
	Node getTarget();

	/**
	 * Sets the value of the '{@link petrinet.lang.petrinet.Arc#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Node value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link petrinet.lang.petrinet.Node#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Node)
	 * @see petrinet.lang.petrinet.PetrinetPackage#getArc_Source()
	 * @see petrinet.lang.petrinet.Node#getOutgoing
	 * @model opposite="outgoing" required="true"
	 * @generated
	 */
	Node getSource();

	/**
	 * Sets the value of the '{@link petrinet.lang.petrinet.Arc#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Node value);

} // Arc
