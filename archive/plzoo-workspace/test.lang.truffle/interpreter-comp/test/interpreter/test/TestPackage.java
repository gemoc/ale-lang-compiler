package test.interpreter.test;

import java.lang.String;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import test.interpreter.test.impl.TestPackageImpl;

public interface TestPackage extends EPackage {
  TestPackage eINSTANCE = TestPackageImpl.init();

  String eNS_URI = "http://test.test.test/";

  String eNAME = "test";

  String eNS_PREFIX = "test";

  int A = 0;

  int B = 1;

  int C = 2;

  int PROGRAM = 3;

  int C__B = 0;

  int C__A = 1;

  int PROGRAM__AS = 0;

  int PROGRAM__CS = 1;

  EClass getA();

  EClass getB();

  EClass getC();

  EClass getProgram();

  EReference getC_B();

  EReference getC_A();

  EReference getProgram_As();

  EReference getProgram_Cs();

  TestFactory getTestFactory();

  interface Literals {
    EClass A = eINSTANCE.getA();

    EClass B = eINSTANCE.getB();

    EClass C = eINSTANCE.getC();

    EClass PROGRAM = eINSTANCE.getProgram();

    EReference C__B = eINSTANCE.getC_B();

    EReference C__A = eINSTANCE.getC_A();

    EReference PROGRAM__AS = eINSTANCE.getProgram_As();

    EReference PROGRAM__CS = eINSTANCE.getProgram_Cs();
  }
}
