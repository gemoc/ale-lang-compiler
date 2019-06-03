package interpreter.imp.interpreter.imp;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface BoolValue extends EObject, NodeInterface, Value {
  boolean isValue();

  void setValue(boolean value);
}
