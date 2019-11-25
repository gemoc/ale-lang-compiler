package visitor.visitor.operation.boa.impl;

import visitor.boa.visitor.boa.Ctx;
import visitor.boa.visitor.boa.EvalBoundFunRes;
import visitor.boa.visitor.boa.EvalFunRes;
import visitor.boa.visitor.boa.EvalMapRes;
import visitor.boa.visitor.boa.EvalRes;
import visitor.boa.visitor.boa.Project;
import visitor.visitor.VisitorInterface;
import visitor.visitor.operation.boa.ProjectOperation;

public class ProjectOperationImpl extends ExprOperationImpl implements ProjectOperation {
  private final Project it;

  private final VisitorInterface vis;

  public ProjectOperationImpl(Project it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    EvalRes vexp = ((EvalRes)((visitor.visitor.operation.boa.ExprOperation)this.it.getExp().accept(vis)).eval(ctx));
    if(vexp instanceof visitor.boa.visitor.boa.EvalMapRes) {
      EvalMapRes mvexp = ((EvalMapRes)vexp);
      if(execboa.MapService.containsKey(mvexp.getValues(), this.it.getName())) {
        EvalRes x = ((EvalRes)mvexp.getValues().get(this.it.getName()));
        if(x instanceof visitor.boa.visitor.boa.EvalFunRes) {
          EvalFunRes func = ((EvalFunRes)x);
          result = ((visitor.visitor.operation.boa.ProjectOperation)this.it.accept(vis)).project(func,mvexp);
        }
        else {
          result = x;
        }
      }
      else {
        result = null;
      }
    }
    else {
      result = null;
    }
    return result;
  }

  public EvalRes project(EvalFunRes func, EvalMapRes mvexp) {
    EvalRes result;
    EvalBoundFunRes ret = ((EvalBoundFunRes)visitor.boa.visitor.boa.BoaFactory.eINSTANCE.createEvalBoundFunRes());
    ret.setExp(func.getExp());
    ret.setCtx(func.getCtx());
    ret.setName(func.getName());
    execboa.MapService.replaceWith(ret.getTh(), mvexp.getValues());
    result = ret;
    return result;
  }
}
