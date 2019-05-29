package testmaprelations.interpreter.testmaprelations.impl;

import java.util.Map.Entry;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import testmaprelations.interpreter.testmaprelations.CA0;
import testmaprelations.interpreter.testmaprelations.CA1;
import testmaprelations.interpreter.testmaprelations.CA2;
import testmaprelations.interpreter.testmaprelations.CA3;
import testmaprelations.interpreter.testmaprelations.CA4;
import testmaprelations.interpreter.testmaprelations.CA5;
import testmaprelations.interpreter.testmaprelations.CA6;
import testmaprelations.interpreter.testmaprelations.CA7;
import testmaprelations.interpreter.testmaprelations.CA8;
import testmaprelations.interpreter.testmaprelations.CA9;
import testmaprelations.interpreter.testmaprelations.CB0;
import testmaprelations.interpreter.testmaprelations.CB1;
import testmaprelations.interpreter.testmaprelations.CB2;
import testmaprelations.interpreter.testmaprelations.CB3;
import testmaprelations.interpreter.testmaprelations.CB4;
import testmaprelations.interpreter.testmaprelations.CB5;
import testmaprelations.interpreter.testmaprelations.CB6;
import testmaprelations.interpreter.testmaprelations.CB7;
import testmaprelations.interpreter.testmaprelations.CB8;
import testmaprelations.interpreter.testmaprelations.CB9;
import testmaprelations.interpreter.testmaprelations.TestmaprelationsFactory;
import testmaprelations.interpreter.testmaprelations.TestmaprelationsPackage;

public class TestmaprelationsPackageImpl extends EPackageImpl implements TestmaprelationsPackage {
	private static boolean isInited = false;

	private EClass mapCA0ToCB0MapEntryEClass = null;

	private EClass ca0EClass = null;

	private EClass cb0EClass = null;

	private EClass mapCA1ToCB1MapEntryEClass = null;

	private EClass cb1EClass = null;

	private EClass ca1EClass = null;

	private EClass ca2EClass = null;

	private EClass cb2EClass = null;

	private EClass mapCA2ToCB2MapEntryEClass = null;

	private EClass cb3EClass = null;

	private EClass ca3EClass = null;

	private EClass mapCA3ToCB3MapEntryEClass = null;

	private EClass ca4EClass = null;

	private EClass mapCA4ToCB4MapEntryEClass = null;

	private EClass cb4EClass = null;

	private EClass ca5EClass = null;

	private EClass cb5EClass = null;

	private EClass mapCA5ToCB5MapEntryEClass = null;

	private EClass mapCA6ToCB6MapEntryEClass = null;

	private EClass ca6EClass = null;

	private EClass cb6EClass = null;

	private EClass ca7EClass = null;

	private EClass mapCA7ToCB7MapEntryEClass = null;

	private EClass cb7EClass = null;

	private EClass ca8EClass = null;

	private EClass mapCA8ToCB8MapEntryEClass = null;

	private EClass cb8EClass = null;

	private EClass mapCA9ToCB9MapEntryEClass = null;

	private EClass cb9EClass = null;

	private EClass ca9EClass = null;

	private boolean isCreated = false;

	private boolean isInitialized = false;

	private TestmaprelationsPackageImpl() {
		super(eNS_URI, TestmaprelationsFactory.eINSTANCE);
	}

	public static TestmaprelationsPackage init() {
		if (isInited)
			return (TestmaprelationsPackage) EPackage.Registry.INSTANCE.getEPackage(TestmaprelationsPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredTestmaprelationsPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		TestmaprelationsPackageImpl theTestmaprelationsPackage = registeredTestmaprelationsPackage instanceof TestmaprelationsPackageImpl
				? (TestmaprelationsPackageImpl) registeredTestmaprelationsPackage
				: new TestmaprelationsPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theTestmaprelationsPackage.createPackageContents();

		// Initialize created meta-data
		theTestmaprelationsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTestmaprelationsPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TestmaprelationsPackage.eNS_URI, theTestmaprelationsPackage);
		return theTestmaprelationsPackage;
	}

	public EClass getMapCA0ToCB0MapEntry() {
		return mapCA0ToCB0MapEntryEClass;
	}

	public EReference getMapCA0ToCB0MapEntry_Key() {
		return (EReference) mapCA0ToCB0MapEntryEClass.getEStructuralFeatures().get(0);
	}

	public EReference getMapCA0ToCB0MapEntry_Value() {
		return (EReference) mapCA0ToCB0MapEntryEClass.getEStructuralFeatures().get(1);
	}

	public EClass getCA0() {
		return ca0EClass;
	}

	public EReference getCA0_Mapca0tocb0mapentry() {
		return (EReference) ca0EClass.getEStructuralFeatures().get(0);
	}

	public EClass getCB0() {
		return cb0EClass;
	}

	public EReference getCB0_Mapca0tocb0mapentry() {
		return (EReference) cb0EClass.getEStructuralFeatures().get(0);
	}

	public EClass getMapCA1ToCB1MapEntry() {
		return mapCA1ToCB1MapEntryEClass;
	}

	public EReference getMapCA1ToCB1MapEntry_Key() {
		return (EReference) mapCA1ToCB1MapEntryEClass.getEStructuralFeatures().get(0);
	}

	public EReference getMapCA1ToCB1MapEntry_Value() {
		return (EReference) mapCA1ToCB1MapEntryEClass.getEStructuralFeatures().get(1);
	}

	public EClass getCB1() {
		return cb1EClass;
	}

	public EReference getCB1_Mapca0tocb0mapentry() {
		return (EReference) cb1EClass.getEStructuralFeatures().get(0);
	}

	public EClass getCA1() {
		return ca1EClass;
	}

	public EReference getCA1_Mapca0tocb0mapentry() {
		return (EReference) ca1EClass.getEStructuralFeatures().get(0);
	}

	public EClass getCA2() {
		return ca2EClass;
	}

	public EReference getCA2_Mapca0tocb0mapentry() {
		return (EReference) ca2EClass.getEStructuralFeatures().get(0);
	}

	public EClass getCB2() {
		return cb2EClass;
	}

	public EReference getCB2_Mapca0tocb0mapentry() {
		return (EReference) cb2EClass.getEStructuralFeatures().get(0);
	}

	public EClass getMapCA2ToCB2MapEntry() {
		return mapCA2ToCB2MapEntryEClass;
	}

	public EReference getMapCA2ToCB2MapEntry_Key() {
		return (EReference) mapCA2ToCB2MapEntryEClass.getEStructuralFeatures().get(0);
	}

	public EReference getMapCA2ToCB2MapEntry_Value() {
		return (EReference) mapCA2ToCB2MapEntryEClass.getEStructuralFeatures().get(1);
	}

	public EClass getCB3() {
		return cb3EClass;
	}

	public EReference getCB3_Mapca0tocb0mapentry() {
		return (EReference) cb3EClass.getEStructuralFeatures().get(0);
	}

	public EClass getCA3() {
		return ca3EClass;
	}

	public EReference getCA3_Mapca0tocb0mapentry() {
		return (EReference) ca3EClass.getEStructuralFeatures().get(0);
	}

	public EClass getMapCA3ToCB3MapEntry() {
		return mapCA3ToCB3MapEntryEClass;
	}

	public EReference getMapCA3ToCB3MapEntry_Key() {
		return (EReference) mapCA3ToCB3MapEntryEClass.getEStructuralFeatures().get(0);
	}

	public EReference getMapCA3ToCB3MapEntry_Value() {
		return (EReference) mapCA3ToCB3MapEntryEClass.getEStructuralFeatures().get(1);
	}

	public EClass getCA4() {
		return ca4EClass;
	}

	public EReference getCA4_Mapca0tocb0mapentry() {
		return (EReference) ca4EClass.getEStructuralFeatures().get(0);
	}

	public EClass getMapCA4ToCB4MapEntry() {
		return mapCA4ToCB4MapEntryEClass;
	}

	public EReference getMapCA4ToCB4MapEntry_Key() {
		return (EReference) mapCA4ToCB4MapEntryEClass.getEStructuralFeatures().get(0);
	}

	public EReference getMapCA4ToCB4MapEntry_Value() {
		return (EReference) mapCA4ToCB4MapEntryEClass.getEStructuralFeatures().get(1);
	}

	public EClass getCB4() {
		return cb4EClass;
	}

	public EReference getCB4_Mapca0tocb0mapentry() {
		return (EReference) cb4EClass.getEStructuralFeatures().get(0);
	}

	public EClass getCA5() {
		return ca5EClass;
	}

	public EReference getCA5_Mapca0tocb0mapentry() {
		return (EReference) ca5EClass.getEStructuralFeatures().get(0);
	}

	public EClass getCB5() {
		return cb5EClass;
	}

	public EReference getCB5_Mapca0tocb0mapentry() {
		return (EReference) cb5EClass.getEStructuralFeatures().get(0);
	}

	public EClass getMapCA5ToCB5MapEntry() {
		return mapCA5ToCB5MapEntryEClass;
	}

	public EReference getMapCA5ToCB5MapEntry_Key() {
		return (EReference) mapCA5ToCB5MapEntryEClass.getEStructuralFeatures().get(0);
	}

	public EReference getMapCA5ToCB5MapEntry_Value() {
		return (EReference) mapCA5ToCB5MapEntryEClass.getEStructuralFeatures().get(1);
	}

	public EClass getMapCA6ToCB6MapEntry() {
		return mapCA6ToCB6MapEntryEClass;
	}

	public EReference getMapCA6ToCB6MapEntry_Key() {
		return (EReference) mapCA6ToCB6MapEntryEClass.getEStructuralFeatures().get(0);
	}

	public EReference getMapCA6ToCB6MapEntry_Value() {
		return (EReference) mapCA6ToCB6MapEntryEClass.getEStructuralFeatures().get(1);
	}

	public EClass getCA6() {
		return ca6EClass;
	}

	public EClass getCB6() {
		return cb6EClass;
	}

	public EClass getCA7() {
		return ca7EClass;
	}

	public EClass getMapCA7ToCB7MapEntry() {
		return mapCA7ToCB7MapEntryEClass;
	}

	public EReference getMapCA7ToCB7MapEntry_Key() {
		return (EReference) mapCA7ToCB7MapEntryEClass.getEStructuralFeatures().get(0);
	}

	public EReference getMapCA7ToCB7MapEntry_Value() {
		return (EReference) mapCA7ToCB7MapEntryEClass.getEStructuralFeatures().get(1);
	}

	public EClass getCB7() {
		return cb7EClass;
	}

	public EClass getCA8() {
		return ca8EClass;
	}

	public EClass getMapCA8ToCB8MapEntry() {
		return mapCA8ToCB8MapEntryEClass;
	}

	public EReference getMapCA8ToCB8MapEntry_Key() {
		return (EReference) mapCA8ToCB8MapEntryEClass.getEStructuralFeatures().get(0);
	}

	public EReference getMapCA8ToCB8MapEntry_Value() {
		return (EReference) mapCA8ToCB8MapEntryEClass.getEStructuralFeatures().get(1);
	}

	public EClass getCB8() {
		return cb8EClass;
	}

	public EClass getMapCA9ToCB9MapEntry() {
		return mapCA9ToCB9MapEntryEClass;
	}

	public EReference getMapCA9ToCB9MapEntry_Key() {
		return (EReference) mapCA9ToCB9MapEntryEClass.getEStructuralFeatures().get(0);
	}

	public EReference getMapCA9ToCB9MapEntry_Value() {
		return (EReference) mapCA9ToCB9MapEntryEClass.getEStructuralFeatures().get(1);
	}

	public EClass getCB9() {
		return cb9EClass;
	}

	public EClass getCA9() {
		return ca9EClass;
	}

	public TestmaprelationsFactory getTestmaprelationsFactory() {
		return (TestmaprelationsFactory) getEFactoryInstance();
	}

	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		mapCA0ToCB0MapEntryEClass = createEClass(MAP_CA0_TO_CB0_MAP_ENTRY);
		createEReference(mapCA0ToCB0MapEntryEClass, MAP_CA0_TO_CB0_MAP_ENTRY__KEY);
		createEReference(mapCA0ToCB0MapEntryEClass, MAP_CA0_TO_CB0_MAP_ENTRY__VALUE);

		ca0EClass = createEClass(CA0);
		createEReference(ca0EClass, CA0__MAPCA0TOCB0MAPENTRY);

		cb0EClass = createEClass(CB0);
		createEReference(cb0EClass, CB0__MAPCA0TOCB0MAPENTRY);

		mapCA1ToCB1MapEntryEClass = createEClass(MAP_CA1_TO_CB1_MAP_ENTRY);
		createEReference(mapCA1ToCB1MapEntryEClass, MAP_CA1_TO_CB1_MAP_ENTRY__KEY);
		createEReference(mapCA1ToCB1MapEntryEClass, MAP_CA1_TO_CB1_MAP_ENTRY__VALUE);

		cb1EClass = createEClass(CB1);
		createEReference(cb1EClass, CB1__MAPCA0TOCB0MAPENTRY);

		ca1EClass = createEClass(CA1);
		createEReference(ca1EClass, CA1__MAPCA0TOCB0MAPENTRY);

		ca2EClass = createEClass(CA2);
		createEReference(ca2EClass, CA2__MAPCA0TOCB0MAPENTRY);

		cb2EClass = createEClass(CB2);
		createEReference(cb2EClass, CB2__MAPCA0TOCB0MAPENTRY);

		mapCA2ToCB2MapEntryEClass = createEClass(MAP_CA2_TO_CB2_MAP_ENTRY);
		createEReference(mapCA2ToCB2MapEntryEClass, MAP_CA2_TO_CB2_MAP_ENTRY__KEY);
		createEReference(mapCA2ToCB2MapEntryEClass, MAP_CA2_TO_CB2_MAP_ENTRY__VALUE);

		cb3EClass = createEClass(CB3);
		createEReference(cb3EClass, CB3__MAPCA0TOCB0MAPENTRY);

		ca3EClass = createEClass(CA3);
		createEReference(ca3EClass, CA3__MAPCA0TOCB0MAPENTRY);

		mapCA3ToCB3MapEntryEClass = createEClass(MAP_CA3_TO_CB3_MAP_ENTRY);
		createEReference(mapCA3ToCB3MapEntryEClass, MAP_CA3_TO_CB3_MAP_ENTRY__KEY);
		createEReference(mapCA3ToCB3MapEntryEClass, MAP_CA3_TO_CB3_MAP_ENTRY__VALUE);

		ca4EClass = createEClass(CA4);
		createEReference(ca4EClass, CA4__MAPCA0TOCB0MAPENTRY);

		mapCA4ToCB4MapEntryEClass = createEClass(MAP_CA4_TO_CB4_MAP_ENTRY);
		createEReference(mapCA4ToCB4MapEntryEClass, MAP_CA4_TO_CB4_MAP_ENTRY__KEY);
		createEReference(mapCA4ToCB4MapEntryEClass, MAP_CA4_TO_CB4_MAP_ENTRY__VALUE);

		cb4EClass = createEClass(CB4);
		createEReference(cb4EClass, CB4__MAPCA0TOCB0MAPENTRY);

		ca5EClass = createEClass(CA5);
		createEReference(ca5EClass, CA5__MAPCA0TOCB0MAPENTRY);

		cb5EClass = createEClass(CB5);
		createEReference(cb5EClass, CB5__MAPCA0TOCB0MAPENTRY);

		mapCA5ToCB5MapEntryEClass = createEClass(MAP_CA5_TO_CB5_MAP_ENTRY);
		createEReference(mapCA5ToCB5MapEntryEClass, MAP_CA5_TO_CB5_MAP_ENTRY__KEY);
		createEReference(mapCA5ToCB5MapEntryEClass, MAP_CA5_TO_CB5_MAP_ENTRY__VALUE);

		mapCA6ToCB6MapEntryEClass = createEClass(MAP_CA6_TO_CB6_MAP_ENTRY);
		createEReference(mapCA6ToCB6MapEntryEClass, MAP_CA6_TO_CB6_MAP_ENTRY__KEY);
		createEReference(mapCA6ToCB6MapEntryEClass, MAP_CA6_TO_CB6_MAP_ENTRY__VALUE);

		ca6EClass = createEClass(CA6);

		cb6EClass = createEClass(CB6);

		ca7EClass = createEClass(CA7);

		mapCA7ToCB7MapEntryEClass = createEClass(MAP_CA7_TO_CB7_MAP_ENTRY);
		createEReference(mapCA7ToCB7MapEntryEClass, MAP_CA7_TO_CB7_MAP_ENTRY__KEY);
		createEReference(mapCA7ToCB7MapEntryEClass, MAP_CA7_TO_CB7_MAP_ENTRY__VALUE);

		cb7EClass = createEClass(CB7);

		ca8EClass = createEClass(CA8);

		mapCA8ToCB8MapEntryEClass = createEClass(MAP_CA8_TO_CB8_MAP_ENTRY);
		createEReference(mapCA8ToCB8MapEntryEClass, MAP_CA8_TO_CB8_MAP_ENTRY__KEY);
		createEReference(mapCA8ToCB8MapEntryEClass, MAP_CA8_TO_CB8_MAP_ENTRY__VALUE);

		cb8EClass = createEClass(CB8);

		mapCA9ToCB9MapEntryEClass = createEClass(MAP_CA9_TO_CB9_MAP_ENTRY);
		createEReference(mapCA9ToCB9MapEntryEClass, MAP_CA9_TO_CB9_MAP_ENTRY__KEY);
		createEReference(mapCA9ToCB9MapEntryEClass, MAP_CA9_TO_CB9_MAP_ENTRY__VALUE);

		cb9EClass = createEClass(CB9);

		ca9EClass = createEClass(CA9);
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
		initEClass(mapCA0ToCB0MapEntryEClass, Entry.class, "MapCA0ToCB0MapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMapCA0ToCB0MapEntry_Key(), this.getCA0(), this.getCA0_Mapca0tocb0mapentry(), "key", null, 0, 1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapCA0ToCB0MapEntry_Value(), this.getCB0(), this.getCB0_Mapca0tocb0mapentry(), "value", null, 0, 1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ca0EClass, CA0.class, "CA0", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCA0_Mapca0tocb0mapentry(), this.getMapCA0ToCB0MapEntry(), this.getMapCA0ToCB0MapEntry_Key(), "mapca0tocb0mapentry", null, 0, 1, CA0.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cb0EClass, CB0.class, "CB0", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCB0_Mapca0tocb0mapentry(), this.getMapCA0ToCB0MapEntry(), this.getMapCA0ToCB0MapEntry_Value(), "mapca0tocb0mapentry", null, 0, 1, CB0.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mapCA1ToCB1MapEntryEClass, Entry.class, "MapCA1ToCB1MapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMapCA1ToCB1MapEntry_Key(), this.getCA1(), this.getCA1_Mapca0tocb0mapentry(), "key", null, 0, -1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapCA1ToCB1MapEntry_Value(), this.getCB1(), this.getCB1_Mapca0tocb0mapentry(), "value", null, 0, -1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cb1EClass, CB1.class, "CB1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCB1_Mapca0tocb0mapentry(), this.getMapCA1ToCB1MapEntry(), this.getMapCA1ToCB1MapEntry_Value(), "mapca0tocb0mapentry", null, 0, 1, CB1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ca1EClass, CA1.class, "CA1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCA1_Mapca0tocb0mapentry(), this.getMapCA1ToCB1MapEntry(), this.getMapCA1ToCB1MapEntry_Key(), "mapca0tocb0mapentry", null, 0, 1, CA1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ca2EClass, CA2.class, "CA2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCA2_Mapca0tocb0mapentry(), this.getMapCA2ToCB2MapEntry(), this.getMapCA2ToCB2MapEntry_Key(), "mapca0tocb0mapentry", null, 0, -1, CA2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cb2EClass, CB2.class, "CB2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCB2_Mapca0tocb0mapentry(), this.getMapCA2ToCB2MapEntry(), this.getMapCA2ToCB2MapEntry_Value(), "mapca0tocb0mapentry", null, 0, -1, CB2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mapCA2ToCB2MapEntryEClass, Entry.class, "MapCA2ToCB2MapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMapCA2ToCB2MapEntry_Key(), this.getCA2(), this.getCA2_Mapca0tocb0mapentry(), "key", null, 0, 1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapCA2ToCB2MapEntry_Value(), this.getCB2(), this.getCB2_Mapca0tocb0mapentry(), "value", null, 0, 1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cb3EClass, CB3.class, "CB3", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCB3_Mapca0tocb0mapentry(), this.getMapCA3ToCB3MapEntry(), this.getMapCA3ToCB3MapEntry_Value(), "mapca0tocb0mapentry", null, 0, -1, CB3.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ca3EClass, CA3.class, "CA3", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCA3_Mapca0tocb0mapentry(), this.getMapCA3ToCB3MapEntry(), this.getMapCA3ToCB3MapEntry_Key(), "mapca0tocb0mapentry", null, 0, -1, CA3.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mapCA3ToCB3MapEntryEClass, Entry.class, "MapCA3ToCB3MapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMapCA3ToCB3MapEntry_Key(), this.getCA3(), this.getCA3_Mapca0tocb0mapentry(), "key", null, 0, -1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapCA3ToCB3MapEntry_Value(), this.getCB3(), this.getCB3_Mapca0tocb0mapentry(), "value", null, 0, -1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ca4EClass, CA4.class, "CA4", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCA4_Mapca0tocb0mapentry(), this.getMapCA4ToCB4MapEntry(), this.getMapCA4ToCB4MapEntry_Key(), "mapca0tocb0mapentry", null, 0, 1, CA4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mapCA4ToCB4MapEntryEClass, Entry.class, "MapCA4ToCB4MapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMapCA4ToCB4MapEntry_Key(), this.getCA4(), this.getCA4_Mapca0tocb0mapentry(), "key", null, 0, 1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapCA4ToCB4MapEntry_Value(), this.getCB4(), this.getCB4_Mapca0tocb0mapentry(), "value", null, 0, 1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cb4EClass, CB4.class, "CB4", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCB4_Mapca0tocb0mapentry(), this.getMapCA4ToCB4MapEntry(), this.getMapCA4ToCB4MapEntry_Value(), "mapca0tocb0mapentry", null, 0, 1, CB4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ca5EClass, CA5.class, "CA5", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCA5_Mapca0tocb0mapentry(), this.getMapCA5ToCB5MapEntry(), this.getMapCA5ToCB5MapEntry_Key(), "mapca0tocb0mapentry", null, 0, 1, CA5.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cb5EClass, CB5.class, "CB5", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCB5_Mapca0tocb0mapentry(), this.getMapCA5ToCB5MapEntry(), this.getMapCA5ToCB5MapEntry_Value(), "mapca0tocb0mapentry", null, 0, 1, CB5.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mapCA5ToCB5MapEntryEClass, Entry.class, "MapCA5ToCB5MapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMapCA5ToCB5MapEntry_Key(), this.getCA5(), this.getCA5_Mapca0tocb0mapentry(), "key", null, 0, -1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapCA5ToCB5MapEntry_Value(), this.getCB5(), this.getCB5_Mapca0tocb0mapentry(), "value", null, 0, -1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mapCA6ToCB6MapEntryEClass, Entry.class, "MapCA6ToCB6MapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMapCA6ToCB6MapEntry_Key(), this.getCA6(), null, "key", null, 0, 1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapCA6ToCB6MapEntry_Value(), this.getCB6(), null, "value", null, 0, 1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ca6EClass, CA6.class, "CA6", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cb6EClass, CB6.class, "CB6", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ca7EClass, CA7.class, "CA7", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mapCA7ToCB7MapEntryEClass, Entry.class, "MapCA7ToCB7MapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMapCA7ToCB7MapEntry_Key(), this.getCA7(), null, "key", null, 0, -1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapCA7ToCB7MapEntry_Value(), this.getCB7(), null, "value", null, 0, -1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cb7EClass, CB7.class, "CB7", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ca8EClass, CA8.class, "CA8", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mapCA8ToCB8MapEntryEClass, Entry.class, "MapCA8ToCB8MapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMapCA8ToCB8MapEntry_Key(), this.getCA8(), null, "key", null, 0, 1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapCA8ToCB8MapEntry_Value(), this.getCB8(), null, "value", null, 0, 1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cb8EClass, CB8.class, "CB8", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mapCA9ToCB9MapEntryEClass, Entry.class, "MapCA9ToCB9MapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMapCA9ToCB9MapEntry_Key(), this.getCA9(), null, "key", null, 0, -1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapCA9ToCB9MapEntry_Value(), this.getCB9(), null, "value", null, 0, -1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cb9EClass, CB9.class, "CB9", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ca9EClass, CA9.class, "CA9", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}
}
