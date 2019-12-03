package emapvselistentry.visitor.emapvselistentry;

import emapvselistentry.visitor.emapvselistentry.impl.EmapvselistentryPackageImpl;
import java.lang.String;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

public interface EmapvselistentryPackage extends EPackage {
	String eNAME = "emapvselistentry";

	String eNS_URI = "http://emapvselistentry.emapvselistentry.emapvselistentry/";

	String eNS_PREFIX = "emapvselistentry";

	EmapvselistentryPackage eINSTANCE = EmapvselistentryPackageImpl.init();

	int NEW_ECLASS1 = 0;

	int NEW_ECLASS1__NEWECLASS2 = 0;

	int NEW_ECLASS1__NEWECLASS3 = 1;

	int NEW_ECLASS1__NEWECLASS4 = 2;

	int NEW_ECLASS1__NEWECLASS5 = 3;

	int NEW_ECLASS1_FEATURE_COUNT = 4;

	int NEW_ECLASS1_OPERATION_COUNT = 0;

	int NEW_ECLASS2 = 1;

	int NEW_ECLASS2__KEY = 0;

	int NEW_ECLASS2__VALUE = 1;

	int NEW_ECLASS2_FEATURE_COUNT = 2;

	int NEW_ECLASS2_OPERATION_COUNT = 0;

	int NEW_ECLASS3 = 2;

	int NEW_ECLASS3__KEY = 0;

	int NEW_ECLASS3__VALUE = 1;

	int NEW_ECLASS3_FEATURE_COUNT = 2;

	int NEW_ECLASS3_OPERATION_COUNT = 0;

	int NEW_ECLASS4 = 3;

	int NEW_ECLASS4__KEY = 0;

	int NEW_ECLASS4__VALUE = 1;

	int NEW_ECLASS4_FEATURE_COUNT = 2;

	int NEW_ECLASS4_OPERATION_COUNT = 0;

	int NEW_ECLASS5 = 4;

	int NEW_ECLASS5__KEY = 0;

	int NEW_ECLASS5__VALUE = 1;

	int NEW_ECLASS5_FEATURE_COUNT = 2;

	int NEW_ECLASS5_OPERATION_COUNT = 0;

	EClass getNewEClass1();

	EReference getNewEClass1_Neweclass2();

	EReference getNewEClass1_Neweclass3();

	EReference getNewEClass1_Neweclass4();

	EReference getNewEClass1_Neweclass5();

	EClass getNewEClass2();

	EAttribute getNewEClass2_Key();

	EAttribute getNewEClass2_Value();

	EClass getNewEClass3();

	EAttribute getNewEClass3_Key();

	EAttribute getNewEClass3_Value();

	EClass getNewEClass4();

	EAttribute getNewEClass4_Key();

	EAttribute getNewEClass4_Value();

	EClass getNewEClass5();

	EAttribute getNewEClass5_Key();

	EAttribute getNewEClass5_Value();

	EmapvselistentryFactory getEmapvselistentryFactory();

	interface Literals {
		EClass NEW_ECLASS1 = eINSTANCE.getNewEClass1();

		EReference NEW_ECLASS1__NEWECLASS2 = eINSTANCE.getNewEClass1_Neweclass2();

		EReference NEW_ECLASS1__NEWECLASS3 = eINSTANCE.getNewEClass1_Neweclass3();

		EReference NEW_ECLASS1__NEWECLASS4 = eINSTANCE.getNewEClass1_Neweclass4();

		EReference NEW_ECLASS1__NEWECLASS5 = eINSTANCE.getNewEClass1_Neweclass5();

		EClass NEW_ECLASS2 = eINSTANCE.getNewEClass2();

		EAttribute NEW_ECLASS2__KEY = eINSTANCE.getNewEClass2_Key();

		EAttribute NEW_ECLASS2__VALUE = eINSTANCE.getNewEClass2_Value();

		EClass NEW_ECLASS3 = eINSTANCE.getNewEClass3();

		EAttribute NEW_ECLASS3__KEY = eINSTANCE.getNewEClass3_Key();

		EAttribute NEW_ECLASS3__VALUE = eINSTANCE.getNewEClass3_Value();

		EClass NEW_ECLASS4 = eINSTANCE.getNewEClass4();

		EAttribute NEW_ECLASS4__KEY = eINSTANCE.getNewEClass4_Key();

		EAttribute NEW_ECLASS4__VALUE = eINSTANCE.getNewEClass4_Value();

		EClass NEW_ECLASS5 = eINSTANCE.getNewEClass5();

		EAttribute NEW_ECLASS5__KEY = eINSTANCE.getNewEClass5_Key();

		EAttribute NEW_ECLASS5__VALUE = eINSTANCE.getNewEClass5_Value();
	}
}
