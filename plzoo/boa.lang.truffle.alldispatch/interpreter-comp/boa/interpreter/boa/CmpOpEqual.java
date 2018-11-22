package boa.interpreter.boa;

import boa.interpreter.boa.impl.CmpOpEqualDispatchWrapperEval;
import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface CmpOpEqual extends EObject, NodeInterface, CmpOp {
  EvalRes eval(Ctx ctx);

  CmpOpEqualDispatchWrapperEval getCachedEval();
}
