package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.RootNode;
import java.lang.Object;
import java.lang.Override;
import miniJava.interpreter.miniJava.BooleanValue;

public class BooleanValueCopyjRootNode extends RootNode {
//  @Child
  private BooleanValue it;

  public BooleanValueCopyjRootNode(BooleanValue it) {
    super(null);
    this.it = it;
  }

  @Override
  public Object execute(VirtualFrame frame) {
    return it.copyj();
  }
}
