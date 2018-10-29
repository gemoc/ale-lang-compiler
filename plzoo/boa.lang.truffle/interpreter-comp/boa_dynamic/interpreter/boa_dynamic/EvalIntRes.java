package boa_dynamic.interpreter.boa_dynamic;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface EvalIntRes extends EObject, NodeInterface, EvalRes {
  int getValue();

  void setValue(int value);
}
