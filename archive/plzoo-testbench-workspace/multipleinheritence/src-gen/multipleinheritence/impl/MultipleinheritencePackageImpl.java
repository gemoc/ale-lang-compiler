/**
 */
package multipleinheritence.impl;

import multipleinheritence.MultipleinheritenceFactory;
import multipleinheritence.MultipleinheritencePackage;
import multipleinheritence.NewEClass1;
import multipleinheritence.NewEClass2;
import multipleinheritence.NewEClass3;
import multipleinheritence.NewEClass4;
import multipleinheritence.NewEClass5;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MultipleinheritencePackageImpl extends EPackageImpl implements MultipleinheritencePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass newEClass1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass newEClass2EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass newEClass3EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass newEClass4EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass newEClass5EClass = null;

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
	 * @see multipleinheritence.MultipleinheritencePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MultipleinheritencePackageImpl() {
		super(eNS_URI, MultipleinheritenceFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link MultipleinheritencePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MultipleinheritencePackage init() {
		if (isInited)
			return (MultipleinheritencePackage) EPackage.Registry.INSTANCE
					.getEPackage(MultipleinheritencePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredMultipleinheritencePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		MultipleinheritencePackageImpl theMultipleinheritencePackage = registeredMultipleinheritencePackage instanceof MultipleinheritencePackageImpl
				? (MultipleinheritencePackageImpl) registeredMultipleinheritencePackage
				: new MultipleinheritencePackageImpl();

		isInited = true;

		// Create package meta-data objects
		theMultipleinheritencePackage.createPackageContents();

		// Initialize created meta-data
		theMultipleinheritencePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMultipleinheritencePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MultipleinheritencePackage.eNS_URI, theMultipleinheritencePackage);
		return theMultipleinheritencePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNewEClass1() {
		return newEClass1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNewEClass1_F1() {
		return (EAttribute) newEClass1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNewEClass2() {
		return newEClass2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNewEClass2_F2() {
		return (EAttribute) newEClass2EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNewEClass3() {
		return newEClass3EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNewEClass3_F3() {
		return (EAttribute) newEClass3EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNewEClass4() {
		return newEClass4EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNewEClass4_F4() {
		return (EAttribute) newEClass4EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNewEClass5() {
		return newEClass5EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNewEClass5_F5() {
		return (EAttribute) newEClass5EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultipleinheritenceFactory getMultipleinheritenceFactory() {
		return (MultipleinheritenceFactory) getEFactoryInstance();
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
		newEClass1EClass = createEClass(NEW_ECLASS1);
		createEAttribute(newEClass1EClass, NEW_ECLASS1__F1);

		newEClass2EClass = createEClass(NEW_ECLASS2);
		createEAttribute(newEClass2EClass, NEW_ECLASS2__F2);

		newEClass3EClass = createEClass(NEW_ECLASS3);
		createEAttribute(newEClass3EClass, NEW_ECLASS3__F3);

		newEClass4EClass = createEClass(NEW_ECLASS4);
		createEAttribute(newEClass4EClass, NEW_ECLASS4__F4);

		newEClass5EClass = createEClass(NEW_ECLASS5);
		createEAttribute(newEClass5EClass, NEW_ECLASS5__F5);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		newEClass1EClass.getESuperTypes().add(this.getNewEClass2());
		newEClass1EClass.getESuperTypes().add(this.getNewEClass3());
		newEClass3EClass.getESuperTypes().add(this.getNewEClass4());
		newEClass3EClass.getESuperTypes().add(this.getNewEClass5());

		// Initialize classes, features, and operations; add parameters
		initEClass(newEClass1EClass, NewEClass1.class, "NewEClass1", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNewEClass1_F1(), ecorePackage.getEInt(), "f1", null, 0, 1, NewEClass1.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(newEClass2EClass, NewEClass2.class, "NewEClass2", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNewEClass2_F2(), ecorePackage.getEInt(), "f2", null, 0, 1, NewEClass2.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(newEClass3EClass, NewEClass3.class, "NewEClass3", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNewEClass3_F3(), ecorePackage.getEInt(), "f3", null, 0, 1, NewEClass3.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(newEClass4EClass, NewEClass4.class, "NewEClass4", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNewEClass4_F4(), ecorePackage.getEInt(), "f4", null, 0, 1, NewEClass4.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(newEClass5EClass, NewEClass5.class, "NewEClass5", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNewEClass5_F5(), ecorePackage.getEInt(), "f5", null, 0, 1, NewEClass5.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //MultipleinheritencePackageImpl
