package kmLogo.interpreter.kmLogo.impl;

import java.lang.IllegalArgumentException;
import kmLogo.interpreter.kmLogo.Back;
import kmLogo.interpreter.kmLogo.Block;
import kmLogo.interpreter.kmLogo.CallStack;
import kmLogo.interpreter.kmLogo.Clear;
import kmLogo.interpreter.kmLogo.Constant;
import kmLogo.interpreter.kmLogo.ControlStructure;
import kmLogo.interpreter.kmLogo.Cos;
import kmLogo.interpreter.kmLogo.Div;
import kmLogo.interpreter.kmLogo.Equals;
import kmLogo.interpreter.kmLogo.Forward;
import kmLogo.interpreter.kmLogo.Greater;
import kmLogo.interpreter.kmLogo.If;
import kmLogo.interpreter.kmLogo.KmLogoFactory;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.Left;
import kmLogo.interpreter.kmLogo.LogoProgram;
import kmLogo.interpreter.kmLogo.Lower;
import kmLogo.interpreter.kmLogo.Minus;
import kmLogo.interpreter.kmLogo.Mult;
import kmLogo.interpreter.kmLogo.Parameter;
import kmLogo.interpreter.kmLogo.ParameterCall;
import kmLogo.interpreter.kmLogo.PenDown;
import kmLogo.interpreter.kmLogo.PenUp;
import kmLogo.interpreter.kmLogo.Plus;
import kmLogo.interpreter.kmLogo.Point;
import kmLogo.interpreter.kmLogo.ProcCall;
import kmLogo.interpreter.kmLogo.ProcDeclaration;
import kmLogo.interpreter.kmLogo.Repeat;
import kmLogo.interpreter.kmLogo.Right;
import kmLogo.interpreter.kmLogo.Segment;
import kmLogo.interpreter.kmLogo.Sin;
import kmLogo.interpreter.kmLogo.StackFrame;
import kmLogo.interpreter.kmLogo.Tan;
import kmLogo.interpreter.kmLogo.Turtle;
import kmLogo.interpreter.kmLogo.Variable;
import kmLogo.interpreter.kmLogo.While;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

public class KmLogoFactoryImpl extends EFactoryImpl implements KmLogoFactory {
  private KmLogoFactoryImpl() {
  }

  public static KmLogoFactory init() {
    try {
    	KmLogoFactory theKmLogoFactory = (KmLogoFactory) EPackage.Registry.INSTANCE.getEFactory(KmLogoPackage.eNS_URI);
    	if (theKmLogoFactory != null) {
    		return theKmLogoFactory;
    	}
    } catch (Exception exception) {
    	EcorePlugin.INSTANCE.log(exception);
    }
    return new KmLogoFactoryImpl();
  }

  public EObject create(EClass eClass) {
    switch (eClass.getClassifierID()) {
    case KmLogoPackage.BACK:
    	return createBack();
    case KmLogoPackage.FORWARD:
    	return createForward();
    case KmLogoPackage.LEFT:
    	return createLeft();
    case KmLogoPackage.RIGHT:
    	return createRight();
    case KmLogoPackage.PEN_DOWN:
    	return createPenDown();
    case KmLogoPackage.PEN_UP:
    	return createPenUp();
    case KmLogoPackage.CLEAR:
    	return createClear();
    case KmLogoPackage.CONSTANT:
    	return createConstant();
    case KmLogoPackage.PROC_CALL:
    	return createProcCall();
    case KmLogoPackage.PROC_DECLARATION:
    	return createProcDeclaration();
    case KmLogoPackage.BLOCK:
    	return createBlock();
    case KmLogoPackage.IF:
    	return createIf();
    case KmLogoPackage.CONTROL_STRUCTURE:
    	return createControlStructure();
    case KmLogoPackage.REPEAT:
    	return createRepeat();
    case KmLogoPackage.WHILE:
    	return createWhile();
    case KmLogoPackage.PARAMETER:
    	return createParameter();
    case KmLogoPackage.PARAMETER_CALL:
    	return createParameterCall();
    case KmLogoPackage.PLUS:
    	return createPlus();
    case KmLogoPackage.MINUS:
    	return createMinus();
    case KmLogoPackage.MULT:
    	return createMult();
    case KmLogoPackage.DIV:
    	return createDiv();
    case KmLogoPackage.EQUALS:
    	return createEquals();
    case KmLogoPackage.GREATER:
    	return createGreater();
    case KmLogoPackage.LOWER:
    	return createLower();
    case KmLogoPackage.COS:
    	return createCos();
    case KmLogoPackage.SIN:
    	return createSin();
    case KmLogoPackage.TAN:
    	return createTan();
    case KmLogoPackage.LOGO_PROGRAM:
    	return createLogoProgram();
    case KmLogoPackage.TURTLE:
    	return createTurtle();
    case KmLogoPackage.POINT:
    	return createPoint();
    case KmLogoPackage.SEGMENT:
    	return createSegment();
    case KmLogoPackage.CALL_STACK:
    	return createCallStack();
    case KmLogoPackage.STACK_FRAME:
    	return createStackFrame();
    case KmLogoPackage.VARIABLE:
    	return createVariable();
    default:
    	throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  public Back createBack() {
    BackImpl ret = new BackImpl();
    return ret;
  }

  public Forward createForward() {
    ForwardImpl ret = new ForwardImpl();
    return ret;
  }

  public Left createLeft() {
    LeftImpl ret = new LeftImpl();
    return ret;
  }

  public Right createRight() {
    RightImpl ret = new RightImpl();
    return ret;
  }

  public PenDown createPenDown() {
    PenDownImpl ret = new PenDownImpl();
    return ret;
  }

  public PenUp createPenUp() {
    PenUpImpl ret = new PenUpImpl();
    return ret;
  }

  public Clear createClear() {
    ClearImpl ret = new ClearImpl();
    return ret;
  }

  public Constant createConstant() {
    ConstantImpl ret = new ConstantImpl();
    return ret;
  }

  public ProcCall createProcCall() {
    ProcCallImpl ret = new ProcCallImpl();
    return ret;
  }

  public ProcDeclaration createProcDeclaration() {
    ProcDeclarationImpl ret = new ProcDeclarationImpl();
    return ret;
  }

  public Block createBlock() {
    BlockImpl ret = new BlockImpl();
    return ret;
  }

  public If createIf() {
    IfImpl ret = new IfImpl();
    return ret;
  }

  public ControlStructure createControlStructure() {
    ControlStructureImpl ret = new ControlStructureImpl();
    return ret;
  }

  public Repeat createRepeat() {
    RepeatImpl ret = new RepeatImpl();
    return ret;
  }

  public While createWhile() {
    WhileImpl ret = new WhileImpl();
    return ret;
  }

  public Parameter createParameter() {
    ParameterImpl ret = new ParameterImpl();
    return ret;
  }

  public ParameterCall createParameterCall() {
    ParameterCallImpl ret = new ParameterCallImpl();
    return ret;
  }

  public Plus createPlus() {
    PlusImpl ret = new PlusImpl();
    return ret;
  }

  public Minus createMinus() {
    MinusImpl ret = new MinusImpl();
    return ret;
  }

  public Mult createMult() {
    MultImpl ret = new MultImpl();
    return ret;
  }

  public Div createDiv() {
    DivImpl ret = new DivImpl();
    return ret;
  }

  public Equals createEquals() {
    EqualsImpl ret = new EqualsImpl();
    return ret;
  }

  public Greater createGreater() {
    GreaterImpl ret = new GreaterImpl();
    return ret;
  }

  public Lower createLower() {
    LowerImpl ret = new LowerImpl();
    return ret;
  }

  public Cos createCos() {
    CosImpl ret = new CosImpl();
    return ret;
  }

  public Sin createSin() {
    SinImpl ret = new SinImpl();
    return ret;
  }

  public Tan createTan() {
    TanImpl ret = new TanImpl();
    return ret;
  }

  public LogoProgram createLogoProgram() {
    LogoProgramImpl ret = new LogoProgramImpl();
    return ret;
  }

  public Turtle createTurtle() {
    TurtleImpl ret = new TurtleImpl();
    return ret;
  }

  public Point createPoint() {
    PointImpl ret = new PointImpl();
    return ret;
  }

  public Segment createSegment() {
    SegmentImpl ret = new SegmentImpl();
    return ret;
  }

  public CallStack createCallStack() {
    CallStackImpl ret = new CallStackImpl();
    return ret;
  }

  public StackFrame createStackFrame() {
    StackFrameImpl ret = new StackFrameImpl();
    return ret;
  }

  public Variable createVariable() {
    VariableImpl ret = new VariableImpl();
    return ret;
  }
}
