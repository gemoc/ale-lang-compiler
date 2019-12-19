package testaccessors.visitor.testaccessors;

import java.lang.String;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import testaccessors.visitor.testaccessors.impl.TestaccessorsPackageImpl;

public interface TestaccessorsPackage extends EPackage {
	String eNAME = "testaccessors";

	String eNS_URI = "http://testaccessors.testaccessors.testaccessors/";

	String eNS_PREFIX = "testaccessors";

	TestaccessorsPackage eINSTANCE = TestaccessorsPackageImpl.init();

	int EACC = 0;

	int EACC__B = 0;

	int EACC__I = 1;

	int EACC__BS = 2;

	int EACC__IS = 3;

	int EACC_FEATURE_COUNT = 4;

	int EACC_OPERATION_COUNT = 0;

	EClass getEAcc();

	EAttribute getEAcc_B();

	EAttribute getEAcc_I();

	EAttribute getEAcc_Bs();

	EAttribute getEAcc_Is();

	TestaccessorsFactory getTestaccessorsFactory();

	interface Literals {
		EClass EACC = eINSTANCE.getEAcc();

		EAttribute EACC__B = eINSTANCE.getEAcc_B();

		EAttribute EACC__I = eINSTANCE.getEAcc_I();

		EAttribute EACC__BS = eINSTANCE.getEAcc_Bs();

		EAttribute EACC__IS = eINSTANCE.getEAcc_Is();
	}
}
