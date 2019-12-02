package factorydeclorder.interpreter.factorydeclorder.impl;

import factorydeclorder.interpreter.factorydeclorder.A;
import factorydeclorder.interpreter.factorydeclorder.B;
import factorydeclorder.interpreter.factorydeclorder.C;
import factorydeclorder.interpreter.factorydeclorder.D;
import factorydeclorder.interpreter.factorydeclorder.FactorydeclorderFactory;
import factorydeclorder.interpreter.factorydeclorder.FactorydeclorderPackage;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

public class FactorydeclorderFactoryImpl extends EFactoryImpl implements FactorydeclorderFactory {
	public FactorydeclorderFactoryImpl() {
		super();
	}

	public static FactorydeclorderFactory init() {
		try {
			FactorydeclorderFactory theFactorydeclorderFactory = (FactorydeclorderFactory) EPackage.Registry.INSTANCE.getEFactory(FactorydeclorderPackage.eNS_URI);
			if (theFactorydeclorderFactory != null) {
				return theFactorydeclorderFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FactorydeclorderFactoryImpl();
	}

	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case FactorydeclorderPackage.C :
				return createC();
			case FactorydeclorderPackage.A :
				return createA();
			case FactorydeclorderPackage.B :
				return createB();
			case FactorydeclorderPackage.D :
				return createD();
			default :
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	public C createC() {
		CImpl c = new CImpl();
		return c;
	}

	public A createA() {
		AImpl a = new AImpl();
		return a;
	}

	public B createB() {
		BImpl b = new BImpl();
		return b;
	}

	public D createD() {
		DImpl d = new DImpl();
		return d;
	}

	public FactorydeclorderPackage getFactorydeclorderPackage() {
		return (FactorydeclorderPackage) getEPackage();
	}

	@Deprecated
	public static FactorydeclorderPackage getPackage() {
		return FactorydeclorderPackage.eINSTANCE;
	}
}
