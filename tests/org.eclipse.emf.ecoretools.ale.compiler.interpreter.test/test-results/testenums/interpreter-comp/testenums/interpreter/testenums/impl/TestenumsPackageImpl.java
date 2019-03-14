
package testenums.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import testenums.Enum1;
import testenums.Root;
import testenums.TestenumsFactory;
import testenums.TestenumsPackage;


public class TestenumsPackageImpl extends EPackageImpl implements TestenumsPackage {
	
	private EClass rootEClass = null;

	
	private EEnum enum1EEnum = null;

	
	private TestenumsPackageImpl() {
		super(eNS_URI, TestenumsFactory.eINSTANCE);
	}

	
	private static boolean isInited = false;

	
	public static TestenumsPackage init() {
		if (isInited) return (TestenumsPackage)EPackage.Registry.INSTANCE.getEPackage(TestenumsPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredTestenumsPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		TestenumsPackageImpl theTestenumsPackage = registeredTestenumsPackage instanceof TestenumsPackageImpl ? (TestenumsPackageImpl)registeredTestenumsPackage : new TestenumsPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theTestenumsPackage.createPackageContents();

		// Initialize created meta-data
		theTestenumsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTestenumsPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TestenumsPackage.eNS_URI, theTestenumsPackage);
		return theTestenumsPackage;
	}

	
	public EClass getRoot() {
		return rootEClass;
	}

	
	public EAttribute getRoot_Enum() {
		return (EAttribute)rootEClass.getEStructuralFeatures().get(0);
	}

	
	public EAttribute getRoot_Enums() {
		return (EAttribute)rootEClass.getEStructuralFeatures().get(1);
	}

	
	public EEnum getEnum1() {
		return enum1EEnum;
	}

	
	public TestenumsFactory getTestenumsFactory() {
		return (TestenumsFactory)getEFactoryInstance();
	}

	
	private boolean isCreated = false;

	
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		rootEClass = createEClass(ROOT);
		createEAttribute(rootEClass, ROOT__ENUM);
		createEAttribute(rootEClass, ROOT__ENUMS);

		// Create enums
		enum1EEnum = createEEnum(ENUM1);
	}

	
	private boolean isInitialized = false;

	
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
		initEClass(rootEClass, Root.class, "Root", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRoot_Enum(), this.getEnum1(), "enum", "LITERAL0", 0, 1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRoot_Enums(), this.getEnum1(), "enums", null, 0, -1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(enum1EEnum, Enum1.class, "Enum1");
		addEEnumLiteral(enum1EEnum, Enum1.LITERAL0);
		addEEnumLiteral(enum1EEnum, Enum1.LITERAL1);

		// Create resource
		createResource(eNS_URI);
	}

} //TestenumsPackageImpl
