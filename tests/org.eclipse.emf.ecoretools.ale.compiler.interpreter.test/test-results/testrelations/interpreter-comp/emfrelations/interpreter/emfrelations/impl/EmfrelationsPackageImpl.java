package emfrelations.interpreter.emfrelations.impl;
import fr.mleduc.xp.emfrelations.ConceptA0;
import fr.mleduc.xp.emfrelations.ConceptA4;
import fr.mleduc.xp.emfrelations.ConceptA1;
import fr.mleduc.xp.emfrelations.ConceptA2;
import fr.mleduc.xp.emfrelations.ConceptA3;
import fr.mleduc.xp.emfrelations.ConceptA5;
import fr.mleduc.xp.emfrelations.ConceptB0;
import fr.mleduc.xp.emfrelations.ConceptB1;
import fr.mleduc.xp.emfrelations.ConceptB2;
import fr.mleduc.xp.emfrelations.ConceptB3;
import fr.mleduc.xp.emfrelations.ConceptB4;
import fr.mleduc.xp.emfrelations.ConceptB5;
import fr.mleduc.xp.emfrelations.EmfrelationsFactory;
import fr.mleduc.xp.emfrelations.EmfrelationsPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
public class EmfrelationsPackageImpl extends EPackageImpl implements EmfrelationsPackage {

	private EClass conceptA0EClass = null;

	private EClass conceptB0EClass = null;

	private EClass conceptA1EClass = null;

	private EClass conceptB1EClass = null;

	private EClass conceptA2EClass = null;

	private EClass conceptB2EClass = null;

	private EClass conceptA3EClass = null;

	private EClass conceptB3EClass = null;

	private EClass conceptA4EClass = null;

	private EClass conceptB4EClass = null;

	private EClass conceptA5EClass = null;

	private EClass conceptB5EClass = null;

	private EmfrelationsPackageImpl() {
		super(eNS_URI, EmfrelationsFactory.eINSTANCE);
	}

	private static boolean isInited = false;

	public static EmfrelationsPackage init() {
		if (isInited)
			return (EmfrelationsPackage) EPackage.Registry.INSTANCE
					.getEPackage(EmfrelationsPackage.eNS_URI);
		// Obtain or create and register package
		Object registeredEmfrelationsPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		EmfrelationsPackageImpl theEmfrelationsPackage = registeredEmfrelationsPackage instanceof EmfrelationsPackageImpl
				? (EmfrelationsPackageImpl) registeredEmfrelationsPackage
				: new EmfrelationsPackageImpl();
		isInited = true;
		// Create package meta-data objects
		theEmfrelationsPackage.createPackageContents();
		// Initialize created meta-data
		theEmfrelationsPackage.initializePackageContents();
		// Mark meta-data to indicate it can't be changed
		theEmfrelationsPackage.freeze();
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EmfrelationsPackage.eNS_URI,
				theEmfrelationsPackage);
		return theEmfrelationsPackage;
	}

	public EClass getConceptA0() {
		return conceptA0EClass;
	}

	public EReference getConceptA0_Conceptb0() {
		return (EReference) conceptA0EClass.getEStructuralFeatures().get(0);
	}

	public EClass getConceptB0() {
		return conceptB0EClass;
	}

	public EReference getConceptB0_Concepta0() {
		return (EReference) conceptB0EClass.getEStructuralFeatures().get(0);
	}

	public EClass getConceptA1() {
		return conceptA1EClass;
	}

	public EReference getConceptA1_Conceptb1() {
		return (EReference) conceptA1EClass.getEStructuralFeatures().get(0);
	}

	public EClass getConceptB1() {
		return conceptB1EClass;
	}

	public EReference getConceptB1_Concepta1() {
		return (EReference) conceptB1EClass.getEStructuralFeatures().get(0);
	}

	public EClass getConceptA2() {
		return conceptA2EClass;
	}

	public EReference getConceptA2_Conceptb2() {
		return (EReference) conceptA2EClass.getEStructuralFeatures().get(0);
	}

	public EClass getConceptB2() {
		return conceptB2EClass;
	}

	public EReference getConceptB2_Concepta2() {
		return (EReference) conceptB2EClass.getEStructuralFeatures().get(0);
	}

	public EClass getConceptA3() {
		return conceptA3EClass;
	}

	public EReference getConceptA3_Conceptb3() {
		return (EReference) conceptA3EClass.getEStructuralFeatures().get(0);
	}

	public EClass getConceptB3() {
		return conceptB3EClass;
	}

	public EReference getConceptB3_Concepta3() {
		return (EReference) conceptB3EClass.getEStructuralFeatures().get(0);
	}

	public EClass getConceptA4() {
		return conceptA4EClass;
	}

	public EReference getConceptA4_Conceptb4() {
		return (EReference) conceptA4EClass.getEStructuralFeatures().get(0);
	}

	public EClass getConceptB4() {
		return conceptB4EClass;
	}

	public EReference getConceptB4_Concepta4() {
		return (EReference) conceptB4EClass.getEStructuralFeatures().get(0);
	}

	public EClass getConceptA5() {
		return conceptA5EClass;
	}

	public EReference getConceptA5_Conceptb5() {
		return (EReference) conceptA5EClass.getEStructuralFeatures().get(0);
	}

	public EClass getConceptB5() {
		return conceptB5EClass;
	}

	public EReference getConceptB5_Concepta5() {
		return (EReference) conceptB5EClass.getEStructuralFeatures().get(0);
	}

	public EmfrelationsFactory getEmfrelationsFactory() {
		return (EmfrelationsFactory) getEFactoryInstance();
	}

	private boolean isCreated = false;

	public void createPackageContents() {
		if (isCreated)
			return;
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
	}

	private boolean isInitialized = false;

	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;
		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);
		// Create type parameters
		// Set bounds for type parameters
		// Add supertypes to classes
		// Initialize classes, features, and operations; add parameters
		initEClass(conceptA0EClass, ConceptA0.class, "ConceptA0", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptA0_Conceptb0(), this.getConceptB0(),
				this.getConceptB0_Concepta0(), "conceptb0", null, 0, 1, ConceptA0.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEClass(conceptB0EClass, ConceptB0.class, "ConceptB0", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptB0_Concepta0(), this.getConceptA0(),
				this.getConceptA0_Conceptb0(), "concepta0", null, 0, 1, ConceptB0.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEClass(conceptA1EClass, ConceptA1.class, "ConceptA1", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptA1_Conceptb1(), this.getConceptB1(),
				this.getConceptB1_Concepta1(), "conceptb1", null, 0, -1, ConceptA1.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEClass(conceptB1EClass, ConceptB1.class, "ConceptB1", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptB1_Concepta1(), this.getConceptA1(),
				this.getConceptA1_Conceptb1(), "concepta1", null, 0, 1, ConceptB1.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEClass(conceptA2EClass, ConceptA2.class, "ConceptA2", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptA2_Conceptb2(), this.getConceptB2(),
				this.getConceptB2_Concepta2(), "conceptb2", null, 0, 1, ConceptA2.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEClass(conceptB2EClass, ConceptB2.class, "ConceptB2", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptB2_Concepta2(), this.getConceptA2(),
				this.getConceptA2_Conceptb2(), "concepta2", null, 0, -1, ConceptB2.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEClass(conceptA3EClass, ConceptA3.class, "ConceptA3", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptA3_Conceptb3(), this.getConceptB3(),
				this.getConceptB3_Concepta3(), "conceptb3", null, 0, -1, ConceptA3.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEClass(conceptB3EClass, ConceptB3.class, "ConceptB3", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptB3_Concepta3(), this.getConceptA3(),
				this.getConceptA3_Conceptb3(), "concepta3", null, 0, -1, ConceptB3.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEClass(conceptA4EClass, ConceptA4.class, "ConceptA4", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptA4_Conceptb4(), this.getConceptB4(),
				this.getConceptB4_Concepta4(), "conceptb4", null, 0, 1, ConceptA4.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEClass(conceptB4EClass, ConceptB4.class, "ConceptB4", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptB4_Concepta4(), this.getConceptA4(),
				this.getConceptA4_Conceptb4(), "concepta4", null, 0, 1, ConceptB4.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEClass(conceptA5EClass, ConceptA5.class, "ConceptA5", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptA5_Conceptb5(), this.getConceptB5(),
				this.getConceptB5_Concepta5(), "conceptb5", null, 0, -1, ConceptA5.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEClass(conceptB5EClass, ConceptB5.class, "ConceptB5", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptB5_Concepta5(), this.getConceptA5(),
				this.getConceptA5_Conceptb5(), "concepta5", null, 0, 1, ConceptB5.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		// Create resource
		createResource(eNS_URI);
	}
}
