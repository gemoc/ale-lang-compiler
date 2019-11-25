package test1.visitor.test1;

import java.lang.String;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import test1.visitor.test1.impl.Test1PackageImpl;

public interface Test1Package extends EPackage {
	String eNAME = "test1";

	String eNS_URI = "http://test1.test1.test1/";

	String eNS_PREFIX = "test1";

	Test1Package eINSTANCE = Test1PackageImpl.init();

	int CONCEPT_A = 0;

	int CONCEPT_A__BS = 0;

	int CONCEPT_A__B = 1;

	int CONCEPT_A_FEATURE_COUNT = 2;

	int CONCEPT_A_OPERATION_COUNT = 0;

	EClass getConceptA();

	EAttribute getConceptA_Bs();

	EAttribute getConceptA_B();

	Test1Factory getTest1Factory();

	interface Literals {
		EClass CONCEPT_A = eINSTANCE.getConceptA();

		EAttribute CONCEPT_A__BS = eINSTANCE.getConceptA_Bs();

		EAttribute CONCEPT_A__B = eINSTANCE.getConceptA_B();
	}
}
