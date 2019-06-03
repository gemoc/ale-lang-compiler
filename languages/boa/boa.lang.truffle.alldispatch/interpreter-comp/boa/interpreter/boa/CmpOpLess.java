package boa.interpreter.boa;

import boa.interpreter.boa.impl.CmpOpLessDispatchWrapperEval;
import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface CmpOpLess extends EObject, NodeInterface, CmpOp {
  EvalRes eval(Ctx ctx);

  CmpOpLessDispatchWrapperEval getCachedEval();
}
