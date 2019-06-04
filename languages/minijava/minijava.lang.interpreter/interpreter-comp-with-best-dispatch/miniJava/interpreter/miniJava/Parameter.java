package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import miniJava.interpreter.miniJava.impl.ParameterDispatchWrapperCompare;
import org.eclipse.emf.ecore.EObject;

public interface Parameter extends EObject, NodeInterface, Symbol {
  boolean compare(Parameter other);

  ParameterDispatchWrapperCompare getCachedCompare();
}
