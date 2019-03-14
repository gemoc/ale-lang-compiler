
package testenums.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import testenums.*;


public class TestenumsFactoryImpl extends EFactoryImpl implements TestenumsFactory {
	
	public static TestenumsFactory init() {
		try {
			TestenumsFactory theTestenumsFactory = (TestenumsFactory)EPackage.Registry.INSTANCE.getEFactory(TestenumsPackage.eNS_URI);
			if (theTestenumsFactory != null) {
				return theTestenumsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TestenumsFactoryImpl();
	}

	
	public TestenumsFactoryImpl() {
		super();
	}

	
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case TestenumsPackage.ROOT: return createRoot();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case TestenumsPackage.ENUM1:
				return createEnum1FromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case TestenumsPackage.ENUM1:
				return convertEnum1ToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	
	public Root createRoot() {
		RootImpl root = new RootImpl();
		return root;
	}

	
	public Enum1 createEnum1FromString(EDataType eDataType, String initialValue) {
		Enum1 result = Enum1.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	
	public String convertEnum1ToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	
	public TestenumsPackage getTestenumsPackage() {
		return (TestenumsPackage)getEPackage();
	}

	
	@Deprecated
	public static TestenumsPackage getPackage() {
		return TestenumsPackage.eINSTANCE;
	}

} //TestenumsFactoryImpl
