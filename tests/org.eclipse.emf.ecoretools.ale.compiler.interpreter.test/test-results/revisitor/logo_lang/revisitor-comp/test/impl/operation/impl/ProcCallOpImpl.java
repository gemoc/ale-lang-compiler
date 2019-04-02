package test.impl.operation.impl;

import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;

import kmLogo.Expression;
import kmLogo.KmLogoFactory;
import kmLogo.ProcCall;
import kmLogo.ProcDeclaration;
import kmLogo.StackFrame;
import kmLogo.Turtle;
import kmLogo.Variable;
import kmLogo.revisitor.KmLogoRevisitor;
import test.impl.operation.BackOp;
import test.impl.operation.BinaryExpOp;
import test.impl.operation.BlockOp;
import test.impl.operation.CallStackOp;
import test.impl.operation.ClearOp;
import test.impl.operation.ConstantOp;
import test.impl.operation.ControlStructureOp;
import test.impl.operation.CosOp;
import test.impl.operation.DivOp;
import test.impl.operation.EqualsOp;
import test.impl.operation.ExpressionOp;
import test.impl.operation.ForwardOp;
import test.impl.operation.GreaterOp;
import test.impl.operation.IfOp;
import test.impl.operation.InstructionOp;
import test.impl.operation.LeftOp;
import test.impl.operation.LogoProgramOp;
import test.impl.operation.LowerOp;
import test.impl.operation.MinusOp;
import test.impl.operation.MultOp;
import test.impl.operation.ParameterCallOp;
import test.impl.operation.ParameterOp;
import test.impl.operation.PenDownOp;
import test.impl.operation.PenUpOp;
import test.impl.operation.PlusOp;
import test.impl.operation.PointOp;
import test.impl.operation.PrimitiveOp;
import test.impl.operation.ProcCallOp;
import test.impl.operation.ProcDeclarationOp;
import test.impl.operation.RepeatOp;
import test.impl.operation.RightOp;
import test.impl.operation.SegmentOp;
import test.impl.operation.SinOp;
import test.impl.operation.StackFrameOp;
import test.impl.operation.TanOp;
import test.impl.operation.TurtleOp;
import test.impl.operation.UnaryExpressionOp;
import test.impl.operation.VariableOp;
import test.impl.operation.WhileOp;

public class ProcCallOpImpl extends ExpressionOpImpl implements ProcCallOp {
  private KmLogoRevisitor<BackOp, BinaryExpOp, BlockOp, CallStackOp, ClearOp, ConstantOp, ControlStructureOp, CosOp, DivOp, EqualsOp, ExpressionOp, ForwardOp, GreaterOp, IfOp, InstructionOp, LeftOp, LogoProgramOp, LowerOp, MinusOp, MultOp, ParameterOp, ParameterCallOp, PenDownOp, PenUpOp, PlusOp, PointOp, PrimitiveOp, ProcCallOp, ProcDeclarationOp, RepeatOp, RightOp, SegmentOp, SinOp, StackFrameOp, TanOp, TurtleOp, UnaryExpressionOp, VariableOp, WhileOp> rev;

  private ProcCall obj;

  public ProcCallOpImpl(ProcCall obj,
      KmLogoRevisitor<BackOp, BinaryExpOp, BlockOp, CallStackOp, ClearOp, ConstantOp, ControlStructureOp, CosOp, DivOp, EqualsOp, ExpressionOp, ForwardOp, GreaterOp, IfOp, InstructionOp, LeftOp, LogoProgramOp, LowerOp, MinusOp, MultOp, ParameterOp, ParameterCallOp, PenDownOp, PenUpOp, PlusOp, PointOp, PrimitiveOp, ProcCallOp, ProcDeclarationOp, RepeatOp, RightOp, SegmentOp, SinOp, StackFrameOp, TanOp, TurtleOp, UnaryExpressionOp, VariableOp, WhileOp> rev) {
    super(obj, rev);
    this.obj = obj;
    this.rev = rev;
  }

  public double eval(Turtle turtle) {
    double result;
    LogService.log(("Calling ") + (this.obj.getDeclaration().getName()));
    StackFrame newFrame = ((StackFrame) (KmLogoFactory.eINSTANCE.createStackFrame()));
    int i = ((int) (0));
    for(Expression exp: this.obj.getActualArgs()) {
      Variable newVar = ((Variable) (KmLogoFactory.eINSTANCE.createVariable()));
      newVar.setName(CollectionService.get(this.obj.getDeclaration().getArgs(), i).getName());
      newVar.setValue(rev.$((Expression)exp).eval(((Turtle) (turtle))));
      newFrame.getVariables().add(newVar);
      i = (i) + (1);
    }
    turtle.getCallStack().getFrames().add(newFrame);
    result = 0.0;
    if(this.obj.getDeclaration() instanceof ProcDeclaration) {
      ProcDeclaration decl = ((ProcDeclaration) (this.obj.getDeclaration()));
      rev.$((ProcDeclaration)decl).deval(((Turtle) (turtle)));
    }
    turtle.getCallStack().getFrames().remove(newFrame);
    return result;
  }
}
