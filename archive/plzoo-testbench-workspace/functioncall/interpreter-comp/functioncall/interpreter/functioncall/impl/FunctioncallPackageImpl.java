package functioncall.interpreter.functioncall.impl;

import functioncall.interpreter.functioncall.ConceptA;
import functioncall.interpreter.functioncall.ConceptB;
import functioncall.interpreter.functioncall.ConceptC;
import functioncall.interpreter.functioncall.FunctioncallFactory;
import functioncall.interpreter.functioncall.FunctioncallPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

public class FunctioncallPackageImpl extends EPackageImpl implements FunctioncallPackage {
	private static boolean isInited = false;

	private EClass conceptAEClass = null;

	private EClass conceptBEClass = null;

	private EClass conceptCEClass = null;

	private boolean isCreated = false;

	private boolean isInitialized = false;

	private FunctioncallPackageImpl() {
		super(eNS_URI, FunctioncallFactory.eINSTANCE);
	}

	public static FunctioncallPackage init() {
		if (isInited)
			return (FunctioncallPackage) EPackage.Registry.INSTANCE.getEPackage(FunctioncallPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredFunctioncallPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		FunctioncallPackageImpl theFunctioncallPackage = registeredFunctioncallPackage instanceof FunctioncallPackageImpl
				? (FunctioncallPackageImpl) registeredFunctioncallPackage
				: new FunctioncallPackageImpl();

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

	public EClass getConceptA() {
		return conceptAEClass;
	}

	public EClass getConceptB() {
		return conceptBEClass;
	}

	public EClass getConceptC() {
		return conceptCEClass;
	}

	public EReference getConceptC_Concepta2() {
		return (EReference) conceptCEClass.getEStructuralFeatures().get(0);
	}

	public EReference getConceptC_Concepta1() {
		return (EReference) conceptCEClass.getEStructuralFeatures().get(1);
	}

	public EReference getConceptC_Conceptb() {
		return (EReference) conceptCEClass.getEStructuralFeatures().get(2);
	}

	public FunctioncallFactory getFunctioncallFactory() {
		return (FunctioncallFactory) getEFactoryInstance();
	}

	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		conceptAEClass = createEClass(CONCEPT_A);

		conceptBEClass = createEClass(CONCEPT_B);

		conceptCEClass = createEClass(CONCEPT_C);
		createEReference(conceptCEClass, CONCEPT_C__CONCEPTA2);
		createEReference(conceptCEClass, CONCEPT_C__CONCEPTA1);
		createEReference(conceptCEClass, CONCEPT_C__CONCEPTB);
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
}
