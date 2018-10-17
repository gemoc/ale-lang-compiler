package kmLogo.revisitor;

public interface KmLogoRevisitor<KmLogo__BackT extends KmLogo__PrimitiveT, KmLogo__BinaryExpT extends KmLogo__ExpressionT, KmLogo__BlockT extends KmLogo__InstructionT, KmLogo__CallStackT, KmLogo__ClearT extends KmLogo__PrimitiveT, KmLogo__ConstantT extends KmLogo__ExpressionT, KmLogo__ControlStructureT extends KmLogo__InstructionT, KmLogo__CosT extends KmLogo__UnaryExpressionT, KmLogo__DivT extends KmLogo__BinaryExpT, KmLogo__EqualsT extends KmLogo__BinaryExpT, KmLogo__ExpressionT extends KmLogo__InstructionT, KmLogo__ForwardT extends KmLogo__PrimitiveT, KmLogo__GreaterT extends KmLogo__BinaryExpT, KmLogo__IfT extends KmLogo__ControlStructureT, KmLogo__InstructionT, KmLogo__LeftT extends KmLogo__PrimitiveT, KmLogo__LogoProgramT, KmLogo__LowerT extends KmLogo__BinaryExpT, KmLogo__MinusT extends KmLogo__BinaryExpT, KmLogo__MultT extends KmLogo__BinaryExpT, KmLogo__ParameterT, KmLogo__ParameterCallT extends KmLogo__ExpressionT, KmLogo__PenDownT extends KmLogo__PrimitiveT, KmLogo__PenUpT extends KmLogo__PrimitiveT, KmLogo__PlusT extends KmLogo__BinaryExpT, KmLogo__PointT, KmLogo__PrimitiveT extends KmLogo__InstructionT, KmLogo__ProcCallT extends KmLogo__ExpressionT, KmLogo__ProcDeclarationT extends KmLogo__InstructionT, KmLogo__RepeatT extends KmLogo__ControlStructureT, KmLogo__RightT extends KmLogo__PrimitiveT, KmLogo__SegmentT, KmLogo__SinT extends KmLogo__UnaryExpressionT, KmLogo__StackFrameT, KmLogo__TanT extends KmLogo__UnaryExpressionT, KmLogo__TurtleT, KmLogo__UnaryExpressionT extends KmLogo__ExpressionT, KmLogo__VariableT, KmLogo__WhileT extends KmLogo__ControlStructureT> {
	KmLogo__BackT kmLogo__Back(final kmLogo.Back it);
	KmLogo__BlockT kmLogo__Block(final kmLogo.Block it);
	KmLogo__CallStackT kmLogo__CallStack(final kmLogo.CallStack it);
	KmLogo__ClearT kmLogo__Clear(final kmLogo.Clear it);
	KmLogo__ConstantT kmLogo__Constant(final kmLogo.Constant it);
	KmLogo__ControlStructureT kmLogo__ControlStructure(final kmLogo.ControlStructure it);
	KmLogo__CosT kmLogo__Cos(final kmLogo.Cos it);
	KmLogo__DivT kmLogo__Div(final kmLogo.Div it);
	KmLogo__EqualsT kmLogo__Equals(final kmLogo.Equals it);
	KmLogo__ForwardT kmLogo__Forward(final kmLogo.Forward it);
	KmLogo__GreaterT kmLogo__Greater(final kmLogo.Greater it);
	KmLogo__IfT kmLogo__If(final kmLogo.If it);
	KmLogo__LeftT kmLogo__Left(final kmLogo.Left it);
	KmLogo__LogoProgramT kmLogo__LogoProgram(final kmLogo.LogoProgram it);
	KmLogo__LowerT kmLogo__Lower(final kmLogo.Lower it);
	KmLogo__MinusT kmLogo__Minus(final kmLogo.Minus it);
	KmLogo__MultT kmLogo__Mult(final kmLogo.Mult it);
	KmLogo__ParameterT kmLogo__Parameter(final kmLogo.Parameter it);
	KmLogo__ParameterCallT kmLogo__ParameterCall(final kmLogo.ParameterCall it);
	KmLogo__PenDownT kmLogo__PenDown(final kmLogo.PenDown it);
	KmLogo__PenUpT kmLogo__PenUp(final kmLogo.PenUp it);
	KmLogo__PlusT kmLogo__Plus(final kmLogo.Plus it);
	KmLogo__PointT kmLogo__Point(final kmLogo.Point it);
	KmLogo__ProcCallT kmLogo__ProcCall(final kmLogo.ProcCall it);
	KmLogo__ProcDeclarationT kmLogo__ProcDeclaration(final kmLogo.ProcDeclaration it);
	KmLogo__RepeatT kmLogo__Repeat(final kmLogo.Repeat it);
	KmLogo__RightT kmLogo__Right(final kmLogo.Right it);
	KmLogo__SegmentT kmLogo__Segment(final kmLogo.Segment it);
	KmLogo__SinT kmLogo__Sin(final kmLogo.Sin it);
	KmLogo__StackFrameT kmLogo__StackFrame(final kmLogo.StackFrame it);
	KmLogo__TanT kmLogo__Tan(final kmLogo.Tan it);
	KmLogo__TurtleT kmLogo__Turtle(final kmLogo.Turtle it);
	KmLogo__VariableT kmLogo__Variable(final kmLogo.Variable it);
	KmLogo__WhileT kmLogo__While(final kmLogo.While it);

	default KmLogo__BackT $(final kmLogo.Back it) {
		return kmLogo__Back(it);
	}
	default KmLogo__BinaryExpT $(final kmLogo.BinaryExp it) {
		if (it.getClass() == kmLogo.impl.DivImpl.class)
			return kmLogo__Div((kmLogo.Div) it);
		if (it.getClass() == kmLogo.impl.EqualsImpl.class)
			return kmLogo__Equals((kmLogo.Equals) it);
		if (it.getClass() == kmLogo.impl.GreaterImpl.class)
			return kmLogo__Greater((kmLogo.Greater) it);
		if (it.getClass() == kmLogo.impl.LowerImpl.class)
			return kmLogo__Lower((kmLogo.Lower) it);
		if (it.getClass() == kmLogo.impl.MinusImpl.class)
			return kmLogo__Minus((kmLogo.Minus) it);
		if (it.getClass() == kmLogo.impl.MultImpl.class)
			return kmLogo__Mult((kmLogo.Mult) it);
		if (it.getClass() == kmLogo.impl.PlusImpl.class)
			return kmLogo__Plus((kmLogo.Plus) it);
		return null;
	}
	default KmLogo__BlockT $(final kmLogo.Block it) {
		return kmLogo__Block(it);
	}
	default KmLogo__CallStackT $(final kmLogo.CallStack it) {
		return kmLogo__CallStack(it);
	}
	default KmLogo__ClearT $(final kmLogo.Clear it) {
		return kmLogo__Clear(it);
	}
	default KmLogo__ConstantT $(final kmLogo.Constant it) {
		return kmLogo__Constant(it);
	}
	default KmLogo__ControlStructureT $(final kmLogo.ControlStructure it) {
		if (it.getClass() == kmLogo.impl.IfImpl.class)
			return kmLogo__If((kmLogo.If) it);
		if (it.getClass() == kmLogo.impl.RepeatImpl.class)
			return kmLogo__Repeat((kmLogo.Repeat) it);
		if (it.getClass() == kmLogo.impl.WhileImpl.class)
			return kmLogo__While((kmLogo.While) it);
		return kmLogo__ControlStructure(it);
	}
	default KmLogo__CosT $(final kmLogo.Cos it) {
		return kmLogo__Cos(it);
	}
	default KmLogo__DivT $(final kmLogo.Div it) {
		return kmLogo__Div(it);
	}
	default KmLogo__EqualsT $(final kmLogo.Equals it) {
		return kmLogo__Equals(it);
	}
	default KmLogo__ExpressionT $(final kmLogo.Expression it) {
		if (it.getClass() == kmLogo.impl.ConstantImpl.class)
			return kmLogo__Constant((kmLogo.Constant) it);
		if (it.getClass() == kmLogo.impl.CosImpl.class)
			return kmLogo__Cos((kmLogo.Cos) it);
		if (it.getClass() == kmLogo.impl.DivImpl.class)
			return kmLogo__Div((kmLogo.Div) it);
		if (it.getClass() == kmLogo.impl.EqualsImpl.class)
			return kmLogo__Equals((kmLogo.Equals) it);
		if (it.getClass() == kmLogo.impl.GreaterImpl.class)
			return kmLogo__Greater((kmLogo.Greater) it);
		if (it.getClass() == kmLogo.impl.LowerImpl.class)
			return kmLogo__Lower((kmLogo.Lower) it);
		if (it.getClass() == kmLogo.impl.MinusImpl.class)
			return kmLogo__Minus((kmLogo.Minus) it);
		if (it.getClass() == kmLogo.impl.MultImpl.class)
			return kmLogo__Mult((kmLogo.Mult) it);
		if (it.getClass() == kmLogo.impl.ParameterCallImpl.class)
			return kmLogo__ParameterCall((kmLogo.ParameterCall) it);
		if (it.getClass() == kmLogo.impl.PlusImpl.class)
			return kmLogo__Plus((kmLogo.Plus) it);
		if (it.getClass() == kmLogo.impl.ProcCallImpl.class)
			return kmLogo__ProcCall((kmLogo.ProcCall) it);
		if (it.getClass() == kmLogo.impl.SinImpl.class)
			return kmLogo__Sin((kmLogo.Sin) it);
		if (it.getClass() == kmLogo.impl.TanImpl.class)
			return kmLogo__Tan((kmLogo.Tan) it);
		return null;
	}
	default KmLogo__ForwardT $(final kmLogo.Forward it) {
		return kmLogo__Forward(it);
	}
	default KmLogo__GreaterT $(final kmLogo.Greater it) {
		return kmLogo__Greater(it);
	}
	default KmLogo__IfT $(final kmLogo.If it) {
		return kmLogo__If(it);
	}
	default KmLogo__InstructionT $(final kmLogo.Instruction it) {
		if (it.getClass() == kmLogo.impl.BackImpl.class)
			return kmLogo__Back((kmLogo.Back) it);
		if (it.getClass() == kmLogo.impl.BlockImpl.class)
			return kmLogo__Block((kmLogo.Block) it);
		if (it.getClass() == kmLogo.impl.ClearImpl.class)
			return kmLogo__Clear((kmLogo.Clear) it);
		if (it.getClass() == kmLogo.impl.ConstantImpl.class)
			return kmLogo__Constant((kmLogo.Constant) it);
		if (it.getClass() == kmLogo.impl.ControlStructureImpl.class)
			return kmLogo__ControlStructure((kmLogo.ControlStructure) it);
		if (it.getClass() == kmLogo.impl.CosImpl.class)
			return kmLogo__Cos((kmLogo.Cos) it);
		if (it.getClass() == kmLogo.impl.DivImpl.class)
			return kmLogo__Div((kmLogo.Div) it);
		if (it.getClass() == kmLogo.impl.EqualsImpl.class)
			return kmLogo__Equals((kmLogo.Equals) it);
		if (it.getClass() == kmLogo.impl.ForwardImpl.class)
			return kmLogo__Forward((kmLogo.Forward) it);
		if (it.getClass() == kmLogo.impl.GreaterImpl.class)
			return kmLogo__Greater((kmLogo.Greater) it);
		if (it.getClass() == kmLogo.impl.IfImpl.class)
			return kmLogo__If((kmLogo.If) it);
		if (it.getClass() == kmLogo.impl.LeftImpl.class)
			return kmLogo__Left((kmLogo.Left) it);
		if (it.getClass() == kmLogo.impl.LowerImpl.class)
			return kmLogo__Lower((kmLogo.Lower) it);
		if (it.getClass() == kmLogo.impl.MinusImpl.class)
			return kmLogo__Minus((kmLogo.Minus) it);
		if (it.getClass() == kmLogo.impl.MultImpl.class)
			return kmLogo__Mult((kmLogo.Mult) it);
		if (it.getClass() == kmLogo.impl.ParameterCallImpl.class)
			return kmLogo__ParameterCall((kmLogo.ParameterCall) it);
		if (it.getClass() == kmLogo.impl.PenDownImpl.class)
			return kmLogo__PenDown((kmLogo.PenDown) it);
		if (it.getClass() == kmLogo.impl.PenUpImpl.class)
			return kmLogo__PenUp((kmLogo.PenUp) it);
		if (it.getClass() == kmLogo.impl.PlusImpl.class)
			return kmLogo__Plus((kmLogo.Plus) it);
		if (it.getClass() == kmLogo.impl.ProcCallImpl.class)
			return kmLogo__ProcCall((kmLogo.ProcCall) it);
		if (it.getClass() == kmLogo.impl.ProcDeclarationImpl.class)
			return kmLogo__ProcDeclaration((kmLogo.ProcDeclaration) it);
		if (it.getClass() == kmLogo.impl.RepeatImpl.class)
			return kmLogo__Repeat((kmLogo.Repeat) it);
		if (it.getClass() == kmLogo.impl.RightImpl.class)
			return kmLogo__Right((kmLogo.Right) it);
		if (it.getClass() == kmLogo.impl.SinImpl.class)
			return kmLogo__Sin((kmLogo.Sin) it);
		if (it.getClass() == kmLogo.impl.TanImpl.class)
			return kmLogo__Tan((kmLogo.Tan) it);
		if (it.getClass() == kmLogo.impl.WhileImpl.class)
			return kmLogo__While((kmLogo.While) it);
		return null;
	}
	default KmLogo__LeftT $(final kmLogo.Left it) {
		return kmLogo__Left(it);
	}
	default KmLogo__LogoProgramT $(final kmLogo.LogoProgram it) {
		return kmLogo__LogoProgram(it);
	}
	default KmLogo__LowerT $(final kmLogo.Lower it) {
		return kmLogo__Lower(it);
	}
	default KmLogo__MinusT $(final kmLogo.Minus it) {
		return kmLogo__Minus(it);
	}
	default KmLogo__MultT $(final kmLogo.Mult it) {
		return kmLogo__Mult(it);
	}
	default KmLogo__ParameterT $(final kmLogo.Parameter it) {
		return kmLogo__Parameter(it);
	}
	default KmLogo__ParameterCallT $(final kmLogo.ParameterCall it) {
		return kmLogo__ParameterCall(it);
	}
	default KmLogo__PenDownT $(final kmLogo.PenDown it) {
		return kmLogo__PenDown(it);
	}
	default KmLogo__PenUpT $(final kmLogo.PenUp it) {
		return kmLogo__PenUp(it);
	}
	default KmLogo__PlusT $(final kmLogo.Plus it) {
		return kmLogo__Plus(it);
	}
	default KmLogo__PointT $(final kmLogo.Point it) {
		return kmLogo__Point(it);
	}
	default KmLogo__PrimitiveT $(final kmLogo.Primitive it) {
		if (it.getClass() == kmLogo.impl.BackImpl.class)
			return kmLogo__Back((kmLogo.Back) it);
		if (it.getClass() == kmLogo.impl.ClearImpl.class)
			return kmLogo__Clear((kmLogo.Clear) it);
		if (it.getClass() == kmLogo.impl.ForwardImpl.class)
			return kmLogo__Forward((kmLogo.Forward) it);
		if (it.getClass() == kmLogo.impl.LeftImpl.class)
			return kmLogo__Left((kmLogo.Left) it);
		if (it.getClass() == kmLogo.impl.PenDownImpl.class)
			return kmLogo__PenDown((kmLogo.PenDown) it);
		if (it.getClass() == kmLogo.impl.PenUpImpl.class)
			return kmLogo__PenUp((kmLogo.PenUp) it);
		if (it.getClass() == kmLogo.impl.RightImpl.class)
			return kmLogo__Right((kmLogo.Right) it);
		return null;
	}
	default KmLogo__ProcCallT $(final kmLogo.ProcCall it) {
		return kmLogo__ProcCall(it);
	}
	default KmLogo__ProcDeclarationT $(final kmLogo.ProcDeclaration it) {
		return kmLogo__ProcDeclaration(it);
	}
	default KmLogo__RepeatT $(final kmLogo.Repeat it) {
		return kmLogo__Repeat(it);
	}
	default KmLogo__RightT $(final kmLogo.Right it) {
		return kmLogo__Right(it);
	}
	default KmLogo__SegmentT $(final kmLogo.Segment it) {
		return kmLogo__Segment(it);
	}
	default KmLogo__SinT $(final kmLogo.Sin it) {
		return kmLogo__Sin(it);
	}
	default KmLogo__StackFrameT $(final kmLogo.StackFrame it) {
		return kmLogo__StackFrame(it);
	}
	default KmLogo__TanT $(final kmLogo.Tan it) {
		return kmLogo__Tan(it);
	}
	default KmLogo__TurtleT $(final kmLogo.Turtle it) {
		return kmLogo__Turtle(it);
	}
	default KmLogo__UnaryExpressionT $(final kmLogo.UnaryExpression it) {
		if (it.getClass() == kmLogo.impl.CosImpl.class)
			return kmLogo__Cos((kmLogo.Cos) it);
		if (it.getClass() == kmLogo.impl.SinImpl.class)
			return kmLogo__Sin((kmLogo.Sin) it);
		if (it.getClass() == kmLogo.impl.TanImpl.class)
			return kmLogo__Tan((kmLogo.Tan) it);
		return null;
	}
	default KmLogo__VariableT $(final kmLogo.Variable it) {
		return kmLogo__Variable(it);
	}
	default KmLogo__WhileT $(final kmLogo.While it) {
		return kmLogo__While(it);
	}
}
