package boa.interpreter.boa;

import boa_dynamic.interpreter.boa_dynamic.Ctx;
import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface TopLevelCmd extends EObject, NodeInterface {
  void nextLine(Ctx ctx);
}
