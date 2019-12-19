package testoperationbody.interpreter.testoperationbody;

import java.lang.String;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import testoperationbody.interpreter.testoperationbody.impl.TestoperationbodyPackageImpl;

public interface TestoperationbodyPackage extends EPackage {
	String eNAME = "testoperationbody";

	String eNS_URI = "http://testoperationbody.testoperationbody.testoperationbody/";

	String eNS_PREFIX = "testoperationbody";

	TestoperationbodyPackage eINSTANCE = TestoperationbodyPackageImpl.init();

	int MAIN = 0;

	int MAIN__LISTINT = 0;

	int MAIN__LISTCONCEPTA = 1;

	int MAIN__SINGLEBOOL = 2;

	int MAIN__SINGLECONCEPTA = 3;

	int MAIN__CHILDREN = 4;

	int MAIN_FEATURE_COUNT = 5;

	int MAIN_OPERATION_COUNT = 0;

	int CONCEPT_A = 1;

	int CONCEPT_A_FEATURE_COUNT = 0;

	int CONCEPT_A_OPERATION_COUNT = 0;

	int PARENT = 2;

	int PARENT_FEATURE_COUNT = 0;

	int PARENT_OPERATION_COUNT = 0;

	int CHILD_A = 3;

	int CHILD_A__VALUE = 0;

	int CHILD_A_FEATURE_COUNT = PARENT_FEATURE_COUNT + 1;

	int CHILD_A_OPERATION_COUNT = PARENT_OPERATION_COUNT + 0;

	int CHILD_B = 4;

	int CHILD_B_FEATURE_COUNT = PARENT_FEATURE_COUNT + 0;

	int CHILD_B_OPERATION_COUNT = PARENT_OPERATION_COUNT + 0;

	int ENUM_A = 5;

	EClass getMain();

	EAttribute getMain_Listint();

	EReference getMain_Listconcepta();

	EAttribute getMain_Singlebool();

	EReference getMain_Singleconcepta();

	EReference getMain_Children();

	EClass getConceptA();

	EClass getParent();

	EClass getChildA();

	EAttribute getChildA_Value();

	EClass getChildB();

	EEnum getEnumA();

	TestoperationbodyFactory getTestoperationbodyFactory();

	interface Literals {
		EClass MAIN = eINSTANCE.getMain();

		EAttribute MAIN__LISTINT = eINSTANCE.getMain_Listint();

		EReference MAIN__LISTCONCEPTA = eINSTANCE.getMain_Listconcepta();

		EAttribute MAIN__SINGLEBOOL = eINSTANCE.getMain_Singlebool();

		EReference MAIN__SINGLECONCEPTA = eINSTANCE.getMain_Singleconcepta();

		EReference MAIN__CHILDREN = eINSTANCE.getMain_Children();

		EClass CONCEPT_A = eINSTANCE.getConceptA();

		EClass PARENT = eINSTANCE.getParent();

		EClass CHILD_A = eINSTANCE.getChildA();

		EAttribute CHILD_A__VALUE = eINSTANCE.getChildA_Value();

		EClass CHILD_B = eINSTANCE.getChildB();

		EEnum ENUMA = eINSTANCE.getEnumA();
	}
}
