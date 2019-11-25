/**
 */
package imp.model.imp;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Store</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link imp.model.imp.Store#getValues <em>Values</em>}</li>
 * </ul>
 *
 * @see imp.model.imp.ImpPackage#getStore()
 * @model
 * @generated
 */
public interface Store extends EObject {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link imp.model.imp.Value},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' map.
	 * @see imp.model.imp.ImpPackage#getStore_Values()
	 * @model mapType="imp.model.imp.StringToValueMap&lt;org.eclipse.emf.ecore.EString, imp.model.imp.Value&gt;"
	 * @generated
	 */
	EMap<String, Value> getValues();

} // Store
