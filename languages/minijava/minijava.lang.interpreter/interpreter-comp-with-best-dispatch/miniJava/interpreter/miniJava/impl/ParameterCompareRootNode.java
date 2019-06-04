package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.RootNode;
import java.lang.Object;
import java.lang.Override;
import miniJava.interpreter.miniJava.Parameter;

public class ParameterCompareRootNode extends RootNode {
  @Child
  private Parameter it;

  public ParameterCompareRootNode(Parameter it) {
    super(null);
    this.it = it;
  }

  @Override
  public Object execute(VirtualFrame frame) {
    miniJava.interpreter.miniJava.Parameter other = (miniJava.interpreter.miniJava.Parameter) frame.getArguments()[0];
    return it.compare(other);
  }
}
