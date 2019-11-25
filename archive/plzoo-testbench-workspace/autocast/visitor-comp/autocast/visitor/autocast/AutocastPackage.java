package autocast.visitor.autocast;

import autocast.visitor.autocast.impl.AutocastPackageImpl;
import java.lang.String;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

public interface AutocastPackage extends EPackage {
	String eNAME = "autocast";

	String eNS_URI = "http://autocast.autocast.autocast/";

	String eNS_PREFIX = "autocast";

	AutocastPackage eINSTANCE = AutocastPackageImpl.init();

	int CONCEPT_A = 0;

	int CONCEPT_A_FEATURE_COUNT = 0;

	int CONCEPT_A_OPERATION_COUNT = 0;

	int CONCEPT_B = 1;

	int CONCEPT_B__NAME = 0;

	int CONCEPT_B_FEATURE_COUNT = CONCEPT_A_FEATURE_COUNT + 1;

	int CONCEPT_B_OPERATION_COUNT = CONCEPT_A_OPERATION_COUNT + 0;

	int CONCEPT_C = 2;

	int CONCEPT_C__AX = 0;

	int CONCEPT_C_FEATURE_COUNT = 1;

	int CONCEPT_C_OPERATION_COUNT = 0;

	EClass getConceptA();

	EClass getConceptB();

	EAttribute getConceptB_Name();

	EClass getConceptC();

	EReference getConceptC_Ax();

	AutocastFactory getAutocastFactory();

	interface Literals {
		EClass CONCEPT_A = eINSTANCE.getConceptA();

		EClass CONCEPT_B = eINSTANCE.getConceptB();

		EAttribute CONCEPT_B__NAME = eINSTANCE.getConceptB_Name();

		EClass CONCEPT_C = eINSTANCE.getConceptC();

		EReference CONCEPT_C__AX = eINSTANCE.getConceptC_Ax();
	}
}
