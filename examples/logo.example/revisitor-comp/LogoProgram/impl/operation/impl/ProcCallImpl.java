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
import java.lang.RuntimeException;
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
      newVar.setName(/*Call org.eclipse.acceleo.query.ast.impl.CallImpl@1127a793 (serviceName: at, type: COLLECTIONCALL)*/.getName());
      newVar.setValue(rev.$(exp).eval(turtle));
      newFrame.add(newVar);
      i = (i) + (1);
    }
    turtle.getCallStack().getFrames().add(newFrame);
    result = 0.0;
    for(kmLogo.Instruction instr: this.obj.getDeclaration().getInstructions()) {
      result = rev.$(instr).eval(turtle);
    }
    throw new RuntimeException("FeatureRemove not implemented");
    return result;
  }
}
