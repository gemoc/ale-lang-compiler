package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.RootNode;
import java.lang.Object;
import java.lang.Override;
import kmLogo.interpreter.kmLogo.Turtle;

public class TurtleRotateRootNode extends RootNode {
  @Child
  private Turtle it;

  public TurtleRotateRootNode(Turtle it) {
    super(null);
    this.it = it;
  }

  @Override
  public Object execute(VirtualFrame frame) {
    double angle = (double) frame.getArguments()[0];
    it.rotate(angle);
    return null;
  }
}
