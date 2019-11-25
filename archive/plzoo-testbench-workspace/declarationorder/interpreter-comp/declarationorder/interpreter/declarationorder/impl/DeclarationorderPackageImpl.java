package declarationorder.interpreter.declarationorder.impl;

import declarationorder.interpreter.declarationorder.Child;
import declarationorder.interpreter.declarationorder.DeclarationorderFactory;
import declarationorder.interpreter.declarationorder.DeclarationorderPackage;
import declarationorder.interpreter.declarationorder.S;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

public class DeclarationorderPackageImpl extends EPackageImpl implements DeclarationorderPackage {
	private static boolean isInited = false;

	private EClass childEClass = null;

	private EClass sEClass = null;

	private boolean isCreated = false;

	private boolean isInitialized = false;

	private DeclarationorderPackageImpl() {
		super(eNS_URI, DeclarationorderFactory.eINSTANCE);
	}

	public static DeclarationorderPackage init() {
		if (isInited)
			return (DeclarationorderPackage) EPackage.Registry.INSTANCE.getEPackage(DeclarationorderPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredDeclarationorderPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		DeclarationorderPackageImpl theDeclarationorderPackage = registeredDeclarationorderPackage instanceof DeclarationorderPackageImpl
				? (DeclarationorderPackageImpl) registeredDeclarationorderPackage
				: new DeclarationorderPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theDeclarationorderPackage.createPackageContents();

		// Initialize created meta-data
		theDeclarationorderPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDeclarationorderPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DeclarationorderPackage.eNS_URI, theDeclarationorderPackage);
		return theDeclarationorderPackage;
	}

	public EClass getChild() {
		return childEClass;
	}

	public EClass getS() {
		return sEClass;
	}

	public DeclarationorderFactory getDeclarationorderFactory() {
		return (DeclarationorderFactory) getEFactoryInstance();
	}

	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		childEClass = createEClass(CHILD);

		sEClass = createEClass(S);
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
		childEClass.getESuperTypes().add(this.getS());

		// Initialize classes, features, and operations; add parameters
		initEClass(childEClass, Child.class, "Child", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sEClass, S.class, "S", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}
}
