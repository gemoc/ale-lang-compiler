package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;

import kmLogo.interpreter.kmLogo.ProcDeclaration;

public class ProcDeclarationEvalRootNode extends RootNode {
  @Child
  private ProcDeclaration it;

  public ProcDeclarationEvalRootNode(ProcDeclaration it) {
    super(null);
    this.it = it;
  }

  @Override
  public Object execute(VirtualFrame frame) {
    kmLogo.interpreter.kmLogo.Turtle turtle = (kmLogo.interpreter.kmLogo.Turtle) frame.getArguments()[0];
    return it.eval(turtle);
  }
}
