package empty.interpreter.empty.impl;

import empty.interpreter.empty.EmptyFactory;
import empty.interpreter.empty.EmptyPackage;
import empty.interpreter.empty.Existing;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

public class EmptyPackageImpl extends EPackageImpl implements EmptyPackage {
	private static boolean isInited = false;

	private EClass existingEClass = null;

	private boolean isCreated = false;

	private boolean isInitialized = false;

	private EmptyPackageImpl() {
		super(eNS_URI, EmptyFactory.eINSTANCE);
	}

	public static EmptyPackage init() {
		if (isInited)
			return (EmptyPackage) EPackage.Registry.INSTANCE.getEPackage(EmptyPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredEmptyPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		EmptyPackageImpl theEmptyPackage = registeredEmptyPackage instanceof EmptyPackageImpl
				? (EmptyPackageImpl) registeredEmptyPackage
				: new EmptyPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theEmptyPackage.createPackageContents();

		// Initialize created meta-data
		theEmptyPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEmptyPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EmptyPackage.eNS_URI, theEmptyPackage);
		return theEmptyPackage;
	}

	public EClass getExisting() {
		return existingEClass;
	}

	public EmptyFactory getEmptyFactory() {
		return (EmptyFactory) getEFactoryInstance();
	}

	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		existingEClass = createEClass(EXISTING);
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
		initEClass(existingEClass, Existing.class, "Existing", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}
}
