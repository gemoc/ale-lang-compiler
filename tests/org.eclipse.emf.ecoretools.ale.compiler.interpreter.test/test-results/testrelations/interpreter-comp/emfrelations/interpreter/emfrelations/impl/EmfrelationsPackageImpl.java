package emfrelations.interpreter.emfrelations.impl;

import emfrelations.interpreter.emfrelations.ConceptA0;
import emfrelations.interpreter.emfrelations.ConceptA1;
import emfrelations.interpreter.emfrelations.ConceptA10;
import emfrelations.interpreter.emfrelations.ConceptA11;
import emfrelations.interpreter.emfrelations.ConceptA2;
import emfrelations.interpreter.emfrelations.ConceptA3;
import emfrelations.interpreter.emfrelations.ConceptA4;
import emfrelations.interpreter.emfrelations.ConceptA5;
import emfrelations.interpreter.emfrelations.ConceptA8;
import emfrelations.interpreter.emfrelations.ConceptA9;
import emfrelations.interpreter.emfrelations.ConceptB0;
import emfrelations.interpreter.emfrelations.ConceptB1;
import emfrelations.interpreter.emfrelations.ConceptB10;
import emfrelations.interpreter.emfrelations.ConceptB11;
import emfrelations.interpreter.emfrelations.ConceptB2;
import emfrelations.interpreter.emfrelations.ConceptB3;
import emfrelations.interpreter.emfrelations.ConceptB4;
import emfrelations.interpreter.emfrelations.ConceptB5;
import emfrelations.interpreter.emfrelations.ConceptB8;
import emfrelations.interpreter.emfrelations.ConceptB9;
import emfrelations.interpreter.emfrelations.EmfrelationsFactory;
import emfrelations.interpreter.emfrelations.EmfrelationsPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

public class EmfrelationsPackageImpl extends EPackageImpl implements EmfrelationsPackage {
	private static boolean isInited = false;

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

	private EClass conceptA8EClass = null;

	private EClass conceptB8EClass = null;

	private EClass conceptA9EClass = null;

	private EClass conceptB9EClass = null;

	private EClass conceptA10EClass = null;

	private EClass conceptB10EClass = null;

	private EClass conceptA11EClass = null;

	private EClass conceptB11EClass = null;

	private boolean isCreated = false;

	private boolean isInitialized = false;

	private EmfrelationsPackageImpl() {
		super(eNS_URI, EmfrelationsFactory.eINSTANCE);
	}

	public static EmfrelationsPackage init() {
		if (isInited)
			return (EmfrelationsPackage) EPackage.Registry.INSTANCE.getEPackage(EmfrelationsPackage.eNS_URI);

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
		EPackage.Registry.INSTANCE.put(EmfrelationsPackage.eNS_URI, theEmfrelationsPackage);
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

	public EClass getConceptA8() {
		return conceptA8EClass;
	}

	public EReference getConceptA8_Conceptb8() {
		return (EReference) conceptA8EClass.getEStructuralFeatures().get(0);
	}

	public EClass getConceptB8() {
		return conceptB8EClass;
	}

	public EClass getConceptA9() {
		return conceptA9EClass;
	}

	public EReference getConceptA9_Conceptb9() {
		return (EReference) conceptA9EClass.getEStructuralFeatures().get(0);
	}

	public EClass getConceptB9() {
		return conceptB9EClass;
	}

	public EClass getConceptA10() {
		return conceptA10EClass;
	}

	public EReference getConceptA10_Conceptb10() {
		return (EReference) conceptA10EClass.getEStructuralFeatures().get(0);
	}

	public EClass getConceptB10() {
		return conceptB10EClass;
	}

	public EClass getConceptA11() {
		return conceptA11EClass;
	}

	public EReference getConceptA11_Conceptb11() {
		return (EReference) conceptA11EClass.getEStructuralFeatures().get(0);
	}

	public EClass getConceptB11() {
		return conceptB11EClass;
	}

	public EmfrelationsFactory getEmfrelationsFactory() {
		return (EmfrelationsFactory) getEFactoryInstance();
	}

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
}
