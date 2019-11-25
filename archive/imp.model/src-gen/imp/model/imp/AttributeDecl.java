/**
 */
package imp.model.imp;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Decl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link imp.model.imp.AttributeDecl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see imp.model.imp.ImpPackage#getAttributeDecl()
 * @model
 * @generated
 */
public interface AttributeDecl extends Member {
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
	 * @see imp.model.imp.ImpPackage#getAttributeDecl_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link imp.model.imp.AttributeDecl#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // AttributeDecl
