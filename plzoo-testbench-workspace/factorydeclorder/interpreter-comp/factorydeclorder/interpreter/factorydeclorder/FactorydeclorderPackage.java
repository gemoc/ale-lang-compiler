package factorydeclorder.interpreter.factorydeclorder;

import factorydeclorder.interpreter.factorydeclorder.impl.FactorydeclorderPackageImpl;
import java.lang.String;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

public interface FactorydeclorderPackage extends EPackage {
	String eNAME = "factorydeclorder";

	String eNS_URI = "http://factorydeclorder.factorydeclorder.factorydeclorder/";

	String eNS_PREFIX = "factorydeclorder";

	FactorydeclorderPackage eINSTANCE = FactorydeclorderPackageImpl.init();

	int B = 0;

	int B__FB = 0;

	int B_FEATURE_COUNT = 1;

	int B_OPERATION_COUNT = 0;

	int D = 1;

	int D_FEATURE_COUNT = 0;

	int D_OPERATION_COUNT = 0;

	int A = 2;

	int A__FB = B__FB;

	int A__FA = 1;

	int A_FEATURE_COUNT = D_FEATURE_COUNT + 1;

	int A_OPERATION_COUNT = D_OPERATION_COUNT + 0;

	int C = 3;

	int C__FB = B__FB;

	int C__FA = A__FA;

	int C__FC = 2;

	int C_FEATURE_COUNT = B_FEATURE_COUNT + 1;

	int C_OPERATION_COUNT = B_OPERATION_COUNT + 0;

	EClass getC();

	EAttribute getC_Fc();

	EClass getA();

	EAttribute getA_Fa();

	EClass getB();

	EAttribute getB_Fb();

	EClass getD();

	FactorydeclorderFactory getFactorydeclorderFactory();

	interface Literals {
		EClass B = eINSTANCE.getB();

		EAttribute B__FB = eINSTANCE.getB_Fb();

		EClass D = eINSTANCE.getD();

		EClass A = eINSTANCE.getA();

		EAttribute A__FA = eINSTANCE.getA_Fa();

		EClass C = eINSTANCE.getC();

		EAttribute C__FC = eINSTANCE.getC_Fc();
	}
}
