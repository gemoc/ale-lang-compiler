package boa_exec_revisitor.impl.operation.impl;

import boa.BObject;
import boa.BoaFactory;
import boa.Ctx;
import boa.EvalMapRes;
import boa.EvalRes;
import boa.Expr;
import boa.Field;
import boa.revisitor.BoaRevisitor;
import boa_exec_revisitor.impl.operation.AppOp;
import boa_exec_revisitor.impl.operation.ArithOpDivideOp;
import boa_exec_revisitor.impl.operation.ArithOpMinusOp;
import boa_exec_revisitor.impl.operation.ArithOpOp;
import boa_exec_revisitor.impl.operation.ArithOpPlusOp;
import boa_exec_revisitor.impl.operation.ArithOpRemainderOp;
import boa_exec_revisitor.impl.operation.ArithOpTimesOp;
import boa_exec_revisitor.impl.operation.AssignOp;
import boa_exec_revisitor.impl.operation.BObjectOp;
import boa_exec_revisitor.impl.operation.BoolOp;
import boa_exec_revisitor.impl.operation.BoolOpAndOp;
import boa_exec_revisitor.impl.operation.BoolOpOp;
import boa_exec_revisitor.impl.operation.BoolOpOrOp;
import boa_exec_revisitor.impl.operation.CmpOpEqualOp;
import boa_exec_revisitor.impl.operation.CmpOpLessOp;
import boa_exec_revisitor.impl.operation.CmpOpOp;
import boa_exec_revisitor.impl.operation.CmpOpUnequalOp;
import boa_exec_revisitor.impl.operation.CopyOp;
import boa_exec_revisitor.impl.operation.CtxOp;
import boa_exec_revisitor.impl.operation.DefOp;
import boa_exec_revisitor.impl.operation.EvalBoolResOp;
import boa_exec_revisitor.impl.operation.EvalBoundFunResOp;
import boa_exec_revisitor.impl.operation.EvalFunResOp;
import boa_exec_revisitor.impl.operation.EvalIntResOp;
import boa_exec_revisitor.impl.operation.EvalMapResOp;
import boa_exec_revisitor.impl.operation.EvalResOp;
import boa_exec_revisitor.impl.operation.ExprOp;
import boa_exec_revisitor.impl.operation.FieldOp;
import boa_exec_revisitor.impl.operation.FileOp;
import boa_exec_revisitor.impl.operation.FunOp;
import boa_exec_revisitor.impl.operation.IfOp;
import boa_exec_revisitor.impl.operation.IntOp;
import boa_exec_revisitor.impl.operation.LetOp;
import boa_exec_revisitor.impl.operation.NotOp;
import boa_exec_revisitor.impl.operation.ProjectOp;
import boa_exec_revisitor.impl.operation.SeqOp;
import boa_exec_revisitor.impl.operation.SkipOp;
import boa_exec_revisitor.impl.operation.ThisOp;
import boa_exec_revisitor.impl.operation.TopLevelCmdOp;
import boa_exec_revisitor.impl.operation.VarOp;
import boa_exec_revisitor.impl.operation.WithOp;
import execboa.MapService;
import java.lang.String;
import org.eclipse.emf.common.util.EMap;

public class BObjectOpImpl extends ExprOpImpl implements BObjectOp {
  private BoaRevisitor<AppOp, ArithOpOp, ArithOpDivideOp, ArithOpMinusOp, ArithOpPlusOp, ArithOpRemainderOp, ArithOpTimesOp, AssignOp, BObjectOp, BoolOp, BoolOpOp, BoolOpAndOp, BoolOpOrOp, CmpOpOp, CmpOpEqualOp, CmpOpLessOp, CmpOpUnequalOp, CopyOp, CtxOp, DefOp, EvalBoolResOp, EvalBoundFunResOp, EvalFunResOp, EvalIntResOp, EvalMapResOp, EvalResOp, ExprOp, FieldOp, FileOp, FunOp, IfOp, IntOp, LetOp, NotOp, ProjectOp, SeqOp, SkipOp, ThisOp, TopLevelCmdOp, VarOp, WithOp> rev;

  private BObject obj;

  public BObjectOpImpl(BObject obj,
      BoaRevisitor<AppOp, ArithOpOp, ArithOpDivideOp, ArithOpMinusOp, ArithOpPlusOp, ArithOpRemainderOp, ArithOpTimesOp, AssignOp, BObjectOp, BoolOp, BoolOpOp, BoolOpAndOp, BoolOpOrOp, CmpOpOp, CmpOpEqualOp, CmpOpLessOp, CmpOpUnequalOp, CopyOp, CtxOp, DefOp, EvalBoolResOp, EvalBoundFunResOp, EvalFunResOp, EvalIntResOp, EvalMapResOp, EvalResOp, ExprOp, FieldOp, FileOp, FunOp, IfOp, IntOp, LetOp, NotOp, ProjectOp, SeqOp, SkipOp, ThisOp, TopLevelCmdOp, VarOp, WithOp> rev) {
    super(obj, rev);
    this.obj = obj;
    this.rev = rev;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    EvalMapRes ret = ((EvalMapRes) (BoaFactory.eINSTANCE.createEvalMapRes()));
    for(Field x: this.obj.getFields()) {
      EvalRes v = ((EvalRes) (rev.$((Expr)x.getValue()).eval(((Ctx) (ctx)))));
      MapService.put((EMap) (ret.getValues()), (String) (x.getName()), (EvalRes) (v));
    }
    result = ret;
    return result;
  }
}
