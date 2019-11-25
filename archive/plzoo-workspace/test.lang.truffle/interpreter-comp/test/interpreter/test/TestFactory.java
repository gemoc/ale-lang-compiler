package test.interpreter.test;

import org.eclipse.emf.ecore.EFactory;
import test.interpreter.test.impl.TestFactoryImpl;

public interface TestFactory extends EFactory {
  TestFactory eINSTANCE = TestFactoryImpl.init();

  A createA();

  B createB();

  C createC();

  Program createProgram();

  TestPackage getTestPackage();
}
