package visitor.boa.visitor.boa;

import java.lang.String;
import org.eclipse.emf.ecore.EObject;
import visitor.visitor.AcceptInterface;

public interface EvalFunRes extends EObject, AcceptInterface, EvalRes {
  String getName();

  void setName(String value);

  Expr getExp();

  void setExp(Expr value);

  Ctx getCtx();

  void setCtx(Ctx value);
}
