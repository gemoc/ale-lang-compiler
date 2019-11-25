package LogoProgram_revisitor.impl;

import LogoProgram_revisitor.impl.operation.Back;
import LogoProgram_revisitor.impl.operation.BinaryExp;
import LogoProgram_revisitor.impl.operation.Block;
import LogoProgram_revisitor.impl.operation.CallStack;
import LogoProgram_revisitor.impl.operation.Clear;
import LogoProgram_revisitor.impl.operation.Constant;
import LogoProgram_revisitor.impl.operation.ControlStructure;
import LogoProgram_revisitor.impl.operation.Cos;
import LogoProgram_revisitor.impl.operation.Div;
import LogoProgram_revisitor.impl.operation.Equals;
import LogoProgram_revisitor.impl.operation.Expression;
import LogoProgram_revisitor.impl.operation.Forward;
import LogoProgram_revisitor.impl.operation.Greater;
import LogoProgram_revisitor.impl.operation.If;
import LogoProgram_revisitor.impl.operation.Instruction;
import LogoProgram_revisitor.impl.operation.Left;
import LogoProgram_revisitor.impl.operation.LogoProgram;
import LogoProgram_revisitor.impl.operation.Lower;
import LogoProgram_revisitor.impl.operation.Minus;
import LogoProgram_revisitor.impl.operation.Mult;
import LogoProgram_revisitor.impl.operation.Parameter;
import LogoProgram_revisitor.impl.operation.ParameterCall;
import LogoProgram_revisitor.impl.operation.PenDown;
import LogoProgram_revisitor.impl.operation.PenUp;
import LogoProgram_revisitor.impl.operation.Plus;
import LogoProgram_revisitor.impl.operation.Point;
import LogoProgram_revisitor.impl.operation.Primitive;
import LogoProgram_revisitor.impl.operation.ProcCall;
import LogoProgram_revisitor.impl.operation.ProcDeclaration;
import LogoProgram_revisitor.impl.operation.Repeat;
import LogoProgram_revisitor.impl.operation.Right;
import LogoProgram_revisitor.impl.operation.Segment;
import LogoProgram_revisitor.impl.operation.Sin;
import LogoProgram_revisitor.impl.operation.StackFrame;
import LogoProgram_revisitor.impl.operation.Tan;
import LogoProgram_revisitor.impl.operation.Turtle;
import LogoProgram_revisitor.impl.operation.UnaryExpression;
import LogoProgram_revisitor.impl.operation.Variable;
import LogoProgram_revisitor.impl.operation.While;
import LogoProgram_revisitor.impl.operation.impl.BackImpl;
import LogoProgram_revisitor.impl.operation.impl.BinaryExpImpl;
import LogoProgram_revisitor.impl.operation.impl.BlockImpl;
import LogoProgram_revisitor.impl.operation.impl.CallStackImpl;
import LogoProgram_revisitor.impl.operation.impl.ClearImpl;
import LogoProgram_revisitor.impl.operation.impl.ConstantImpl;
import LogoProgram_revisitor.impl.operation.impl.ControlStructureImpl;
import LogoProgram_revisitor.impl.operation.impl.CosImpl;
import LogoProgram_revisitor.impl.operation.impl.DivImpl;
import LogoProgram_revisitor.impl.operation.impl.EqualsImpl;
import LogoProgram_revisitor.impl.operation.impl.ExpressionImpl;
import LogoProgram_revisitor.impl.operation.impl.ForwardImpl;
import LogoProgram_revisitor.impl.operation.impl.GreaterImpl;
import LogoProgram_revisitor.impl.operation.impl.IfImpl;
import LogoProgram_revisitor.impl.operation.impl.InstructionImpl;
import LogoProgram_revisitor.impl.operation.impl.LeftImpl;
import LogoProgram_revisitor.impl.operation.impl.LogoProgramImpl;
import LogoProgram_revisitor.impl.operation.impl.LowerImpl;
import LogoProgram_revisitor.impl.operation.impl.MinusImpl;
import LogoProgram_revisitor.impl.operation.impl.MultImpl;
import LogoProgram_revisitor.impl.operation.impl.ParameterCallImpl;
import LogoProgram_revisitor.impl.operation.impl.ParameterImpl;
import LogoProgram_revisitor.impl.operation.impl.PenDownImpl;
import LogoProgram_revisitor.impl.operation.impl.PenUpImpl;
import LogoProgram_revisitor.impl.operation.impl.PlusImpl;
import LogoProgram_revisitor.impl.operation.impl.PointImpl;
import LogoProgram_revisitor.impl.operation.impl.PrimitiveImpl;
import LogoProgram_revisitor.impl.operation.impl.ProcCallImpl;
import LogoProgram_revisitor.impl.operation.impl.ProcDeclarationImpl;
import LogoProgram_revisitor.impl.operation.impl.RepeatImpl;
import LogoProgram_revisitor.impl.operation.impl.RightImpl;
import LogoProgram_revisitor.impl.operation.impl.SegmentImpl;
import LogoProgram_revisitor.impl.operation.impl.SinImpl;
import LogoProgram_revisitor.impl.operation.impl.StackFrameImpl;
import LogoProgram_revisitor.impl.operation.impl.TanImpl;
import LogoProgram_revisitor.impl.operation.impl.TurtleImpl;
import LogoProgram_revisitor.impl.operation.impl.UnaryExpressionImpl;
import LogoProgram_revisitor.impl.operation.impl.VariableImpl;
import LogoProgram_revisitor.impl.operation.impl.WhileImpl;
import kmLogo.revisitor.KmLogoRevisitor;

public interface LogoProgram_revisitorImplementation extends KmLogoRevisitor<Back, BinaryExp, Block, CallStack, Clear, Constant, ControlStructure, Cos, Div, Equals, Expression, Forward, Greater, If, Instruction, Left, LogoProgram, Lower, Minus, Mult, Parameter, ParameterCall, PenDown, PenUp, Plus, Point, Primitive, ProcCall, ProcDeclaration, Repeat, Right, Segment, Sin, StackFrame, Tan, Turtle, UnaryExpression, Variable, While> {
  default Instruction kmLogo__Instruction(kmLogo.Instruction it) {
    return new InstructionImpl(it, this);
  }

  default Primitive kmLogo__Primitive(kmLogo.Primitive it) {
    return new PrimitiveImpl(it, this);
  }

  default Back kmLogo__Back(kmLogo.Back it) {
    return new BackImpl(it, this);
  }

  default Forward kmLogo__Forward(kmLogo.Forward it) {
    return new ForwardImpl(it, this);
  }

  default Left kmLogo__Left(kmLogo.Left it) {
    return new LeftImpl(it, this);
  }

  default Right kmLogo__Right(kmLogo.Right it) {
    return new RightImpl(it, this);
  }

  default PenDown kmLogo__PenDown(kmLogo.PenDown it) {
    return new PenDownImpl(it, this);
  }

  default PenUp kmLogo__PenUp(kmLogo.PenUp it) {
    return new PenUpImpl(it, this);
  }

  default Clear kmLogo__Clear(kmLogo.Clear it) {
    return new ClearImpl(it, this);
  }

  default Expression kmLogo__Expression(kmLogo.Expression it) {
    return new ExpressionImpl(it, this);
  }

  default BinaryExp kmLogo__BinaryExp(kmLogo.BinaryExp it) {
    return new BinaryExpImpl(it, this);
  }

  default UnaryExpression kmLogo__UnaryExpression(kmLogo.UnaryExpression it) {
    return new UnaryExpressionImpl(it, this);
  }

  default Constant kmLogo__Constant(kmLogo.Constant it) {
    return new ConstantImpl(it, this);
  }

  default ProcCall kmLogo__ProcCall(kmLogo.ProcCall it) {
    return new ProcCallImpl(it, this);
  }

  default ProcDeclaration kmLogo__ProcDeclaration(kmLogo.ProcDeclaration it) {
    return new ProcDeclarationImpl(it, this);
  }

  default Block kmLogo__Block(kmLogo.Block it) {
    return new BlockImpl(it, this);
  }

  default If kmLogo__If(kmLogo.If it) {
    return new IfImpl(it, this);
  }

  default ControlStructure kmLogo__ControlStructure(kmLogo.ControlStructure it) {
    return new ControlStructureImpl(it, this);
  }

  default Repeat kmLogo__Repeat(kmLogo.Repeat it) {
    return new RepeatImpl(it, this);
  }

  default While kmLogo__While(kmLogo.While it) {
    return new WhileImpl(it, this);
  }

  default Parameter kmLogo__Parameter(kmLogo.Parameter it) {
    return new ParameterImpl(it, this);
  }

  default ParameterCall kmLogo__ParameterCall(kmLogo.ParameterCall it) {
    return new ParameterCallImpl(it, this);
  }

  default Plus kmLogo__Plus(kmLogo.Plus it) {
    return new PlusImpl(it, this);
  }

  default Minus kmLogo__Minus(kmLogo.Minus it) {
    return new MinusImpl(it, this);
  }

  default Mult kmLogo__Mult(kmLogo.Mult it) {
    return new MultImpl(it, this);
  }

  default Div kmLogo__Div(kmLogo.Div it) {
    return new DivImpl(it, this);
  }

  default Equals kmLogo__Equals(kmLogo.Equals it) {
    return new EqualsImpl(it, this);
  }

  default Greater kmLogo__Greater(kmLogo.Greater it) {
    return new GreaterImpl(it, this);
  }

  default Lower kmLogo__Lower(kmLogo.Lower it) {
    return new LowerImpl(it, this);
  }

  default Cos kmLogo__Cos(kmLogo.Cos it) {
    return new CosImpl(it, this);
  }

  default Sin kmLogo__Sin(kmLogo.Sin it) {
    return new SinImpl(it, this);
  }

  default Tan kmLogo__Tan(kmLogo.Tan it) {
    return new TanImpl(it, this);
  }

  default LogoProgram kmLogo__LogoProgram(kmLogo.LogoProgram it) {
    return new LogoProgramImpl(it, this);
  }

  default Turtle kmLogo__Turtle(kmLogo.Turtle it) {
    return new TurtleImpl(it, this);
  }

  default Point kmLogo__Point(kmLogo.Point it) {
    return new PointImpl(it, this);
  }

  default Segment kmLogo__Segment(kmLogo.Segment it) {
    return new SegmentImpl(it, this);
  }

  default CallStack kmLogo__CallStack(kmLogo.CallStack it) {
    return new CallStackImpl(it, this);
  }

  default StackFrame kmLogo__StackFrame(kmLogo.StackFrame it) {
    return new StackFrameImpl(it, this);
  }

  default Variable kmLogo__Variable(kmLogo.Variable it) {
    return new VariableImpl(it, this);
  }
}
