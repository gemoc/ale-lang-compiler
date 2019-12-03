package testaccessors.visitor.testaccessors.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import testaccessors.visitor.testaccessors.EAcc;
import testaccessors.visitor.testaccessors.TestaccessorsFactory;
import testaccessors.visitor.testaccessors.TestaccessorsPackage;

public class TestaccessorsPackageImpl extends EPackageImpl implements TestaccessorsPackage {
	private static boolean isInited = false;

	private EClass eAccEClass = null;

	private boolean isCreated = false;

	private boolean isInitialized = false;

	private TestaccessorsPackageImpl() {
		super(eNS_URI, TestaccessorsFactory.eINSTANCE);
	}

	public static TestaccessorsPackage init() {
		if (isInited)
			return (TestaccessorsPackage) EPackage.Registry.INSTANCE.getEPackage(TestaccessorsPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredTestaccessorsPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		TestaccessorsPackageImpl theTestaccessorsPackage = registeredTestaccessorsPackage instanceof TestaccessorsPackageImpl
				? (TestaccessorsPackageImpl) registeredTestaccessorsPackage
				: new TestaccessorsPackageImpl();

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

	public EClass getEAcc() {
		return eAccEClass;
	}

	public EAttribute getEAcc_B() {
		return (EAttribute) eAccEClass.getEStructuralFeatures().get(0);
	}

	public EAttribute getEAcc_I() {
		return (EAttribute) eAccEClass.getEStructuralFeatures().get(1);
	}

	public EAttribute getEAcc_Bs() {
		return (EAttribute) eAccEClass.getEStructuralFeatures().get(2);
	}

	public EAttribute getEAcc_Is() {
		return (EAttribute) eAccEClass.getEStructuralFeatures().get(3);
	}

	public TestaccessorsFactory getTestaccessorsFactory() {
		return (TestaccessorsFactory) getEFactoryInstance();
	}

	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		eAccEClass = createEClass(EACC);
		createEAttribute(eAccEClass, EACC__B);
		createEAttribute(eAccEClass, EACC__I);
		createEAttribute(eAccEClass, EACC__BS);
		createEAttribute(eAccEClass, EACC__IS);
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
		initEClass(eAccEClass, EAcc.class, "EAcc", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEAcc_B(), ecorePackage.getEBoolean(), "b", null, 0, 1, EAcc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAcc_I(), ecorePackage.getEInt(), "i", null, 0, 1, EAcc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAcc_Bs(), ecorePackage.getEBoolean(), "bs", null, 0, -1, EAcc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAcc_Is(), ecorePackage.getEInt(), "is", null, 0, -1, EAcc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}
}
