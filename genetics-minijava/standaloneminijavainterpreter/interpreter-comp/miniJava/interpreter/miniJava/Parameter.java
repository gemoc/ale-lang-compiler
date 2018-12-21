package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface Parameter extends EObject, NodeInterface, Symbol {
  boolean compare(Parameter other);
}
