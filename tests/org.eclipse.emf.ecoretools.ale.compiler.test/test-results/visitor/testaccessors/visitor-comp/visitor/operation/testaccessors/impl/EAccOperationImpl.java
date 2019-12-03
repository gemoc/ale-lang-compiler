package visitor.operation.testaccessors.impl;

import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import testaccessors.visitor.testaccessors.EAcc;
import visitor.VisitorInterface;
import visitor.operation.testaccessors.EAccOperation;

public class EAccOperationImpl implements EAccOperation {
	private final EAcc it;

	private final VisitorInterface vis;

	public EAccOperationImpl(EAcc it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}

	public void logacc() {
		LogService.log(this.it.isB());
		LogService.log(this.it.getI());
		LogService.log(this.it.getBs());
		LogService.log(this.it.getIs());
	}
}
