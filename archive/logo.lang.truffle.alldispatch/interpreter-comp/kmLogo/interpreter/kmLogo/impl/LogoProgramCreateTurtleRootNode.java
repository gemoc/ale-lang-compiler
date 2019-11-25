package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.RootNode;
import java.lang.Object;
import java.lang.Override;
import kmLogo.interpreter.kmLogo.LogoProgram;

public class LogoProgramCreateTurtleRootNode extends RootNode {
  @Child
  private LogoProgram it;

  public LogoProgramCreateTurtleRootNode(LogoProgram it) {
    super(null);
    this.it = it;
  }

  @Override
  public Object execute(VirtualFrame frame) {
    return it.createTurtle();
  }
}
