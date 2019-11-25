package test.interpreter.test.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.String;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import test.interpreter.test.A;
import test.interpreter.test.B;
import test.interpreter.test.C;
import test.interpreter.test.Program;
import test.interpreter.test.TestFactory;
import test.interpreter.test.TestPackage;

public class TestFactoryImpl extends EFactoryImpl implements TestFactory {
  public TestFactoryImpl() {
  }

  public static TestFactory init() {
    try {
    	TestFactory theTestFactory = (TestFactory) EPackage.Registry.INSTANCE.getEFactory(TestPackage.eNS_URI);
    	if (theTestFactory != null) {
    		return theTestFactory;
    	}
    } catch (Exception exception) {
    	EcorePlugin.INSTANCE.log(exception);
    }
    return new TestFactoryImpl();
  }

  @TruffleBoundary
  public EObject create(EClass eClass) {
    switch (eClass.getClassifierID()) {
    case TestPackage.A:
    	return createA();
    case TestPackage.B:
    	return createB();
    case TestPackage.C:
    	return createC();
    case TestPackage.PROGRAM:
    	return createProgram();
    default:
    	throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  public Object createFromString(EDataType eDataType, String initialValue) {
    switch (eDataType.getClassifierID()) {
    default:
    	throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  public String convertToString(EDataType eDataType, Object instanceValue) {
    switch (eDataType.getClassifierID()) {
    default:
    	throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  public TestPackage getTestPackage() {
    return (TestPackage)getEPackage();}

  @TruffleBoundary
  public A createA() {
    AImpl ret = new AImpl();
    return ret;
  }

  @TruffleBoundary
  public B createB() {
    BImpl ret = new BImpl();
    return ret;
  }

  @TruffleBoundary
  public C createC() {
    CImpl ret = new CImpl();
    return ret;
  }

  @TruffleBoundary
  public Program createProgram() {
    ProgramImpl ret = new ProgramImpl();
    return ret;
  }
}
