package empty.interpreter.empty.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import empty.interpreter.empty.EmptyFactory;
import empty.interpreter.empty.EmptyPackage;
import empty.interpreter.empty.Existing2;

public class EmptyFactoryImpl extends EFactoryImpl implements EmptyFactory {
	public EmptyFactoryImpl() {
		super();
	}

	public static EmptyFactory init() {
		try {
			EmptyFactory theEmptyFactory = (EmptyFactory) EPackage.Registry.INSTANCE.getEFactory(EmptyPackage.eNS_URI);
			if (theEmptyFactory != null) {
				return theEmptyFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EmptyFactoryImpl();
	}

	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EmptyPackage.EXISTING :
				return createExisting();
			default :
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	public Existing2 createExisting() {
		ExistingImpl2 existing = new ExistingImpl2();
		return existing;
	}

	public EmptyPackage getEmptyPackage() {
		return (EmptyPackage) getEPackage();
	}

	@Deprecated
	public static EmptyPackage getPackage() {
		return EmptyPackage.eINSTANCE;
	}
}
