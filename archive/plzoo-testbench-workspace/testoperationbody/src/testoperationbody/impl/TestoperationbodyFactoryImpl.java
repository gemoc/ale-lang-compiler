
package testoperationbody.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import testoperationbody.*;


public class TestoperationbodyFactoryImpl extends EFactoryImpl implements TestoperationbodyFactory {
	public TestoperationbodyFactoryImpl() {
		super();
	}

	public static TestoperationbodyFactory init() {
		try {
			TestoperationbodyFactory theTestoperationbodyFactory = (TestoperationbodyFactory)EPackage.Registry.INSTANCE.getEFactory(TestoperationbodyPackage.eNS_URI);
			if (theTestoperationbodyFactory != null) {
				return theTestoperationbodyFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TestoperationbodyFactoryImpl();
	}

	
	

	
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case TestoperationbodyPackage.MAIN :
				return createMain();
			case TestoperationbodyPackage.CONCEPT_A :
				return createConceptA();
			case TestoperationbodyPackage.CHILD_A :
				return createChildA();
			case TestoperationbodyPackage.CHILD_B :
				return createChildB();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case TestoperationbodyPackage.ENUM_A:
				return createEnumAFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case TestoperationbodyPackage.ENUM_A:
				return convertEnumAToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	
	public Main createMain() {
		MainImpl main = new MainImpl();
		return main;
	}

	
	public ConceptA createConceptA() {
		ConceptAImpl conceptA = new ConceptAImpl();
		return conceptA;
	}

	
	public ChildA createChildA() {
		ChildAImpl childA = new ChildAImpl();
		return childA;
	}

	
	public ChildB createChildB() {
		ChildBImpl childB = new ChildBImpl();
		return childB;
	}

	
	public EnumA createEnumAFromString(EDataType eDataType, String initialValue) {
		EnumA result = EnumA.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	
	public String convertEnumAToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	
	public TestoperationbodyPackage getTestoperationbodyPackage() {
		return (TestoperationbodyPackage)getEPackage();
	}

	
	@Deprecated
	public static TestoperationbodyPackage getPackage() {
		return TestoperationbodyPackage.eINSTANCE;
	}

} //TestoperationbodyFactoryImpl
