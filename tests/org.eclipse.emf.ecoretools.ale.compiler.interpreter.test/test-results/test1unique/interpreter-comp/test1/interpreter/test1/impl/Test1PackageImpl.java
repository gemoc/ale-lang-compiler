package test1.interpreter.test1.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import test1.interpreter.test1.Test1Factory;
import test1.interpreter.test1.Test1Package;

public class Test1PackageImpl extends EPackageImpl implements Test1Package {
	private static boolean isInited = false;

	private boolean isCreated = false;

	private boolean isInitialized = false;

	private EClass conceptAEClass = null;

	private Test1PackageImpl() {
		super(eNS_URI, Test1Factory.eINSTANCE);
	}

	public static Test1Package init() {
		if (isInited)
			return (Test1Package) EPackage.Registry.INSTANCE.getEPackage(Test1Package.eNS_URI);

		// Obtain or create and register package
		Object registeredTest1Package = EPackage.Registry.INSTANCE.get(eNS_URI);
		test1.interpreter.test1.impl.Test1PackageImpl theTest1Package;
		if (registeredTest1Package instanceof test1.interpreter.test1.impl.Test1PackageImpl) {
			theTest1Package = (test1.interpreter.test1.impl.Test1PackageImpl) registeredTest1Package;
		} else {
			theTest1Package = new test1.interpreter.test1.impl.Test1PackageImpl();
		}
		isInited = true;

		// Create package meta-data objects
		theTest1Package.createPackageContents();

		// Initialize created meta-data
		theTest1Package.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTest1Package.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Test1Package.eNS_URI, theTest1Package);
		return theTest1Package;
	}

	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

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
		initEClass(conceptAEClass, test1.interpreter.test1.ConceptA.class, "ConceptA", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConceptA_Bs(), ecorePackage.getEBooleanObject(), "bs", null, 0, 10, test1.interpreter.test1.ConceptA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		// Create resource
		createResource(eNS_URI);
	}

	public Test1Factory getTest1Factory() {
		return (Test1Factory) getEFactoryInstance();
	}

	public EClass getConceptA() {
		return conceptAEClass;
	}

	public EAttribute getConceptA_Bs() {
		return (EAttribute) conceptAEClass.getEStructuralFeatures().get(0);
	}
}
