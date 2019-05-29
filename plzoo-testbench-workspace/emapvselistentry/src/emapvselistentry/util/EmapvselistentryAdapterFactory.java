
package emapvselistentry.util;

import emapvselistentry.*;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;


public class EmapvselistentryAdapterFactory extends AdapterFactoryImpl {
	
	protected static EmapvselistentryPackage modelPackage;

	
	public EmapvselistentryAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = EmapvselistentryPackage.eINSTANCE;
		}
	}

	
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	
	protected EmapvselistentrySwitch<Adapter> modelSwitch =
		new EmapvselistentrySwitch<Adapter>() {
			@Override
			public Adapter caseNewEClass1(NewEClass1 object) {
				return createNewEClass1Adapter();
			}
			@Override
			public Adapter caseNewEClass2(Map.Entry<Integer, Boolean> object) {
				return createNewEClass2Adapter();
			}
			@Override
			public Adapter caseNewEClass3(Map.Entry<Integer, Boolean> object) {
				return createNewEClass3Adapter();
			}
			@Override
			public Adapter caseNewEClass4(Map.Entry<Integer, Boolean> object) {
				return createNewEClass4Adapter();
			}
			@Override
			public Adapter caseNewEClass5(Map.Entry<Integer, Boolean> object) {
				return createNewEClass5Adapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	
	public Adapter createNewEClass1Adapter() {
		return null;
	}

	
	public Adapter createNewEClass2Adapter() {
		return null;
	}

	
	public Adapter createNewEClass3Adapter() {
		return null;
	}

	
	public Adapter createNewEClass4Adapter() {
		return null;
	}

	
	public Adapter createNewEClass5Adapter() {
		return null;
	}

	
	public Adapter createEObjectAdapter() {
		return null;
	}

} //EmapvselistentryAdapterFactory
