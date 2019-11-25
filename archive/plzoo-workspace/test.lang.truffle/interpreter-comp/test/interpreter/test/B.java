package test.interpreter.test;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface B extends EObject, NodeInterface, A {
  void eval();
}
