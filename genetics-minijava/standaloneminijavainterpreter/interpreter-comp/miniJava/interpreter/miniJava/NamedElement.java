package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface NamedElement extends EObject, NodeInterface {
  String getName();

  void setName(String value);
}
