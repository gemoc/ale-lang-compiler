package test1.visitor.test1;

import java.lang.String;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import test1.visitor.test1.impl.Test1PackageImpl;

public interface Test1Package extends EPackage {
	String eNAME = "test1";

	String eNS_URI = "http://test1.test1.test1/";

	String eNS_PREFIX = "test1";

	Test1Package eINSTANCE = Test1PackageImpl.init();

	int CONCEPT_A = 0;

	int CONCEPT_A__CS = 0;

	int CONCEPT_A_FEATURE_COUNT = 1;

	int CONCEPT_A_OPERATION_COUNT = 0;

	int CONCEPT_B = 1;

	int CONCEPT_B__CS = CONCEPT_A__CS;

	int CONCEPT_B_FEATURE_COUNT = CONCEPT_A_FEATURE_COUNT + 0;

	int CONCEPT_B_OPERATION_COUNT = CONCEPT_A_OPERATION_COUNT + 0;

	int CONCEPT_C = 2;

	int CONCEPT_C__NBR = 0;

	int CONCEPT_C__COOL = 1;

	int CONCEPT_C_FEATURE_COUNT = 2;

	int CONCEPT_C_OPERATION_COUNT = 0;

	EClass getConceptA();

	EReference getConceptA_Cs();

	EClass getConceptB();

	EClass getConceptC();

	EAttribute getConceptC_Nbr();

	EAttribute getConceptC_Cool();

	Test1Factory getTest1Factory();

	interface Literals {
		EClass CONCEPT_A = eINSTANCE.getConceptA();

		EReference CONCEPT_A__CS = eINSTANCE.getConceptA_Cs();

		EClass CONCEPT_B = eINSTANCE.getConceptB();

		EClass CONCEPT_C = eINSTANCE.getConceptC();

		EAttribute CONCEPT_C__NBR = eINSTANCE.getConceptC_Nbr();

		EAttribute CONCEPT_C__COOL = eINSTANCE.getConceptC_Cool();
	}
}
