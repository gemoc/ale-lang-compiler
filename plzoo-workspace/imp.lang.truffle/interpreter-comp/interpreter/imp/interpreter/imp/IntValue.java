package interpreter.imp.interpreter.imp;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface IntValue extends EObject, NodeInterface, Value {
  long getValue();

  void setValue(long value);
}
