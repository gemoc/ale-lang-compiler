/**
 */
package boa_dynamic;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see boa_dynamic.Boa_dynamicPackage
 * @generated
 */
public interface Boa_dynamicFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Boa_dynamicFactory eINSTANCE = boa_dynamic.impl.Boa_dynamicFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Ctx</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ctx</em>'.
	 * @generated
	 */
	Ctx createCtx();

	/**
	 * Returns a new object of class '<em>Eval Map Res</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Eval Map Res</em>'.
	 * @generated
	 */
	EvalMapRes createEvalMapRes();

	/**
	 * Returns a new object of class '<em>Eval Fun Res</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Eval Fun Res</em>'.
	 * @generated
	 */
	EvalFunRes createEvalFunRes();

	/**
	 * Returns a new object of class '<em>Eval Bound Fun Res</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Eval Bound Fun Res</em>'.
	 * @generated
	 */
	EvalBoundFunRes createEvalBoundFunRes();

	/**
	 * Returns a new object of class '<em>Eval Int Res</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Eval Int Res</em>'.
	 * @generated
	 */
	EvalIntRes createEvalIntRes();

	/**
	 * Returns a new object of class '<em>Eval Bool Res</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Eval Bool Res</em>'.
	 * @generated
	 */
	EvalBoolRes createEvalBoolRes();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Boa_dynamicPackage getBoa_dynamicPackage();

} //Boa_dynamicFactory
