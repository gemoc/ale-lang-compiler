package test1unique.interpreter.test1unique.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import test1unique.interpreter.test1unique.ConceptA;
import test1unique.interpreter.test1unique.Test1uniqueFactory;
import test1unique.interpreter.test1unique.Test1uniquePackage;

public class Test1uniquePackageImpl extends EPackageImpl implements Test1uniquePackage {
	private static boolean isInited = false;

	private EClass conceptAEClass = null;

	private boolean isCreated = false;

	private boolean isInitialized = false;

	private Test1uniquePackageImpl() {
		super(eNS_URI, Test1uniqueFactory.eINSTANCE);
	}

	public static Test1uniquePackage init() {
		if (isInited)
			return (Test1uniquePackage) EPackage.Registry.INSTANCE.getEPackage(Test1uniquePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredTest1uniquePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		Test1uniquePackageImpl theTest1uniquePackage = registeredTest1uniquePackage instanceof Test1uniquePackageImpl
				? (Test1uniquePackageImpl) registeredTest1uniquePackage
				: new Test1uniquePackageImpl();

		isInited = true;

		// Create package meta-data objects
		theTest1uniquePackage.createPackageContents();

		// Initialize created meta-data
		theTest1uniquePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTest1uniquePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Test1uniquePackage.eNS_URI, theTest1uniquePackage);
		return theTest1uniquePackage;
	}

	public EClass getConceptA() {
		return conceptAEClass;
	}

	public EAttribute getConceptA_Bs() {
		return (EAttribute) conceptAEClass.getEStructuralFeatures().get(0);
	}

	public Test1uniqueFactory getTest1uniqueFactory() {
		return (Test1uniqueFactory) getEFactoryInstance();
	}

	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		conceptAEClass = createEClass(CONCEPT_A);
		createEAttribute(conceptAEClass, CONCEPT_A__BS);
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
		initEAttribute(getConceptA_Bs(), ecorePackage.getEBooleanObject(), "bs", null, 0, 10, ConceptA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}
}
