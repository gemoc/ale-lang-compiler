package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.RootNode;
import java.lang.Object;
import java.lang.Override;
import miniJava.interpreter.miniJava.Program;

public class ProgramInitializeRootNode extends RootNode {
  @Child
  private Program it;

  public ProgramInitializeRootNode(Program it) {
    super(null);
    this.it = it;
  }

  @Override
  public Object execute(VirtualFrame frame) {
    org.eclipse.emf.common.util.EList args = (org.eclipse.emf.common.util.EList) frame.getArguments()[0];
    it.initialize(args);
    return null;
  }
}
