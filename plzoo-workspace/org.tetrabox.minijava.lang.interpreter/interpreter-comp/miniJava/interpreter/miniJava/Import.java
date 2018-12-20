package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface Import extends EObject, NodeInterface {
  String getImportedNamespace();

  void setImportedNamespace(String value);
}
