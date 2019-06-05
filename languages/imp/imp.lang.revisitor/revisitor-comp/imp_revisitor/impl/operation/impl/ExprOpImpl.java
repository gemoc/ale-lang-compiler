package imp_revisitor.impl.operation.impl;

import imp.model.imp.Expr;
import imp.model.imp.ImpFactory;
import imp.model.imp.IntValue;
import imp.model.imp.Store;
import imp.model.imp.Value;
import imp.model.revisitor.ImpRevisitor;
import imp_revisitor.impl.operation.AssignOp;
import imp_revisitor.impl.operation.BinaryOp;
import imp_revisitor.impl.operation.BlockOp;
import imp_revisitor.impl.operation.BoolValueOp;
import imp_revisitor.impl.operation.ExprOp;
import imp_revisitor.impl.operation.IfOp;
import imp_revisitor.impl.operation.IntConstOp;
import imp_revisitor.impl.operation.IntValueOp;
import imp_revisitor.impl.operation.SkipOp;
import imp_revisitor.impl.operation.StmtOp;
import imp_revisitor.impl.operation.StoreOp;
import imp_revisitor.impl.operation.UnaryOp;
import imp_revisitor.impl.operation.ValueOp;
import imp_revisitor.impl.operation.VarOp;
import imp_revisitor.impl.operation.WhileOp;

public class ExprOpImpl implements ExprOp {
  private ImpRevisitor<AssignOp, BinaryOp, BlockOp, BoolValueOp, ExprOp, IfOp, IntConstOp, IntValueOp, SkipOp, StmtOp, StoreOp, UnaryOp, ValueOp, VarOp, WhileOp> rev;

  private Expr obj;

  public ExprOpImpl(Expr obj,
      ImpRevisitor<AssignOp, BinaryOp, BlockOp, BoolValueOp, ExprOp, IfOp, IntConstOp, IntValueOp, SkipOp, StmtOp, StoreOp, UnaryOp, ValueOp, VarOp, WhileOp> rev) {
    this.obj = obj;
    this.rev = rev;
  }

  public Value evaluate(Store s) {
    Value result;
    result = ((IntValue) (ImpFactory.eINSTANCE.createIntValue()));
    return result;
  }
}
