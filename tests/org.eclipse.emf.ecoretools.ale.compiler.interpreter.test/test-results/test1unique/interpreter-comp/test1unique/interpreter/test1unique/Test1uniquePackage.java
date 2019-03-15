package test1unique.interpreter.test1unique;

import java.lang.String;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import test1unique.interpreter.test1unique.impl.Test1uniquePackageImpl;

public interface Test1uniquePackage extends EPackage {
	String eNAME = "test1unique";

	Test1uniquePackage eINSTANCE = Test1uniquePackageImpl.init();

	String eNS_PREFIX = "test1unique";

	String eNS_URI = "http://test1unique.test1unique.test1unique/";

	int CONCEPT_A = 0;

	int CONCEPT_A__BS = 0;

	int CONCEPT_A_FEATURE_COUNT = 1;

	int CONCEPT_A_OPERATION_COUNT = 0;

	EClass getConceptA();

	EAttribute getConceptA_Bs();

	Test1uniqueFactory getTest1uniqueFactory();

	interface Literals {
		EClass CONCEPT_A = eINSTANCE.getConceptA();

		EAttribute CONCEPT_A__BS = eINSTANCE.getConceptA_Bs();
	}
}
