package interpreter.boa.interpreter.boa;

import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface Let extends EObject, Expr {
  String getName();

  void setName(String value);

  Expr getLhs();

  void setLhs(Expr value);

  Expr getRhs();

  void setRhs(Expr value);

  EvalRes eval(Ctx ctx);
}
