package kmLogo.visitor.kmLogo;

import kmLogo.visitor.kmLogo.impl.KmLogoFactoryImpl;
import org.eclipse.emf.ecore.EFactory;

public interface KmLogoFactory extends EFactory {
  KmLogoFactory eINSTANCE = KmLogoFactoryImpl.init();

  Back createBack();

  Forward createForward();

  Left createLeft();

  Right createRight();

  PenDown createPenDown();

  PenUp createPenUp();

  Clear createClear();

  Constant createConstant();

  ProcCall createProcCall();

  ProcDeclaration createProcDeclaration();

  Block createBlock();

  If createIf();

  ControlStructure createControlStructure();

  Repeat createRepeat();

  While createWhile();

  Parameter createParameter();

  ParameterCall createParameterCall();

  Plus createPlus();

  Minus createMinus();

  Mult createMult();

  Div createDiv();

  Equals createEquals();

  Greater createGreater();

  Lower createLower();

  Cos createCos();

  Sin createSin();

  Tan createTan();

  LogoProgram createLogoProgram();

  Turtle createTurtle();

  Point createPoint();

  Segment createSegment();

  CallStack createCallStack();

  StackFrame createStackFrame();

  Variable createVariable();

  KmLogoPackage getKmLogoPackage();
}
