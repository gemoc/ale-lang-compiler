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

public class ProcCallImpl extends ExpressionImpl implements ProcCall {
  private KmLogoRevisitor<Back, BinaryExp, Block, CallStack, Clear, Constant, ControlStructure, Cos, Div, Equals, Expression, Forward, Greater, If, Instruction, Left, LogoProgram, Lower, Minus, Mult, Parameter, ParameterCall, PenDown, PenUp, Plus, Point, Primitive, ProcCall, ProcDeclaration, Repeat, Right, Segment, Sin, StackFrame, Tan, Turtle, UnaryExpression, Variable, While> rev;

  private kmLogo.ProcCall obj;

  public ProcCallImpl(kmLogo.ProcCall obj,
      KmLogoRevisitor<Back, BinaryExp, Block, CallStack, Clear, Constant, ControlStructure, Cos, Div, Equals, Expression, Forward, Greater, If, Instruction, Left, LogoProgram, Lower, Minus, Mult, Parameter, ParameterCall, PenDown, PenUp, Plus, Point, Primitive, ProcCall, ProcDeclaration, Repeat, Right, Segment, Sin, StackFrame, Tan, Turtle, UnaryExpression, Variable, While> rev) {
    super(obj, rev);
    this.obj = obj;
    this.rev = rev;
  }

  public double eval(kmLogo.Turtle turtle) {
    double result;
    org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log(("Calling ") + (this.obj.getDeclaration().getName()));
    kmLogo.StackFrame newFrame = ((kmLogo.StackFrame)kmLogo.KmLogoFactory.eINSTANCE.createStackFrame());
    int i = ((int)1);
    for(kmLogo.Expression exp: this.obj.getActualArgs()) {
      kmLogo.Variable newVar = ((kmLogo.Variable)kmLogo.KmLogoFactory.eINSTANCE.createVariable());
      newVar.setName(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.get(this.obj.getDeclaration().getArgs(), i).getName());
      newVar.setValue(rev.$(exp).eval(turtle));
      newFrame.getVariables().add(newVar);
      i = (i) + (1);
    }
    turtle.getCallStack().getFrames().add(newFrame);
    result = 0.0;
    for(kmLogo.Instruction instr: this.obj.getDeclaration().getInstructions()) {
      result = rev.$(instr).eval(turtle);
    }
    turtle.getCallStack().getFrames().remove(newFrame);
    return result;
  }
}
