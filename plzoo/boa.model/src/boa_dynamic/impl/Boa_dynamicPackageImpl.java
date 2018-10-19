/**
 */
package boa_dynamic.impl;

import boa.BoaPackage;
import boa.impl.BoaPackageImpl;
import boa_dynamic.Boa_dynamicFactory;
import boa_dynamic.Boa_dynamicPackage;
import boa_dynamic.Ctx;
import boa_dynamic.EvalBoolRes;
import boa_dynamic.EvalBoundFunRes;
import boa_dynamic.EvalFunRes;
import boa_dynamic.EvalIntRes;
import boa_dynamic.EvalMapRes;
import boa_dynamic.EvalRes;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Boa_dynamicPackageImpl extends EPackageImpl implements Boa_dynamicPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ctxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringToEvalResMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass evalResEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass evalMapResEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass evalFunResEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass evalBoundFunResEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass evalIntResEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass evalBoolResEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see boa_dynamic.Boa_dynamicPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Boa_dynamicPackageImpl() {
		super(eNS_URI, Boa_dynamicFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link Boa_dynamicPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Boa_dynamicPackage init() {
		if (isInited) return (Boa_dynamicPackage)EPackage.Registry.INSTANCE.getEPackage(Boa_dynamicPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredBoa_dynamicPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		Boa_dynamicPackageImpl theBoa_dynamicPackage = registeredBoa_dynamicPackage instanceof Boa_dynamicPackageImpl ? (Boa_dynamicPackageImpl)registeredBoa_dynamicPackage : new Boa_dynamicPackageImpl();

		isInited = true;

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(BoaPackage.eNS_URI);
		BoaPackageImpl theBoaPackage = (BoaPackageImpl)(registeredPackage instanceof BoaPackageImpl ? registeredPackage : BoaPackage.eINSTANCE);

		// Create package meta-data objects
		theBoa_dynamicPackage.createPackageContents();
		theBoaPackage.createPackageContents();

		// Initialize created meta-data
		theBoa_dynamicPackage.initializePackageContents();
		theBoaPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBoa_dynamicPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Boa_dynamicPackage.eNS_URI, theBoa_dynamicPackage);
		return theBoa_dynamicPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCtx() {
		return ctxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCtx_Env() {
		return (EReference)ctxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCtx_Th() {
		return (EReference)ctxEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringToEvalResMap() {
		return stringToEvalResMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringToEvalResMap_Key() {
		return (EAttribute)stringToEvalResMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStringToEvalResMap_Value() {
		return (EReference)stringToEvalResMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvalRes() {
		return evalResEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvalMapRes() {
		return evalMapResEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvalMapRes_Values() {
		return (EReference)evalMapResEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvalFunRes() {
		return evalFunResEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvalFunRes_Exp() {
		return (EReference)evalFunResEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvalFunRes_Ctx() {
		return (EReference)evalFunResEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvalFunRes_Name() {
		return (EAttribute)evalFunResEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvalBoundFunRes() {
		return evalBoundFunResEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvalBoundFunRes_Th() {
		return (EReference)evalBoundFunResEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvalIntRes() {
		return evalIntResEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvalIntRes_Value() {
		return (EAttribute)evalIntResEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvalBoolRes() {
		return evalBoolResEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvalBoolRes_Value() {
		return (EAttribute)evalBoolResEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boa_dynamicFactory getBoa_dynamicFactory() {
		return (Boa_dynamicFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		ctxEClass = createEClass(CTX);
		createEReference(ctxEClass, CTX__ENV);
		createEReference(ctxEClass, CTX__TH);

		stringToEvalResMapEClass = createEClass(STRING_TO_EVAL_RES_MAP);
		createEAttribute(stringToEvalResMapEClass, STRING_TO_EVAL_RES_MAP__KEY);
		createEReference(stringToEvalResMapEClass, STRING_TO_EVAL_RES_MAP__VALUE);

		evalResEClass = createEClass(EVAL_RES);

		evalMapResEClass = createEClass(EVAL_MAP_RES);
		createEReference(evalMapResEClass, EVAL_MAP_RES__VALUES);

		evalFunResEClass = createEClass(EVAL_FUN_RES);
		createEReference(evalFunResEClass, EVAL_FUN_RES__EXP);
		createEReference(evalFunResEClass, EVAL_FUN_RES__CTX);
		createEAttribute(evalFunResEClass, EVAL_FUN_RES__NAME);

		evalBoundFunResEClass = createEClass(EVAL_BOUND_FUN_RES);
		createEReference(evalBoundFunResEClass, EVAL_BOUND_FUN_RES__TH);

		evalIntResEClass = createEClass(EVAL_INT_RES);
		createEAttribute(evalIntResEClass, EVAL_INT_RES__VALUE);

		evalBoolResEClass = createEClass(EVAL_BOOL_RES);
		createEAttribute(evalBoolResEClass, EVAL_BOOL_RES__VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		BoaPackage theBoaPackage = (BoaPackage)EPackage.Registry.INSTANCE.getEPackage(BoaPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		evalMapResEClass.getESuperTypes().add(this.getEvalRes());
		evalFunResEClass.getESuperTypes().add(this.getEvalRes());
		evalBoundFunResEClass.getESuperTypes().add(this.getEvalFunRes());
		evalIntResEClass.getESuperTypes().add(this.getEvalRes());
		evalBoolResEClass.getESuperTypes().add(this.getEvalRes());

		// Initialize classes, features, and operations; add parameters
		initEClass(ctxEClass, Ctx.class, "Ctx", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCtx_Env(), this.getStringToEvalResMap(), null, "env", null, 0, -1, Ctx.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCtx_Th(), this.getStringToEvalResMap(), null, "th", null, 0, -1, Ctx.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringToEvalResMapEClass, Map.Entry.class, "StringToEvalResMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringToEvalResMap_Key(), ecorePackage.getEString(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStringToEvalResMap_Value(), this.getEvalRes(), null, "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(evalResEClass, EvalRes.class, "EvalRes", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(evalMapResEClass, EvalMapRes.class, "EvalMapRes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEvalMapRes_Values(), this.getStringToEvalResMap(), null, "values", null, 0, -1, EvalMapRes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(evalFunResEClass, EvalFunRes.class, "EvalFunRes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEvalFunRes_Exp(), theBoaPackage.getExpr(), null, "exp", null, 1, 1, EvalFunRes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEvalFunRes_Ctx(), this.getCtx(), null, "ctx", null, 1, 1, EvalFunRes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvalFunRes_Name(), ecorePackage.getEString(), "name", null, 0, 1, EvalFunRes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(evalBoundFunResEClass, EvalBoundFunRes.class, "EvalBoundFunRes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEvalBoundFunRes_Th(), this.getStringToEvalResMap(), null, "th", null, 0, -1, EvalBoundFunRes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(evalIntResEClass, EvalIntRes.class, "EvalIntRes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEvalIntRes_Value(), ecorePackage.getEInt(), "value", null, 0, 1, EvalIntRes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(evalBoolResEClass, EvalBoolRes.class, "EvalBoolRes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEvalBoolRes_Value(), ecorePackage.getEBoolean(), "value", null, 0, 1, EvalBoolRes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //Boa_dynamicPackageImpl
