package test.interpreter.test.impl;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.RootNode;
import java.lang.Object;
import java.lang.Override;
import test.interpreter.test.A;

public class AEvalRootNode extends RootNode {
  @Child
  private A it;

  public AEvalRootNode(A it) {
    super(null);
    this.it = it;
  }

  @Override
  public Object execute(VirtualFrame frame) {
    it.eval();
    return null;
  }
}
