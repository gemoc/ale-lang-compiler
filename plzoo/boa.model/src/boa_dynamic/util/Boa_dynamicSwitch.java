/**
 */
package boa_dynamic.util;

import boa_dynamic.*;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see boa_dynamic.Boa_dynamicPackage
 * @generated
 */
public class Boa_dynamicSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Boa_dynamicPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boa_dynamicSwitch() {
		if (modelPackage == null) {
			modelPackage = Boa_dynamicPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case Boa_dynamicPackage.CTX: {
				Ctx ctx = (Ctx)theEObject;
				T result = caseCtx(ctx);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Boa_dynamicPackage.STRING_TO_EVAL_RES_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<String, EvalRes> stringToEvalResMap = (Map.Entry<String, EvalRes>)theEObject;
				T result = caseStringToEvalResMap(stringToEvalResMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Boa_dynamicPackage.EVAL_RES: {
				EvalRes evalRes = (EvalRes)theEObject;
				T result = caseEvalRes(evalRes);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Boa_dynamicPackage.EVAL_MAP_RES: {
				EvalMapRes evalMapRes = (EvalMapRes)theEObject;
				T result = caseEvalMapRes(evalMapRes);
				if (result == null) result = caseEvalRes(evalMapRes);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Boa_dynamicPackage.EVAL_FUN_RES: {
				EvalFunRes evalFunRes = (EvalFunRes)theEObject;
				T result = caseEvalFunRes(evalFunRes);
				if (result == null) result = caseEvalRes(evalFunRes);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Boa_dynamicPackage.EVAL_BOUND_FUN_RES: {
				EvalBoundFunRes evalBoundFunRes = (EvalBoundFunRes)theEObject;
				T result = caseEvalBoundFunRes(evalBoundFunRes);
				if (result == null) result = caseEvalFunRes(evalBoundFunRes);
				if (result == null) result = caseEvalRes(evalBoundFunRes);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Boa_dynamicPackage.EVAL_INT_RES: {
				EvalIntRes evalIntRes = (EvalIntRes)theEObject;
				T result = caseEvalIntRes(evalIntRes);
				if (result == null) result = caseEvalRes(evalIntRes);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Boa_dynamicPackage.EVAL_BOOL_RES: {
				EvalBoolRes evalBoolRes = (EvalBoolRes)theEObject;
				T result = caseEvalBoolRes(evalBoolRes);
				if (result == null) result = caseEvalRes(evalBoolRes);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ctx</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ctx</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCtx(Ctx object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String To Eval Res Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String To Eval Res Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringToEvalResMap(Map.Entry<String, EvalRes> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Eval Res</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Eval Res</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvalRes(EvalRes object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Eval Map Res</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Eval Map Res</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvalMapRes(EvalMapRes object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Eval Fun Res</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Eval Fun Res</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvalFunRes(EvalFunRes object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Eval Bound Fun Res</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Eval Bound Fun Res</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvalBoundFunRes(EvalBoundFunRes object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Eval Int Res</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Eval Int Res</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvalIntRes(EvalIntRes object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Eval Bool Res</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Eval Bool Res</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvalBoolRes(EvalBoolRes object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //Boa_dynamicSwitch
