package kmLogo.interpreter.kmLogo.impl;

import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Override;
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
	public KmLogoFactoryImpl() {
		super();
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

	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case KmLogoPackage.BACK :
				return createBack();
			case KmLogoPackage.FORWARD :
				return createForward();
			case KmLogoPackage.LEFT :
				return createLeft();
			case KmLogoPackage.RIGHT :
				return createRight();
			case KmLogoPackage.PEN_DOWN :
				return createPenDown();
			case KmLogoPackage.PEN_UP :
				return createPenUp();
			case KmLogoPackage.CLEAR :
				return createClear();
			case KmLogoPackage.CONSTANT :
				return createConstant();
			case KmLogoPackage.PROC_CALL :
				return createProcCall();
			case KmLogoPackage.PROC_DECLARATION :
				return createProcDeclaration();
			case KmLogoPackage.BLOCK :
				return createBlock();
			case KmLogoPackage.IF :
				return createIf();
			case KmLogoPackage.CONTROL_STRUCTURE :
				return createControlStructure();
			case KmLogoPackage.REPEAT :
				return createRepeat();
			case KmLogoPackage.WHILE :
				return createWhile();
			case KmLogoPackage.PARAMETER :
				return createParameter();
			case KmLogoPackage.PARAMETER_CALL :
				return createParameterCall();
			case KmLogoPackage.PLUS :
				return createPlus();
			case KmLogoPackage.MINUS :
				return createMinus();
			case KmLogoPackage.MULT :
				return createMult();
			case KmLogoPackage.DIV :
				return createDiv();
			case KmLogoPackage.EQUALS :
				return createEquals();
			case KmLogoPackage.GREATER :
				return createGreater();
			case KmLogoPackage.LOWER :
				return createLower();
			case KmLogoPackage.COS :
				return createCos();
			case KmLogoPackage.SIN :
				return createSin();
			case KmLogoPackage.TAN :
				return createTan();
			case KmLogoPackage.LOGO_PROGRAM :
				return createLogoProgram();
			case KmLogoPackage.TURTLE :
				return createTurtle();
			case KmLogoPackage.POINT :
				return createPoint();
			case KmLogoPackage.SEGMENT :
				return createSegment();
			case KmLogoPackage.CALL_STACK :
				return createCallStack();
			case KmLogoPackage.STACK_FRAME :
				return createStackFrame();
			case KmLogoPackage.VARIABLE :
				return createVariable();
			default :
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	public Back createBack() {
		BackImpl back = new BackImpl();
		return back;
	}

	public Forward createForward() {
		ForwardImpl forward = new ForwardImpl();
		return forward;
	}

	public Left createLeft() {
		LeftImpl left = new LeftImpl();
		return left;
	}

	public Right createRight() {
		RightImpl right = new RightImpl();
		return right;
	}

	public PenDown createPenDown() {
		PenDownImpl penDown = new PenDownImpl();
		return penDown;
	}

	public PenUp createPenUp() {
		PenUpImpl penUp = new PenUpImpl();
		return penUp;
	}

	public Clear createClear() {
		ClearImpl clear = new ClearImpl();
		return clear;
	}

	public Constant createConstant() {
		ConstantImpl constant = new ConstantImpl();
		return constant;
	}

	public ProcCall createProcCall() {
		ProcCallImpl procCall = new ProcCallImpl();
		return procCall;
	}

	public ProcDeclaration createProcDeclaration() {
		ProcDeclarationImpl procDeclaration = new ProcDeclarationImpl();
		return procDeclaration;
	}

	public Block createBlock() {
		BlockImpl block = new BlockImpl();
		return block;
	}

	public If createIf() {
		IfImpl if_ = new IfImpl();
		return if_;
	}

	public ControlStructure createControlStructure() {
		ControlStructureImpl controlStructure = new ControlStructureImpl();
		return controlStructure;
	}

	public Repeat createRepeat() {
		RepeatImpl repeat = new RepeatImpl();
		return repeat;
	}

	public While createWhile() {
		WhileImpl while_ = new WhileImpl();
		return while_;
	}

	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	public ParameterCall createParameterCall() {
		ParameterCallImpl parameterCall = new ParameterCallImpl();
		return parameterCall;
	}

	public Plus createPlus() {
		PlusImpl plus = new PlusImpl();
		return plus;
	}

	public Minus createMinus() {
		MinusImpl minus = new MinusImpl();
		return minus;
	}

	public Mult createMult() {
		MultImpl mult = new MultImpl();
		return mult;
	}

	public Div createDiv() {
		DivImpl div = new DivImpl();
		return div;
	}

	public Equals createEquals() {
		EqualsImpl equals = new EqualsImpl();
		return equals;
	}

	public Greater createGreater() {
		GreaterImpl greater = new GreaterImpl();
		return greater;
	}

	public Lower createLower() {
		LowerImpl lower = new LowerImpl();
		return lower;
	}

	public Cos createCos() {
		CosImpl cos = new CosImpl();
		return cos;
	}

	public Sin createSin() {
		SinImpl sin = new SinImpl();
		return sin;
	}

	public Tan createTan() {
		TanImpl tan = new TanImpl();
		return tan;
	}

	public LogoProgram createLogoProgram() {
		LogoProgramImpl logoProgram = new LogoProgramImpl();
		return logoProgram;
	}

	public Turtle createTurtle() {
		TurtleImpl turtle = new TurtleImpl();
		return turtle;
	}

	public Point createPoint() {
		PointImpl point = new PointImpl();
		return point;
	}

	public Segment createSegment() {
		SegmentImpl segment = new SegmentImpl();
		return segment;
	}

	public CallStack createCallStack() {
		CallStackImpl callStack = new CallStackImpl();
		return callStack;
	}

	public StackFrame createStackFrame() {
		StackFrameImpl stackFrame = new StackFrameImpl();
		return stackFrame;
	}

	public Variable createVariable() {
		VariableImpl variable = new VariableImpl();
		return variable;
	}

	public KmLogoPackage getKmLogoPackage() {
		return (KmLogoPackage) getEPackage();
	}

	@Deprecated
	public static KmLogoPackage getPackage() {
		return KmLogoPackage.eINSTANCE;
	}
}
