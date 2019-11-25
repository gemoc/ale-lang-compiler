package test.interpreter.test;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface Program extends EObject, NodeInterface {
  EList<A> getAs();

  EList<C> getCs();

  void execute();
}
