/**
 */
package testmaprelations.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import testmaprelations.TestmaprelationsFactory;
import testmaprelations.TestmaprelationsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TestmaprelationsPackageImpl extends EPackageImpl implements TestmaprelationsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mapCA0ToCB0MapEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ca0EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cb0EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mapCA1ToCB1MapEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cb1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ca1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ca2EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cb2EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mapCA2ToCB2MapEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cb3EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ca3EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mapCA3ToCB3MapEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ca4EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mapCA4ToCB4MapEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cb4EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ca5EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cb5EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mapCA5ToCB5MapEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mapCA6ToCB6MapEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ca6EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cb6EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ca7EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mapCA7ToCB7MapEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cb7EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ca8EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mapCA8ToCB8MapEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cb8EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mapCA9ToCB9MapEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cb9EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ca9EClass = null;

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
	 * @see testmaprelations.TestmaprelationsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TestmaprelationsPackageImpl() {
		super(eNS_URI, TestmaprelationsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TestmaprelationsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TestmaprelationsPackage init() {
		if (isInited) return (TestmaprelationsPackage)EPackage.Registry.INSTANCE.getEPackage(TestmaprelationsPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredTestmaprelationsPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		TestmaprelationsPackageImpl theTestmaprelationsPackage = registeredTestmaprelationsPackage instanceof TestmaprelationsPackageImpl ? (TestmaprelationsPackageImpl)registeredTestmaprelationsPackage : new TestmaprelationsPackageImpl();

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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMapCA0ToCB0MapEntry() {
		return mapCA0ToCB0MapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapCA0ToCB0MapEntry_Key() {
		return (EReference)mapCA0ToCB0MapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapCA0ToCB0MapEntry_Value() {
		return (EReference)mapCA0ToCB0MapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCA0() {
		return ca0EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCA0_Mapca0tocb0mapentry() {
		return (EReference)ca0EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCB0() {
		return cb0EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCB0_Mapca0tocb0mapentry() {
		return (EReference)cb0EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMapCA1ToCB1MapEntry() {
		return mapCA1ToCB1MapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapCA1ToCB1MapEntry_Key() {
		return (EReference)mapCA1ToCB1MapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapCA1ToCB1MapEntry_Value() {
		return (EReference)mapCA1ToCB1MapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCB1() {
		return cb1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCB1_Mapca0tocb0mapentry() {
		return (EReference)cb1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCA1() {
		return ca1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCA1_Mapca0tocb0mapentry() {
		return (EReference)ca1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCA2() {
		return ca2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCA2_Mapca0tocb0mapentry() {
		return (EReference)ca2EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCB2() {
		return cb2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCB2_Mapca0tocb0mapentry() {
		return (EReference)cb2EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMapCA2ToCB2MapEntry() {
		return mapCA2ToCB2MapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapCA2ToCB2MapEntry_Key() {
		return (EReference)mapCA2ToCB2MapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapCA2ToCB2MapEntry_Value() {
		return (EReference)mapCA2ToCB2MapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCB3() {
		return cb3EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCB3_Mapca0tocb0mapentry() {
		return (EReference)cb3EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCA3() {
		return ca3EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCA3_Mapca0tocb0mapentry() {
		return (EReference)ca3EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMapCA3ToCB3MapEntry() {
		return mapCA3ToCB3MapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapCA3ToCB3MapEntry_Key() {
		return (EReference)mapCA3ToCB3MapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapCA3ToCB3MapEntry_Value() {
		return (EReference)mapCA3ToCB3MapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCA4() {
		return ca4EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCA4_Mapca0tocb0mapentry() {
		return (EReference)ca4EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMapCA4ToCB4MapEntry() {
		return mapCA4ToCB4MapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapCA4ToCB4MapEntry_Key() {
		return (EReference)mapCA4ToCB4MapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapCA4ToCB4MapEntry_Value() {
		return (EReference)mapCA4ToCB4MapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCB4() {
		return cb4EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCB4_Mapca0tocb0mapentry() {
		return (EReference)cb4EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCA5() {
		return ca5EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCA5_Mapca0tocb0mapentry() {
		return (EReference)ca5EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCB5() {
		return cb5EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCB5_Mapca0tocb0mapentry() {
		return (EReference)cb5EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMapCA5ToCB5MapEntry() {
		return mapCA5ToCB5MapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapCA5ToCB5MapEntry_Key() {
		return (EReference)mapCA5ToCB5MapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapCA5ToCB5MapEntry_Value() {
		return (EReference)mapCA5ToCB5MapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMapCA6ToCB6MapEntry() {
		return mapCA6ToCB6MapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapCA6ToCB6MapEntry_Key() {
		return (EReference)mapCA6ToCB6MapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapCA6ToCB6MapEntry_Value() {
		return (EReference)mapCA6ToCB6MapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCA6() {
		return ca6EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCB6() {
		return cb6EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCA7() {
		return ca7EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMapCA7ToCB7MapEntry() {
		return mapCA7ToCB7MapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapCA7ToCB7MapEntry_Key() {
		return (EReference)mapCA7ToCB7MapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapCA7ToCB7MapEntry_Value() {
		return (EReference)mapCA7ToCB7MapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCB7() {
		return cb7EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCA8() {
		return ca8EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMapCA8ToCB8MapEntry() {
		return mapCA8ToCB8MapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapCA8ToCB8MapEntry_Key() {
		return (EReference)mapCA8ToCB8MapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapCA8ToCB8MapEntry_Value() {
		return (EReference)mapCA8ToCB8MapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCB8() {
		return cb8EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMapCA9ToCB9MapEntry() {
		return mapCA9ToCB9MapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapCA9ToCB9MapEntry_Key() {
		return (EReference)mapCA9ToCB9MapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapCA9ToCB9MapEntry_Value() {
		return (EReference)mapCA9ToCB9MapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCB9() {
		return cb9EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCA9() {
		return ca9EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestmaprelationsFactory getTestmaprelationsFactory() {
		return (TestmaprelationsFactory)getEFactoryInstance();
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
		initEClass(mapCA0ToCB0MapEntryEClass, Map.Entry.class, "MapCA0ToCB0MapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMapCA0ToCB0MapEntry_Key(), this.getCA0(), this.getCA0_Mapca0tocb0mapentry(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapCA0ToCB0MapEntry_Value(), this.getCB0(), this.getCB0_Mapca0tocb0mapentry(), "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ca0EClass, testmaprelations.CA0.class, "CA0", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCA0_Mapca0tocb0mapentry(), this.getMapCA0ToCB0MapEntry(), this.getMapCA0ToCB0MapEntry_Key(), "mapca0tocb0mapentry", null, 0, 1, testmaprelations.CA0.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cb0EClass, testmaprelations.CB0.class, "CB0", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCB0_Mapca0tocb0mapentry(), this.getMapCA0ToCB0MapEntry(), this.getMapCA0ToCB0MapEntry_Value(), "mapca0tocb0mapentry", null, 0, 1, testmaprelations.CB0.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mapCA1ToCB1MapEntryEClass, Map.Entry.class, "MapCA1ToCB1MapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMapCA1ToCB1MapEntry_Key(), this.getCA1(), this.getCA1_Mapca0tocb0mapentry(), "key", null, 0, -1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapCA1ToCB1MapEntry_Value(), this.getCB1(), this.getCB1_Mapca0tocb0mapentry(), "value", null, 0, -1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cb1EClass, testmaprelations.CB1.class, "CB1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCB1_Mapca0tocb0mapentry(), this.getMapCA1ToCB1MapEntry(), this.getMapCA1ToCB1MapEntry_Value(), "mapca0tocb0mapentry", null, 0, 1, testmaprelations.CB1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ca1EClass, testmaprelations.CA1.class, "CA1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCA1_Mapca0tocb0mapentry(), this.getMapCA1ToCB1MapEntry(), this.getMapCA1ToCB1MapEntry_Key(), "mapca0tocb0mapentry", null, 0, 1, testmaprelations.CA1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ca2EClass, testmaprelations.CA2.class, "CA2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCA2_Mapca0tocb0mapentry(), this.getMapCA2ToCB2MapEntry(), this.getMapCA2ToCB2MapEntry_Key(), "mapca0tocb0mapentry", null, 0, -1, testmaprelations.CA2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cb2EClass, testmaprelations.CB2.class, "CB2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCB2_Mapca0tocb0mapentry(), this.getMapCA2ToCB2MapEntry(), this.getMapCA2ToCB2MapEntry_Value(), "mapca0tocb0mapentry", null, 0, -1, testmaprelations.CB2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mapCA2ToCB2MapEntryEClass, Map.Entry.class, "MapCA2ToCB2MapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMapCA2ToCB2MapEntry_Key(), this.getCA2(), this.getCA2_Mapca0tocb0mapentry(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapCA2ToCB2MapEntry_Value(), this.getCB2(), this.getCB2_Mapca0tocb0mapentry(), "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cb3EClass, testmaprelations.CB3.class, "CB3", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCB3_Mapca0tocb0mapentry(), this.getMapCA3ToCB3MapEntry(), this.getMapCA3ToCB3MapEntry_Value(), "mapca0tocb0mapentry", null, 0, -1, testmaprelations.CB3.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ca3EClass, testmaprelations.CA3.class, "CA3", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCA3_Mapca0tocb0mapentry(), this.getMapCA3ToCB3MapEntry(), this.getMapCA3ToCB3MapEntry_Key(), "mapca0tocb0mapentry", null, 0, -1, testmaprelations.CA3.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mapCA3ToCB3MapEntryEClass, Map.Entry.class, "MapCA3ToCB3MapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMapCA3ToCB3MapEntry_Key(), this.getCA3(), this.getCA3_Mapca0tocb0mapentry(), "key", null, 0, -1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapCA3ToCB3MapEntry_Value(), this.getCB3(), this.getCB3_Mapca0tocb0mapentry(), "value", null, 0, -1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ca4EClass, testmaprelations.CA4.class, "CA4", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCA4_Mapca0tocb0mapentry(), this.getMapCA4ToCB4MapEntry(), this.getMapCA4ToCB4MapEntry_Key(), "mapca0tocb0mapentry", null, 0, 1, testmaprelations.CA4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mapCA4ToCB4MapEntryEClass, Map.Entry.class, "MapCA4ToCB4MapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMapCA4ToCB4MapEntry_Key(), this.getCA4(), this.getCA4_Mapca0tocb0mapentry(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapCA4ToCB4MapEntry_Value(), this.getCB4(), this.getCB4_Mapca0tocb0mapentry(), "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cb4EClass, testmaprelations.CB4.class, "CB4", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCB4_Mapca0tocb0mapentry(), this.getMapCA4ToCB4MapEntry(), this.getMapCA4ToCB4MapEntry_Value(), "mapca0tocb0mapentry", null, 0, 1, testmaprelations.CB4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ca5EClass, testmaprelations.CA5.class, "CA5", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCA5_Mapca0tocb0mapentry(), this.getMapCA5ToCB5MapEntry(), this.getMapCA5ToCB5MapEntry_Key(), "mapca0tocb0mapentry", null, 0, 1, testmaprelations.CA5.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cb5EClass, testmaprelations.CB5.class, "CB5", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCB5_Mapca0tocb0mapentry(), this.getMapCA5ToCB5MapEntry(), this.getMapCA5ToCB5MapEntry_Value(), "mapca0tocb0mapentry", null, 0, 1, testmaprelations.CB5.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mapCA5ToCB5MapEntryEClass, Map.Entry.class, "MapCA5ToCB5MapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMapCA5ToCB5MapEntry_Key(), this.getCA5(), this.getCA5_Mapca0tocb0mapentry(), "key", null, 0, -1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapCA5ToCB5MapEntry_Value(), this.getCB5(), this.getCB5_Mapca0tocb0mapentry(), "value", null, 0, -1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mapCA6ToCB6MapEntryEClass, Map.Entry.class, "MapCA6ToCB6MapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMapCA6ToCB6MapEntry_Key(), this.getCA6(), null, "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapCA6ToCB6MapEntry_Value(), this.getCB6(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ca6EClass, testmaprelations.CA6.class, "CA6", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cb6EClass, testmaprelations.CB6.class, "CB6", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ca7EClass, testmaprelations.CA7.class, "CA7", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mapCA7ToCB7MapEntryEClass, Map.Entry.class, "MapCA7ToCB7MapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMapCA7ToCB7MapEntry_Key(), this.getCA7(), null, "key", null, 0, -1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapCA7ToCB7MapEntry_Value(), this.getCB7(), null, "value", null, 0, -1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cb7EClass, testmaprelations.CB7.class, "CB7", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ca8EClass, testmaprelations.CA8.class, "CA8", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mapCA8ToCB8MapEntryEClass, Map.Entry.class, "MapCA8ToCB8MapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMapCA8ToCB8MapEntry_Key(), this.getCA8(), null, "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapCA8ToCB8MapEntry_Value(), this.getCB8(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cb8EClass, testmaprelations.CB8.class, "CB8", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mapCA9ToCB9MapEntryEClass, Map.Entry.class, "MapCA9ToCB9MapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMapCA9ToCB9MapEntry_Key(), this.getCA9(), null, "key", null, 0, -1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapCA9ToCB9MapEntry_Value(), this.getCB9(), null, "value", null, 0, -1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cb9EClass, testmaprelations.CB9.class, "CB9", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ca9EClass, testmaprelations.CA9.class, "CA9", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //TestmaprelationsPackageImpl
