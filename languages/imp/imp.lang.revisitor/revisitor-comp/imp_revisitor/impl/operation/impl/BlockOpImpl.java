package imp_revisitor.impl.operation.impl;

import imp.model.imp.Block;
import imp.model.imp.Stmt;
import imp.model.imp.Store;
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

public class BlockOpImpl extends StmtOpImpl implements BlockOp {
  private ImpRevisitor<AssignOp, BinaryOp, BlockOp, BoolValueOp, ExprOp, IfOp, IntConstOp, IntValueOp, SkipOp, StmtOp, StoreOp, UnaryOp, ValueOp, VarOp, WhileOp> rev;

  private Block obj;

  public BlockOpImpl(Block obj,
      ImpRevisitor<AssignOp, BinaryOp, BlockOp, BoolValueOp, ExprOp, IfOp, IntConstOp, IntValueOp, SkipOp, StmtOp, StoreOp, UnaryOp, ValueOp, VarOp, WhileOp> rev) {
    super(obj, rev);
    this.obj = obj;
    this.rev = rev;
  }

  public Store execute(Store s) {
    Store result;
    result = ((Store) (s));
    for(Stmt e: this.obj.getStmts()) {
      result = ((Store) (rev.$((Stmt)e).execute(((Store) (result)))));
    }
    return result;
  }
}
