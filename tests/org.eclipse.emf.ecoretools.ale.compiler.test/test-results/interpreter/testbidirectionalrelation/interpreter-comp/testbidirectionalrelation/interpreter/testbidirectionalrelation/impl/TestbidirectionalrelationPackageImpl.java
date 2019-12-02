package testbidirectionalrelation.interpreter.testbidirectionalrelation.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import testbidirectionalrelation.interpreter.testbidirectionalrelation.ConceptA;
import testbidirectionalrelation.interpreter.testbidirectionalrelation.ConceptB;
import testbidirectionalrelation.interpreter.testbidirectionalrelation.ConceptC;
import testbidirectionalrelation.interpreter.testbidirectionalrelation.ConceptD;
import testbidirectionalrelation.interpreter.testbidirectionalrelation.ConceptE;
import testbidirectionalrelation.interpreter.testbidirectionalrelation.ConceptF;
import testbidirectionalrelation.interpreter.testbidirectionalrelation.ConceptG;
import testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationFactory;
import testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage;

public class TestbidirectionalrelationPackageImpl extends EPackageImpl implements TestbidirectionalrelationPackage {
	private static boolean isInited = false;

	private EClass conceptAEClass = null;

	private EClass conceptBEClass = null;

	private EClass conceptCEClass = null;

	private EClass conceptDEClass = null;

	private EClass conceptEEClass = null;

	private EClass conceptFEClass = null;

	private EClass conceptGEClass = null;

	private boolean isCreated = false;

	private boolean isInitialized = false;

	private TestbidirectionalrelationPackageImpl() {
		super(eNS_URI, TestbidirectionalrelationFactory.eINSTANCE);
	}

	public static TestbidirectionalrelationPackage init() {
		if (isInited)
			return (TestbidirectionalrelationPackage) EPackage.Registry.INSTANCE.getEPackage(TestbidirectionalrelationPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredTestbidirectionalrelationPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		TestbidirectionalrelationPackageImpl theTestbidirectionalrelationPackage = registeredTestbidirectionalrelationPackage instanceof TestbidirectionalrelationPackageImpl
				? (TestbidirectionalrelationPackageImpl) registeredTestbidirectionalrelationPackage
				: new TestbidirectionalrelationPackageImpl();

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

	public EClass getConceptA() {
		return conceptAEClass;
	}

	public EReference getConceptA_Conceptb() {
		return (EReference) conceptAEClass.getEStructuralFeatures().get(0);
	}

	public EReference getConceptA_Conceptc() {
		return (EReference) conceptAEClass.getEStructuralFeatures().get(1);
	}

	public EReference getConceptA_Conceptd() {
		return (EReference) conceptAEClass.getEStructuralFeatures().get(2);
	}

	public EReference getConceptA_Concepte() {
		return (EReference) conceptAEClass.getEStructuralFeatures().get(3);
	}

	public EReference getConceptA_Conceptf() {
		return (EReference) conceptAEClass.getEStructuralFeatures().get(4);
	}

	public EReference getConceptA_Conceptg() {
		return (EReference) conceptAEClass.getEStructuralFeatures().get(5);
	}

	public EClass getConceptB() {
		return conceptBEClass;
	}

	public EReference getConceptB_Conceptc() {
		return (EReference) conceptBEClass.getEStructuralFeatures().get(0);
	}

	public EClass getConceptC() {
		return conceptCEClass;
	}

	public EReference getConceptC_Conceptb() {
		return (EReference) conceptCEClass.getEStructuralFeatures().get(0);
	}

	public EClass getConceptD() {
		return conceptDEClass;
	}

	public EReference getConceptD_Concepte() {
		return (EReference) conceptDEClass.getEStructuralFeatures().get(0);
	}

	public EClass getConceptE() {
		return conceptEEClass;
	}

	public EReference getConceptE_Conceptd() {
		return (EReference) conceptEEClass.getEStructuralFeatures().get(0);
	}

	public EClass getConceptF() {
		return conceptFEClass;
	}

	public EReference getConceptF_Conceptg() {
		return (EReference) conceptFEClass.getEStructuralFeatures().get(0);
	}

	public EClass getConceptG() {
		return conceptGEClass;
	}

	public EReference getConceptG_Conceptf() {
		return (EReference) conceptGEClass.getEStructuralFeatures().get(0);
	}

	public TestbidirectionalrelationFactory getTestbidirectionalrelationFactory() {
		return (TestbidirectionalrelationFactory) getEFactoryInstance();
	}

	public void createPackageContents() {
		if (isCreated)
			return;
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
}
