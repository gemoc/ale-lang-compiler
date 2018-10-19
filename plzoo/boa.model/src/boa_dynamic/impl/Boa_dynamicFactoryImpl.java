/**
 */
package boa_dynamic.impl;

import boa_dynamic.*;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Boa_dynamicFactoryImpl extends EFactoryImpl implements Boa_dynamicFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Boa_dynamicFactory init() {
		try {
			Boa_dynamicFactory theBoa_dynamicFactory = (Boa_dynamicFactory)EPackage.Registry.INSTANCE.getEFactory(Boa_dynamicPackage.eNS_URI);
			if (theBoa_dynamicFactory != null) {
				return theBoa_dynamicFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Boa_dynamicFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boa_dynamicFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case Boa_dynamicPackage.CTX: return createCtx();
			case Boa_dynamicPackage.STRING_TO_EVAL_RES_MAP: return (EObject)createStringToEvalResMap();
			case Boa_dynamicPackage.EVAL_MAP_RES: return createEvalMapRes();
			case Boa_dynamicPackage.EVAL_FUN_RES: return createEvalFunRes();
			case Boa_dynamicPackage.EVAL_BOUND_FUN_RES: return createEvalBoundFunRes();
			case Boa_dynamicPackage.EVAL_INT_RES: return createEvalIntRes();
			case Boa_dynamicPackage.EVAL_BOOL_RES: return createEvalBoolRes();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ctx createCtx() {
		CtxImpl ctx = new CtxImpl();
		return ctx;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, EvalRes> createStringToEvalResMap() {
		StringToEvalResMapImpl stringToEvalResMap = new StringToEvalResMapImpl();
		return stringToEvalResMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EvalMapRes createEvalMapRes() {
		EvalMapResImpl evalMapRes = new EvalMapResImpl();
		return evalMapRes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EvalFunRes createEvalFunRes() {
		EvalFunResImpl evalFunRes = new EvalFunResImpl();
		return evalFunRes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EvalBoundFunRes createEvalBoundFunRes() {
		EvalBoundFunResImpl evalBoundFunRes = new EvalBoundFunResImpl();
		return evalBoundFunRes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EvalIntRes createEvalIntRes() {
		EvalIntResImpl evalIntRes = new EvalIntResImpl();
		return evalIntRes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EvalBoolRes createEvalBoolRes() {
		EvalBoolResImpl evalBoolRes = new EvalBoolResImpl();
		return evalBoolRes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boa_dynamicPackage getBoa_dynamicPackage() {
		return (Boa_dynamicPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Boa_dynamicPackage getPackage() {
		return Boa_dynamicPackage.eINSTANCE;
	}

} //Boa_dynamicFactoryImpl
