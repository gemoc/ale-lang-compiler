package declarationorder.interpreter.declarationorder.impl;

import declarationorder.interpreter.declarationorder.Child;
import declarationorder.interpreter.declarationorder.DeclarationorderFactory;
import declarationorder.interpreter.declarationorder.DeclarationorderPackage;
import declarationorder.interpreter.declarationorder.S;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

public class DeclarationorderFactoryImpl extends EFactoryImpl implements DeclarationorderFactory {
	public DeclarationorderFactoryImpl() {
		super();
	}

	public static DeclarationorderFactory init() {
		try {
			DeclarationorderFactory theDeclarationorderFactory = (DeclarationorderFactory) EPackage.Registry.INSTANCE.getEFactory(DeclarationorderPackage.eNS_URI);
			if (theDeclarationorderFactory != null) {
				return theDeclarationorderFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DeclarationorderFactoryImpl();
	}

	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DeclarationorderPackage.CHILD :
				return createChild();
			case DeclarationorderPackage.S :
				return createS();
			default :
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	public Child createChild() {
		ChildImpl child = new ChildImpl();
		return child;
	}

	public S createS() {
		SImpl s = new SImpl();
		return s;
	}

	public DeclarationorderPackage getDeclarationorderPackage() {
		return (DeclarationorderPackage) getEPackage();
	}

	@Deprecated
	public static DeclarationorderPackage getPackage() {
		return DeclarationorderPackage.eINSTANCE;
	}
}
