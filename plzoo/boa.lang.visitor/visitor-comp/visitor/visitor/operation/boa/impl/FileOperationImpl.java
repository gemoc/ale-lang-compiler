package visitor.visitor.operation.boa.impl;

import visitor.boa.visitor.boa.Ctx;
import visitor.boa.visitor.boa.File;
import visitor.boa.visitor.boa.TopLevelCmd;
import visitor.visitor.VisitorInterface;
import visitor.visitor.operation.boa.FileOperation;

public class FileOperationImpl implements FileOperation {
  private final File it;

  private final VisitorInterface vis;

  public FileOperationImpl(File it, VisitorInterface vis) {
    this.it = it;
    this.vis = vis;
  }

  public void eval() {
    org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log("v1");
    Ctx ctx = ((Ctx)visitor.boa.visitor.boa.BoaFactory.eINSTANCE.createCtx());
    for(TopLevelCmd it: this.it.getCommands()) {
      ((visitor.visitor.operation.boa.TopLevelCmdOperation)it.accept(vis)).nextLine(ctx);
    }
  }
}
