package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface NewCall extends EObject,  Call {
  NewObject getNewz();

  void setNewz(NewObject value);
}
