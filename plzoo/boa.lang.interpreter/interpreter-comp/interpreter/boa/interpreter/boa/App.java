package interpreter.boa.interpreter.boa;

import org.eclipse.emf.ecore.EObject;

public interface App extends EObject, Expr {
  Expr getLhs();

  void setLhs(Expr value);

  Expr getRhs();

  void setRhs(Expr value);

  EvalRes eval(Ctx ctx);

  EvalRes callFunc(EvalFunRes fct, Ctx callCtx);
}
