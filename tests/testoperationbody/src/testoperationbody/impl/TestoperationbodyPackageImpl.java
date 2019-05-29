/**
 */
package testoperationbody.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import testoperationbody.ChildA;
import testoperationbody.ChildB;
import testoperationbody.ConceptA;
import testoperationbody.EnumA;
import testoperationbody.Main;
import testoperationbody.Parent;
import testoperationbody.TestoperationbodyFactory;
import testoperationbody.TestoperationbodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TestoperationbodyPackageImpl extends EPackageImpl implements TestoperationbodyPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptAEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass childAEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass childBEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum enumAEEnum = null;

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
	 * @see testoperationbody.TestoperationbodyPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TestoperationbodyPackageImpl() {
		super(eNS_URI, TestoperationbodyFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TestoperationbodyPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TestoperationbodyPackage init() {
		if (isInited) return (TestoperationbodyPackage)EPackage.Registry.INSTANCE.getEPackage(TestoperationbodyPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredTestoperationbodyPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		TestoperationbodyPackageImpl theTestoperationbodyPackage = registeredTestoperationbodyPackage instanceof TestoperationbodyPackageImpl ? (TestoperationbodyPackageImpl)registeredTestoperationbodyPackage : new TestoperationbodyPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theTestoperationbodyPackage.createPackageContents();

		// Initialize created meta-data
		theTestoperationbodyPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTestoperationbodyPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TestoperationbodyPackage.eNS_URI, theTestoperationbodyPackage);
		return theTestoperationbodyPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMain() {
		return mainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMain_Listint() {
		return (EAttribute)mainEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMain_Listconcepta() {
		return (EReference)mainEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMain_Singlebool() {
		return (EAttribute)mainEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMain_Singleconcepta() {
		return (EReference)mainEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMain_Children() {
		return (EReference)mainEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptA() {
		return conceptAEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParent() {
		return parentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChildA() {
		return childAEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChildA_Value() {
		return (EAttribute)childAEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChildB() {
		return childBEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEnumA() {
		return enumAEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestoperationbodyFactory getTestoperationbodyFactory() {
		return (TestoperationbodyFactory)getEFactoryInstance();
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
		mainEClass = createEClass(MAIN);
		createEAttribute(mainEClass, MAIN__LISTINT);
		createEReference(mainEClass, MAIN__LISTCONCEPTA);
		createEAttribute(mainEClass, MAIN__SINGLEBOOL);
		createEReference(mainEClass, MAIN__SINGLECONCEPTA);
		createEReference(mainEClass, MAIN__CHILDREN);

		conceptAEClass = createEClass(CONCEPT_A);

		parentEClass = createEClass(PARENT);

		childAEClass = createEClass(CHILD_A);
		createEAttribute(childAEClass, CHILD_A__VALUE);

		childBEClass = createEClass(CHILD_B);

		// Create enums
		enumAEEnum = createEEnum(ENUM_A);
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
		childAEClass.getESuperTypes().add(this.getParent());
		childBEClass.getESuperTypes().add(this.getParent());

		// Initialize classes, features, and operations; add parameters
		initEClass(mainEClass, Main.class, "Main", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMain_Listint(), ecorePackage.getEInt(), "listint", null, 0, -1, Main.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMain_Listconcepta(), this.getConceptA(), null, "listconcepta", null, 0, -1, Main.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMain_Singlebool(), ecorePackage.getEBoolean(), "singlebool", null, 0, 1, Main.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMain_Singleconcepta(), this.getConceptA(), null, "singleconcepta", null, 0, 1, Main.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMain_Children(), this.getParent(), null, "children", null, 0, -1, Main.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conceptAEClass, ConceptA.class, "ConceptA", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(parentEClass, Parent.class, "Parent", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(childAEClass, ChildA.class, "ChildA", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getChildA_Value(), this.getEnumA(), "value", null, 0, 1, ChildA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(childBEClass, ChildB.class, "ChildB", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(enumAEEnum, EnumA.class, "EnumA");
		addEEnumLiteral(enumAEEnum, EnumA.CASE1);
		addEEnumLiteral(enumAEEnum, EnumA.CASE2);

		// Create resource
		createResource(eNS_URI);
	}

} //TestoperationbodyPackageImpl
