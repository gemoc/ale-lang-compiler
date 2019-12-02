package autocast.visitor.autocast.impl;

import autocast.visitor.autocast.AutocastFactory;
import autocast.visitor.autocast.AutocastPackage;
import autocast.visitor.autocast.ConceptA;
import autocast.visitor.autocast.ConceptB;
import autocast.visitor.autocast.ConceptC;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

public class AutocastPackageImpl extends EPackageImpl implements AutocastPackage {
	private static boolean isInited = false;

	private EClass conceptAEClass = null;

	private EClass conceptBEClass = null;

	private EClass conceptCEClass = null;

	private boolean isCreated = false;

	private boolean isInitialized = false;

	private AutocastPackageImpl() {
		super(eNS_URI, AutocastFactory.eINSTANCE);
	}

	public static AutocastPackage init() {
		if (isInited)
			return (AutocastPackage) EPackage.Registry.INSTANCE.getEPackage(AutocastPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredAutocastPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		AutocastPackageImpl theAutocastPackage = registeredAutocastPackage instanceof AutocastPackageImpl
				? (AutocastPackageImpl) registeredAutocastPackage
				: new AutocastPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theAutocastPackage.createPackageContents();

		// Initialize created meta-data
		theAutocastPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAutocastPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AutocastPackage.eNS_URI, theAutocastPackage);
		return theAutocastPackage;
	}

	public EClass getConceptA() {
		return conceptAEClass;
	}

	public EClass getConceptB() {
		return conceptBEClass;
	}

	public EAttribute getConceptB_Name() {
		return (EAttribute) conceptBEClass.getEStructuralFeatures().get(0);
	}

	public EClass getConceptC() {
		return conceptCEClass;
	}

	public EReference getConceptC_Ax() {
		return (EReference) conceptCEClass.getEStructuralFeatures().get(0);
	}

	public AutocastFactory getAutocastFactory() {
		return (AutocastFactory) getEFactoryInstance();
	}

	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		conceptAEClass = createEClass(CONCEPT_A);

		conceptBEClass = createEClass(CONCEPT_B);
		createEAttribute(conceptBEClass, CONCEPT_B__NAME);

		conceptCEClass = createEClass(CONCEPT_C);
		createEReference(conceptCEClass, CONCEPT_C__AX);
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
		conceptBEClass.getESuperTypes().add(this.getConceptA());

		// Initialize classes, features, and operations; add parameters
		initEClass(conceptAEClass, ConceptA.class, "ConceptA", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(conceptBEClass, ConceptB.class, "ConceptB", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConceptB_Name(), ecorePackage.getEString(), "name", null, 0, 1, ConceptB.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conceptCEClass, ConceptC.class, "ConceptC", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptC_Ax(), this.getConceptA(), null, "ax", null, 0, -1, ConceptC.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}
}
