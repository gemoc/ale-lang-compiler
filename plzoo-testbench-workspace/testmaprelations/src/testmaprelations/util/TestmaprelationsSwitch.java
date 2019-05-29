
package testmaprelations.util;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import testmaprelations.*;

public class TestmaprelationsSwitch<T> extends Switch<T> {
	
	protected static TestmaprelationsPackage modelPackage;
	
	public TestmaprelationsSwitch() {
		if (modelPackage == null) {
			modelPackage = TestmaprelationsPackage.eINSTANCE;
		}
	}
	
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}
	
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case TestmaprelationsPackage.MAP_CA0_TO_CB0_MAP_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<CA0, CB0> mapCA0ToCB0MapEntry = (Map.Entry<CA0, CB0>)theEObject;
				T result = caseMapCA0ToCB0MapEntry(mapCA0ToCB0MapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestmaprelationsPackage.CA0: {
				CA0 ca0 = (CA0)theEObject;
				T result = caseCA0(ca0);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestmaprelationsPackage.CB0: {
				CB0 cb0 = (CB0)theEObject;
				T result = caseCB0(cb0);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestmaprelationsPackage.MAP_CA1_TO_CB1_MAP_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<EList<CA1>, EList<CB1>> mapCA1ToCB1MapEntry = (Map.Entry<EList<CA1>, EList<CB1>>)theEObject;
				T result = caseMapCA1ToCB1MapEntry(mapCA1ToCB1MapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestmaprelationsPackage.CB1: {
				CB1 cb1 = (CB1)theEObject;
				T result = caseCB1(cb1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestmaprelationsPackage.CA1: {
				CA1 ca1 = (CA1)theEObject;
				T result = caseCA1(ca1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestmaprelationsPackage.CA2: {
				CA2 ca2 = (CA2)theEObject;
				T result = caseCA2(ca2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestmaprelationsPackage.CB2: {
				CB2 cb2 = (CB2)theEObject;
				T result = caseCB2(cb2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestmaprelationsPackage.MAP_CA2_TO_CB2_MAP_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<CA2, CB2> mapCA2ToCB2MapEntry = (Map.Entry<CA2, CB2>)theEObject;
				T result = caseMapCA2ToCB2MapEntry(mapCA2ToCB2MapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestmaprelationsPackage.CB3: {
				CB3 cb3 = (CB3)theEObject;
				T result = caseCB3(cb3);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestmaprelationsPackage.CA3: {
				CA3 ca3 = (CA3)theEObject;
				T result = caseCA3(ca3);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestmaprelationsPackage.MAP_CA3_TO_CB3_MAP_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<EList<CA3>, EList<CB3>> mapCA3ToCB3MapEntry = (Map.Entry<EList<CA3>, EList<CB3>>)theEObject;
				T result = caseMapCA3ToCB3MapEntry(mapCA3ToCB3MapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestmaprelationsPackage.CA4: {
				CA4 ca4 = (CA4)theEObject;
				T result = caseCA4(ca4);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestmaprelationsPackage.MAP_CA4_TO_CB4_MAP_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<CA4, CB4> mapCA4ToCB4MapEntry = (Map.Entry<CA4, CB4>)theEObject;
				T result = caseMapCA4ToCB4MapEntry(mapCA4ToCB4MapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestmaprelationsPackage.CB4: {
				CB4 cb4 = (CB4)theEObject;
				T result = caseCB4(cb4);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestmaprelationsPackage.CA5: {
				CA5 ca5 = (CA5)theEObject;
				T result = caseCA5(ca5);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestmaprelationsPackage.CB5: {
				CB5 cb5 = (CB5)theEObject;
				T result = caseCB5(cb5);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestmaprelationsPackage.MAP_CA5_TO_CB5_MAP_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<EList<CA5>, EList<CB5>> mapCA5ToCB5MapEntry = (Map.Entry<EList<CA5>, EList<CB5>>)theEObject;
				T result = caseMapCA5ToCB5MapEntry(mapCA5ToCB5MapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestmaprelationsPackage.MAP_CA6_TO_CB6_MAP_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<CA6, CB6> mapCA6ToCB6MapEntry = (Map.Entry<CA6, CB6>)theEObject;
				T result = caseMapCA6ToCB6MapEntry(mapCA6ToCB6MapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestmaprelationsPackage.CA6: {
				CA6 ca6 = (CA6)theEObject;
				T result = caseCA6(ca6);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestmaprelationsPackage.CB6: {
				CB6 cb6 = (CB6)theEObject;
				T result = caseCB6(cb6);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestmaprelationsPackage.CA7: {
				CA7 ca7 = (CA7)theEObject;
				T result = caseCA7(ca7);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestmaprelationsPackage.MAP_CA7_TO_CB7_MAP_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<EList<CA7>, EList<CB7>> mapCA7ToCB7MapEntry = (Map.Entry<EList<CA7>, EList<CB7>>)theEObject;
				T result = caseMapCA7ToCB7MapEntry(mapCA7ToCB7MapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestmaprelationsPackage.CB7: {
				CB7 cb7 = (CB7)theEObject;
				T result = caseCB7(cb7);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestmaprelationsPackage.CA8: {
				CA8 ca8 = (CA8)theEObject;
				T result = caseCA8(ca8);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestmaprelationsPackage.MAP_CA8_TO_CB8_MAP_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<CA8, CB8> mapCA8ToCB8MapEntry = (Map.Entry<CA8, CB8>)theEObject;
				T result = caseMapCA8ToCB8MapEntry(mapCA8ToCB8MapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestmaprelationsPackage.CB8: {
				CB8 cb8 = (CB8)theEObject;
				T result = caseCB8(cb8);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestmaprelationsPackage.MAP_CA9_TO_CB9_MAP_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<EList<CA9>, EList<CB9>> mapCA9ToCB9MapEntry = (Map.Entry<EList<CA9>, EList<CB9>>)theEObject;
				T result = caseMapCA9ToCB9MapEntry(mapCA9ToCB9MapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestmaprelationsPackage.CB9: {
				CB9 cb9 = (CB9)theEObject;
				T result = caseCB9(cb9);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestmaprelationsPackage.CA9: {
				CA9 ca9 = (CA9)theEObject;
				T result = caseCA9(ca9);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}
	
	public T caseMapCA0ToCB0MapEntry(Map.Entry<CA0, CB0> object) {
		return null;
	}
	
	public T caseCA0(CA0 object) {
		return null;
	}
	
	public T caseCB0(CB0 object) {
		return null;
	}
	
	public T caseMapCA1ToCB1MapEntry(Map.Entry<EList<CA1>, EList<CB1>> object) {
		return null;
	}
	
	public T caseCB1(CB1 object) {
		return null;
	}
	
	public T caseCA1(CA1 object) {
		return null;
	}
	
	public T caseCA2(CA2 object) {
		return null;
	}
	
	public T caseCB2(CB2 object) {
		return null;
	}
	
	public T caseMapCA2ToCB2MapEntry(Map.Entry<CA2, CB2> object) {
		return null;
	}
	
	public T caseCB3(CB3 object) {
		return null;
	}
	
	public T caseCA3(CA3 object) {
		return null;
	}
	
	public T caseMapCA3ToCB3MapEntry(Map.Entry<EList<CA3>, EList<CB3>> object) {
		return null;
	}
	
	public T caseCA4(CA4 object) {
		return null;
	}
	
	public T caseMapCA4ToCB4MapEntry(Map.Entry<CA4, CB4> object) {
		return null;
	}
	
	public T caseCB4(CB4 object) {
		return null;
	}
	
	public T caseCA5(CA5 object) {
		return null;
	}
	
	public T caseCB5(CB5 object) {
		return null;
	}
	
	public T caseMapCA5ToCB5MapEntry(Map.Entry<EList<CA5>, EList<CB5>> object) {
		return null;
	}
	
	public T caseMapCA6ToCB6MapEntry(Map.Entry<CA6, CB6> object) {
		return null;
	}
	
	public T caseCA6(CA6 object) {
		return null;
	}
	
	public T caseCB6(CB6 object) {
		return null;
	}
	
	public T caseCA7(CA7 object) {
		return null;
	}
	
	public T caseMapCA7ToCB7MapEntry(Map.Entry<EList<CA7>, EList<CB7>> object) {
		return null;
	}
	
	public T caseCB7(CB7 object) {
		return null;
	}
	
	public T caseCA8(CA8 object) {
		return null;
	}
	
	public T caseMapCA8ToCB8MapEntry(Map.Entry<CA8, CB8> object) {
		return null;
	}
	
	public T caseCB8(CB8 object) {
		return null;
	}
	
	public T caseMapCA9ToCB9MapEntry(Map.Entry<EList<CA9>, EList<CB9>> object) {
		return null;
	}
	
	public T caseCB9(CB9 object) {
		return null;
	}
	
	public T caseCA9(CA9 object) {
		return null;
	}
	
	@Override
	public T defaultCase(EObject object) {
		return null;
	}
} //TestmaprelationsSwitch
