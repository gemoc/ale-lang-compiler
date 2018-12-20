package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface BooleanValue extends EObject, NodeInterface, Value {
  boolean isValue();

  void setValue(boolean value);

  String customToString();

  Value copyj();
}
