package LogoProgram.impl;

import LogoProgram.impl.operation.Back;
import LogoProgram.impl.operation.BinaryExp;
import LogoProgram.impl.operation.Block;
import LogoProgram.impl.operation.CallStack;
import LogoProgram.impl.operation.Clear;
import LogoProgram.impl.operation.Constant;
import LogoProgram.impl.operation.ControlStructure;
import LogoProgram.impl.operation.Cos;
import LogoProgram.impl.operation.Div;
import LogoProgram.impl.operation.Equals;
import LogoProgram.impl.operation.Expression;
import LogoProgram.impl.operation.Forward;
import LogoProgram.impl.operation.Greater;
import LogoProgram.impl.operation.If;
import LogoProgram.impl.operation.Instruction;
import LogoProgram.impl.operation.Left;
import LogoProgram.impl.operation.LogoProgram;
import LogoProgram.impl.operation.Lower;
import LogoProgram.impl.operation.Minus;
import LogoProgram.impl.operation.Mult;
import LogoProgram.impl.operation.Parameter;
import LogoProgram.impl.operation.ParameterCall;
import LogoProgram.impl.operation.PenDown;
import LogoProgram.impl.operation.PenUp;
import LogoProgram.impl.operation.Plus;
import LogoProgram.impl.operation.Point;
import LogoProgram.impl.operation.Primitive;
import LogoProgram.impl.operation.ProcCall;
import LogoProgram.impl.operation.ProcDeclaration;
import LogoProgram.impl.operation.Repeat;
import LogoProgram.impl.operation.Right;
import LogoProgram.impl.operation.Segment;
import LogoProgram.impl.operation.Sin;
import LogoProgram.impl.operation.StackFrame;
import LogoProgram.impl.operation.Tan;
import LogoProgram.impl.operation.Turtle;
import LogoProgram.impl.operation.UnaryExpression;
import LogoProgram.impl.operation.Variable;
import LogoProgram.impl.operation.While;
import LogoProgram.impl.operation.impl.BackImpl;
import LogoProgram.impl.operation.impl.BinaryExpImpl;
import LogoProgram.impl.operation.impl.BlockImpl;
import LogoProgram.impl.operation.impl.CallStackImpl;
import LogoProgram.impl.operation.impl.ClearImpl;
import LogoProgram.impl.operation.impl.ConstantImpl;
import LogoProgram.impl.operation.impl.ControlStructureImpl;
import LogoProgram.impl.operation.impl.CosImpl;
import LogoProgram.impl.operation.impl.DivImpl;
import LogoProgram.impl.operation.impl.EqualsImpl;
import LogoProgram.impl.operation.impl.ExpressionImpl;
import LogoProgram.impl.operation.impl.ForwardImpl;
import LogoProgram.impl.operation.impl.GreaterImpl;
import LogoProgram.impl.operation.impl.IfImpl;
import LogoProgram.impl.operation.impl.InstructionImpl;
import LogoProgram.impl.operation.impl.LeftImpl;
import LogoProgram.impl.operation.impl.LogoProgramImpl;
import LogoProgram.impl.operation.impl.LowerImpl;
import LogoProgram.impl.operation.impl.MinusImpl;
import LogoProgram.impl.operation.impl.MultImpl;
import LogoProgram.impl.operation.impl.ParameterCallImpl;
import LogoProgram.impl.operation.impl.ParameterImpl;
import LogoProgram.impl.operation.impl.PenDownImpl;
import LogoProgram.impl.operation.impl.PenUpImpl;
import LogoProgram.impl.operation.impl.PlusImpl;
import LogoProgram.impl.operation.impl.PointImpl;
import LogoProgram.impl.operation.impl.PrimitiveImpl;
import LogoProgram.impl.operation.impl.ProcCallImpl;
import LogoProgram.impl.operation.impl.ProcDeclarationImpl;
import LogoProgram.impl.operation.impl.RepeatImpl;
import LogoProgram.impl.operation.impl.RightImpl;
import LogoProgram.impl.operation.impl.SegmentImpl;
import LogoProgram.impl.operation.impl.SinImpl;
import LogoProgram.impl.operation.impl.StackFrameImpl;
import LogoProgram.impl.operation.impl.TanImpl;
import LogoProgram.impl.operation.impl.TurtleImpl;
import LogoProgram.impl.operation.impl.UnaryExpressionImpl;
import LogoProgram.impl.operation.impl.VariableImpl;
import LogoProgram.impl.operation.impl.WhileImpl;
import kmLogo.revisitor.KmLogoRevisitor;

public interface LogoProgramImplementation extends KmLogoRevisitor<Back, BinaryExp, Block, CallStack, Clear, Constant, ControlStructure, Cos, Div, Equals, Expression, Forward, Greater, If, Instruction, Left, LogoProgram, Lower, Minus, Mult, Parameter, ParameterCall, PenDown, PenUp, Plus, Point, Primitive, ProcCall, ProcDeclaration, Repeat, Right, Segment, Sin, StackFrame, Tan, Turtle, UnaryExpression, Variable, While> {
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
