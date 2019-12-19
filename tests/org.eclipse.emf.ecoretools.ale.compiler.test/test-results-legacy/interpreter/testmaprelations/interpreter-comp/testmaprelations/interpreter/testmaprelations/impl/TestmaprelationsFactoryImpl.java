package testmaprelations.interpreter.testmaprelations.impl;

import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Override;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import testmaprelations.interpreter.testmaprelations.CA0;
import testmaprelations.interpreter.testmaprelations.CA1;
import testmaprelations.interpreter.testmaprelations.CA2;
import testmaprelations.interpreter.testmaprelations.CA3;
import testmaprelations.interpreter.testmaprelations.CA4;
import testmaprelations.interpreter.testmaprelations.CA5;
import testmaprelations.interpreter.testmaprelations.CA6;
import testmaprelations.interpreter.testmaprelations.CA7;
import testmaprelations.interpreter.testmaprelations.CA8;
import testmaprelations.interpreter.testmaprelations.CA9;
import testmaprelations.interpreter.testmaprelations.CB0;
import testmaprelations.interpreter.testmaprelations.CB1;
import testmaprelations.interpreter.testmaprelations.CB2;
import testmaprelations.interpreter.testmaprelations.CB3;
import testmaprelations.interpreter.testmaprelations.CB4;
import testmaprelations.interpreter.testmaprelations.CB5;
import testmaprelations.interpreter.testmaprelations.CB6;
import testmaprelations.interpreter.testmaprelations.CB7;
import testmaprelations.interpreter.testmaprelations.CB8;
import testmaprelations.interpreter.testmaprelations.CB9;
import testmaprelations.interpreter.testmaprelations.TestmaprelationsFactory;
import testmaprelations.interpreter.testmaprelations.TestmaprelationsPackage;

public class TestmaprelationsFactoryImpl extends EFactoryImpl implements TestmaprelationsFactory {
	public TestmaprelationsFactoryImpl() {
		super();
	}

	public static TestmaprelationsFactory init() {
		try {
			TestmaprelationsFactory theTestmaprelationsFactory = (TestmaprelationsFactory) EPackage.Registry.INSTANCE
					.getEFactory(TestmaprelationsPackage.eNS_URI);
			if (theTestmaprelationsFactory != null) {
				return theTestmaprelationsFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TestmaprelationsFactoryImpl();
	}

	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case TestmaprelationsPackage.MAP_CA0_TO_CB0_MAP_ENTRY :
			return (EObject) createMapCA0ToCB0MapEntry();
		case TestmaprelationsPackage.CA0 :
			return createCA0();
		case TestmaprelationsPackage.CB0 :
			return createCB0();
		case TestmaprelationsPackage.MAP_CA1_TO_CB1_MAP_ENTRY :
			return (EObject) createMapCA1ToCB1MapEntry();
		case TestmaprelationsPackage.CB1 :
			return createCB1();
		case TestmaprelationsPackage.CA1 :
			return createCA1();
		case TestmaprelationsPackage.CA2 :
			return createCA2();
		case TestmaprelationsPackage.CB2 :
			return createCB2();
		case TestmaprelationsPackage.MAP_CA2_TO_CB2_MAP_ENTRY :
			return (EObject) createMapCA2ToCB2MapEntry();
		case TestmaprelationsPackage.CB3 :
			return createCB3();
		case TestmaprelationsPackage.CA3 :
			return createCA3();
		case TestmaprelationsPackage.MAP_CA3_TO_CB3_MAP_ENTRY :
			return (EObject) createMapCA3ToCB3MapEntry();
		case TestmaprelationsPackage.CA4 :
			return createCA4();
		case TestmaprelationsPackage.MAP_CA4_TO_CB4_MAP_ENTRY :
			return (EObject) createMapCA4ToCB4MapEntry();
		case TestmaprelationsPackage.CB4 :
			return createCB4();
		case TestmaprelationsPackage.CA5 :
			return createCA5();
		case TestmaprelationsPackage.CB5 :
			return createCB5();
		case TestmaprelationsPackage.MAP_CA5_TO_CB5_MAP_ENTRY :
			return (EObject) createMapCA5ToCB5MapEntry();
		case TestmaprelationsPackage.MAP_CA6_TO_CB6_MAP_ENTRY :
			return (EObject) createMapCA6ToCB6MapEntry();
		case TestmaprelationsPackage.CA6 :
			return createCA6();
		case TestmaprelationsPackage.CB6 :
			return createCB6();
		case TestmaprelationsPackage.CA7 :
			return createCA7();
		case TestmaprelationsPackage.MAP_CA7_TO_CB7_MAP_ENTRY :
			return (EObject) createMapCA7ToCB7MapEntry();
		case TestmaprelationsPackage.CB7 :
			return createCB7();
		case TestmaprelationsPackage.CA8 :
			return createCA8();
		case TestmaprelationsPackage.MAP_CA8_TO_CB8_MAP_ENTRY :
			return (EObject) createMapCA8ToCB8MapEntry();
		case TestmaprelationsPackage.CB8 :
			return createCB8();
		case TestmaprelationsPackage.MAP_CA9_TO_CB9_MAP_ENTRY :
			return (EObject) createMapCA9ToCB9MapEntry();
		case TestmaprelationsPackage.CB9 :
			return createCB9();
		case TestmaprelationsPackage.CA9 :
			return createCA9();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	public Map.Entry<CA0, CB0> createMapCA0ToCB0MapEntry() {
		MapCA0ToCB0MapEntryImpl mapCA0ToCB0MapEntry = new MapCA0ToCB0MapEntryImpl();
		return mapCA0ToCB0MapEntry;
	}

	public CA0 createCA0() {
		CA0Impl ca0 = new CA0Impl();
		return ca0;
	}

	public CB0 createCB0() {
		CB0Impl cb0 = new CB0Impl();
		return cb0;
	}

	public Map.Entry<EList<CA1>, EList<CB1>> createMapCA1ToCB1MapEntry() {
		MapCA1ToCB1MapEntryImpl mapCA1ToCB1MapEntry = new MapCA1ToCB1MapEntryImpl();
		return mapCA1ToCB1MapEntry;
	}

	public CB1 createCB1() {
		CB1Impl cb1 = new CB1Impl();
		return cb1;
	}

	public CA1 createCA1() {
		CA1Impl ca1 = new CA1Impl();
		return ca1;
	}

	public CA2 createCA2() {
		CA2Impl ca2 = new CA2Impl();
		return ca2;
	}

	public CB2 createCB2() {
		CB2Impl cb2 = new CB2Impl();
		return cb2;
	}

	public Map.Entry<CA2, CB2> createMapCA2ToCB2MapEntry() {
		MapCA2ToCB2MapEntryImpl mapCA2ToCB2MapEntry = new MapCA2ToCB2MapEntryImpl();
		return mapCA2ToCB2MapEntry;
	}

	public CB3 createCB3() {
		CB3Impl cb3 = new CB3Impl();
		return cb3;
	}

	public CA3 createCA3() {
		CA3Impl ca3 = new CA3Impl();
		return ca3;
	}

	public Map.Entry<EList<CA3>, EList<CB3>> createMapCA3ToCB3MapEntry() {
		MapCA3ToCB3MapEntryImpl mapCA3ToCB3MapEntry = new MapCA3ToCB3MapEntryImpl();
		return mapCA3ToCB3MapEntry;
	}

	public CA4 createCA4() {
		CA4Impl ca4 = new CA4Impl();
		return ca4;
	}

	public Map.Entry<CA4, CB4> createMapCA4ToCB4MapEntry() {
		MapCA4ToCB4MapEntryImpl mapCA4ToCB4MapEntry = new MapCA4ToCB4MapEntryImpl();
		return mapCA4ToCB4MapEntry;
	}

	public CB4 createCB4() {
		CB4Impl cb4 = new CB4Impl();
		return cb4;
	}

	public CA5 createCA5() {
		CA5Impl ca5 = new CA5Impl();
		return ca5;
	}

	public CB5 createCB5() {
		CB5Impl cb5 = new CB5Impl();
		return cb5;
	}

	public Map.Entry<EList<CA5>, EList<CB5>> createMapCA5ToCB5MapEntry() {
		MapCA5ToCB5MapEntryImpl mapCA5ToCB5MapEntry = new MapCA5ToCB5MapEntryImpl();
		return mapCA5ToCB5MapEntry;
	}

	public Map.Entry<CA6, CB6> createMapCA6ToCB6MapEntry() {
		MapCA6ToCB6MapEntryImpl mapCA6ToCB6MapEntry = new MapCA6ToCB6MapEntryImpl();
		return mapCA6ToCB6MapEntry;
	}

	public CA6 createCA6() {
		CA6Impl ca6 = new CA6Impl();
		return ca6;
	}

	public CB6 createCB6() {
		CB6Impl cb6 = new CB6Impl();
		return cb6;
	}

	public CA7 createCA7() {
		CA7Impl ca7 = new CA7Impl();
		return ca7;
	}

	public Map.Entry<EList<CA7>, EList<CB7>> createMapCA7ToCB7MapEntry() {
		MapCA7ToCB7MapEntryImpl mapCA7ToCB7MapEntry = new MapCA7ToCB7MapEntryImpl();
		return mapCA7ToCB7MapEntry;
	}

	public CB7 createCB7() {
		CB7Impl cb7 = new CB7Impl();
		return cb7;
	}

	public CA8 createCA8() {
		CA8Impl ca8 = new CA8Impl();
		return ca8;
	}

	public Map.Entry<CA8, CB8> createMapCA8ToCB8MapEntry() {
		MapCA8ToCB8MapEntryImpl mapCA8ToCB8MapEntry = new MapCA8ToCB8MapEntryImpl();
		return mapCA8ToCB8MapEntry;
	}

	public CB8 createCB8() {
		CB8Impl cb8 = new CB8Impl();
		return cb8;
	}

	public Map.Entry<EList<CA9>, EList<CB9>> createMapCA9ToCB9MapEntry() {
		MapCA9ToCB9MapEntryImpl mapCA9ToCB9MapEntry = new MapCA9ToCB9MapEntryImpl();
		return mapCA9ToCB9MapEntry;
	}

	public CB9 createCB9() {
		CB9Impl cb9 = new CB9Impl();
		return cb9;
	}

	public CA9 createCA9() {
		CA9Impl ca9 = new CA9Impl();
		return ca9;
	}

	public TestmaprelationsPackage getTestmaprelationsPackage() {
		return (TestmaprelationsPackage) getEPackage();
	}

	@Deprecated
	public static TestmaprelationsPackage getPackage() {
		return TestmaprelationsPackage.eINSTANCE;
	}
}
