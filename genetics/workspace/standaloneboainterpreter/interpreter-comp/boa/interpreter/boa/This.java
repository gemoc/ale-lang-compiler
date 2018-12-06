package boa.interpreter.boa;

import boa.interpreter.boa.impl.ThisDispatchWrapperEval;
import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface This extends EObject, NodeInterface, Expr {
  EvalRes eval(Ctx ctx);

  ThisDispatchWrapperEval getCachedEval();
}
