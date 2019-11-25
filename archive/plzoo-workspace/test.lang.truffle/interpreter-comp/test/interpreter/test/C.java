package test.interpreter.test;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface C extends EObject, NodeInterface {
  B getB();

  void setB(B value);

  A getA();

  void setA(A value);

  void run();
}
