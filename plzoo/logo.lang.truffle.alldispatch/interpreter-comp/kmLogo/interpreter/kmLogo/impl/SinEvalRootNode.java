package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.RootNode;
import java.lang.Object;
import java.lang.Override;
import kmLogo.interpreter.kmLogo.Sin;

public class SinEvalRootNode extends RootNode {
  @Child
  private Sin it;

  public SinEvalRootNode(Sin it) {
    super(null);
    this.it = it;
  }

  @Override
  public Object execute(VirtualFrame frame) {
    kmLogo.interpreter.kmLogo.Turtle turtle = (kmLogo.interpreter.kmLogo.Turtle) frame.getArguments()[0];
    return it.eval(turtle);
  }
}
