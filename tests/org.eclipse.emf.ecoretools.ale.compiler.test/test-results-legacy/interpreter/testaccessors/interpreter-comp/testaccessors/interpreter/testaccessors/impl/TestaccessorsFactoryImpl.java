package testaccessors.interpreter.testaccessors.impl;

import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import testaccessors.interpreter.testaccessors.EAcc;
import testaccessors.interpreter.testaccessors.TestaccessorsFactory;
import testaccessors.interpreter.testaccessors.TestaccessorsPackage;

public class TestaccessorsFactoryImpl extends EFactoryImpl implements TestaccessorsFactory {
	public TestaccessorsFactoryImpl() {
		super();
	}

	public static TestaccessorsFactory init() {
		try {
			TestaccessorsFactory theTestaccessorsFactory = (TestaccessorsFactory) EPackage.Registry.INSTANCE.getEFactory(TestaccessorsPackage.eNS_URI);
			if (theTestaccessorsFactory != null) {
				return theTestaccessorsFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TestaccessorsFactoryImpl();
	}

	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case TestaccessorsPackage.EACC :
				return createEAcc();
			default :
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	public EAcc createEAcc() {
		EAccImpl eAcc = new EAccImpl();
		return eAcc;
	}

	public TestaccessorsPackage getTestaccessorsPackage() {
		return (TestaccessorsPackage) getEPackage();
	}

	@Deprecated
	public static TestaccessorsPackage getPackage() {
		return TestaccessorsPackage.eINSTANCE;
	}
}
