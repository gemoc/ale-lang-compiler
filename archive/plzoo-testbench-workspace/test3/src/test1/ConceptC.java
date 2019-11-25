/**
 */
package test1;

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
 *   <li>{@link test1.ConceptC#getNbr <em>Nbr</em>}</li>
 *   <li>{@link test1.ConceptC#isCool <em>Cool</em>}</li>
 * </ul>
 *
 * @see test1.Test1Package#getConceptC()
 * @model
 * @generated
 */
public interface ConceptC extends EObject {
	/**
	 * Returns the value of the '<em><b>Nbr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nbr</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nbr</em>' attribute.
	 * @see #setNbr(int)
	 * @see test1.Test1Package#getConceptC_Nbr()
	 * @model
	 * @generated
	 */
	int getNbr();

	/**
	 * Sets the value of the '{@link test1.ConceptC#getNbr <em>Nbr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nbr</em>' attribute.
	 * @see #getNbr()
	 * @generated
	 */
	void setNbr(int value);

	/**
	 * Returns the value of the '<em><b>Cool</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cool</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cool</em>' attribute.
	 * @see #setCool(boolean)
	 * @see test1.Test1Package#getConceptC_Cool()
	 * @model
	 * @generated
	 */
	boolean isCool();

	/**
	 * Sets the value of the '{@link test1.ConceptC#isCool <em>Cool</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cool</em>' attribute.
	 * @see #isCool()
	 * @generated
	 */
	void setCool(boolean value);

} // ConceptC
