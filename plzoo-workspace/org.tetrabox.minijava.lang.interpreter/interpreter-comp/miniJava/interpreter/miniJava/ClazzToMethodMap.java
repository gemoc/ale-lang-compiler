package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface ClazzToMethodMap extends EObject, NodeInterface {
  Clazz getKey();

  void setKey(Clazz value);

  Method getValue();

  void setValue(Method value);
}
