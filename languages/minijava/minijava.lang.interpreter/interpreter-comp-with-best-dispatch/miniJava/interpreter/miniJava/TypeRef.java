package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import miniJava.interpreter.miniJava.impl.TypeRefDispatchWrapperCompare;
import org.eclipse.emf.ecore.EObject;

public interface TypeRef extends EObject, NodeInterface {
  boolean compare(TypeRef other);

  TypeRefDispatchWrapperCompare getCachedCompare();
}
