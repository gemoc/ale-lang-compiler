/**
 */
package helloworld.impl;

import helloworld.HelloWorld;
import helloworld.HelloworldFactory;
import helloworld.HelloworldPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HelloworldPackageImpl extends EPackageImpl implements HelloworldPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass helloWorldEClass = null;

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
	 * @see helloworld.HelloworldPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private HelloworldPackageImpl() {
		super(eNS_URI, HelloworldFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link HelloworldPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static HelloworldPackage init() {
		if (isInited) return (HelloworldPackage)EPackage.Registry.INSTANCE.getEPackage(HelloworldPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredHelloworldPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		HelloworldPackageImpl theHelloworldPackage = registeredHelloworldPackage instanceof HelloworldPackageImpl ? (HelloworldPackageImpl)registeredHelloworldPackage : new HelloworldPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theHelloworldPackage.createPackageContents();

		// Initialize created meta-data
		theHelloworldPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theHelloworldPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(HelloworldPackage.eNS_URI, theHelloworldPackage);
		return theHelloworldPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHelloWorld() {
		return helloWorldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getHelloWorld__Greeting() {
		return helloWorldEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HelloworldFactory getHelloworldFactory() {
		return (HelloworldFactory)getEFactoryInstance();
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
		helloWorldEClass = createEClass(HELLO_WORLD);
		createEOperation(helloWorldEClass, HELLO_WORLD___GREETING);
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
		initEClass(helloWorldEClass, HelloWorld.class, "HelloWorld", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getHelloWorld__Greeting(), ecorePackage.getEString(), "greeting", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //HelloworldPackageImpl
