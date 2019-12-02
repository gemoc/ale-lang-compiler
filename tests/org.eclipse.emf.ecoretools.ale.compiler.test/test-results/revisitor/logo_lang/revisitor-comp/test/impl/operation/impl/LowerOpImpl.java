package test.impl.operation.impl;

import java.lang.Double;
import kmLogo.Expression;
import kmLogo.Lower;
import kmLogo.Turtle;
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

public class LowerOpImpl extends BinaryExpOpImpl implements LowerOp {
  private KmLogoRevisitor<BackOp, BinaryExpOp, BlockOp, CallStackOp, ClearOp, ConstantOp, ControlStructureOp, CosOp, DivOp, EqualsOp, ExpressionOp, ForwardOp, GreaterOp, IfOp, InstructionOp, LeftOp, LogoProgramOp, LowerOp, MinusOp, MultOp, ParameterOp, ParameterCallOp, PenDownOp, PenUpOp, PlusOp, PointOp, PrimitiveOp, ProcCallOp, ProcDeclarationOp, RepeatOp, RightOp, SegmentOp, SinOp, StackFrameOp, TanOp, TurtleOp, UnaryExpressionOp, VariableOp, WhileOp> rev;

  private Lower obj;

  public LowerOpImpl(Lower obj,
      KmLogoRevisitor<BackOp, BinaryExpOp, BlockOp, CallStackOp, ClearOp, ConstantOp, ControlStructureOp, CosOp, DivOp, EqualsOp, ExpressionOp, ForwardOp, GreaterOp, IfOp, InstructionOp, LeftOp, LogoProgramOp, LowerOp, MinusOp, MultOp, ParameterOp, ParameterCallOp, PenDownOp, PenUpOp, PlusOp, PointOp, PrimitiveOp, ProcCallOp, ProcDeclarationOp, RepeatOp, RightOp, SegmentOp, SinOp, StackFrameOp, TanOp, TurtleOp, UnaryExpressionOp, VariableOp, WhileOp> rev) {
    super(obj, rev);
    this.obj = obj;
    this.rev = rev;
  }

  public double eval(Turtle turtle) {
    double result;
    if((rev.$((Expression)this.obj.getLhs()).eval(((Turtle) (turtle)))) < (rev.$((Expression)this.obj.getRhs()).eval(((Turtle) (turtle))))) {
      result = ((Double) 1.0);
    }
    else {
      result = ((Double) 0.0);
    }
    return result;
  }
}
