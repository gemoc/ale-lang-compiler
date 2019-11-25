/**
 */
package x.y.z.functioncall.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import x.y.z.functioncall.ConceptA;
import x.y.z.functioncall.ConceptB;
import x.y.z.functioncall.ConceptC;
import x.y.z.functioncall.FunctioncallFactory;
import x.y.z.functioncall.FunctioncallPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FunctioncallPackageImpl extends EPackageImpl implements FunctioncallPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptAEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptBEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptCEClass = null;

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
	 * @see x.y.z.functioncall.FunctioncallPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FunctioncallPackageImpl() {
		super(eNS_URI, FunctioncallFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link FunctioncallPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static FunctioncallPackage init() {
		if (isInited) return (FunctioncallPackage)EPackage.Registry.INSTANCE.getEPackage(FunctioncallPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredFunctioncallPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		FunctioncallPackageImpl theFunctioncallPackage = registeredFunctioncallPackage instanceof FunctioncallPackageImpl ? (FunctioncallPackageImpl)registeredFunctioncallPackage : new FunctioncallPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theFunctioncallPackage.createPackageContents();

		// Initialize created meta-data
		theFunctioncallPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFunctioncallPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FunctioncallPackage.eNS_URI, theFunctioncallPackage);
		return theFunctioncallPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptA() {
		return conceptAEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptB() {
		return conceptBEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptC() {
		return conceptCEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptC_Concepta2() {
		return (EReference)conceptCEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptC_Concepta1() {
		return (EReference)conceptCEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptC_Conceptb() {
		return (EReference)conceptCEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctioncallFactory getFunctioncallFactory() {
		return (FunctioncallFactory)getEFactoryInstance();
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
		conceptAEClass = createEClass(CONCEPT_A);

		conceptBEClass = createEClass(CONCEPT_B);

		conceptCEClass = createEClass(CONCEPT_C);
		createEReference(conceptCEClass, CONCEPT_C__CONCEPTA2);
		createEReference(conceptCEClass, CONCEPT_C__CONCEPTA1);
		createEReference(conceptCEClass, CONCEPT_C__CONCEPTB);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		conceptBEClass.getESuperTypes().add(this.getConceptA());

		// Initialize classes, features, and operations; add parameters
		initEClass(conceptAEClass, ConceptA.class, "ConceptA", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(conceptBEClass, ConceptB.class, "ConceptB", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(conceptCEClass, ConceptC.class, "ConceptC", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptC_Concepta2(), this.getConceptA(), null, "concepta2", null, 1, 1, ConceptC.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConceptC_Concepta1(), this.getConceptA(), null, "concepta1", null, 1, 1, ConceptC.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConceptC_Conceptb(), this.getConceptB(), null, "conceptb", null, 1, 1, ConceptC.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //FunctioncallPackageImpl
