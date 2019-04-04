package testoperationbody.visitor.testoperationbody.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import testoperationbody.visitor.testoperationbody.ChildA;
import testoperationbody.visitor.testoperationbody.ChildB;
import testoperationbody.visitor.testoperationbody.ConceptA;
import testoperationbody.visitor.testoperationbody.EnumA;
import testoperationbody.visitor.testoperationbody.Main;
import testoperationbody.visitor.testoperationbody.Parent;
import testoperationbody.visitor.testoperationbody.TestoperationbodyFactory;
import testoperationbody.visitor.testoperationbody.TestoperationbodyPackage;

public class TestoperationbodyPackageImpl extends EPackageImpl implements TestoperationbodyPackage {
	private static boolean isInited = false;

	private EClass mainEClass = null;

	private EClass conceptAEClass = null;

	private EClass parentEClass = null;

	private EClass childAEClass = null;

	private EClass childBEClass = null;

	private EEnum enumAEEnum = null;

	private boolean isCreated = false;

	private boolean isInitialized = false;

	private TestoperationbodyPackageImpl() {
		super(eNS_URI, TestoperationbodyFactory.eINSTANCE);
	}

	public static TestoperationbodyPackage init() {
		if (isInited)
			return (TestoperationbodyPackage) EPackage.Registry.INSTANCE.getEPackage(TestoperationbodyPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredTestoperationbodyPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		TestoperationbodyPackageImpl theTestoperationbodyPackage = registeredTestoperationbodyPackage instanceof TestoperationbodyPackageImpl
				? (TestoperationbodyPackageImpl) registeredTestoperationbodyPackage
				: new TestoperationbodyPackageImpl();

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

	public EClass getMain() {
		return mainEClass;
	}

	public EAttribute getMain_Listint() {
		return (EAttribute) mainEClass.getEStructuralFeatures().get(0);
	}

	public EReference getMain_Listconcepta() {
		return (EReference) mainEClass.getEStructuralFeatures().get(1);
	}

	public EAttribute getMain_Singlebool() {
		return (EAttribute) mainEClass.getEStructuralFeatures().get(2);
	}

	public EReference getMain_Singleconcepta() {
		return (EReference) mainEClass.getEStructuralFeatures().get(3);
	}

	public EReference getMain_Children() {
		return (EReference) mainEClass.getEStructuralFeatures().get(4);
	}

	public EClass getConceptA() {
		return conceptAEClass;
	}

	public EClass getParent() {
		return parentEClass;
	}

	public EClass getChildA() {
		return childAEClass;
	}

	public EAttribute getChildA_Value() {
		return (EAttribute) childAEClass.getEStructuralFeatures().get(0);
	}

	public EClass getChildB() {
		return childBEClass;
	}

	public EEnum getEnumA() {
		return enumAEEnum;
	}

	public TestoperationbodyFactory getTestoperationbodyFactory() {
		return (TestoperationbodyFactory) getEFactoryInstance();
	}

	public void createPackageContents() {
		if (isCreated)
			return;
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
}
