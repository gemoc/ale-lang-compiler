/**
 */
package fr.mleduc.xp.emfrelations.emfrelations.impl;

import fr.mleduc.xp.emfrelations.emfrelations.ConceptA0;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptA1;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptA10;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptA11;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptA2;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptA3;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptA4;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptA5;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptA8;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptA9;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptB0;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptB1;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptB10;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptB11;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptB2;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptB3;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptB4;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptB5;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptB8;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptB9;
import fr.mleduc.xp.emfrelations.emfrelations.EmfrelationsFactory;
import fr.mleduc.xp.emfrelations.emfrelations.EmfrelationsPackage;

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
public class EmfrelationsPackageImpl extends EPackageImpl implements EmfrelationsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptA0EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptB0EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptA1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptB1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptA2EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptB2EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptA3EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptB3EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptA4EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptB4EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptA5EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptB5EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptA8EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptB8EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptA9EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptB9EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptA10EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptB10EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptA11EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptB11EClass = null;

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
	 * @see fr.mleduc.xp.emfrelations.emfrelations.EmfrelationsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EmfrelationsPackageImpl() {
		super(eNS_URI, EmfrelationsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link EmfrelationsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EmfrelationsPackage init() {
		if (isInited) return (EmfrelationsPackage)EPackage.Registry.INSTANCE.getEPackage(EmfrelationsPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredEmfrelationsPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		EmfrelationsPackageImpl theEmfrelationsPackage = registeredEmfrelationsPackage instanceof EmfrelationsPackageImpl ? (EmfrelationsPackageImpl)registeredEmfrelationsPackage : new EmfrelationsPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theEmfrelationsPackage.createPackageContents();

		// Initialize created meta-data
		theEmfrelationsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEmfrelationsPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EmfrelationsPackage.eNS_URI, theEmfrelationsPackage);
		return theEmfrelationsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptA0() {
		return conceptA0EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptA0_Conceptb0() {
		return (EReference)conceptA0EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptB0() {
		return conceptB0EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptB0_Concepta0() {
		return (EReference)conceptB0EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptA1() {
		return conceptA1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptA1_Conceptb1() {
		return (EReference)conceptA1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptB1() {
		return conceptB1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptB1_Concepta1() {
		return (EReference)conceptB1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptA2() {
		return conceptA2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptA2_Conceptb2() {
		return (EReference)conceptA2EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptB2() {
		return conceptB2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptB2_Concepta2() {
		return (EReference)conceptB2EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptA3() {
		return conceptA3EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptA3_Conceptb3() {
		return (EReference)conceptA3EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptB3() {
		return conceptB3EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptB3_Concepta3() {
		return (EReference)conceptB3EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptA4() {
		return conceptA4EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptA4_Conceptb4() {
		return (EReference)conceptA4EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptB4() {
		return conceptB4EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptB4_Concepta4() {
		return (EReference)conceptB4EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptA5() {
		return conceptA5EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptA5_Conceptb5() {
		return (EReference)conceptA5EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptB5() {
		return conceptB5EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptB5_Concepta5() {
		return (EReference)conceptB5EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptA8() {
		return conceptA8EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptA8_Conceptb8() {
		return (EReference)conceptA8EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptB8() {
		return conceptB8EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptA9() {
		return conceptA9EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptA9_Conceptb9() {
		return (EReference)conceptA9EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptB9() {
		return conceptB9EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptA10() {
		return conceptA10EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptA10_Conceptb10() {
		return (EReference)conceptA10EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptB10() {
		return conceptB10EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptA11() {
		return conceptA11EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptA11_Conceptb11() {
		return (EReference)conceptA11EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptB11() {
		return conceptB11EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmfrelationsFactory getEmfrelationsFactory() {
		return (EmfrelationsFactory)getEFactoryInstance();
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
		conceptA0EClass = createEClass(CONCEPT_A0);
		createEReference(conceptA0EClass, CONCEPT_A0__CONCEPTB0);

		conceptB0EClass = createEClass(CONCEPT_B0);
		createEReference(conceptB0EClass, CONCEPT_B0__CONCEPTA0);

		conceptA1EClass = createEClass(CONCEPT_A1);
		createEReference(conceptA1EClass, CONCEPT_A1__CONCEPTB1);

		conceptB1EClass = createEClass(CONCEPT_B1);
		createEReference(conceptB1EClass, CONCEPT_B1__CONCEPTA1);

		conceptA2EClass = createEClass(CONCEPT_A2);
		createEReference(conceptA2EClass, CONCEPT_A2__CONCEPTB2);

		conceptB2EClass = createEClass(CONCEPT_B2);
		createEReference(conceptB2EClass, CONCEPT_B2__CONCEPTA2);

		conceptA3EClass = createEClass(CONCEPT_A3);
		createEReference(conceptA3EClass, CONCEPT_A3__CONCEPTB3);

		conceptB3EClass = createEClass(CONCEPT_B3);
		createEReference(conceptB3EClass, CONCEPT_B3__CONCEPTA3);

		conceptA4EClass = createEClass(CONCEPT_A4);
		createEReference(conceptA4EClass, CONCEPT_A4__CONCEPTB4);

		conceptB4EClass = createEClass(CONCEPT_B4);
		createEReference(conceptB4EClass, CONCEPT_B4__CONCEPTA4);

		conceptA5EClass = createEClass(CONCEPT_A5);
		createEReference(conceptA5EClass, CONCEPT_A5__CONCEPTB5);

		conceptB5EClass = createEClass(CONCEPT_B5);
		createEReference(conceptB5EClass, CONCEPT_B5__CONCEPTA5);

		conceptA8EClass = createEClass(CONCEPT_A8);
		createEReference(conceptA8EClass, CONCEPT_A8__CONCEPTB8);

		conceptB8EClass = createEClass(CONCEPT_B8);

		conceptA9EClass = createEClass(CONCEPT_A9);
		createEReference(conceptA9EClass, CONCEPT_A9__CONCEPTB9);

		conceptB9EClass = createEClass(CONCEPT_B9);

		conceptA10EClass = createEClass(CONCEPT_A10);
		createEReference(conceptA10EClass, CONCEPT_A10__CONCEPTB10);

		conceptB10EClass = createEClass(CONCEPT_B10);

		conceptA11EClass = createEClass(CONCEPT_A11);
		createEReference(conceptA11EClass, CONCEPT_A11__CONCEPTB11);

		conceptB11EClass = createEClass(CONCEPT_B11);
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
		initEClass(conceptA0EClass, ConceptA0.class, "ConceptA0", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptA0_Conceptb0(), this.getConceptB0(), this.getConceptB0_Concepta0(), "conceptb0", null, 0, 1, ConceptA0.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conceptB0EClass, ConceptB0.class, "ConceptB0", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptB0_Concepta0(), this.getConceptA0(), this.getConceptA0_Conceptb0(), "concepta0", null, 0, 1, ConceptB0.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conceptA1EClass, ConceptA1.class, "ConceptA1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptA1_Conceptb1(), this.getConceptB1(), this.getConceptB1_Concepta1(), "conceptb1", null, 0, -1, ConceptA1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conceptB1EClass, ConceptB1.class, "ConceptB1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptB1_Concepta1(), this.getConceptA1(), this.getConceptA1_Conceptb1(), "concepta1", null, 0, 1, ConceptB1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conceptA2EClass, ConceptA2.class, "ConceptA2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptA2_Conceptb2(), this.getConceptB2(), this.getConceptB2_Concepta2(), "conceptb2", null, 0, 1, ConceptA2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conceptB2EClass, ConceptB2.class, "ConceptB2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptB2_Concepta2(), this.getConceptA2(), this.getConceptA2_Conceptb2(), "concepta2", null, 0, -1, ConceptB2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conceptA3EClass, ConceptA3.class, "ConceptA3", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptA3_Conceptb3(), this.getConceptB3(), this.getConceptB3_Concepta3(), "conceptb3", null, 0, -1, ConceptA3.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conceptB3EClass, ConceptB3.class, "ConceptB3", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptB3_Concepta3(), this.getConceptA3(), this.getConceptA3_Conceptb3(), "concepta3", null, 0, -1, ConceptB3.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conceptA4EClass, ConceptA4.class, "ConceptA4", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptA4_Conceptb4(), this.getConceptB4(), this.getConceptB4_Concepta4(), "conceptb4", null, 0, 1, ConceptA4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conceptB4EClass, ConceptB4.class, "ConceptB4", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptB4_Concepta4(), this.getConceptA4(), this.getConceptA4_Conceptb4(), "concepta4", null, 0, 1, ConceptB4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conceptA5EClass, ConceptA5.class, "ConceptA5", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptA5_Conceptb5(), this.getConceptB5(), this.getConceptB5_Concepta5(), "conceptb5", null, 0, -1, ConceptA5.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conceptB5EClass, ConceptB5.class, "ConceptB5", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptB5_Concepta5(), this.getConceptA5(), this.getConceptA5_Conceptb5(), "concepta5", null, 0, 1, ConceptB5.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conceptA8EClass, ConceptA8.class, "ConceptA8", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptA8_Conceptb8(), this.getConceptB8(), null, "conceptb8", null, 0, 1, ConceptA8.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conceptB8EClass, ConceptB8.class, "ConceptB8", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(conceptA9EClass, ConceptA9.class, "ConceptA9", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptA9_Conceptb9(), this.getConceptB9(), null, "conceptb9", null, 0, -1, ConceptA9.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conceptB9EClass, ConceptB9.class, "ConceptB9", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(conceptA10EClass, ConceptA10.class, "ConceptA10", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptA10_Conceptb10(), this.getConceptB10(), null, "conceptb10", null, 0, 1, ConceptA10.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conceptB10EClass, ConceptB10.class, "ConceptB10", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(conceptA11EClass, ConceptA11.class, "ConceptA11", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptA11_Conceptb11(), this.getConceptB11(), null, "conceptb11", null, 0, -1, ConceptA11.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conceptB11EClass, ConceptB11.class, "ConceptB11", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //EmfrelationsPackageImpl
