package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface NewCall extends EObject, NodeInterface, Call {
  NewObject getNewz();

  void setNewz(NewObject value);
}
