package fsm.interpreter.fsm.impl;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.RootNode;
import fsm.interpreter.fsm.Buffer;
import java.lang.Object;
import java.lang.Override;

public class BufferDequeueRootNode extends RootNode {
  @Child
  private Buffer it;

  public BufferDequeueRootNode(Buffer it) {
    super(null);
    this.it = it;
  }

  @Override
  public Object execute(VirtualFrame frame) {
    return it.dequeue();
  }
}
