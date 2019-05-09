package testmaprelations.visitor.testmaprelations;

import org.eclipse.emf.ecore.EFactory;
import testmaprelations.visitor.testmaprelations.impl.TestmaprelationsFactoryImpl;

public interface TestmaprelationsFactory extends EFactory {
	TestmaprelationsFactory eINSTANCE = TestmaprelationsFactoryImpl.init();

	CA0 createCA0();

	CB0 createCB0();

	CB1 createCB1();

	CA1 createCA1();

	CA2 createCA2();

	CB2 createCB2();

	CB3 createCB3();

	CA3 createCA3();

	CA4 createCA4();

	CB4 createCB4();

	CA5 createCA5();

	CB5 createCB5();

	CA6 createCA6();

	CB6 createCB6();

	CA7 createCA7();

	CB7 createCB7();

	CA8 createCA8();

	CB8 createCB8();

	CB9 createCB9();

	CA9 createCA9();

	TestmaprelationsPackage getTestmaprelationsPackage();
}
