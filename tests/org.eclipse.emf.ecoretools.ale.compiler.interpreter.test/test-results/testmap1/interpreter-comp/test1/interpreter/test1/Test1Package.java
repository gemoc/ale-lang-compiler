package test1.interpreter.test1;

import java.lang.String;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import test1.interpreter.test1.impl.Test1PackageImpl;

public interface Test1Package extends EPackage {
	String eNAME = "test1";

	String eNS_URI = "http://test1.test1.test1/";

	String eNS_PREFIX = "test1";

	Test1Package eINSTANCE = Test1PackageImpl.init();

	int CONCEPT_A = 0;

	int CONCEPT_A__CS = 0;

	int CONCEPT_A_FEATURE_COUNT = 1;

	int CONCEPT_A_OPERATION_COUNT = 0;

	int STRING_TO_INTEGER_MAP_ENTRY = 1;

	int STRING_TO_INTEGER_MAP_ENTRY__KEY = 0;

	int STRING_TO_INTEGER_MAP_ENTRY__VALUE = 1;

	int STRING_TO_INTEGER_MAP_ENTRY_FEATURE_COUNT = 2;

	int STRING_TO_INTEGER_MAP_ENTRY_OPERATION_COUNT = 0;

	EClass getConceptA();

	EReference getConceptA_Cs();

	EClass getStringToIntegerMapEntry();

	EAttribute getStringToIntegerMapEntry_Key();

	EAttribute getStringToIntegerMapEntry_Value();

	Test1Factory getTest1Factory();

	interface Literals {
		EClass CONCEPT_A = eINSTANCE.getConceptA();

		EReference CONCEPT_A__CS = eINSTANCE.getConceptA_Cs();

		EClass STRING_TO_INTEGER_MAP_ENTRY = eINSTANCE.getStringToIntegerMapEntry();

		EAttribute STRING_TO_INTEGER_MAP_ENTRY__KEY = eINSTANCE.getStringToIntegerMapEntry_Key();

		EAttribute STRING_TO_INTEGER_MAP_ENTRY__VALUE = eINSTANCE.getStringToIntegerMapEntry_Value();
	}
}
