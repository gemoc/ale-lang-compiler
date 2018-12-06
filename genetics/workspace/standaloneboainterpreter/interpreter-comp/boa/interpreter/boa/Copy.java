package boa.interpreter.boa;

import boa.interpreter.boa.impl.CopyDispatchWrapperEval;
import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface Copy extends EObject, NodeInterface, Expr {
  Expr getCopy();

  void setCopy(Expr value);

  EvalRes eval(Ctx ctx);

  CopyDispatchWrapperEval getCachedEval();
}
