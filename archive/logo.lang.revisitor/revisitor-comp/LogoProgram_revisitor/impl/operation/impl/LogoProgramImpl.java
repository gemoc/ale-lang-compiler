package LogoProgram_revisitor.impl.operation.impl;

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
import kmLogo.revisitor.KmLogoRevisitor;

public class LogoProgramImpl implements LogoProgram {
  private KmLogoRevisitor<Back, BinaryExp, Block, CallStack, Clear, Constant, ControlStructure, Cos, Div, Equals, Expression, Forward, Greater, If, Instruction, Left, LogoProgram, Lower, Minus, Mult, Parameter, ParameterCall, PenDown, PenUp, Plus, Point, Primitive, ProcCall, ProcDeclaration, Repeat, Right, Segment, Sin, StackFrame, Tan, Turtle, UnaryExpression, Variable, While> rev;

  private kmLogo.LogoProgram obj;

  public LogoProgramImpl(kmLogo.LogoProgram obj,
      KmLogoRevisitor<Back, BinaryExp, Block, CallStack, Clear, Constant, ControlStructure, Cos, Div, Equals, Expression, Forward, Greater, If, Instruction, Left, LogoProgram, Lower, Minus, Mult, Parameter, ParameterCall, PenDown, PenUp, Plus, Point, Primitive, ProcCall, ProcDeclaration, Repeat, Right, Segment, Sin, StackFrame, Tan, Turtle, UnaryExpression, Variable, While> rev) {
    this.obj = obj;
    this.rev = rev;
  }

  public kmLogo.Turtle eval() {
    kmLogo.Turtle result;
    long start = ((long)logo.example.service.TimeService.time(this.obj));
    kmLogo.Turtle turtle = ((kmLogo.Turtle)rev.$(this.obj).createTurtle());
    result = turtle;
    for(kmLogo.Instruction it: this.obj.getInstructions()) {
      rev.$(it).eval(turtle);
    }
    result = turtle;
    long stop = ((long)logo.example.service.TimeService.time(this.obj));
    long time = ((long)(stop) - (start));
    org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log(time);
    org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(turtle.getDrawings()));
    return result;
  }

  public kmLogo.Turtle createTurtle() {
    kmLogo.Turtle result;
    kmLogo.Turtle turtle = ((kmLogo.Turtle)kmLogo.KmLogoFactory.eINSTANCE.createTurtle());
    turtle.setPosition(kmLogo.KmLogoFactory.eINSTANCE.createPoint());
    turtle.getPosition().setX(0.0);
    turtle.getPosition().setY(0.0);
    turtle.setCallStack(kmLogo.KmLogoFactory.eINSTANCE.createCallStack());
    turtle.getCallStack().getFrames().add(kmLogo.KmLogoFactory.eINSTANCE.createStackFrame());
    result = turtle;
    return result;
  }
}
