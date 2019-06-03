package visitor.operation.boa.impl;

import boa.visitor.boa.BoaFactory;
import boa.visitor.boa.Ctx;
import boa.visitor.boa.File;
import boa.visitor.boa.TopLevelCmd;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import visitor.VisitorInterface;
import visitor.operation.boa.FileOperation;
import visitor.operation.boa.TopLevelCmdOperation;

public class FileOperationImpl implements FileOperation {
	private final File it;

	private final VisitorInterface vis;

	public FileOperationImpl(File it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}

	public void eval() {
		LogService.log("v2");
		Ctx ctx = ((Ctx) (BoaFactory.eINSTANCE.createCtx()));
		for(TopLevelCmd it: this.it.getCommands()) {
			((TopLevelCmdOperation)it.accept(vis)).nextLine((Ctx) (ctx));
		}
	}
}
