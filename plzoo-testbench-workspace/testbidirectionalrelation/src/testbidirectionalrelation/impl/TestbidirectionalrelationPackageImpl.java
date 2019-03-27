/**
 */
package testbidirectionalrelation.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import testbidirectionalrelation.ConceptA;
import testbidirectionalrelation.ConceptB;
import testbidirectionalrelation.ConceptC;
import testbidirectionalrelation.ConceptD;
import testbidirectionalrelation.ConceptE;
import testbidirectionalrelation.ConceptF;
import testbidirectionalrelation.ConceptG;
import testbidirectionalrelation.TestbidirectionalrelationFactory;
import testbidirectionalrelation.TestbidirectionalrelationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TestbidirectionalrelationPackageImpl extends EPackageImpl implements TestbidirectionalrelationPackage {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptDEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptEEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptFEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptGEClass = null;

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
	 * @see testbidirectionalrelation.TestbidirectionalrelationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TestbidirectionalrelationPackageImpl() {
		super(eNS_URI, TestbidirectionalrelationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TestbidirectionalrelationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TestbidirectionalrelationPackage init() {
		if (isInited) return (TestbidirectionalrelationPackage)EPackage.Registry.INSTANCE.getEPackage(TestbidirectionalrelationPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredTestbidirectionalrelationPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		TestbidirectionalrelationPackageImpl theTestbidirectionalrelationPackage = registeredTestbidirectionalrelationPackage instanceof TestbidirectionalrelationPackageImpl ? (TestbidirectionalrelationPackageImpl)registeredTestbidirectionalrelationPackage : new TestbidirectionalrelationPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theTestbidirectionalrelationPackage.createPackageContents();

		// Initialize created meta-data
		theTestbidirectionalrelationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTestbidirectionalrelationPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TestbidirectionalrelationPackage.eNS_URI, theTestbidirectionalrelationPackage);
		return theTestbidirectionalrelationPackage;
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
	public EReference getConceptA_Conceptb() {
		return (EReference)conceptAEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptA_Conceptc() {
		return (EReference)conceptAEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptA_Conceptd() {
		return (EReference)conceptAEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptA_Concepte() {
		return (EReference)conceptAEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptA_Conceptf() {
		return (EReference)conceptAEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptA_Conceptg() {
		return (EReference)conceptAEClass.getEStructuralFeatures().get(5);
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
	public EReference getConceptB_Conceptc() {
		return (EReference)conceptBEClass.getEStructuralFeatures().get(0);
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
	public EReference getConceptC_Conceptb() {
		return (EReference)conceptCEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptD() {
		return conceptDEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptD_Concepte() {
		return (EReference)conceptDEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptE() {
		return conceptEEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptE_Conceptd() {
		return (EReference)conceptEEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptF() {
		return conceptFEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptF_Conceptg() {
		return (EReference)conceptFEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptG() {
		return conceptGEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptG_Conceptf() {
		return (EReference)conceptGEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestbidirectionalrelationFactory getTestbidirectionalrelationFactory() {
		return (TestbidirectionalrelationFactory)getEFactoryInstance();
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
		createEReference(conceptAEClass, CONCEPT_A__CONCEPTB);
		createEReference(conceptAEClass, CONCEPT_A__CONCEPTC);
		createEReference(conceptAEClass, CONCEPT_A__CONCEPTD);
		createEReference(conceptAEClass, CONCEPT_A__CONCEPTE);
		createEReference(conceptAEClass, CONCEPT_A__CONCEPTF);
		createEReference(conceptAEClass, CONCEPT_A__CONCEPTG);

		conceptBEClass = createEClass(CONCEPT_B);
		createEReference(conceptBEClass, CONCEPT_B__CONCEPTC);

		conceptCEClass = createEClass(CONCEPT_C);
		createEReference(conceptCEClass, CONCEPT_C__CONCEPTB);

		conceptDEClass = createEClass(CONCEPT_D);
		createEReference(conceptDEClass, CONCEPT_D__CONCEPTE);

		conceptEEClass = createEClass(CONCEPT_E);
		createEReference(conceptEEClass, CONCEPT_E__CONCEPTD);

		conceptFEClass = createEClass(CONCEPT_F);
		createEReference(conceptFEClass, CONCEPT_F__CONCEPTG);

		conceptGEClass = createEClass(CONCEPT_G);
		createEReference(conceptGEClass, CONCEPT_G__CONCEPTF);
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

		// Initialize classes, features, and operations; add parameters
		initEClass(conceptAEClass, ConceptA.class, "ConceptA", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptA_Conceptb(), this.getConceptB(), null, "conceptb", null, 0, -1, ConceptA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConceptA_Conceptc(), this.getConceptC(), null, "conceptc", null, 0, -1, ConceptA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConceptA_Conceptd(), this.getConceptD(), null, "conceptd", null, 0, -1, ConceptA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConceptA_Concepte(), this.getConceptE(), null, "concepte", null, 0, -1, ConceptA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConceptA_Conceptf(), this.getConceptF(), null, "conceptf", null, 0, -1, ConceptA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConceptA_Conceptg(), this.getConceptG(), null, "conceptg", null, 0, -1, ConceptA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conceptBEClass, ConceptB.class, "ConceptB", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptB_Conceptc(), this.getConceptC(), this.getConceptC_Conceptb(), "conceptc", null, 0, 1, ConceptB.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conceptCEClass, ConceptC.class, "ConceptC", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptC_Conceptb(), this.getConceptB(), this.getConceptB_Conceptc(), "conceptb", null, 0, 1, ConceptC.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conceptDEClass, ConceptD.class, "ConceptD", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptD_Concepte(), this.getConceptE(), this.getConceptE_Conceptd(), "concepte", null, 0, 1, ConceptD.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conceptEEClass, ConceptE.class, "ConceptE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptE_Conceptd(), this.getConceptD(), this.getConceptD_Concepte(), "conceptd", null, 0, -1, ConceptE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conceptFEClass, ConceptF.class, "ConceptF", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptF_Conceptg(), this.getConceptG(), this.getConceptG_Conceptf(), "conceptg", null, 0, -1, ConceptF.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conceptGEClass, ConceptG.class, "ConceptG", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptG_Conceptf(), this.getConceptF(), this.getConceptF_Conceptg(), "conceptf", null, 0, -1, ConceptG.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //TestbidirectionalrelationPackageImpl
