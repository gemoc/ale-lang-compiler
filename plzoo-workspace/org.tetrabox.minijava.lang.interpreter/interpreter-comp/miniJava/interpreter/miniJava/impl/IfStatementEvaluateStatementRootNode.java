package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.RootNode;
import java.lang.Object;
import java.lang.Override;
import miniJava.interpreter.miniJava.IfStatement;

public class IfStatementEvaluateStatementRootNode extends RootNode {
  @Child
  private IfStatement it;

  public IfStatementEvaluateStatementRootNode(IfStatement it) {
    super(null);
    this.it = it;
  }

  @Override
  public Object execute(VirtualFrame frame) {
    miniJava.interpreter.miniJava.State state = (miniJava.interpreter.miniJava.State) frame.getArguments()[0];
    it.evaluateStatement(state);
    return null;
  }
}
