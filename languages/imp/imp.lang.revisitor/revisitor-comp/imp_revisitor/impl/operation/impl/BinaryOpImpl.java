package imp_revisitor.impl.operation.impl;

import imp.model.imp.Binary;
import imp.model.imp.BoolValue;
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
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

public class BinaryOpImpl extends ExprOpImpl implements BinaryOp {
  private ImpRevisitor<AssignOp, BinaryOp, BlockOp, BoolValueOp, ExprOp, IfOp, IntConstOp, IntValueOp, SkipOp, StmtOp, StoreOp, UnaryOp, ValueOp, VarOp, WhileOp> rev;

  private Binary obj;

  public BinaryOpImpl(Binary obj,
      ImpRevisitor<AssignOp, BinaryOp, BlockOp, BoolValueOp, ExprOp, IfOp, IntConstOp, IntValueOp, SkipOp, StmtOp, StoreOp, UnaryOp, ValueOp, VarOp, WhileOp> rev) {
    super(obj, rev);
    this.obj = obj;
    this.rev = rev;
  }

  public Value evaluate(Store s) {
    Value result;
    Value lv = ((Value) (rev.$((Expr)this.obj.getLhs()).evaluate(((Store) (s)))));
    Value rv = ((Value) (rev.$((Expr)this.obj.getRhs()).evaluate(((Store) (s)))));
    if(EqualService.equals((this.obj.getOp().getValue()), (4))) {
      IntValue ilv = ((IntValue) (((IntValue) (lv))));
      IntValue irv = ((IntValue) (((IntValue) (rv))));
      BoolValue res = ((BoolValue) (ImpFactory.eINSTANCE.createBoolValue()));
      res.setValue((ilv.getValue()) <= (irv.getValue()));
      result = ((BoolValue) (res));
    }
    else {
      result = ((Value) (null));
    }
    return result;
  }
}
