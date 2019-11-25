package visitor;

import kmLogo.visitor.kmLogo.Back;
import kmLogo.visitor.kmLogo.Block;
import kmLogo.visitor.kmLogo.CallStack;
import kmLogo.visitor.kmLogo.Clear;
import kmLogo.visitor.kmLogo.Constant;
import kmLogo.visitor.kmLogo.ControlStructure;
import kmLogo.visitor.kmLogo.Cos;
import kmLogo.visitor.kmLogo.Div;
import kmLogo.visitor.kmLogo.Equals;
import kmLogo.visitor.kmLogo.Forward;
import kmLogo.visitor.kmLogo.Greater;
import kmLogo.visitor.kmLogo.If;
import kmLogo.visitor.kmLogo.Left;
import kmLogo.visitor.kmLogo.LogoProgram;
import kmLogo.visitor.kmLogo.Lower;
import kmLogo.visitor.kmLogo.Minus;
import kmLogo.visitor.kmLogo.Mult;
import kmLogo.visitor.kmLogo.Parameter;
import kmLogo.visitor.kmLogo.ParameterCall;
import kmLogo.visitor.kmLogo.PenDown;
import kmLogo.visitor.kmLogo.PenUp;
import kmLogo.visitor.kmLogo.Plus;
import kmLogo.visitor.kmLogo.Point;
import kmLogo.visitor.kmLogo.ProcCall;
import kmLogo.visitor.kmLogo.ProcDeclaration;
import kmLogo.visitor.kmLogo.Repeat;
import kmLogo.visitor.kmLogo.Right;
import kmLogo.visitor.kmLogo.Segment;
import kmLogo.visitor.kmLogo.Sin;
import kmLogo.visitor.kmLogo.StackFrame;
import kmLogo.visitor.kmLogo.Tan;
import kmLogo.visitor.kmLogo.Turtle;
import kmLogo.visitor.kmLogo.Variable;
import kmLogo.visitor.kmLogo.While;
import visitor.operation.kmLogo.BackOperation;
import visitor.operation.kmLogo.BlockOperation;
import visitor.operation.kmLogo.CallStackOperation;
import visitor.operation.kmLogo.ClearOperation;
import visitor.operation.kmLogo.ConstantOperation;
import visitor.operation.kmLogo.ControlStructureOperation;
import visitor.operation.kmLogo.CosOperation;
import visitor.operation.kmLogo.DivOperation;
import visitor.operation.kmLogo.EqualsOperation;
import visitor.operation.kmLogo.ForwardOperation;
import visitor.operation.kmLogo.GreaterOperation;
import visitor.operation.kmLogo.IfOperation;
import visitor.operation.kmLogo.LeftOperation;
import visitor.operation.kmLogo.LogoProgramOperation;
import visitor.operation.kmLogo.LowerOperation;
import visitor.operation.kmLogo.MinusOperation;
import visitor.operation.kmLogo.MultOperation;
import visitor.operation.kmLogo.ParameterCallOperation;
import visitor.operation.kmLogo.ParameterOperation;
import visitor.operation.kmLogo.PenDownOperation;
import visitor.operation.kmLogo.PenUpOperation;
import visitor.operation.kmLogo.PlusOperation;
import visitor.operation.kmLogo.PointOperation;
import visitor.operation.kmLogo.ProcCallOperation;
import visitor.operation.kmLogo.ProcDeclarationOperation;
import visitor.operation.kmLogo.RepeatOperation;
import visitor.operation.kmLogo.RightOperation;
import visitor.operation.kmLogo.SegmentOperation;
import visitor.operation.kmLogo.SinOperation;
import visitor.operation.kmLogo.StackFrameOperation;
import visitor.operation.kmLogo.TanOperation;
import visitor.operation.kmLogo.TurtleOperation;
import visitor.operation.kmLogo.VariableOperation;
import visitor.operation.kmLogo.WhileOperation;
import visitor.operation.kmLogo.impl.BackOperationImpl;
import visitor.operation.kmLogo.impl.BlockOperationImpl;
import visitor.operation.kmLogo.impl.CallStackOperationImpl;
import visitor.operation.kmLogo.impl.ClearOperationImpl;
import visitor.operation.kmLogo.impl.ConstantOperationImpl;
import visitor.operation.kmLogo.impl.ControlStructureOperationImpl;
import visitor.operation.kmLogo.impl.CosOperationImpl;
import visitor.operation.kmLogo.impl.DivOperationImpl;
import visitor.operation.kmLogo.impl.EqualsOperationImpl;
import visitor.operation.kmLogo.impl.ForwardOperationImpl;
import visitor.operation.kmLogo.impl.GreaterOperationImpl;
import visitor.operation.kmLogo.impl.IfOperationImpl;
import visitor.operation.kmLogo.impl.LeftOperationImpl;
import visitor.operation.kmLogo.impl.LogoProgramOperationImpl;
import visitor.operation.kmLogo.impl.LowerOperationImpl;
import visitor.operation.kmLogo.impl.MinusOperationImpl;
import visitor.operation.kmLogo.impl.MultOperationImpl;
import visitor.operation.kmLogo.impl.ParameterCallOperationImpl;
import visitor.operation.kmLogo.impl.ParameterOperationImpl;
import visitor.operation.kmLogo.impl.PenDownOperationImpl;
import visitor.operation.kmLogo.impl.PenUpOperationImpl;
import visitor.operation.kmLogo.impl.PlusOperationImpl;
import visitor.operation.kmLogo.impl.PointOperationImpl;
import visitor.operation.kmLogo.impl.ProcCallOperationImpl;
import visitor.operation.kmLogo.impl.ProcDeclarationOperationImpl;
import visitor.operation.kmLogo.impl.RepeatOperationImpl;
import visitor.operation.kmLogo.impl.RightOperationImpl;
import visitor.operation.kmLogo.impl.SegmentOperationImpl;
import visitor.operation.kmLogo.impl.SinOperationImpl;
import visitor.operation.kmLogo.impl.StackFrameOperationImpl;
import visitor.operation.kmLogo.impl.TanOperationImpl;
import visitor.operation.kmLogo.impl.TurtleOperationImpl;
import visitor.operation.kmLogo.impl.VariableOperationImpl;
import visitor.operation.kmLogo.impl.WhileOperationImpl;

public class VisitorImplementation implements VisitorInterface {
  public BackOperation visitkmLogo__Back(Back it) {
    return new BackOperationImpl(it, this);
  }

  public ForwardOperation visitkmLogo__Forward(Forward it) {
    return new ForwardOperationImpl(it, this);
  }

  public LeftOperation visitkmLogo__Left(Left it) {
    return new LeftOperationImpl(it, this);
  }

  public RightOperation visitkmLogo__Right(Right it) {
    return new RightOperationImpl(it, this);
  }

  public PenDownOperation visitkmLogo__PenDown(PenDown it) {
    return new PenDownOperationImpl(it, this);
  }

  public PenUpOperation visitkmLogo__PenUp(PenUp it) {
    return new PenUpOperationImpl(it, this);
  }

  public ClearOperation visitkmLogo__Clear(Clear it) {
    return new ClearOperationImpl(it, this);
  }

  public ConstantOperation visitkmLogo__Constant(Constant it) {
    return new ConstantOperationImpl(it, this);
  }

  public ProcCallOperation visitkmLogo__ProcCall(ProcCall it) {
    return new ProcCallOperationImpl(it, this);
  }

  public ProcDeclarationOperation visitkmLogo__ProcDeclaration(ProcDeclaration it) {
    return new ProcDeclarationOperationImpl(it, this);
  }

  public BlockOperation visitkmLogo__Block(Block it) {
    return new BlockOperationImpl(it, this);
  }

  public IfOperation visitkmLogo__If(If it) {
    return new IfOperationImpl(it, this);
  }

  public ControlStructureOperation visitkmLogo__ControlStructure(ControlStructure it) {
    return new ControlStructureOperationImpl(it, this);
  }

  public RepeatOperation visitkmLogo__Repeat(Repeat it) {
    return new RepeatOperationImpl(it, this);
  }

  public WhileOperation visitkmLogo__While(While it) {
    return new WhileOperationImpl(it, this);
  }

  public ParameterOperation visitkmLogo__Parameter(Parameter it) {
    return new ParameterOperationImpl(it, this);
  }

  public ParameterCallOperation visitkmLogo__ParameterCall(ParameterCall it) {
    return new ParameterCallOperationImpl(it, this);
  }

  public PlusOperation visitkmLogo__Plus(Plus it) {
    return new PlusOperationImpl(it, this);
  }

  public MinusOperation visitkmLogo__Minus(Minus it) {
    return new MinusOperationImpl(it, this);
  }

  public MultOperation visitkmLogo__Mult(Mult it) {
    return new MultOperationImpl(it, this);
  }

  public DivOperation visitkmLogo__Div(Div it) {
    return new DivOperationImpl(it, this);
  }

  public EqualsOperation visitkmLogo__Equals(Equals it) {
    return new EqualsOperationImpl(it, this);
  }

  public GreaterOperation visitkmLogo__Greater(Greater it) {
    return new GreaterOperationImpl(it, this);
  }

  public LowerOperation visitkmLogo__Lower(Lower it) {
    return new LowerOperationImpl(it, this);
  }

  public CosOperation visitkmLogo__Cos(Cos it) {
    return new CosOperationImpl(it, this);
  }

  public SinOperation visitkmLogo__Sin(Sin it) {
    return new SinOperationImpl(it, this);
  }

  public TanOperation visitkmLogo__Tan(Tan it) {
    return new TanOperationImpl(it, this);
  }

  public LogoProgramOperation visitkmLogo__LogoProgram(LogoProgram it) {
    return new LogoProgramOperationImpl(it, this);
  }

  public TurtleOperation visitkmLogo__Turtle(Turtle it) {
    return new TurtleOperationImpl(it, this);
  }

  public PointOperation visitkmLogo__Point(Point it) {
    return new PointOperationImpl(it, this);
  }

  public SegmentOperation visitkmLogo__Segment(Segment it) {
    return new SegmentOperationImpl(it, this);
  }

  public CallStackOperation visitkmLogo__CallStack(CallStack it) {
    return new CallStackOperationImpl(it, this);
  }

  public StackFrameOperation visitkmLogo__StackFrame(StackFrame it) {
    return new StackFrameOperationImpl(it, this);
  }

  public VariableOperation visitkmLogo__Variable(Variable it) {
    return new VariableOperationImpl(it, this);
  }
}
