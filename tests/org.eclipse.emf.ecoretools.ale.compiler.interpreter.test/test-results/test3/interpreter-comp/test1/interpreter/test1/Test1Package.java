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

	int CONCEPT_B = 1;

	int CONCEPT_C = 2;

	int CONCEPT_A__CS = 0;

	int CONCEPT_C__NBR = 0;

	EClass getConceptA();

	EClass getConceptB();

	EClass getConceptC();

	EReference getConceptA_Cs();

	EAttribute getConceptC_Nbr();

	Test1Factory getTest1Factory();

	interface Literals {
		EClass CONCEPT_A = eINSTANCE.getConceptA();

		EClass CONCEPT_B = eINSTANCE.getConceptB();

		EClass CONCEPT_C = eINSTANCE.getConceptC();

		EReference CONCEPT_A__CS = eINSTANCE.getConceptA_Cs();

		EAttribute CONCEPT_C__NBR = eINSTANCE.getConceptC_Nbr();
	}
}
