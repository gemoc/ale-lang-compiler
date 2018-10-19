/**
 */
package petrinet.model.petrinet;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Place</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link petrinet.model.petrinet.Place#getTokenNb <em>Token Nb</em>}</li>
 * </ul>
 *
 * @see petrinet.model.petrinet.PetrinetPackage#getPlace()
 * @model
 * @generated
 */
public interface Place extends Node {
	/**
	 * Returns the value of the '<em><b>Token Nb</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Token Nb</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Token Nb</em>' attribute.
	 * @see #setTokenNb(int)
	 * @see petrinet.model.petrinet.PetrinetPackage#getPlace_TokenNb()
	 * @model
	 * @generated
	 */
	int getTokenNb();

	/**
	 * Sets the value of the '{@link petrinet.model.petrinet.Place#getTokenNb <em>Token Nb</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Token Nb</em>' attribute.
	 * @see #getTokenNb()
	 * @generated
	 */
	void setTokenNb(int value);

} // Place
