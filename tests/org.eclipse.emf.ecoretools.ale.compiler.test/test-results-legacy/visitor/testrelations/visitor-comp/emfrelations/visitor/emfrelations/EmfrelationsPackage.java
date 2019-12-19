package emfrelations.visitor.emfrelations;

import emfrelations.visitor.emfrelations.impl.EmfrelationsPackageImpl;
import java.lang.String;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

public interface EmfrelationsPackage extends EPackage {
	String eNAME = "emfrelations";

	String eNS_URI = "http://emfrelations.emfrelations.emfrelations/";

	String eNS_PREFIX = "emfrelations";

	EmfrelationsPackage eINSTANCE = EmfrelationsPackageImpl.init();

	int CONCEPT_A0 = 0;

	int CONCEPT_A0__CONCEPTB0 = 0;

	int CONCEPT_A0_FEATURE_COUNT = 1;

	int CONCEPT_A0_OPERATION_COUNT = 0;

	int CONCEPT_B0 = 1;

	int CONCEPT_B0__CONCEPTA0 = 0;

	int CONCEPT_B0_FEATURE_COUNT = 1;

	int CONCEPT_B0_OPERATION_COUNT = 0;

	int CONCEPT_A1 = 2;

	int CONCEPT_A1__CONCEPTB1 = 0;

	int CONCEPT_A1_FEATURE_COUNT = 1;

	int CONCEPT_A1_OPERATION_COUNT = 0;

	int CONCEPT_B1 = 3;

	int CONCEPT_B1__CONCEPTA1 = 0;

	int CONCEPT_B1_FEATURE_COUNT = 1;

	int CONCEPT_B1_OPERATION_COUNT = 0;

	int CONCEPT_A2 = 4;

	int CONCEPT_A2__CONCEPTB2 = 0;

	int CONCEPT_A2_FEATURE_COUNT = 1;

	int CONCEPT_A2_OPERATION_COUNT = 0;

	int CONCEPT_B2 = 5;

	int CONCEPT_B2__CONCEPTA2 = 0;

	int CONCEPT_B2_FEATURE_COUNT = 1;

	int CONCEPT_B2_OPERATION_COUNT = 0;

	int CONCEPT_A3 = 6;

	int CONCEPT_A3__CONCEPTB3 = 0;

	int CONCEPT_A3_FEATURE_COUNT = 1;

	int CONCEPT_A3_OPERATION_COUNT = 0;

	int CONCEPT_B3 = 7;

	int CONCEPT_B3__CONCEPTA3 = 0;

	int CONCEPT_B3_FEATURE_COUNT = 1;

	int CONCEPT_B3_OPERATION_COUNT = 0;

	int CONCEPT_A4 = 8;

	int CONCEPT_A4__CONCEPTB4 = 0;

	int CONCEPT_A4_FEATURE_COUNT = 1;

	int CONCEPT_A4_OPERATION_COUNT = 0;

	int CONCEPT_B4 = 9;

	int CONCEPT_B4__CONCEPTA4 = 0;

	int CONCEPT_B4_FEATURE_COUNT = 1;

	int CONCEPT_B4_OPERATION_COUNT = 0;

	int CONCEPT_A5 = 10;

	int CONCEPT_A5__CONCEPTB5 = 0;

	int CONCEPT_A5_FEATURE_COUNT = 1;

	int CONCEPT_A5_OPERATION_COUNT = 0;

	int CONCEPT_B5 = 11;

	int CONCEPT_B5__CONCEPTA5 = 0;

	int CONCEPT_B5_FEATURE_COUNT = 1;

	int CONCEPT_B5_OPERATION_COUNT = 0;

	int CONCEPT_A8 = 12;

	int CONCEPT_A8__CONCEPTB8 = 0;

	int CONCEPT_A8_FEATURE_COUNT = 1;

	int CONCEPT_A8_OPERATION_COUNT = 0;

	int CONCEPT_B8 = 13;

	int CONCEPT_B8_FEATURE_COUNT = 0;

	int CONCEPT_B8_OPERATION_COUNT = 0;

	int CONCEPT_A9 = 14;

	int CONCEPT_A9__CONCEPTB9 = 0;

	int CONCEPT_A9_FEATURE_COUNT = 1;

	int CONCEPT_A9_OPERATION_COUNT = 0;

	int CONCEPT_B9 = 15;

	int CONCEPT_B9_FEATURE_COUNT = 0;

	int CONCEPT_B9_OPERATION_COUNT = 0;

	int CONCEPT_A10 = 16;

	int CONCEPT_A10__CONCEPTB10 = 0;

	int CONCEPT_A10_FEATURE_COUNT = 1;

	int CONCEPT_A10_OPERATION_COUNT = 0;

	int CONCEPT_B10 = 17;

	int CONCEPT_B10_FEATURE_COUNT = 0;

	int CONCEPT_B10_OPERATION_COUNT = 0;

	int CONCEPT_A11 = 18;

	int CONCEPT_A11__CONCEPTB11 = 0;

	int CONCEPT_A11_FEATURE_COUNT = 1;

	int CONCEPT_A11_OPERATION_COUNT = 0;

	int CONCEPT_B11 = 19;

	int CONCEPT_B11_FEATURE_COUNT = 0;

	int CONCEPT_B11_OPERATION_COUNT = 0;

	EClass getConceptA0();

	EReference getConceptA0_Conceptb0();

	EClass getConceptB0();

	EReference getConceptB0_Concepta0();

	EClass getConceptA1();

	EReference getConceptA1_Conceptb1();

	EClass getConceptB1();

	EReference getConceptB1_Concepta1();

	EClass getConceptA2();

	EReference getConceptA2_Conceptb2();

	EClass getConceptB2();

	EReference getConceptB2_Concepta2();

	EClass getConceptA3();

	EReference getConceptA3_Conceptb3();

	EClass getConceptB3();

	EReference getConceptB3_Concepta3();

	EClass getConceptA4();

	EReference getConceptA4_Conceptb4();

	EClass getConceptB4();

	EReference getConceptB4_Concepta4();

	EClass getConceptA5();

	EReference getConceptA5_Conceptb5();

	EClass getConceptB5();

	EReference getConceptB5_Concepta5();

	EClass getConceptA8();

	EReference getConceptA8_Conceptb8();

	EClass getConceptB8();

	EClass getConceptA9();

	EReference getConceptA9_Conceptb9();

	EClass getConceptB9();

	EClass getConceptA10();

	EReference getConceptA10_Conceptb10();

	EClass getConceptB10();

	EClass getConceptA11();

	EReference getConceptA11_Conceptb11();

	EClass getConceptB11();

	EmfrelationsFactory getEmfrelationsFactory();

	interface Literals {
		EClass CONCEPT_A0 = eINSTANCE.getConceptA0();

		EReference CONCEPT_A0__CONCEPTB0 = eINSTANCE.getConceptA0_Conceptb0();

		EClass CONCEPT_B0 = eINSTANCE.getConceptB0();

		EReference CONCEPT_B0__CONCEPTA0 = eINSTANCE.getConceptB0_Concepta0();

		EClass CONCEPT_A1 = eINSTANCE.getConceptA1();

		EReference CONCEPT_A1__CONCEPTB1 = eINSTANCE.getConceptA1_Conceptb1();

		EClass CONCEPT_B1 = eINSTANCE.getConceptB1();

		EReference CONCEPT_B1__CONCEPTA1 = eINSTANCE.getConceptB1_Concepta1();

		EClass CONCEPT_A2 = eINSTANCE.getConceptA2();

		EReference CONCEPT_A2__CONCEPTB2 = eINSTANCE.getConceptA2_Conceptb2();

		EClass CONCEPT_B2 = eINSTANCE.getConceptB2();

		EReference CONCEPT_B2__CONCEPTA2 = eINSTANCE.getConceptB2_Concepta2();

		EClass CONCEPT_A3 = eINSTANCE.getConceptA3();

		EReference CONCEPT_A3__CONCEPTB3 = eINSTANCE.getConceptA3_Conceptb3();

		EClass CONCEPT_B3 = eINSTANCE.getConceptB3();

		EReference CONCEPT_B3__CONCEPTA3 = eINSTANCE.getConceptB3_Concepta3();

		EClass CONCEPT_A4 = eINSTANCE.getConceptA4();

		EReference CONCEPT_A4__CONCEPTB4 = eINSTANCE.getConceptA4_Conceptb4();

		EClass CONCEPT_B4 = eINSTANCE.getConceptB4();

		EReference CONCEPT_B4__CONCEPTA4 = eINSTANCE.getConceptB4_Concepta4();

		EClass CONCEPT_A5 = eINSTANCE.getConceptA5();

		EReference CONCEPT_A5__CONCEPTB5 = eINSTANCE.getConceptA5_Conceptb5();

		EClass CONCEPT_B5 = eINSTANCE.getConceptB5();

		EReference CONCEPT_B5__CONCEPTA5 = eINSTANCE.getConceptB5_Concepta5();

		EClass CONCEPT_A8 = eINSTANCE.getConceptA8();

		EReference CONCEPT_A8__CONCEPTB8 = eINSTANCE.getConceptA8_Conceptb8();

		EClass CONCEPT_B8 = eINSTANCE.getConceptB8();

		EClass CONCEPT_A9 = eINSTANCE.getConceptA9();

		EReference CONCEPT_A9__CONCEPTB9 = eINSTANCE.getConceptA9_Conceptb9();

		EClass CONCEPT_B9 = eINSTANCE.getConceptB9();

		EClass CONCEPT_A10 = eINSTANCE.getConceptA10();

		EReference CONCEPT_A10__CONCEPTB10 = eINSTANCE.getConceptA10_Conceptb10();

		EClass CONCEPT_B10 = eINSTANCE.getConceptB10();

		EClass CONCEPT_A11 = eINSTANCE.getConceptA11();

		EReference CONCEPT_A11__CONCEPTB11 = eINSTANCE.getConceptA11_Conceptb11();

		EClass CONCEPT_B11 = eINSTANCE.getConceptB11();
	}
}
