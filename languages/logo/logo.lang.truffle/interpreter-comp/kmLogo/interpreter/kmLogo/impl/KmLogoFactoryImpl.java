package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Override;
import kmLogo.interpreter.kmLogo.KmLogoFactory;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
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
	@TruffleBoundary
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

	@TruffleBoundary
	public BackImpl createBack() {
		BackImpl back = new BackImpl();
		return back;
	}

	@TruffleBoundary
	public ForwardImpl createForward() {
		ForwardImpl forward = new ForwardImpl();
		return forward;
	}

	@TruffleBoundary
	public LeftImpl createLeft() {
		LeftImpl left = new LeftImpl();
		return left;
	}

	@TruffleBoundary
	public RightImpl createRight() {
		RightImpl right = new RightImpl();
		return right;
	}

	@TruffleBoundary
	public PenDownImpl createPenDown() {
		PenDownImpl penDown = new PenDownImpl();
		return penDown;
	}

	@TruffleBoundary
	public PenUpImpl createPenUp() {
		PenUpImpl penUp = new PenUpImpl();
		return penUp;
	}

	@TruffleBoundary
	public ClearImpl createClear() {
		ClearImpl clear = new ClearImpl();
		return clear;
	}

	@TruffleBoundary
	public ConstantImpl createConstant() {
		ConstantImpl constant = new ConstantImpl();
		return constant;
	}

	@TruffleBoundary
	public ProcCallImpl createProcCall() {
		ProcCallImpl procCall = new ProcCallImpl();
		return procCall;
	}

	@TruffleBoundary
	public ProcDeclarationImpl createProcDeclaration() {
		ProcDeclarationImpl procDeclaration = new ProcDeclarationImpl();
		return procDeclaration;
	}

	@TruffleBoundary
	public BlockImpl createBlock() {
		BlockImpl block = new BlockImpl();
		return block;
	}

	@TruffleBoundary
	public IfImpl createIf() {
		IfImpl if_ = new IfImpl();
		return if_;
	}

	@TruffleBoundary
	public ControlStructureImpl createControlStructure() {
		ControlStructureImpl controlStructure = new ControlStructureImpl();
		return controlStructure;
	}

	@TruffleBoundary
	public RepeatImpl createRepeat() {
		RepeatImpl repeat = new RepeatImpl();
		return repeat;
	}

	@TruffleBoundary
	public WhileImpl createWhile() {
		WhileImpl while_ = new WhileImpl();
		return while_;
	}

	@TruffleBoundary
	public ParameterImpl createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	@TruffleBoundary
	public ParameterCallImpl createParameterCall() {
		ParameterCallImpl parameterCall = new ParameterCallImpl();
		return parameterCall;
	}

	@TruffleBoundary
	public PlusImpl createPlus() {
		PlusImpl plus = new PlusImpl();
		return plus;
	}

	@TruffleBoundary
	public MinusImpl createMinus() {
		MinusImpl minus = new MinusImpl();
		return minus;
	}

	@TruffleBoundary
	public MultImpl createMult() {
		MultImpl mult = new MultImpl();
		return mult;
	}

	@TruffleBoundary
	public DivImpl createDiv() {
		DivImpl div = new DivImpl();
		return div;
	}

	@TruffleBoundary
	public EqualsImpl createEquals() {
		EqualsImpl equals = new EqualsImpl();
		return equals;
	}

	@TruffleBoundary
	public GreaterImpl createGreater() {
		GreaterImpl greater = new GreaterImpl();
		return greater;
	}

	@TruffleBoundary
	public LowerImpl createLower() {
		LowerImpl lower = new LowerImpl();
		return lower;
	}

	@TruffleBoundary
	public CosImpl createCos() {
		CosImpl cos = new CosImpl();
		return cos;
	}

	@TruffleBoundary
	public SinImpl createSin() {
		SinImpl sin = new SinImpl();
		return sin;
	}

	@TruffleBoundary
	public TanImpl createTan() {
		TanImpl tan = new TanImpl();
		return tan;
	}

	@TruffleBoundary
	public LogoProgramImpl createLogoProgram() {
		LogoProgramImpl logoProgram = new LogoProgramImpl();
		return logoProgram;
	}

	@TruffleBoundary
	public TurtleImpl createTurtle() {
		TurtleImpl turtle = new TurtleImpl();
		return turtle;
	}

	@TruffleBoundary
	public PointImpl createPoint() {
		PointImpl point = new PointImpl();
		return point;
	}

	@TruffleBoundary
	public SegmentImpl createSegment() {
		SegmentImpl segment = new SegmentImpl();
		return segment;
	}

	@TruffleBoundary
	public CallStackImpl createCallStack() {
		CallStackImpl callStack = new CallStackImpl();
		return callStack;
	}

	@TruffleBoundary
	public StackFrameImpl createStackFrame() {
		StackFrameImpl stackFrame = new StackFrameImpl();
		return stackFrame;
	}

	@TruffleBoundary
	public VariableImpl createVariable() {
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
