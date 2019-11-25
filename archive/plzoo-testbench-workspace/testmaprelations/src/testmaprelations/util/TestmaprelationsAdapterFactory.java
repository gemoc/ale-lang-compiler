
package testmaprelations.util;
import java.util.Map;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import testmaprelations.*;

public class TestmaprelationsAdapterFactory extends AdapterFactoryImpl {
	
	protected static TestmaprelationsPackage modelPackage;
	
	public TestmaprelationsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = TestmaprelationsPackage.eINSTANCE;
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
	
	protected TestmaprelationsSwitch<Adapter> modelSwitch =
		new TestmaprelationsSwitch<Adapter>() {
			@Override
			public Adapter caseMapCA0ToCB0MapEntry(Map.Entry<CA0, CB0> object) {
				return createMapCA0ToCB0MapEntryAdapter();
			}
			@Override
			public Adapter caseCA0(CA0 object) {
				return createCA0Adapter();
			}
			@Override
			public Adapter caseCB0(CB0 object) {
				return createCB0Adapter();
			}
			@Override
			public Adapter caseMapCA1ToCB1MapEntry(Map.Entry<EList<CA1>, EList<CB1>> object) {
				return createMapCA1ToCB1MapEntryAdapter();
			}
			@Override
			public Adapter caseCB1(CB1 object) {
				return createCB1Adapter();
			}
			@Override
			public Adapter caseCA1(CA1 object) {
				return createCA1Adapter();
			}
			@Override
			public Adapter caseCA2(CA2 object) {
				return createCA2Adapter();
			}
			@Override
			public Adapter caseCB2(CB2 object) {
				return createCB2Adapter();
			}
			@Override
			public Adapter caseMapCA2ToCB2MapEntry(Map.Entry<CA2, CB2> object) {
				return createMapCA2ToCB2MapEntryAdapter();
			}
			@Override
			public Adapter caseCB3(CB3 object) {
				return createCB3Adapter();
			}
			@Override
			public Adapter caseCA3(CA3 object) {
				return createCA3Adapter();
			}
			@Override
			public Adapter caseMapCA3ToCB3MapEntry(Map.Entry<EList<CA3>, EList<CB3>> object) {
				return createMapCA3ToCB3MapEntryAdapter();
			}
			@Override
			public Adapter caseCA4(CA4 object) {
				return createCA4Adapter();
			}
			@Override
			public Adapter caseMapCA4ToCB4MapEntry(Map.Entry<CA4, CB4> object) {
				return createMapCA4ToCB4MapEntryAdapter();
			}
			@Override
			public Adapter caseCB4(CB4 object) {
				return createCB4Adapter();
			}
			@Override
			public Adapter caseCA5(CA5 object) {
				return createCA5Adapter();
			}
			@Override
			public Adapter caseCB5(CB5 object) {
				return createCB5Adapter();
			}
			@Override
			public Adapter caseMapCA5ToCB5MapEntry(Map.Entry<EList<CA5>, EList<CB5>> object) {
				return createMapCA5ToCB5MapEntryAdapter();
			}
			@Override
			public Adapter caseMapCA6ToCB6MapEntry(Map.Entry<CA6, CB6> object) {
				return createMapCA6ToCB6MapEntryAdapter();
			}
			@Override
			public Adapter caseCA6(CA6 object) {
				return createCA6Adapter();
			}
			@Override
			public Adapter caseCB6(CB6 object) {
				return createCB6Adapter();
			}
			@Override
			public Adapter caseCA7(CA7 object) {
				return createCA7Adapter();
			}
			@Override
			public Adapter caseMapCA7ToCB7MapEntry(Map.Entry<EList<CA7>, EList<CB7>> object) {
				return createMapCA7ToCB7MapEntryAdapter();
			}
			@Override
			public Adapter caseCB7(CB7 object) {
				return createCB7Adapter();
			}
			@Override
			public Adapter caseCA8(CA8 object) {
				return createCA8Adapter();
			}
			@Override
			public Adapter caseMapCA8ToCB8MapEntry(Map.Entry<CA8, CB8> object) {
				return createMapCA8ToCB8MapEntryAdapter();
			}
			@Override
			public Adapter caseCB8(CB8 object) {
				return createCB8Adapter();
			}
			@Override
			public Adapter caseMapCA9ToCB9MapEntry(Map.Entry<EList<CA9>, EList<CB9>> object) {
				return createMapCA9ToCB9MapEntryAdapter();
			}
			@Override
			public Adapter caseCB9(CB9 object) {
				return createCB9Adapter();
			}
			@Override
			public Adapter caseCA9(CA9 object) {
				return createCA9Adapter();
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

	
	public Adapter createMapCA0ToCB0MapEntryAdapter() {
		return null;
	}
	
	public Adapter createCA0Adapter() {
		return null;
	}
	
	public Adapter createCB0Adapter() {
		return null;
	}
	
	public Adapter createMapCA1ToCB1MapEntryAdapter() {
		return null;
	}
	
	public Adapter createCB1Adapter() {
		return null;
	}
	
	public Adapter createCA1Adapter() {
		return null;
	}
	
	public Adapter createCA2Adapter() {
		return null;
	}
	
	public Adapter createCB2Adapter() {
		return null;
	}
	
	public Adapter createMapCA2ToCB2MapEntryAdapter() {
		return null;
	}
	
	public Adapter createCB3Adapter() {
		return null;
	}
	
	public Adapter createCA3Adapter() {
		return null;
	}
	
	public Adapter createMapCA3ToCB3MapEntryAdapter() {
		return null;
	}
	
	public Adapter createCA4Adapter() {
		return null;
	}
	
	public Adapter createMapCA4ToCB4MapEntryAdapter() {
		return null;
	}
	
	public Adapter createCB4Adapter() {
		return null;
	}
	
	public Adapter createCA5Adapter() {
		return null;
	}
	
	public Adapter createCB5Adapter() {
		return null;
	}
	
	public Adapter createMapCA5ToCB5MapEntryAdapter() {
		return null;
	}
	
	public Adapter createMapCA6ToCB6MapEntryAdapter() {
		return null;
	}
	
	public Adapter createCA6Adapter() {
		return null;
	}
	
	public Adapter createCB6Adapter() {
		return null;
	}
	
	public Adapter createCA7Adapter() {
		return null;
	}
	
	public Adapter createMapCA7ToCB7MapEntryAdapter() {
		return null;
	}
	
	public Adapter createCB7Adapter() {
		return null;
	}
	
	public Adapter createCA8Adapter() {
		return null;
	}
	
	public Adapter createMapCA8ToCB8MapEntryAdapter() {
		return null;
	}
	
	public Adapter createCB8Adapter() {
		return null;
	}
	
	public Adapter createMapCA9ToCB9MapEntryAdapter() {
		return null;
	}
	
	public Adapter createCB9Adapter() {
		return null;
	}
	
	public Adapter createCA9Adapter() {
		return null;
	}
	
	public Adapter createEObjectAdapter() {
		return null;
	}
} //TestmaprelationsAdapterFactory
