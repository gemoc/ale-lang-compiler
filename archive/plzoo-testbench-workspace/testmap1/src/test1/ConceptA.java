/**
 */
package test1;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concept A</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link test1.ConceptA#getCs <em>Cs</em>}</li>
 * </ul>
 *
 * @see test1.Test1Package#getConceptA()
 * @model
 * @generated
 */
public interface ConceptA extends EObject {
	/**
	 * Returns the value of the '<em><b>Cs</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.Integer},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cs</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cs</em>' map.
	 * @see test1.Test1Package#getConceptA_Cs()
	 * @model mapType="test1.StringToIntegerMapEntry&lt;org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EIntegerObject&gt;"
	 * @generated
	 */
	EMap<String, Integer> getCs();

} // ConceptA
