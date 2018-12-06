package boa.interpreter.boa.impl;

import boa.interpreter.boa.File;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.RootNode;
import java.lang.Object;
import java.lang.Override;

public class FileEvalRootNode extends RootNode {
  @Child
  private File it;

  public FileEvalRootNode(File it) {
    super(null);
    this.it = it;
  }

  @Override
  public Object execute(VirtualFrame frame) {
    it.eval();
    return null;
  }
}
