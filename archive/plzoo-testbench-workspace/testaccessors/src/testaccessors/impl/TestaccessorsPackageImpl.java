/**
 */
package testaccessors.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import testaccessors.EAcc;
import testaccessors.TestaccessorsFactory;
import testaccessors.TestaccessorsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TestaccessorsPackageImpl extends EPackageImpl implements TestaccessorsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAccEClass = null;

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
	 * @see testaccessors.TestaccessorsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TestaccessorsPackageImpl() {
		super(eNS_URI, TestaccessorsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TestaccessorsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TestaccessorsPackage init() {
		if (isInited) return (TestaccessorsPackage)EPackage.Registry.INSTANCE.getEPackage(TestaccessorsPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredTestaccessorsPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		TestaccessorsPackageImpl theTestaccessorsPackage = registeredTestaccessorsPackage instanceof TestaccessorsPackageImpl ? (TestaccessorsPackageImpl)registeredTestaccessorsPackage : new TestaccessorsPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theTestaccessorsPackage.createPackageContents();

		// Initialize created meta-data
		theTestaccessorsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTestaccessorsPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TestaccessorsPackage.eNS_URI, theTestaccessorsPackage);
		return theTestaccessorsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAcc() {
		return eAccEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAcc_B() {
		return (EAttribute)eAccEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAcc_I() {
		return (EAttribute)eAccEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAcc_Bs() {
		return (EAttribute)eAccEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAcc_Is() {
		return (EAttribute)eAccEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestaccessorsFactory getTestaccessorsFactory() {
		return (TestaccessorsFactory)getEFactoryInstance();
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
		eAccEClass = createEClass(EACC);
		createEAttribute(eAccEClass, EACC__B);
		createEAttribute(eAccEClass, EACC__I);
		createEAttribute(eAccEClass, EACC__BS);
		createEAttribute(eAccEClass, EACC__IS);
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
		initEClass(eAccEClass, EAcc.class, "EAcc", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEAcc_B(), ecorePackage.getEBoolean(), "b", null, 0, 1, EAcc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAcc_I(), ecorePackage.getEInt(), "i", null, 0, 1, EAcc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAcc_Bs(), ecorePackage.getEBoolean(), "bs", null, 0, -1, EAcc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAcc_Is(), ecorePackage.getEInt(), "is", null, 0, -1, EAcc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //TestaccessorsPackageImpl
