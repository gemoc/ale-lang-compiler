package test1.interpreter.test1;

import java.lang.String;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import test1.interpreter.test1.impl.Test1PackageImpl;

public interface Test1Package extends EPackage {
	Test1Package eINSTANCE = Test1PackageImpl.init();

	String eNS_URI = "http://test1.test1.test1/";

	String eNAME = "test1";

	String eNS_PREFIX = "test1";

	int CONCEPT_A = 0;

	int STRING_TO_INTEGER_MAP_ENTRY = 1;

	int CONCEPT_A__CS = 0;

	int STRING_TO_INTEGER_MAP_ENTRY__KEY = 0;

	int STRING_TO_INTEGER_MAP_ENTRY__VALUE = 1;

	EClass getConceptA();

	EClass getStringToIntegerMapEntry();

	EReference getConceptA_Cs();

	EAttribute getStringToIntegerMapEntry_Key();

	EAttribute getStringToIntegerMapEntry_Value();

	Test1Factory getTest1Factory();

	interface Literals {
		EClass CONCEPT_A = eINSTANCE.getConceptA();

		EClass STRING_TO_INTEGER_MAP_ENTRY = eINSTANCE.getStringToIntegerMapEntry();

		EReference CONCEPT_A__CS = eINSTANCE.getConceptA_Cs();

		EAttribute STRING_TO_INTEGER_MAP_ENTRY__KEY = eINSTANCE.getStringToIntegerMapEntry_Key();

		EAttribute STRING_TO_INTEGER_MAP_ENTRY__VALUE = eINSTANCE.getStringToIntegerMapEntry_Value();
	}
}
