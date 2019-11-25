package boa.interpreter.boa;

import com.oracle.truffle.api.nodes.NodeInterface;
import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface EvalFunRes extends EObject, NodeInterface, EvalRes {
  String getName();

  void setName(String value);

  Expr getExp();

  void setExp(Expr value);

  Ctx getCtx();

  void setCtx(Ctx value);
}
