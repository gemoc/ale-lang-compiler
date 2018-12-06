package boa.interpreter.boa.impl;

import boa.interpreter.boa.Assign;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.RootNode;
import java.lang.Object;
import java.lang.Override;

public class AssignEvalRootNode extends RootNode {
  @Child
  private Assign it;

  public AssignEvalRootNode(Assign it) {
    super(null);
    this.it = it;
  }

  @Override
  public Object execute(VirtualFrame frame) {
    boa.interpreter.boa.Ctx ctx = (boa.interpreter.boa.Ctx) frame.getArguments()[0];
    return it.eval(ctx);
  }
}
