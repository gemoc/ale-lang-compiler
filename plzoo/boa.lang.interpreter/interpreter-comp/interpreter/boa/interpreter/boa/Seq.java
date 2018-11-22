package interpreter.boa.interpreter.boa;

import org.eclipse.emf.ecore.EObject;

public interface Seq extends EObject, Expr {
  Expr getLhs();

  void setLhs(Expr value);

  Expr getRhs();

  void setRhs(Expr value);

  EvalRes eval(Ctx ctx);
}
