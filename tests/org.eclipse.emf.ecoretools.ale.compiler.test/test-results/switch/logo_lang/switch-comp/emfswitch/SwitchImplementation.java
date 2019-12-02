package emfswitch;

import emfswitch.operation.BackOperation;
import emfswitch.operation.BinaryExpOperation;
import emfswitch.operation.BlockOperation;
import emfswitch.operation.CallStackOperation;
import emfswitch.operation.ClearOperation;
import emfswitch.operation.ConstantOperation;
import emfswitch.operation.ControlStructureOperation;
import emfswitch.operation.CosOperation;
import emfswitch.operation.DivOperation;
import emfswitch.operation.EqualsOperation;
import emfswitch.operation.ExpressionOperation;
import emfswitch.operation.ForwardOperation;
import emfswitch.operation.GreaterOperation;
import emfswitch.operation.IfOperation;
import emfswitch.operation.InstructionOperation;
import emfswitch.operation.LeftOperation;
import emfswitch.operation.LogoProgramOperation;
import emfswitch.operation.LowerOperation;
import emfswitch.operation.MinusOperation;
import emfswitch.operation.MultOperation;
import emfswitch.operation.ParameterCallOperation;
import emfswitch.operation.ParameterOperation;
import emfswitch.operation.PenDownOperation;
import emfswitch.operation.PenUpOperation;
import emfswitch.operation.PlusOperation;
import emfswitch.operation.PointOperation;
import emfswitch.operation.PrimitiveOperation;
import emfswitch.operation.ProcCallOperation;
import emfswitch.operation.ProcDeclarationOperation;
import emfswitch.operation.RepeatOperation;
import emfswitch.operation.RightOperation;
import emfswitch.operation.SegmentOperation;
import emfswitch.operation.SinOperation;
import emfswitch.operation.StackFrameOperation;
import emfswitch.operation.TanOperation;
import emfswitch.operation.TurtleOperation;
import emfswitch.operation.UnaryExpressionOperation;
import emfswitch.operation.VariableOperation;
import emfswitch.operation.WhileOperation;
import java.lang.Object;
import java.lang.Override;
import kmLogo.Back;
import kmLogo.BinaryExp;
import kmLogo.Block;
import kmLogo.CallStack;
import kmLogo.Clear;
import kmLogo.Constant;
import kmLogo.ControlStructure;
import kmLogo.Cos;
import kmLogo.Div;
import kmLogo.Equals;
import kmLogo.Expression;
import kmLogo.Forward;
import kmLogo.Greater;
import kmLogo.If;
import kmLogo.Instruction;
import kmLogo.Left;
import kmLogo.LogoProgram;
import kmLogo.Lower;
import kmLogo.Minus;
import kmLogo.Mult;
import kmLogo.Parameter;
import kmLogo.ParameterCall;
import kmLogo.PenDown;
import kmLogo.PenUp;
import kmLogo.Plus;
import kmLogo.Point;
import kmLogo.Primitive;
import kmLogo.ProcCall;
import kmLogo.ProcDeclaration;
import kmLogo.Repeat;
import kmLogo.Right;
import kmLogo.Segment;
import kmLogo.Sin;
import kmLogo.StackFrame;
import kmLogo.Tan;
import kmLogo.Turtle;
import kmLogo.UnaryExpression;
import kmLogo.Variable;
import kmLogo.While;
import kmLogo.util.KmLogoSwitch;

public class SwitchImplementation extends KmLogoSwitch<Object> {
	@Override
	public Object caseInstruction(Instruction it) {
		return new InstructionOperation(it, this);
	}

	@Override
	public Object casePrimitive(Primitive it) {
		return new PrimitiveOperation(it, this);
	}

	@Override
	public Object caseBack(Back it) {
		return new BackOperation(it, this);
	}

	@Override
	public Object caseForward(Forward it) {
		return new ForwardOperation(it, this);
	}

	@Override
	public Object caseLeft(Left it) {
		return new LeftOperation(it, this);
	}

	@Override
	public Object caseRight(Right it) {
		return new RightOperation(it, this);
	}

	@Override
	public Object casePenDown(PenDown it) {
		return new PenDownOperation(it, this);
	}

	@Override
	public Object casePenUp(PenUp it) {
		return new PenUpOperation(it, this);
	}

	@Override
	public Object caseClear(Clear it) {
		return new ClearOperation(it, this);
	}

	@Override
	public Object caseExpression(Expression it) {
		return new ExpressionOperation(it, this);
	}

	@Override
	public Object caseBinaryExp(BinaryExp it) {
		return new BinaryExpOperation(it, this);
	}

	@Override
	public Object caseUnaryExpression(UnaryExpression it) {
		return new UnaryExpressionOperation(it, this);
	}

	@Override
	public Object caseConstant(Constant it) {
		return new ConstantOperation(it, this);
	}

	@Override
	public Object caseProcCall(ProcCall it) {
		return new ProcCallOperation(it, this);
	}

	@Override
	public Object caseProcDeclaration(ProcDeclaration it) {
		return new ProcDeclarationOperation(it, this);
	}

	@Override
	public Object caseBlock(Block it) {
		return new BlockOperation(it, this);
	}

	@Override
	public Object caseIf(If it) {
		return new IfOperation(it, this);
	}

	@Override
	public Object caseControlStructure(ControlStructure it) {
		return new ControlStructureOperation(it, this);
	}

	@Override
	public Object caseRepeat(Repeat it) {
		return new RepeatOperation(it, this);
	}

	@Override
	public Object caseWhile(While it) {
		return new WhileOperation(it, this);
	}

	@Override
	public Object caseParameter(Parameter it) {
		return new ParameterOperation(it, this);
	}

	@Override
	public Object caseParameterCall(ParameterCall it) {
		return new ParameterCallOperation(it, this);
	}

	@Override
	public Object casePlus(Plus it) {
		return new PlusOperation(it, this);
	}

	@Override
	public Object caseMinus(Minus it) {
		return new MinusOperation(it, this);
	}

	@Override
	public Object caseMult(Mult it) {
		return new MultOperation(it, this);
	}

	@Override
	public Object caseDiv(Div it) {
		return new DivOperation(it, this);
	}

	@Override
	public Object caseEquals(Equals it) {
		return new EqualsOperation(it, this);
	}

	@Override
	public Object caseGreater(Greater it) {
		return new GreaterOperation(it, this);
	}

	@Override
	public Object caseLower(Lower it) {
		return new LowerOperation(it, this);
	}

	@Override
	public Object caseCos(Cos it) {
		return new CosOperation(it, this);
	}

	@Override
	public Object caseSin(Sin it) {
		return new SinOperation(it, this);
	}

	@Override
	public Object caseTan(Tan it) {
		return new TanOperation(it, this);
	}

	@Override
	public Object caseLogoProgram(LogoProgram it) {
		return new LogoProgramOperation(it, this);
	}

	@Override
	public Object caseTurtle(Turtle it) {
		return new TurtleOperation(it, this);
	}

	@Override
	public Object casePoint(Point it) {
		return new PointOperation(it, this);
	}

	@Override
	public Object caseSegment(Segment it) {
		return new SegmentOperation(it, this);
	}

	@Override
	public Object caseCallStack(CallStack it) {
		return new CallStackOperation(it, this);
	}

	@Override
	public Object caseStackFrame(StackFrame it) {
		return new StackFrameOperation(it, this);
	}

	@Override
	public Object caseVariable(Variable it) {
		return new VariableOperation(it, this);
	}
}
