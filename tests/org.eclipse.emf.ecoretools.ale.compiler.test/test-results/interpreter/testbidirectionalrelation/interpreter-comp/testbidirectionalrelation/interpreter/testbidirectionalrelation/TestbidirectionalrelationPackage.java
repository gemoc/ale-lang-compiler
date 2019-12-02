package testbidirectionalrelation.interpreter.testbidirectionalrelation;

import java.lang.String;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import testbidirectionalrelation.interpreter.testbidirectionalrelation.impl.TestbidirectionalrelationPackageImpl;

public interface TestbidirectionalrelationPackage extends EPackage {
	String eNAME = "testbidirectionalrelation";

	String eNS_URI = "http://testbidirectionalrelation.testbidirectionalrelation.testbidirectionalrelation/";

	String eNS_PREFIX = "testbidirectionalrelation";

	TestbidirectionalrelationPackage eINSTANCE = TestbidirectionalrelationPackageImpl.init();

	int CONCEPT_A = 0;

	int CONCEPT_A__CONCEPTB = 0;

	int CONCEPT_A__CONCEPTC = 1;

	int CONCEPT_A__CONCEPTD = 2;

	int CONCEPT_A__CONCEPTE = 3;

	int CONCEPT_A__CONCEPTF = 4;

	int CONCEPT_A__CONCEPTG = 5;

	int CONCEPT_A_FEATURE_COUNT = 6;

	int CONCEPT_A_OPERATION_COUNT = 0;

	int CONCEPT_B = 1;

	int CONCEPT_B__CONCEPTC = 0;

	int CONCEPT_B_FEATURE_COUNT = 1;

	int CONCEPT_B_OPERATION_COUNT = 0;

	int CONCEPT_C = 2;

	int CONCEPT_C__CONCEPTB = 0;

	int CONCEPT_C_FEATURE_COUNT = 1;

	int CONCEPT_C_OPERATION_COUNT = 0;

	int CONCEPT_D = 3;

	int CONCEPT_D__CONCEPTE = 0;

	int CONCEPT_D_FEATURE_COUNT = 1;

	int CONCEPT_D_OPERATION_COUNT = 0;

	int CONCEPT_E = 4;

	int CONCEPT_E__CONCEPTD = 0;

	int CONCEPT_E_FEATURE_COUNT = 1;

	int CONCEPT_E_OPERATION_COUNT = 0;

	int CONCEPT_F = 5;

	int CONCEPT_F__CONCEPTG = 0;

	int CONCEPT_F_FEATURE_COUNT = 1;

	int CONCEPT_F_OPERATION_COUNT = 0;

	int CONCEPT_G = 6;

	int CONCEPT_G__CONCEPTF = 0;

	int CONCEPT_G_FEATURE_COUNT = 1;

	int CONCEPT_G_OPERATION_COUNT = 0;

	EClass getConceptA();

	EReference getConceptA_Conceptb();

	EReference getConceptA_Conceptc();

	EReference getConceptA_Conceptd();

	EReference getConceptA_Concepte();

	EReference getConceptA_Conceptf();

	EReference getConceptA_Conceptg();

	EClass getConceptB();

	EReference getConceptB_Conceptc();

	EClass getConceptC();

	EReference getConceptC_Conceptb();

	EClass getConceptD();

	EReference getConceptD_Concepte();

	EClass getConceptE();

	EReference getConceptE_Conceptd();

	EClass getConceptF();

	EReference getConceptF_Conceptg();

	EClass getConceptG();

	EReference getConceptG_Conceptf();

	TestbidirectionalrelationFactory getTestbidirectionalrelationFactory();

	interface Literals {
		EClass CONCEPT_A = eINSTANCE.getConceptA();

		EReference CONCEPT_A__CONCEPTB = eINSTANCE.getConceptA_Conceptb();

		EReference CONCEPT_A__CONCEPTC = eINSTANCE.getConceptA_Conceptc();

		EReference CONCEPT_A__CONCEPTD = eINSTANCE.getConceptA_Conceptd();

		EReference CONCEPT_A__CONCEPTE = eINSTANCE.getConceptA_Concepte();

		EReference CONCEPT_A__CONCEPTF = eINSTANCE.getConceptA_Conceptf();

		EReference CONCEPT_A__CONCEPTG = eINSTANCE.getConceptA_Conceptg();

		EClass CONCEPT_B = eINSTANCE.getConceptB();

		EReference CONCEPT_B__CONCEPTC = eINSTANCE.getConceptB_Conceptc();

		EClass CONCEPT_C = eINSTANCE.getConceptC();

		EReference CONCEPT_C__CONCEPTB = eINSTANCE.getConceptC_Conceptb();

		EClass CONCEPT_D = eINSTANCE.getConceptD();

		EReference CONCEPT_D__CONCEPTE = eINSTANCE.getConceptD_Concepte();

		EClass CONCEPT_E = eINSTANCE.getConceptE();

		EReference CONCEPT_E__CONCEPTD = eINSTANCE.getConceptE_Conceptd();

		EClass CONCEPT_F = eINSTANCE.getConceptF();

		EReference CONCEPT_F__CONCEPTG = eINSTANCE.getConceptF_Conceptg();

		EClass CONCEPT_G = eINSTANCE.getConceptG();

		EReference CONCEPT_G__CONCEPTF = eINSTANCE.getConceptG_Conceptf();
	}
}
