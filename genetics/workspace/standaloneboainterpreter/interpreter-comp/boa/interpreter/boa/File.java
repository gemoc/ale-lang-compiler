package boa.interpreter.boa;

import boa.interpreter.boa.impl.FileDispatchWrapperEval;
import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface File extends EObject, NodeInterface {
  EList<TopLevelCmd> getCommands();

  void eval();

  FileDispatchWrapperEval getCachedEval();
}
