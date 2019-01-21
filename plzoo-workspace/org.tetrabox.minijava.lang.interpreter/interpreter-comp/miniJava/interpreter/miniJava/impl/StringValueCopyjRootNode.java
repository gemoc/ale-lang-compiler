package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.RootNode;
import java.lang.Object;
import java.lang.Override;
import miniJava.interpreter.miniJava.StringValue;

public class StringValueCopyjRootNode extends RootNode {
//  @Child
  private StringValue it;

  public StringValueCopyjRootNode(StringValue it) {
    super(null);
    this.it = it;
  }

  @Override
  public Object execute(VirtualFrame frame) {
    return it.copyj();
  }
}
