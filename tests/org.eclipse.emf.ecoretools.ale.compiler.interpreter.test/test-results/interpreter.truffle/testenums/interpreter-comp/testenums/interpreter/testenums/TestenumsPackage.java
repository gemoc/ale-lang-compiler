package testenums.interpreter.testenums;

import java.lang.String;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import testenums.interpreter.testenums.impl.TestenumsPackageImpl;

public interface TestenumsPackage extends EPackage {
	String eNAME = "testenums";

	String eNS_URI = "http://testenums.testenums.testenums/";

	String eNS_PREFIX = "testenums";

	TestenumsPackage eINSTANCE = TestenumsPackageImpl.init();

	int ROOT = 0;

	int ROOT__ENUM = 0;

	int ROOT__ENUMS = 1;

	int ROOT_FEATURE_COUNT = 2;

	int ROOT_OPERATION_COUNT = 0;

	int ENUM1 = 1;

	EClass getRoot();

	EAttribute getRoot_Enum();

	EAttribute getRoot_Enums();

	EEnum getEnum1();

	TestenumsFactory getTestenumsFactory();

	interface Literals {
		EClass ROOT = eINSTANCE.getRoot();

		EAttribute ROOT__ENUM = eINSTANCE.getRoot_Enum();

		EAttribute ROOT__ENUMS = eINSTANCE.getRoot_Enums();

		EEnum ENUM1 = eINSTANCE.getEnum1();
	}
}
