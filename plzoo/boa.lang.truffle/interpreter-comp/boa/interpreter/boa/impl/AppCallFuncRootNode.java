package boa.interpreter.boa.impl;

import boa.interpreter.boa.App;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.RootNode;
import java.lang.Object;
import java.lang.Override;

public class AppCallFuncRootNode extends RootNode {
  @Child
  private App it;

  public AppCallFuncRootNode(App it) {
    super(null);
    this.it = it;
  }

  @Override
  public Object execute(VirtualFrame frame) {
    boa.interpreter.boa.EvalFunRes fct = (boa.interpreter.boa.EvalFunRes) frame.getArguments()[0];
    boa.interpreter.boa.Ctx callCtx = (boa.interpreter.boa.Ctx) frame.getArguments()[1];
    return it.callFunc(fct, callCtx);
  }
}
