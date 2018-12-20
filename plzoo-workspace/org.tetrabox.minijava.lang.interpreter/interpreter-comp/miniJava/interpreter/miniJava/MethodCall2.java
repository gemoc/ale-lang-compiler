package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface MethodCall2 extends EObject,  Call {
  MethodCall getMethodcall();

  void setMethodcall(MethodCall value);
}
