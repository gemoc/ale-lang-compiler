package visitor;

import java.lang.Object;
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

public interface VisitorInterface {
  Object visitkmLogo__Back(Back it);

  Object visitkmLogo__Forward(Forward it);

  Object visitkmLogo__Left(Left it);

  Object visitkmLogo__Right(Right it);

  Object visitkmLogo__PenDown(PenDown it);

  Object visitkmLogo__PenUp(PenUp it);

  Object visitkmLogo__Clear(Clear it);

  Object visitkmLogo__Constant(Constant it);

  Object visitkmLogo__ProcCall(ProcCall it);

  Object visitkmLogo__ProcDeclaration(ProcDeclaration it);

  Object visitkmLogo__Block(Block it);

  Object visitkmLogo__If(If it);

  Object visitkmLogo__ControlStructure(ControlStructure it);

  Object visitkmLogo__Repeat(Repeat it);

  Object visitkmLogo__While(While it);

  Object visitkmLogo__Parameter(Parameter it);

  Object visitkmLogo__ParameterCall(ParameterCall it);

  Object visitkmLogo__Plus(Plus it);

  Object visitkmLogo__Minus(Minus it);

  Object visitkmLogo__Mult(Mult it);

  Object visitkmLogo__Div(Div it);

  Object visitkmLogo__Equals(Equals it);

  Object visitkmLogo__Greater(Greater it);

  Object visitkmLogo__Lower(Lower it);

  Object visitkmLogo__Cos(Cos it);

  Object visitkmLogo__Sin(Sin it);

  Object visitkmLogo__Tan(Tan it);

  Object visitkmLogo__LogoProgram(LogoProgram it);

  Object visitkmLogo__Turtle(Turtle it);

  Object visitkmLogo__Point(Point it);

  Object visitkmLogo__Segment(Segment it);

  Object visitkmLogo__CallStack(CallStack it);

  Object visitkmLogo__StackFrame(StackFrame it);

  Object visitkmLogo__Variable(Variable it);
}
