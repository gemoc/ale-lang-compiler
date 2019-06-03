package LogoProgram_revisitor.impl;

import LogoProgram_revisitor.impl.operation.BackOp;
import LogoProgram_revisitor.impl.operation.BinaryExpOp;
import LogoProgram_revisitor.impl.operation.BlockOp;
import LogoProgram_revisitor.impl.operation.CallStackOp;
import LogoProgram_revisitor.impl.operation.ClearOp;
import LogoProgram_revisitor.impl.operation.ConstantOp;
import LogoProgram_revisitor.impl.operation.ControlStructureOp;
import LogoProgram_revisitor.impl.operation.CosOp;
import LogoProgram_revisitor.impl.operation.DivOp;
import LogoProgram_revisitor.impl.operation.EqualsOp;
import LogoProgram_revisitor.impl.operation.ExpressionOp;
import LogoProgram_revisitor.impl.operation.ForwardOp;
import LogoProgram_revisitor.impl.operation.GreaterOp;
import LogoProgram_revisitor.impl.operation.IfOp;
import LogoProgram_revisitor.impl.operation.InstructionOp;
import LogoProgram_revisitor.impl.operation.LeftOp;
import LogoProgram_revisitor.impl.operation.LogoProgramOp;
import LogoProgram_revisitor.impl.operation.LowerOp;
import LogoProgram_revisitor.impl.operation.MinusOp;
import LogoProgram_revisitor.impl.operation.MultOp;
import LogoProgram_revisitor.impl.operation.ParameterCallOp;
import LogoProgram_revisitor.impl.operation.ParameterOp;
import LogoProgram_revisitor.impl.operation.PenDownOp;
import LogoProgram_revisitor.impl.operation.PenUpOp;
import LogoProgram_revisitor.impl.operation.PlusOp;
import LogoProgram_revisitor.impl.operation.PointOp;
import LogoProgram_revisitor.impl.operation.PrimitiveOp;
import LogoProgram_revisitor.impl.operation.ProcCallOp;
import LogoProgram_revisitor.impl.operation.ProcDeclarationOp;
import LogoProgram_revisitor.impl.operation.RepeatOp;
import LogoProgram_revisitor.impl.operation.RightOp;
import LogoProgram_revisitor.impl.operation.SegmentOp;
import LogoProgram_revisitor.impl.operation.SinOp;
import LogoProgram_revisitor.impl.operation.StackFrameOp;
import LogoProgram_revisitor.impl.operation.TanOp;
import LogoProgram_revisitor.impl.operation.TurtleOp;
import LogoProgram_revisitor.impl.operation.UnaryExpressionOp;
import LogoProgram_revisitor.impl.operation.VariableOp;
import LogoProgram_revisitor.impl.operation.WhileOp;
import LogoProgram_revisitor.impl.operation.impl.BackOpImpl;
import LogoProgram_revisitor.impl.operation.impl.BinaryExpOpImpl;
import LogoProgram_revisitor.impl.operation.impl.BlockOpImpl;
import LogoProgram_revisitor.impl.operation.impl.CallStackOpImpl;
import LogoProgram_revisitor.impl.operation.impl.ClearOpImpl;
import LogoProgram_revisitor.impl.operation.impl.ConstantOpImpl;
import LogoProgram_revisitor.impl.operation.impl.ControlStructureOpImpl;
import LogoProgram_revisitor.impl.operation.impl.CosOpImpl;
import LogoProgram_revisitor.impl.operation.impl.DivOpImpl;
import LogoProgram_revisitor.impl.operation.impl.EqualsOpImpl;
import LogoProgram_revisitor.impl.operation.impl.ExpressionOpImpl;
import LogoProgram_revisitor.impl.operation.impl.ForwardOpImpl;
import LogoProgram_revisitor.impl.operation.impl.GreaterOpImpl;
import LogoProgram_revisitor.impl.operation.impl.IfOpImpl;
import LogoProgram_revisitor.impl.operation.impl.InstructionOpImpl;
import LogoProgram_revisitor.impl.operation.impl.LeftOpImpl;
import LogoProgram_revisitor.impl.operation.impl.LogoProgramOpImpl;
import LogoProgram_revisitor.impl.operation.impl.LowerOpImpl;
import LogoProgram_revisitor.impl.operation.impl.MinusOpImpl;
import LogoProgram_revisitor.impl.operation.impl.MultOpImpl;
import LogoProgram_revisitor.impl.operation.impl.ParameterCallOpImpl;
import LogoProgram_revisitor.impl.operation.impl.ParameterOpImpl;
import LogoProgram_revisitor.impl.operation.impl.PenDownOpImpl;
import LogoProgram_revisitor.impl.operation.impl.PenUpOpImpl;
import LogoProgram_revisitor.impl.operation.impl.PlusOpImpl;
import LogoProgram_revisitor.impl.operation.impl.PointOpImpl;
import LogoProgram_revisitor.impl.operation.impl.PrimitiveOpImpl;
import LogoProgram_revisitor.impl.operation.impl.ProcCallOpImpl;
import LogoProgram_revisitor.impl.operation.impl.ProcDeclarationOpImpl;
import LogoProgram_revisitor.impl.operation.impl.RepeatOpImpl;
import LogoProgram_revisitor.impl.operation.impl.RightOpImpl;
import LogoProgram_revisitor.impl.operation.impl.SegmentOpImpl;
import LogoProgram_revisitor.impl.operation.impl.SinOpImpl;
import LogoProgram_revisitor.impl.operation.impl.StackFrameOpImpl;
import LogoProgram_revisitor.impl.operation.impl.TanOpImpl;
import LogoProgram_revisitor.impl.operation.impl.TurtleOpImpl;
import LogoProgram_revisitor.impl.operation.impl.UnaryExpressionOpImpl;
import LogoProgram_revisitor.impl.operation.impl.VariableOpImpl;
import LogoProgram_revisitor.impl.operation.impl.WhileOpImpl;
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

public interface LogoProgram_revisitorImplementation extends KmLogoRevisitor<BackOp, BinaryExpOp, BlockOp, CallStackOp, ClearOp, ConstantOp, ControlStructureOp, CosOp, DivOp, EqualsOp, ExpressionOp, ForwardOp, GreaterOp, IfOp, InstructionOp, LeftOp, LogoProgramOp, LowerOp, MinusOp, MultOp, ParameterOp, ParameterCallOp, PenDownOp, PenUpOp, PlusOp, PointOp, PrimitiveOp, ProcCallOp, ProcDeclarationOp, RepeatOp, RightOp, SegmentOp, SinOp, StackFrameOp, TanOp, TurtleOp, UnaryExpressionOp, VariableOp, WhileOp> {
	default InstructionOp kmLogo__Instruction(Instruction it) {
		return new InstructionOpImpl(it, this);
	}

	default PrimitiveOp kmLogo__Primitive(Primitive it) {
		return new PrimitiveOpImpl(it, this);
	}

	default BackOp kmLogo__Back(Back it) {
		return new BackOpImpl(it, this);
	}

	default ForwardOp kmLogo__Forward(Forward it) {
		return new ForwardOpImpl(it, this);
	}

	default LeftOp kmLogo__Left(Left it) {
		return new LeftOpImpl(it, this);
	}

	default RightOp kmLogo__Right(Right it) {
		return new RightOpImpl(it, this);
	}

	default PenDownOp kmLogo__PenDown(PenDown it) {
		return new PenDownOpImpl(it, this);
	}

	default PenUpOp kmLogo__PenUp(PenUp it) {
		return new PenUpOpImpl(it, this);
	}

	default ClearOp kmLogo__Clear(Clear it) {
		return new ClearOpImpl(it, this);
	}

	default ExpressionOp kmLogo__Expression(Expression it) {
		return new ExpressionOpImpl(it, this);
	}

	default BinaryExpOp kmLogo__BinaryExp(BinaryExp it) {
		return new BinaryExpOpImpl(it, this);
	}

	default UnaryExpressionOp kmLogo__UnaryExpression(UnaryExpression it) {
		return new UnaryExpressionOpImpl(it, this);
	}

	default ConstantOp kmLogo__Constant(Constant it) {
		return new ConstantOpImpl(it, this);
	}

	default ProcCallOp kmLogo__ProcCall(ProcCall it) {
		return new ProcCallOpImpl(it, this);
	}

	default ProcDeclarationOp kmLogo__ProcDeclaration(ProcDeclaration it) {
		return new ProcDeclarationOpImpl(it, this);
	}

	default BlockOp kmLogo__Block(Block it) {
		return new BlockOpImpl(it, this);
	}

	default IfOp kmLogo__If(If it) {
		return new IfOpImpl(it, this);
	}

	default ControlStructureOp kmLogo__ControlStructure(ControlStructure it) {
		return new ControlStructureOpImpl(it, this);
	}

	default RepeatOp kmLogo__Repeat(Repeat it) {
		return new RepeatOpImpl(it, this);
	}

	default WhileOp kmLogo__While(While it) {
		return new WhileOpImpl(it, this);
	}

	default ParameterOp kmLogo__Parameter(Parameter it) {
		return new ParameterOpImpl(it, this);
	}

	default ParameterCallOp kmLogo__ParameterCall(ParameterCall it) {
		return new ParameterCallOpImpl(it, this);
	}

	default PlusOp kmLogo__Plus(Plus it) {
		return new PlusOpImpl(it, this);
	}

	default MinusOp kmLogo__Minus(Minus it) {
		return new MinusOpImpl(it, this);
	}

	default MultOp kmLogo__Mult(Mult it) {
		return new MultOpImpl(it, this);
	}

	default DivOp kmLogo__Div(Div it) {
		return new DivOpImpl(it, this);
	}

	default EqualsOp kmLogo__Equals(Equals it) {
		return new EqualsOpImpl(it, this);
	}

	default GreaterOp kmLogo__Greater(Greater it) {
		return new GreaterOpImpl(it, this);
	}

	default LowerOp kmLogo__Lower(Lower it) {
		return new LowerOpImpl(it, this);
	}

	default CosOp kmLogo__Cos(Cos it) {
		return new CosOpImpl(it, this);
	}

	default SinOp kmLogo__Sin(Sin it) {
		return new SinOpImpl(it, this);
	}

	default TanOp kmLogo__Tan(Tan it) {
		return new TanOpImpl(it, this);
	}

	default LogoProgramOp kmLogo__LogoProgram(LogoProgram it) {
		return new LogoProgramOpImpl(it, this);
	}

	default TurtleOp kmLogo__Turtle(Turtle it) {
		return new TurtleOpImpl(it, this);
	}

	default PointOp kmLogo__Point(Point it) {
		return new PointOpImpl(it, this);
	}

	default SegmentOp kmLogo__Segment(Segment it) {
		return new SegmentOpImpl(it, this);
	}

	default CallStackOp kmLogo__CallStack(CallStack it) {
		return new CallStackOpImpl(it, this);
	}

	default StackFrameOp kmLogo__StackFrame(StackFrame it) {
		return new StackFrameOpImpl(it, this);
	}

	default VariableOp kmLogo__Variable(Variable it) {
		return new VariableOpImpl(it, this);
	}
}
