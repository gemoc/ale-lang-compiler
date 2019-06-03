package fsm.interpreter.fsm;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface System extends EObject, NodeInterface {
  EList<FSM> getOwnedFsms();

  EList<Buffer> getOwnedBuffers();

  void intialize();

  void main();
}
