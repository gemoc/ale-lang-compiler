package boa.interpreter.boa;

import boa.interpreter.boa.impl.SeqDispatchWrapperEval;
import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface Seq extends EObject, NodeInterface, Expr {
  Expr getLhs();

  void setLhs(Expr value);

  Expr getRhs();

  void setRhs(Expr value);

  EvalRes eval(Ctx ctx);

  SeqDispatchWrapperEval getCachedEval();
}
