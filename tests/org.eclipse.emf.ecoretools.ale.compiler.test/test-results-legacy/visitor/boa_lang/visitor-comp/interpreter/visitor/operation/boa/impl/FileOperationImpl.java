package interpreter.visitor.operation.boa.impl;

import interpreter.boa.visitor.boa.BoaFactory;
import interpreter.boa.visitor.boa.Ctx;
import interpreter.boa.visitor.boa.File;
import interpreter.boa.visitor.boa.TopLevelCmd;
import interpreter.visitor.VisitorInterface;
import interpreter.visitor.operation.boa.FileOperation;
import interpreter.visitor.operation.boa.TopLevelCmdOperation;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;

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
