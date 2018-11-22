package boa.interpreter.boa;

import boa.interpreter.boa.impl.IfDispatchWrapperEval;
import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface If extends EObject, NodeInterface, Expr {
  Expr getCond();

  void setCond(Expr value);

  Expr getThn();

  void setThn(Expr value);

  Expr getEls();

  void setEls(Expr value);

  EvalRes eval(Ctx ctx);

  IfDispatchWrapperEval getCachedEval();
}
