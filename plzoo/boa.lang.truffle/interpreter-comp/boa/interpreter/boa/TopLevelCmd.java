package boa.interpreter.boa;

import boa.interpreter.boa.impl.TopLevelCmdDispatchWrapperNextLine;
import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface TopLevelCmd extends EObject, NodeInterface {
  void nextLine(Ctx ctx);

  TopLevelCmdDispatchWrapperNextLine getCachedNextLine();
}
