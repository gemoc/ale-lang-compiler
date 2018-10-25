package boa_dynamic.interpreter.boa_dynamic;

import boa.interpreter.boa.Expr;
import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface EvalFunRes extends EObject, EvalRes {
  String getName();

  void setName(String value);

  Expr getExp();

  void setExp(Expr value);

  Ctx getCtx();

  void setCtx(Ctx value);
}
