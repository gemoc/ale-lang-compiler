/**
 */
package testenums;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link testenums.Root#getEnum <em>Enum</em>}</li>
 *   <li>{@link testenums.Root#getEnums <em>Enums</em>}</li>
 * </ul>
 *
 * @see testenums.TestenumsPackage#getRoot()
 * @model
 * @generated
 */
public interface Root extends EObject {
	/**
	 * Returns the value of the '<em><b>Enum</b></em>' attribute.
	 * The default value is <code>"LITERAL0"</code>.
	 * The literals are from the enumeration {@link testenums.Enum1}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enum</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enum</em>' attribute.
	 * @see testenums.Enum1
	 * @see #setEnum(Enum1)
	 * @see testenums.TestenumsPackage#getRoot_Enum()
	 * @model default="LITERAL0"
	 * @generated
	 */
	Enum1 getEnum();

	/**
	 * Sets the value of the '{@link testenums.Root#getEnum <em>Enum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enum</em>' attribute.
	 * @see testenums.Enum1
	 * @see #getEnum()
	 * @generated
	 */
	void setEnum(Enum1 value);

	/**
	 * Returns the value of the '<em><b>Enums</b></em>' attribute list.
	 * The list contents are of type {@link testenums.Enum1}.
	 * The literals are from the enumeration {@link testenums.Enum1}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enums</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enums</em>' attribute list.
	 * @see testenums.Enum1
	 * @see testenums.TestenumsPackage#getRoot_Enums()
	 * @model
	 * @generated
	 */
	EList<Enum1> getEnums();

} // Root
