package test1.interpreter.test1;

import java.lang.String;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import test1.interpreter.test1.impl.Test1PackageImpl;

public interface Test1Package extends EPackage {
	String eNAME = "test1";

	String eNS_URI = "http://test1.test1.test1/";

	String eNS_PREFIX = "test1";

	Test1Package eINSTANCE = Test1PackageImpl.init();

	int CONCEPT_A = 0;

	int CONCEPT_A_FEATURE_COUNT = 0;

	int CONCEPT_A_OPERATION_COUNT = 0;

	int CONCEPT_B = 1;

	int CONCEPT_B_FEATURE_COUNT = CONCEPT_A_FEATURE_COUNT + 0;

	int CONCEPT_B_OPERATION_COUNT = CONCEPT_A_OPERATION_COUNT + 0;

	EClass getConceptA();

	EClass getConceptB();

	Test1Factory getTest1Factory();

	interface Literals {
		EClass CONCEPT_A = eINSTANCE.getConceptA();

		EClass CONCEPT_B = eINSTANCE.getConceptB();
	}
}
