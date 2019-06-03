package boa.interpreter.boa.impl;

import boa.interpreter.boa.Project;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.RootNode;
import java.lang.Object;
import java.lang.Override;

public class ProjectProjectRootNode extends RootNode {
  @Child
  private Project it;

  public ProjectProjectRootNode(Project it) {
    super(null);
    this.it = it;
  }

  @Override
  public Object execute(VirtualFrame frame) {
    boa.interpreter.boa.EvalFunRes func = (boa.interpreter.boa.EvalFunRes) frame.getArguments()[0];
    boa.interpreter.boa.EvalMapRes mvexp = (boa.interpreter.boa.EvalMapRes) frame.getArguments()[1];
    return it.project(func, mvexp);
  }
}
