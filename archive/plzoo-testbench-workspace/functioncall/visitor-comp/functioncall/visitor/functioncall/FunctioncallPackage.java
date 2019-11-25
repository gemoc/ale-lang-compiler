package functioncall.visitor.functioncall;

import functioncall.visitor.functioncall.impl.FunctioncallPackageImpl;
import java.lang.String;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

public interface FunctioncallPackage extends EPackage {
	String eNAME = "functioncall";

	String eNS_URI = "http://functioncall.functioncall.functioncall/";

	String eNS_PREFIX = "functioncall";

	FunctioncallPackage eINSTANCE = FunctioncallPackageImpl.init();

	int CONCEPT_A = 0;

	int CONCEPT_A_FEATURE_COUNT = 0;

	int CONCEPT_A_OPERATION_COUNT = 0;

	int CONCEPT_B = 1;

	int CONCEPT_B_FEATURE_COUNT = CONCEPT_A_FEATURE_COUNT + 0;

	int CONCEPT_B_OPERATION_COUNT = CONCEPT_A_OPERATION_COUNT + 0;

	int CONCEPT_C = 2;

	int CONCEPT_C__CONCEPTA2 = 0;

	int CONCEPT_C__CONCEPTA1 = 1;

	int CONCEPT_C__CONCEPTB = 2;

	int CONCEPT_C_FEATURE_COUNT = 3;

	int CONCEPT_C_OPERATION_COUNT = 0;

	EClass getConceptA();

	EClass getConceptB();

	EClass getConceptC();

	EReference getConceptC_Concepta2();

	EReference getConceptC_Concepta1();

	EReference getConceptC_Conceptb();

	FunctioncallFactory getFunctioncallFactory();

	interface Literals {
		EClass CONCEPT_A = eINSTANCE.getConceptA();

		EClass CONCEPT_B = eINSTANCE.getConceptB();

		EClass CONCEPT_C = eINSTANCE.getConceptC();

		EReference CONCEPT_C__CONCEPTA2 = eINSTANCE.getConceptC_Concepta2();

		EReference CONCEPT_C__CONCEPTA1 = eINSTANCE.getConceptC_Concepta1();

		EReference CONCEPT_C__CONCEPTB = eINSTANCE.getConceptC_Conceptb();
	}
}
