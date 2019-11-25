/**
 */
package modelB.impl;

import modelA.ModelAPackage;

import modelB.ModelBFactory;
import modelB.ModelBPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelBPackageImpl extends EPackageImpl implements ModelBPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aEClass = null;

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
	 * @see modelB.ModelBPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ModelBPackageImpl() {
		super(eNS_URI, ModelBFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ModelBPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ModelBPackage init() {
		if (isInited)
			return (ModelBPackage) EPackage.Registry.INSTANCE.getEPackage(ModelBPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredModelBPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ModelBPackageImpl theModelBPackage = registeredModelBPackage instanceof ModelBPackageImpl
				? (ModelBPackageImpl) registeredModelBPackage
				: new ModelBPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		ModelAPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theModelBPackage.createPackageContents();

		// Initialize created meta-data
		theModelBPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theModelBPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ModelBPackage.eNS_URI, theModelBPackage);
		return theModelBPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getA() {
		return aEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelBFactory getModelBFactory() {
		return (ModelBFactory) getEFactoryInstance();
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
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		aEClass = createEClass(A);
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
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ModelAPackage theModelAPackage = (ModelAPackage) EPackage.Registry.INSTANCE.getEPackage(ModelAPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		aEClass.getESuperTypes().add(theModelAPackage.getA());
		aEClass.getESuperTypes().add(theModelAPackage.getB());

		// Initialize classes, features, and operations; add parameters
		initEClass(aEClass, modelB.A.class, "A", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ModelBPackageImpl
