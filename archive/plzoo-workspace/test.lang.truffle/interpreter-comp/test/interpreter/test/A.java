package test.interpreter.test;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;
import test.interpreter.test.impl.ADispatchWrapperEval;

public interface A extends EObject, NodeInterface {
  void eval();

  ADispatchWrapperEval getCachedEval();
}
