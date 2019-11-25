/**
 */
package petrinet.lang.petrinet;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link petrinet.lang.petrinet.Node#getName <em>Name</em>}</li>
 *   <li>{@link petrinet.lang.petrinet.Node#getIncomming <em>Incomming</em>}</li>
 *   <li>{@link petrinet.lang.petrinet.Node#getOutgoing <em>Outgoing</em>}</li>
 * </ul>
 *
 * @see petrinet.lang.petrinet.PetrinetPackage#getNode()
 * @model abstract="true"
 * @generated
 */
public interface Node extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see petrinet.lang.petrinet.PetrinetPackage#getNode_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link petrinet.lang.petrinet.Node#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Incomming</b></em>' reference list.
	 * The list contents are of type {@link petrinet.lang.petrinet.Arc}.
	 * It is bidirectional and its opposite is '{@link petrinet.lang.petrinet.Arc#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incomming</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incomming</em>' reference list.
	 * @see petrinet.lang.petrinet.PetrinetPackage#getNode_Incomming()
	 * @see petrinet.lang.petrinet.Arc#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<Arc> getIncomming();

	/**
	 * Returns the value of the '<em><b>Outgoing</b></em>' reference list.
	 * The list contents are of type {@link petrinet.lang.petrinet.Arc}.
	 * It is bidirectional and its opposite is '{@link petrinet.lang.petrinet.Arc#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing</em>' reference list.
	 * @see petrinet.lang.petrinet.PetrinetPackage#getNode_Outgoing()
	 * @see petrinet.lang.petrinet.Arc#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<Arc> getOutgoing();

} // Node
