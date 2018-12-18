package boa.interpreter.boa.impl;

import boa.interpreter.boa.TopLevelCmd;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.RootNode;
import java.lang.Object;
import java.lang.Override;

public class TopLevelCmdNextLineRootNode extends RootNode {
  @Child
  private TopLevelCmd it;

  public TopLevelCmdNextLineRootNode(TopLevelCmd it) {
    super(null);
    this.it = it;
  }

  @Override
  public Object execute(VirtualFrame frame) {
    boa.interpreter.boa.Ctx ctx = (boa.interpreter.boa.Ctx) frame.getArguments()[0];
    it.nextLine(ctx);
    return null;
  }
}
