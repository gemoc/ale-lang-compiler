package emapvselistentry.visitor.emapvselistentry.impl;

import emapvselistentry.visitor.emapvselistentry.EmapvselistentryFactory;
import emapvselistentry.visitor.emapvselistentry.EmapvselistentryPackage;
import emapvselistentry.visitor.emapvselistentry.NewEClass1;
import java.lang.Boolean;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Override;
import java.util.Map;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

public class EmapvselistentryFactoryImpl extends EFactoryImpl implements EmapvselistentryFactory {
	public EmapvselistentryFactoryImpl() {
		super();
	}

	public static EmapvselistentryFactory init() {
		try {
			EmapvselistentryFactory theEmapvselistentryFactory = (EmapvselistentryFactory) EPackage.Registry.INSTANCE.getEFactory(EmapvselistentryPackage.eNS_URI);
			if (theEmapvselistentryFactory != null) {
				return theEmapvselistentryFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EmapvselistentryFactoryImpl();
	}

	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EmapvselistentryPackage.NEW_ECLASS1 :
				return createNewEClass1();
			case EmapvselistentryPackage.NEW_ECLASS2 :
				return (EObject) createNewEClass2();
			case EmapvselistentryPackage.NEW_ECLASS3 :
				return (EObject) createNewEClass3();
			case EmapvselistentryPackage.NEW_ECLASS4 :
				return (EObject) createNewEClass4();
			case EmapvselistentryPackage.NEW_ECLASS5 :
				return (EObject) createNewEClass5();
			default :
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	public NewEClass1 createNewEClass1() {
		NewEClass1Impl newEClass1 = new NewEClass1Impl();
		return newEClass1;
	}

	public Map.Entry<Integer, Boolean> createNewEClass2() {
		NewEClass2Impl newEClass2 = new NewEClass2Impl();
		return newEClass2;
	}

	public Map.Entry<Integer, Boolean> createNewEClass3() {
		NewEClass3Impl newEClass3 = new NewEClass3Impl();
		return newEClass3;
	}

	public Map.Entry<Integer, Boolean> createNewEClass4() {
		NewEClass4Impl newEClass4 = new NewEClass4Impl();
		return newEClass4;
	}

	public Map.Entry<Integer, Boolean> createNewEClass5() {
		NewEClass5Impl newEClass5 = new NewEClass5Impl();
		return newEClass5;
	}

	public EmapvselistentryPackage getEmapvselistentryPackage() {
		return (EmapvselistentryPackage) getEPackage();
	}

	@Deprecated
	public static EmapvselistentryPackage getPackage() {
		return EmapvselistentryPackage.eINSTANCE;
	}
}
