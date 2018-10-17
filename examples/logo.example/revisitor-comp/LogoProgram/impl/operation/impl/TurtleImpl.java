package LogoProgram.impl.operation.impl;

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
import kmLogo.revisitor.KmLogoRevisitor;

public class TurtleImpl implements Turtle {
  private KmLogoRevisitor<Back, BinaryExp, Block, CallStack, Clear, Constant, ControlStructure, Cos, Div, Equals, Expression, Forward, Greater, If, Instruction, Left, LogoProgram, Lower, Minus, Mult, Parameter, ParameterCall, PenDown, PenUp, Plus, Point, Primitive, ProcCall, ProcDeclaration, Repeat, Right, Segment, Sin, StackFrame, Tan, Turtle, UnaryExpression, Variable, While> rev;

  private kmLogo.Turtle obj;

  public TurtleImpl(kmLogo.Turtle obj,
      KmLogoRevisitor<Back, BinaryExp, Block, CallStack, Clear, Constant, ControlStructure, Cos, Div, Equals, Expression, Forward, Greater, If, Instruction, Left, LogoProgram, Lower, Minus, Mult, Parameter, ParameterCall, PenDown, PenUp, Plus, Point, Primitive, ProcCall, ProcDeclaration, Repeat, Right, Segment, Sin, StackFrame, Tan, Turtle, UnaryExpression, Variable, While> rev) {
    this.obj = obj;
    this.rev = rev;
  }

  public void move(double dx, double dy) {
    kmLogo.Point newPos = ((kmLogo.Point)kmLogo.KmLogoFactory.eINSTANCE.createPoint());
    newPos.setX((this.obj.getPosition().getX()) + (dx));
    newPos.setY((this.obj.getPosition().getY()) + (dy));
    if(this.obj.getPenUp()) {
    }
    else {
      kmLogo.Segment newSegment = ((kmLogo.Segment)kmLogo.KmLogoFactory.eINSTANCE.createSegment());
      newSegment.setBegin(this.obj.getPosition());
      newSegment.setEnd(newPos);
      this.obj.getDrawings().add(newSegment);
    }
    kmLogo.Point newPosCopy = ((kmLogo.Point)kmLogo.KmLogoFactory.eINSTANCE.createPoint());
    newPosCopy.setX(newPos.getX());
    newPosCopy.setY(newPos.getY());
    this.obj.setPosition(newPosCopy);
  }

  public void forward(double steps) {
    rev.$(this.obj).move(/*Call org.eclipse.acceleo.query.ast.impl.CallImpl@6a17383d (serviceName: mult, type: CALLSERVICE)*/,/*Call org.eclipse.acceleo.query.ast.impl.CallImpl@3c594a58 (serviceName: mult, type: CALLSERVICE)*/);
  }

  public void rotate(double angle) {
    double newAngle = ((double)(this.obj.getHeading()) + (angle));
    if((newAngle) > (360.0)) {
      newAngle = (newAngle) - (360.0);
      this.obj.setHeading(newAngle);
    }
    else {
      if(/*Call org.eclipse.acceleo.query.ast.impl.CallImpl@17aa498e (serviceName: lessThan, type: CALLSERVICE)*/) {
        newAngle = (360.0) + (newAngle);
        this.obj.setHeading(newAngle);
      }
      else {
        this.obj.setHeading(newAngle);
      }
    }
  }
}
