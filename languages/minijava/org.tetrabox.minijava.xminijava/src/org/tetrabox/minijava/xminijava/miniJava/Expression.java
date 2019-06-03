/**
 */
package org.tetrabox.minijava.xminijava.miniJava;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.tetrabox.minijava.xminijava.miniJava.MiniJavaPackage#getExpression()
 * @model
 * @generated
 */
public interface Expression extends Statement, Assignee {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void evaluateStatement(State state);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Value evaluateExpression(State state);

} // Expression
