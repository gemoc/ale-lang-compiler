package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface FieldBinding extends EObject, NodeInterface {
  Field getField();

  void setField(Field value);

  Value getValue();

  void setValue(Value value);
}
