/**
 */
package boa;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Eval Fun Res</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link boa.EvalFunRes#getExp <em>Exp</em>}</li>
 *   <li>{@link boa.EvalFunRes#getCtx <em>Ctx</em>}</li>
 *   <li>{@link boa.EvalFunRes#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see boa.BoaPackage#getEvalFunRes()
 * @model
 * @generated
 */
public interface EvalFunRes extends EvalRes {
	/**
	 * Returns the value of the '<em><b>Exp</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exp</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exp</em>' reference.
	 * @see #setExp(Expr)
	 * @see boa.BoaPackage#getEvalFunRes_Exp()
	 * @model required="true"
	 * @generated
	 */
	Expr getExp();

	/**
	 * Sets the value of the '{@link boa.EvalFunRes#getExp <em>Exp</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exp</em>' reference.
	 * @see #getExp()
	 * @generated
	 */
	void setExp(Expr value);

	/**
	 * Returns the value of the '<em><b>Ctx</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ctx</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ctx</em>' reference.
	 * @see #setCtx(Ctx)
	 * @see boa.BoaPackage#getEvalFunRes_Ctx()
	 * @model required="true"
	 * @generated
	 */
	Ctx getCtx();

	/**
	 * Sets the value of the '{@link boa.EvalFunRes#getCtx <em>Ctx</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ctx</em>' reference.
	 * @see #getCtx()
	 * @generated
	 */
	void setCtx(Ctx value);

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
	 * @see boa.BoaPackage#getEvalFunRes_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link boa.EvalFunRes#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // EvalFunRes
