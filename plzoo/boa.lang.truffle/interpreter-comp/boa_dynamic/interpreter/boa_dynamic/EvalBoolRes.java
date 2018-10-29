package boa_dynamic.interpreter.boa_dynamic;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface EvalBoolRes extends EObject, NodeInterface, EvalRes {
  boolean isValue();

  void setValue(boolean value);
}
