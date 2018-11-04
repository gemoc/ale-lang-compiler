package boa.interpreter.boa;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface EvalIntRes extends EObject, EvalRes {
  int getValue();

  void setValue(int value);
}
