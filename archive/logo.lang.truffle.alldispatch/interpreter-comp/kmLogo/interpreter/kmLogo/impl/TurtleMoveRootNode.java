package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.RootNode;
import java.lang.Object;
import java.lang.Override;
import kmLogo.interpreter.kmLogo.Turtle;

public class TurtleMoveRootNode extends RootNode {
  @Child
  private Turtle it;

  public TurtleMoveRootNode(Turtle it) {
    super(null);
    this.it = it;
  }

  @Override
  public Object execute(VirtualFrame frame) {
    double dx = (double) frame.getArguments()[0];
    double dy = (double) frame.getArguments()[1];
    it.move(dx, dy);
    return null;
  }
}
