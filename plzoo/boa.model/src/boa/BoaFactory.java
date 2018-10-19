/**
 */
package boa;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see boa.BoaPackage
 * @generated
 */
public interface BoaFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BoaFactory eINSTANCE = boa.impl.BoaFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>File</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>File</em>'.
	 * @generated
	 */
	File createFile();

	/**
	 * Returns a new object of class '<em>Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Def</em>'.
	 * @generated
	 */
	Def createDef();

	/**
	 * Returns a new object of class '<em>App</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>App</em>'.
	 * @generated
	 */
	App createApp();

	/**
	 * Returns a new object of class '<em>Var</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Var</em>'.
	 * @generated
	 */
	Var createVar();

	/**
	 * Returns a new object of class '<em>This</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>This</em>'.
	 * @generated
	 */
	This createThis();

	/**
	 * Returns a new object of class '<em>Bool</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bool</em>'.
	 * @generated
	 */
	Bool createBool();

	/**
	 * Returns a new object of class '<em>Int</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Int</em>'.
	 * @generated
	 */
	Int createInt();

	/**
	 * Returns a new object of class '<em>Skip</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Skip</em>'.
	 * @generated
	 */
	Skip createSkip();

	/**
	 * Returns a new object of class '<em>Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Project</em>'.
	 * @generated
	 */
	Project createProject();

	/**
	 * Returns a new object of class '<em>BObject</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>BObject</em>'.
	 * @generated
	 */
	BObject createBObject();

	/**
	 * Returns a new object of class '<em>Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Field</em>'.
	 * @generated
	 */
	Field createField();

	/**
	 * Returns a new object of class '<em>Copy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Copy</em>'.
	 * @generated
	 */
	Copy createCopy();

	/**
	 * Returns a new object of class '<em>With</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>With</em>'.
	 * @generated
	 */
	With createWith();

	/**
	 * Returns a new object of class '<em>Not</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Not</em>'.
	 * @generated
	 */
	Not createNot();

	/**
	 * Returns a new object of class '<em>If</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>If</em>'.
	 * @generated
	 */
	If createIf();

	/**
	 * Returns a new object of class '<em>Let</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Let</em>'.
	 * @generated
	 */
	Let createLet();

	/**
	 * Returns a new object of class '<em>Fun</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fun</em>'.
	 * @generated
	 */
	Fun createFun();

	/**
	 * Returns a new object of class '<em>Assign</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assign</em>'.
	 * @generated
	 */
	Assign createAssign();

	/**
	 * Returns a new object of class '<em>Arith Op Plus</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Arith Op Plus</em>'.
	 * @generated
	 */
	ArithOpPlus createArithOpPlus();

	/**
	 * Returns a new object of class '<em>Arith Op Minus</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Arith Op Minus</em>'.
	 * @generated
	 */
	ArithOpMinus createArithOpMinus();

	/**
	 * Returns a new object of class '<em>Arith Op Times</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Arith Op Times</em>'.
	 * @generated
	 */
	ArithOpTimes createArithOpTimes();

	/**
	 * Returns a new object of class '<em>Arith Op Divide</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Arith Op Divide</em>'.
	 * @generated
	 */
	ArithOpDivide createArithOpDivide();

	/**
	 * Returns a new object of class '<em>Arith Op Remainder</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Arith Op Remainder</em>'.
	 * @generated
	 */
	ArithOpRemainder createArithOpRemainder();

	/**
	 * Returns a new object of class '<em>Bool Op And</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bool Op And</em>'.
	 * @generated
	 */
	BoolOpAnd createBoolOpAnd();

	/**
	 * Returns a new object of class '<em>Bool Op Or</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bool Op Or</em>'.
	 * @generated
	 */
	BoolOpOr createBoolOpOr();

	/**
	 * Returns a new object of class '<em>Seq</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Seq</em>'.
	 * @generated
	 */
	Seq createSeq();

	/**
	 * Returns a new object of class '<em>Cmp Op Equal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cmp Op Equal</em>'.
	 * @generated
	 */
	CmpOpEqual createCmpOpEqual();

	/**
	 * Returns a new object of class '<em>Cmp Op Unequal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cmp Op Unequal</em>'.
	 * @generated
	 */
	CmpOpUnequal createCmpOpUnequal();

	/**
	 * Returns a new object of class '<em>Cmp Op Less</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cmp Op Less</em>'.
	 * @generated
	 */
	CmpOpLess createCmpOpLess();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	BoaPackage getBoaPackage();

} //BoaFactory
