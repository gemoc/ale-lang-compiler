package emapvselistentry.interpreter.emapvselistentry.impl;

import emapvselistentry.interpreter.emapvselistentry.EmapvselistentryFactory;
import emapvselistentry.interpreter.emapvselistentry.EmapvselistentryPackage;
import emapvselistentry.interpreter.emapvselistentry.NewEClass1;
import java.util.Map.Entry;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

public class EmapvselistentryPackageImpl extends EPackageImpl implements EmapvselistentryPackage {
	private static boolean isInited = false;

	private EClass newEClass1EClass = null;

	private EClass newEClass2EClass = null;

	private EClass newEClass3EClass = null;

	private EClass newEClass4EClass = null;

	private EClass newEClass5EClass = null;

	private boolean isCreated = false;

	private boolean isInitialized = false;

	private EmapvselistentryPackageImpl() {
		super(eNS_URI, EmapvselistentryFactory.eINSTANCE);
	}

	public static EmapvselistentryPackage init() {
		if (isInited)
			return (EmapvselistentryPackage) EPackage.Registry.INSTANCE.getEPackage(EmapvselistentryPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredEmapvselistentryPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		EmapvselistentryPackageImpl theEmapvselistentryPackage = registeredEmapvselistentryPackage instanceof EmapvselistentryPackageImpl
				? (EmapvselistentryPackageImpl) registeredEmapvselistentryPackage
				: new EmapvselistentryPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theEmapvselistentryPackage.createPackageContents();

		// Initialize created meta-data
		theEmapvselistentryPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEmapvselistentryPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EmapvselistentryPackage.eNS_URI, theEmapvselistentryPackage);
		return theEmapvselistentryPackage;
	}

	public EClass getNewEClass1() {
		return newEClass1EClass;
	}

	public EReference getNewEClass1_Neweclass2() {
		return (EReference) newEClass1EClass.getEStructuralFeatures().get(0);
	}

	public EReference getNewEClass1_Neweclass3() {
		return (EReference) newEClass1EClass.getEStructuralFeatures().get(1);
	}

	public EReference getNewEClass1_Neweclass4() {
		return (EReference) newEClass1EClass.getEStructuralFeatures().get(2);
	}

	public EReference getNewEClass1_Neweclass5() {
		return (EReference) newEClass1EClass.getEStructuralFeatures().get(3);
	}

	public EClass getNewEClass2() {
		return newEClass2EClass;
	}

	public EAttribute getNewEClass2_Key() {
		return (EAttribute) newEClass2EClass.getEStructuralFeatures().get(0);
	}

	public EAttribute getNewEClass2_Value() {
		return (EAttribute) newEClass2EClass.getEStructuralFeatures().get(1);
	}

	public EClass getNewEClass3() {
		return newEClass3EClass;
	}

	public EAttribute getNewEClass3_Key() {
		return (EAttribute) newEClass3EClass.getEStructuralFeatures().get(0);
	}

	public EAttribute getNewEClass3_Value() {
		return (EAttribute) newEClass3EClass.getEStructuralFeatures().get(1);
	}

	public EClass getNewEClass4() {
		return newEClass4EClass;
	}

	public EAttribute getNewEClass4_Key() {
		return (EAttribute) newEClass4EClass.getEStructuralFeatures().get(0);
	}

	public EAttribute getNewEClass4_Value() {
		return (EAttribute) newEClass4EClass.getEStructuralFeatures().get(1);
	}

	public EClass getNewEClass5() {
		return newEClass5EClass;
	}

	public EAttribute getNewEClass5_Key() {
		return (EAttribute) newEClass5EClass.getEStructuralFeatures().get(0);
	}

	public EAttribute getNewEClass5_Value() {
		return (EAttribute) newEClass5EClass.getEStructuralFeatures().get(1);
	}

	public EmapvselistentryFactory getEmapvselistentryFactory() {
		return (EmapvselistentryFactory) getEFactoryInstance();
	}

	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		newEClass1EClass = createEClass(NEW_ECLASS1);
		createEReference(newEClass1EClass, NEW_ECLASS1__NEWECLASS2);
		createEReference(newEClass1EClass, NEW_ECLASS1__NEWECLASS3);
		createEReference(newEClass1EClass, NEW_ECLASS1__NEWECLASS4);
		createEReference(newEClass1EClass, NEW_ECLASS1__NEWECLASS5);

		newEClass2EClass = createEClass(NEW_ECLASS2);
		createEAttribute(newEClass2EClass, NEW_ECLASS2__KEY);
		createEAttribute(newEClass2EClass, NEW_ECLASS2__VALUE);

		newEClass3EClass = createEClass(NEW_ECLASS3);
		createEAttribute(newEClass3EClass, NEW_ECLASS3__KEY);
		createEAttribute(newEClass3EClass, NEW_ECLASS3__VALUE);

		newEClass4EClass = createEClass(NEW_ECLASS4);
		createEAttribute(newEClass4EClass, NEW_ECLASS4__KEY);
		createEAttribute(newEClass4EClass, NEW_ECLASS4__VALUE);

		newEClass5EClass = createEClass(NEW_ECLASS5);
		createEAttribute(newEClass5EClass, NEW_ECLASS5__KEY);
		createEAttribute(newEClass5EClass, NEW_ECLASS5__VALUE);
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
		initEClass(newEClass1EClass, NewEClass1.class, "NewEClass1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNewEClass1_Neweclass2(), this.getNewEClass2(), null, "neweclass2", null, 0, -1, NewEClass1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNewEClass1_Neweclass3(), this.getNewEClass3(), null, "neweclass3", null, 0, -1, NewEClass1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNewEClass1_Neweclass4(), this.getNewEClass4(), null, "neweclass4", null, 0, 1, NewEClass1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNewEClass1_Neweclass5(), this.getNewEClass5(), null, "neweclass5", null, 0, 1, NewEClass1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(newEClass2EClass, Entry.class, "NewEClass2", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNewEClass2_Key(), ecorePackage.getEIntegerObject(), "key", null, 0, 1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNewEClass2_Value(), ecorePackage.getEBooleanObject(), "value", null, 0, 1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(newEClass3EClass, Entry.class, "NewEClass3", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNewEClass3_Key(), ecorePackage.getEIntegerObject(), "key", null, 0, 1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNewEClass3_Value(), ecorePackage.getEBooleanObject(), "value", null, 0, 1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(newEClass4EClass, Entry.class, "NewEClass4", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNewEClass4_Key(), ecorePackage.getEIntegerObject(), "key", null, 0, 1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNewEClass4_Value(), ecorePackage.getEBooleanObject(), "value", null, 0, 1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(newEClass5EClass, Entry.class, "NewEClass5", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNewEClass5_Key(), ecorePackage.getEIntegerObject(), "key", null, 0, 1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNewEClass5_Value(), ecorePackage.getEBooleanObject(), "value", null, 0, 1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}
}
