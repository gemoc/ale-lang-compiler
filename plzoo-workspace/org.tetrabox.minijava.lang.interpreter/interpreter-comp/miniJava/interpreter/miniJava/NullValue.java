package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface NullValue extends EObject, NodeInterface, Value {
  Value copyj();
}
