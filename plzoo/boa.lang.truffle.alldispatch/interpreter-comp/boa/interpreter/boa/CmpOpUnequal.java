package boa.interpreter.boa;

import boa.interpreter.boa.impl.CmpOpUnequalDispatchWrapperEval;
import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface CmpOpUnequal extends EObject, NodeInterface, CmpOp {
  EvalRes eval(Ctx ctx);

  CmpOpUnequalDispatchWrapperEval getCachedEval();
}
