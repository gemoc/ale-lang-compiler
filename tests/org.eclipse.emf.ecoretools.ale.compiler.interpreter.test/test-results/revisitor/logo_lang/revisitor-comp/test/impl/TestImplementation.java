package test.impl;

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
import kmLogo.revisitor.KmLogoRevisitor;
import test.impl.operation.BackOp;
import test.impl.operation.BinaryExpOp;
import test.impl.operation.BlockOp;
import test.impl.operation.CallStackOp;
import test.impl.operation.ClearOp;
import test.impl.operation.ConstantOp;
import test.impl.operation.ControlStructureOp;
import test.impl.operation.CosOp;
import test.impl.operation.DivOp;
import test.impl.operation.EqualsOp;
import test.impl.operation.ExpressionOp;
import test.impl.operation.ForwardOp;
import test.impl.operation.GreaterOp;
import test.impl.operation.IfOp;
import test.impl.operation.InstructionOp;
import test.impl.operation.LeftOp;
import test.impl.operation.LogoProgramOp;
import test.impl.operation.LowerOp;
import test.impl.operation.MinusOp;
import test.impl.operation.MultOp;
import test.impl.operation.ParameterCallOp;
import test.impl.operation.ParameterOp;
import test.impl.operation.PenDownOp;
import test.impl.operation.PenUpOp;
import test.impl.operation.PlusOp;
import test.impl.operation.PointOp;
import test.impl.operation.PrimitiveOp;
import test.impl.operation.ProcCallOp;
import test.impl.operation.ProcDeclarationOp;
import test.impl.operation.RepeatOp;
import test.impl.operation.RightOp;
import test.impl.operation.SegmentOp;
import test.impl.operation.SinOp;
import test.impl.operation.StackFrameOp;
import test.impl.operation.TanOp;
import test.impl.operation.TurtleOp;
import test.impl.operation.UnaryExpressionOp;
import test.impl.operation.VariableOp;
import test.impl.operation.WhileOp;
import test.impl.operation.impl.BackOpImpl;
import test.impl.operation.impl.BinaryExpOpImpl;
import test.impl.operation.impl.BlockOpImpl;
import test.impl.operation.impl.CallStackOpImpl;
import test.impl.operation.impl.ClearOpImpl;
import test.impl.operation.impl.ConstantOpImpl;
import test.impl.operation.impl.ControlStructureOpImpl;
import test.impl.operation.impl.CosOpImpl;
import test.impl.operation.impl.DivOpImpl;
import test.impl.operation.impl.EqualsOpImpl;
import test.impl.operation.impl.ExpressionOpImpl;
import test.impl.operation.impl.ForwardOpImpl;
import test.impl.operation.impl.GreaterOpImpl;
import test.impl.operation.impl.IfOpImpl;
import test.impl.operation.impl.InstructionOpImpl;
import test.impl.operation.impl.LeftOpImpl;
import test.impl.operation.impl.LogoProgramOpImpl;
import test.impl.operation.impl.LowerOpImpl;
import test.impl.operation.impl.MinusOpImpl;
import test.impl.operation.impl.MultOpImpl;
import test.impl.operation.impl.ParameterCallOpImpl;
import test.impl.operation.impl.ParameterOpImpl;
import test.impl.operation.impl.PenDownOpImpl;
import test.impl.operation.impl.PenUpOpImpl;
import test.impl.operation.impl.PlusOpImpl;
import test.impl.operation.impl.PointOpImpl;
import test.impl.operation.impl.PrimitiveOpImpl;
import test.impl.operation.impl.ProcCallOpImpl;
import test.impl.operation.impl.ProcDeclarationOpImpl;
import test.impl.operation.impl.RepeatOpImpl;
import test.impl.operation.impl.RightOpImpl;
import test.impl.operation.impl.SegmentOpImpl;
import test.impl.operation.impl.SinOpImpl;
import test.impl.operation.impl.StackFrameOpImpl;
import test.impl.operation.impl.TanOpImpl;
import test.impl.operation.impl.TurtleOpImpl;
import test.impl.operation.impl.UnaryExpressionOpImpl;
import test.impl.operation.impl.VariableOpImpl;
import test.impl.operation.impl.WhileOpImpl;

public interface TestImplementation extends KmLogoRevisitor<BackOp, BinaryExpOp, BlockOp, CallStackOp, ClearOp, ConstantOp, ControlStructureOp, CosOp, DivOp, EqualsOp, ExpressionOp, ForwardOp, GreaterOp, IfOp, InstructionOp, LeftOp, LogoProgramOp, LowerOp, MinusOp, MultOp, ParameterOp, ParameterCallOp, PenDownOp, PenUpOp, PlusOp, PointOp, PrimitiveOp, ProcCallOp, ProcDeclarationOp, RepeatOp, RightOp, SegmentOp, SinOp, StackFrameOp, TanOp, TurtleOp, UnaryExpressionOp, VariableOp, WhileOp> {
	default BackOp kmLogo__Back(Back it) {
		return new BackOpImpl(it, this);
	}

	default BinaryExpOp kmLogo__BinaryExp(BinaryExp it) {
		return new BinaryExpOpImpl(it, this);
	}

	default BlockOp kmLogo__Block(Block it) {
		return new BlockOpImpl(it, this);
	}

	default CallStackOp kmLogo__CallStack(CallStack it) {
		return new CallStackOpImpl(it, this);
	}

	default ClearOp kmLogo__Clear(Clear it) {
		return new ClearOpImpl(it, this);
	}

	default ConstantOp kmLogo__Constant(Constant it) {
		return new ConstantOpImpl(it, this);
	}

	default ControlStructureOp kmLogo__ControlStructure(ControlStructure it) {
		return new ControlStructureOpImpl(it, this);
	}

	default CosOp kmLogo__Cos(Cos it) {
		return new CosOpImpl(it, this);
	}

	default DivOp kmLogo__Div(Div it) {
		return new DivOpImpl(it, this);
	}

	default EqualsOp kmLogo__Equals(Equals it) {
		return new EqualsOpImpl(it, this);
	}

	default ExpressionOp kmLogo__Expression(Expression it) {
		return new ExpressionOpImpl(it, this);
	}

	default ForwardOp kmLogo__Forward(Forward it) {
		return new ForwardOpImpl(it, this);
	}

	default GreaterOp kmLogo__Greater(Greater it) {
		return new GreaterOpImpl(it, this);
	}

	default IfOp kmLogo__If(If it) {
		return new IfOpImpl(it, this);
	}

	default InstructionOp kmLogo__Instruction(Instruction it) {
		return new InstructionOpImpl(it, this);
	}

	default LeftOp kmLogo__Left(Left it) {
		return new LeftOpImpl(it, this);
	}

	default LogoProgramOp kmLogo__LogoProgram(LogoProgram it) {
		return new LogoProgramOpImpl(it, this);
	}

	default LowerOp kmLogo__Lower(Lower it) {
		return new LowerOpImpl(it, this);
	}

	default MinusOp kmLogo__Minus(Minus it) {
		return new MinusOpImpl(it, this);
	}

	default MultOp kmLogo__Mult(Mult it) {
		return new MultOpImpl(it, this);
	}

	default ParameterOp kmLogo__Parameter(Parameter it) {
		return new ParameterOpImpl(it, this);
	}

	default ParameterCallOp kmLogo__ParameterCall(ParameterCall it) {
		return new ParameterCallOpImpl(it, this);
	}

	default PenDownOp kmLogo__PenDown(PenDown it) {
		return new PenDownOpImpl(it, this);
	}

	default PenUpOp kmLogo__PenUp(PenUp it) {
		return new PenUpOpImpl(it, this);
	}

	default PlusOp kmLogo__Plus(Plus it) {
		return new PlusOpImpl(it, this);
	}

	default PointOp kmLogo__Point(Point it) {
		return new PointOpImpl(it, this);
	}

	default PrimitiveOp kmLogo__Primitive(Primitive it) {
		return new PrimitiveOpImpl(it, this);
	}

	default ProcCallOp kmLogo__ProcCall(ProcCall it) {
		return new ProcCallOpImpl(it, this);
	}

	default ProcDeclarationOp kmLogo__ProcDeclaration(ProcDeclaration it) {
		return new ProcDeclarationOpImpl(it, this);
	}

	default RepeatOp kmLogo__Repeat(Repeat it) {
		return new RepeatOpImpl(it, this);
	}

	default RightOp kmLogo__Right(Right it) {
		return new RightOpImpl(it, this);
	}

	default SegmentOp kmLogo__Segment(Segment it) {
		return new SegmentOpImpl(it, this);
	}

	default SinOp kmLogo__Sin(Sin it) {
		return new SinOpImpl(it, this);
	}

	default StackFrameOp kmLogo__StackFrame(StackFrame it) {
		return new StackFrameOpImpl(it, this);
	}

	default TanOp kmLogo__Tan(Tan it) {
		return new TanOpImpl(it, this);
	}

	default TurtleOp kmLogo__Turtle(Turtle it) {
		return new TurtleOpImpl(it, this);
	}

	default UnaryExpressionOp kmLogo__UnaryExpression(UnaryExpression it) {
		return new UnaryExpressionOpImpl(it, this);
	}

	default VariableOp kmLogo__Variable(Variable it) {
		return new VariableOpImpl(it, this);
	}

	default WhileOp kmLogo__While(While it) {
		return new WhileOpImpl(it, this);
	}
}
