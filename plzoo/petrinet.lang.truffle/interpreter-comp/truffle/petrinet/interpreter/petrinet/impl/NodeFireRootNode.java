package truffle.petrinet.interpreter.petrinet.impl;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.RootNode;
import java.lang.Object;
import java.lang.Override;
import truffle.petrinet.interpreter.petrinet.Node;

public class NodeFireRootNode extends RootNode {
  @Child
  private Node it;

  public NodeFireRootNode(Node it) {
    super(null);
    this.it = it;
  }

  @Override
  public Object execute(VirtualFrame frame) {
    it.fire();
    return null;
  }
}
