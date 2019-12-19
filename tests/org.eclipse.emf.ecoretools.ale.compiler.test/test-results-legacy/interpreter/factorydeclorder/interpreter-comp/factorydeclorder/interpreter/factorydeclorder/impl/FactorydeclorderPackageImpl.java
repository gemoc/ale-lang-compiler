package factorydeclorder.interpreter.factorydeclorder.impl;

import factorydeclorder.interpreter.factorydeclorder.A;
import factorydeclorder.interpreter.factorydeclorder.B;
import factorydeclorder.interpreter.factorydeclorder.C;
import factorydeclorder.interpreter.factorydeclorder.D;
import factorydeclorder.interpreter.factorydeclorder.FactorydeclorderFactory;
import factorydeclorder.interpreter.factorydeclorder.FactorydeclorderPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

public class FactorydeclorderPackageImpl extends EPackageImpl implements FactorydeclorderPackage {
	private static boolean isInited = false;

	private EClass cEClass = null;

	private EClass aEClass = null;

	private EClass bEClass = null;

	private EClass dEClass = null;

	private boolean isCreated = false;

	private boolean isInitialized = false;

	private FactorydeclorderPackageImpl() {
		super(eNS_URI, FactorydeclorderFactory.eINSTANCE);
	}

	public static FactorydeclorderPackage init() {
		if (isInited)
			return (FactorydeclorderPackage) EPackage.Registry.INSTANCE.getEPackage(FactorydeclorderPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredFactorydeclorderPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		FactorydeclorderPackageImpl theFactorydeclorderPackage = registeredFactorydeclorderPackage instanceof FactorydeclorderPackageImpl
				? (FactorydeclorderPackageImpl) registeredFactorydeclorderPackage
				: new FactorydeclorderPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theFactorydeclorderPackage.createPackageContents();

		// Initialize created meta-data
		theFactorydeclorderPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFactorydeclorderPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FactorydeclorderPackage.eNS_URI, theFactorydeclorderPackage);
		return theFactorydeclorderPackage;
	}

	public EClass getC() {
		return cEClass;
	}

	public EAttribute getC_Fc() {
		return (EAttribute) cEClass.getEStructuralFeatures().get(0);
	}

	public EClass getA() {
		return aEClass;
	}

	public EAttribute getA_Fa() {
		return (EAttribute) aEClass.getEStructuralFeatures().get(0);
	}

	public EClass getB() {
		return bEClass;
	}

	public EAttribute getB_Fb() {
		return (EAttribute) bEClass.getEStructuralFeatures().get(0);
	}

	public EClass getD() {
		return dEClass;
	}

	public FactorydeclorderFactory getFactorydeclorderFactory() {
		return (FactorydeclorderFactory) getEFactoryInstance();
	}

	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		cEClass = createEClass(C);
		createEAttribute(cEClass, C__FC);

		aEClass = createEClass(A);
		createEAttribute(aEClass, A__FA);

		bEClass = createEClass(B);
		createEAttribute(bEClass, B__FB);

		dEClass = createEClass(D);
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
		cEClass.getESuperTypes().add(this.getB());
		cEClass.getESuperTypes().add(this.getA());
		aEClass.getESuperTypes().add(this.getD());
		aEClass.getESuperTypes().add(this.getB());

		// Initialize classes, features, and operations; add parameters
		initEClass(cEClass, C.class, "C", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getC_Fc(), ecorePackage.getEBoolean(), "fc", null, 0, 1, C.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(aEClass, A.class, "A", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getA_Fa(), ecorePackage.getEInt(), "fa", null, 0, 1, A.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bEClass, B.class, "B", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getB_Fb(), ecorePackage.getELong(), "fb", null, 0, 1, B.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dEClass, D.class, "D", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}
}
