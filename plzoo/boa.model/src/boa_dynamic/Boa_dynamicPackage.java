/**
 */
package boa_dynamic;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see boa_dynamic.Boa_dynamicFactory
 * @model kind="package"
 * @generated
 */
public interface Boa_dynamicPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "boa_dynamic";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/boa_dynamic";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "boa_dynamic";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Boa_dynamicPackage eINSTANCE = boa_dynamic.impl.Boa_dynamicPackageImpl.init();

	/**
	 * The meta object id for the '{@link boa_dynamic.impl.CtxImpl <em>Ctx</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa_dynamic.impl.CtxImpl
	 * @see boa_dynamic.impl.Boa_dynamicPackageImpl#getCtx()
	 * @generated
	 */
	int CTX = 0;

	/**
	 * The feature id for the '<em><b>Env</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CTX__ENV = 0;

	/**
	 * The feature id for the '<em><b>Th</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CTX__TH = 1;

	/**
	 * The number of structural features of the '<em>Ctx</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CTX_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Ctx</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CTX_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link boa_dynamic.impl.StringToEvalResMapImpl <em>String To Eval Res Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa_dynamic.impl.StringToEvalResMapImpl
	 * @see boa_dynamic.impl.Boa_dynamicPackageImpl#getStringToEvalResMap()
	 * @generated
	 */
	int STRING_TO_EVAL_RES_MAP = 1;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_EVAL_RES_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_EVAL_RES_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>String To Eval Res Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_EVAL_RES_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>String To Eval Res Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_EVAL_RES_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link boa_dynamic.impl.EvalResImpl <em>Eval Res</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa_dynamic.impl.EvalResImpl
	 * @see boa_dynamic.impl.Boa_dynamicPackageImpl#getEvalRes()
	 * @generated
	 */
	int EVAL_RES = 2;

	/**
	 * The number of structural features of the '<em>Eval Res</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVAL_RES_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Eval Res</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVAL_RES_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link boa_dynamic.impl.EvalMapResImpl <em>Eval Map Res</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa_dynamic.impl.EvalMapResImpl
	 * @see boa_dynamic.impl.Boa_dynamicPackageImpl#getEvalMapRes()
	 * @generated
	 */
	int EVAL_MAP_RES = 3;

	/**
	 * The feature id for the '<em><b>Values</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVAL_MAP_RES__VALUES = EVAL_RES_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Eval Map Res</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVAL_MAP_RES_FEATURE_COUNT = EVAL_RES_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Eval Map Res</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVAL_MAP_RES_OPERATION_COUNT = EVAL_RES_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link boa_dynamic.impl.EvalFunResImpl <em>Eval Fun Res</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa_dynamic.impl.EvalFunResImpl
	 * @see boa_dynamic.impl.Boa_dynamicPackageImpl#getEvalFunRes()
	 * @generated
	 */
	int EVAL_FUN_RES = 4;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVAL_FUN_RES__EXP = EVAL_RES_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ctx</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVAL_FUN_RES__CTX = EVAL_RES_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVAL_FUN_RES__NAME = EVAL_RES_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Eval Fun Res</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVAL_FUN_RES_FEATURE_COUNT = EVAL_RES_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Eval Fun Res</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVAL_FUN_RES_OPERATION_COUNT = EVAL_RES_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link boa_dynamic.impl.EvalBoundFunResImpl <em>Eval Bound Fun Res</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa_dynamic.impl.EvalBoundFunResImpl
	 * @see boa_dynamic.impl.Boa_dynamicPackageImpl#getEvalBoundFunRes()
	 * @generated
	 */
	int EVAL_BOUND_FUN_RES = 5;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVAL_BOUND_FUN_RES__EXP = EVAL_FUN_RES__EXP;

	/**
	 * The feature id for the '<em><b>Ctx</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVAL_BOUND_FUN_RES__CTX = EVAL_FUN_RES__CTX;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVAL_BOUND_FUN_RES__NAME = EVAL_FUN_RES__NAME;

	/**
	 * The feature id for the '<em><b>Th</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVAL_BOUND_FUN_RES__TH = EVAL_FUN_RES_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Eval Bound Fun Res</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVAL_BOUND_FUN_RES_FEATURE_COUNT = EVAL_FUN_RES_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Eval Bound Fun Res</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVAL_BOUND_FUN_RES_OPERATION_COUNT = EVAL_FUN_RES_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link boa_dynamic.impl.EvalIntResImpl <em>Eval Int Res</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa_dynamic.impl.EvalIntResImpl
	 * @see boa_dynamic.impl.Boa_dynamicPackageImpl#getEvalIntRes()
	 * @generated
	 */
	int EVAL_INT_RES = 6;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVAL_INT_RES__VALUE = EVAL_RES_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Eval Int Res</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVAL_INT_RES_FEATURE_COUNT = EVAL_RES_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Eval Int Res</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVAL_INT_RES_OPERATION_COUNT = EVAL_RES_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link boa_dynamic.impl.EvalBoolResImpl <em>Eval Bool Res</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see boa_dynamic.impl.EvalBoolResImpl
	 * @see boa_dynamic.impl.Boa_dynamicPackageImpl#getEvalBoolRes()
	 * @generated
	 */
	int EVAL_BOOL_RES = 7;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVAL_BOOL_RES__VALUE = EVAL_RES_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Eval Bool Res</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVAL_BOOL_RES_FEATURE_COUNT = EVAL_RES_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Eval Bool Res</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVAL_BOOL_RES_OPERATION_COUNT = EVAL_RES_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link boa_dynamic.Ctx <em>Ctx</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ctx</em>'.
	 * @see boa_dynamic.Ctx
	 * @generated
	 */
	EClass getCtx();

	/**
	 * Returns the meta object for the map '{@link boa_dynamic.Ctx#getEnv <em>Env</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Env</em>'.
	 * @see boa_dynamic.Ctx#getEnv()
	 * @see #getCtx()
	 * @generated
	 */
	EReference getCtx_Env();

	/**
	 * Returns the meta object for the map '{@link boa_dynamic.Ctx#getTh <em>Th</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Th</em>'.
	 * @see boa_dynamic.Ctx#getTh()
	 * @see #getCtx()
	 * @generated
	 */
	EReference getCtx_Th();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>String To Eval Res Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String To Eval Res Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueType="boa_dynamic.EvalRes" valueRequired="true"
	 * @generated
	 */
	EClass getStringToEvalResMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToEvalResMap()
	 * @generated
	 */
	EAttribute getStringToEvalResMap_Key();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToEvalResMap()
	 * @generated
	 */
	EReference getStringToEvalResMap_Value();

	/**
	 * Returns the meta object for class '{@link boa_dynamic.EvalRes <em>Eval Res</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Eval Res</em>'.
	 * @see boa_dynamic.EvalRes
	 * @generated
	 */
	EClass getEvalRes();

	/**
	 * Returns the meta object for class '{@link boa_dynamic.EvalMapRes <em>Eval Map Res</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Eval Map Res</em>'.
	 * @see boa_dynamic.EvalMapRes
	 * @generated
	 */
	EClass getEvalMapRes();

	/**
	 * Returns the meta object for the map '{@link boa_dynamic.EvalMapRes#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Values</em>'.
	 * @see boa_dynamic.EvalMapRes#getValues()
	 * @see #getEvalMapRes()
	 * @generated
	 */
	EReference getEvalMapRes_Values();

	/**
	 * Returns the meta object for class '{@link boa_dynamic.EvalFunRes <em>Eval Fun Res</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Eval Fun Res</em>'.
	 * @see boa_dynamic.EvalFunRes
	 * @generated
	 */
	EClass getEvalFunRes();

	/**
	 * Returns the meta object for the reference '{@link boa_dynamic.EvalFunRes#getExp <em>Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Exp</em>'.
	 * @see boa_dynamic.EvalFunRes#getExp()
	 * @see #getEvalFunRes()
	 * @generated
	 */
	EReference getEvalFunRes_Exp();

	/**
	 * Returns the meta object for the reference '{@link boa_dynamic.EvalFunRes#getCtx <em>Ctx</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ctx</em>'.
	 * @see boa_dynamic.EvalFunRes#getCtx()
	 * @see #getEvalFunRes()
	 * @generated
	 */
	EReference getEvalFunRes_Ctx();

	/**
	 * Returns the meta object for the attribute '{@link boa_dynamic.EvalFunRes#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see boa_dynamic.EvalFunRes#getName()
	 * @see #getEvalFunRes()
	 * @generated
	 */
	EAttribute getEvalFunRes_Name();

	/**
	 * Returns the meta object for class '{@link boa_dynamic.EvalBoundFunRes <em>Eval Bound Fun Res</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Eval Bound Fun Res</em>'.
	 * @see boa_dynamic.EvalBoundFunRes
	 * @generated
	 */
	EClass getEvalBoundFunRes();

	/**
	 * Returns the meta object for the map '{@link boa_dynamic.EvalBoundFunRes#getTh <em>Th</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Th</em>'.
	 * @see boa_dynamic.EvalBoundFunRes#getTh()
	 * @see #getEvalBoundFunRes()
	 * @generated
	 */
	EReference getEvalBoundFunRes_Th();

	/**
	 * Returns the meta object for class '{@link boa_dynamic.EvalIntRes <em>Eval Int Res</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Eval Int Res</em>'.
	 * @see boa_dynamic.EvalIntRes
	 * @generated
	 */
	EClass getEvalIntRes();

	/**
	 * Returns the meta object for the attribute '{@link boa_dynamic.EvalIntRes#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see boa_dynamic.EvalIntRes#getValue()
	 * @see #getEvalIntRes()
	 * @generated
	 */
	EAttribute getEvalIntRes_Value();

	/**
	 * Returns the meta object for class '{@link boa_dynamic.EvalBoolRes <em>Eval Bool Res</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Eval Bool Res</em>'.
	 * @see boa_dynamic.EvalBoolRes
	 * @generated
	 */
	EClass getEvalBoolRes();

	/**
	 * Returns the meta object for the attribute '{@link boa_dynamic.EvalBoolRes#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see boa_dynamic.EvalBoolRes#isValue()
	 * @see #getEvalBoolRes()
	 * @generated
	 */
	EAttribute getEvalBoolRes_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Boa_dynamicFactory getBoa_dynamicFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link boa_dynamic.impl.CtxImpl <em>Ctx</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa_dynamic.impl.CtxImpl
		 * @see boa_dynamic.impl.Boa_dynamicPackageImpl#getCtx()
		 * @generated
		 */
		EClass CTX = eINSTANCE.getCtx();

		/**
		 * The meta object literal for the '<em><b>Env</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CTX__ENV = eINSTANCE.getCtx_Env();

		/**
		 * The meta object literal for the '<em><b>Th</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CTX__TH = eINSTANCE.getCtx_Th();

		/**
		 * The meta object literal for the '{@link boa_dynamic.impl.StringToEvalResMapImpl <em>String To Eval Res Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa_dynamic.impl.StringToEvalResMapImpl
		 * @see boa_dynamic.impl.Boa_dynamicPackageImpl#getStringToEvalResMap()
		 * @generated
		 */
		EClass STRING_TO_EVAL_RES_MAP = eINSTANCE.getStringToEvalResMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_TO_EVAL_RES_MAP__KEY = eINSTANCE.getStringToEvalResMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRING_TO_EVAL_RES_MAP__VALUE = eINSTANCE.getStringToEvalResMap_Value();

		/**
		 * The meta object literal for the '{@link boa_dynamic.impl.EvalResImpl <em>Eval Res</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa_dynamic.impl.EvalResImpl
		 * @see boa_dynamic.impl.Boa_dynamicPackageImpl#getEvalRes()
		 * @generated
		 */
		EClass EVAL_RES = eINSTANCE.getEvalRes();

		/**
		 * The meta object literal for the '{@link boa_dynamic.impl.EvalMapResImpl <em>Eval Map Res</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa_dynamic.impl.EvalMapResImpl
		 * @see boa_dynamic.impl.Boa_dynamicPackageImpl#getEvalMapRes()
		 * @generated
		 */
		EClass EVAL_MAP_RES = eINSTANCE.getEvalMapRes();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVAL_MAP_RES__VALUES = eINSTANCE.getEvalMapRes_Values();

		/**
		 * The meta object literal for the '{@link boa_dynamic.impl.EvalFunResImpl <em>Eval Fun Res</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa_dynamic.impl.EvalFunResImpl
		 * @see boa_dynamic.impl.Boa_dynamicPackageImpl#getEvalFunRes()
		 * @generated
		 */
		EClass EVAL_FUN_RES = eINSTANCE.getEvalFunRes();

		/**
		 * The meta object literal for the '<em><b>Exp</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVAL_FUN_RES__EXP = eINSTANCE.getEvalFunRes_Exp();

		/**
		 * The meta object literal for the '<em><b>Ctx</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVAL_FUN_RES__CTX = eINSTANCE.getEvalFunRes_Ctx();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVAL_FUN_RES__NAME = eINSTANCE.getEvalFunRes_Name();

		/**
		 * The meta object literal for the '{@link boa_dynamic.impl.EvalBoundFunResImpl <em>Eval Bound Fun Res</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa_dynamic.impl.EvalBoundFunResImpl
		 * @see boa_dynamic.impl.Boa_dynamicPackageImpl#getEvalBoundFunRes()
		 * @generated
		 */
		EClass EVAL_BOUND_FUN_RES = eINSTANCE.getEvalBoundFunRes();

		/**
		 * The meta object literal for the '<em><b>Th</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVAL_BOUND_FUN_RES__TH = eINSTANCE.getEvalBoundFunRes_Th();

		/**
		 * The meta object literal for the '{@link boa_dynamic.impl.EvalIntResImpl <em>Eval Int Res</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa_dynamic.impl.EvalIntResImpl
		 * @see boa_dynamic.impl.Boa_dynamicPackageImpl#getEvalIntRes()
		 * @generated
		 */
		EClass EVAL_INT_RES = eINSTANCE.getEvalIntRes();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVAL_INT_RES__VALUE = eINSTANCE.getEvalIntRes_Value();

		/**
		 * The meta object literal for the '{@link boa_dynamic.impl.EvalBoolResImpl <em>Eval Bool Res</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see boa_dynamic.impl.EvalBoolResImpl
		 * @see boa_dynamic.impl.Boa_dynamicPackageImpl#getEvalBoolRes()
		 * @generated
		 */
		EClass EVAL_BOOL_RES = eINSTANCE.getEvalBoolRes();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVAL_BOOL_RES__VALUE = eINSTANCE.getEvalBoolRes_Value();

	}

} //Boa_dynamicPackage
