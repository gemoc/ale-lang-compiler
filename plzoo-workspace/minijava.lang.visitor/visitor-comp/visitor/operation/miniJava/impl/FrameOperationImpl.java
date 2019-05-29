package visitor.operation.miniJava.impl;

import miniJava.visitor.miniJava.Context;
import miniJava.visitor.miniJava.Frame;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;
import visitor.VisitorInterface;
import visitor.operation.miniJava.ContextOperation;
import visitor.operation.miniJava.FrameOperation;

public class FrameOperationImpl implements FrameOperation {
	private final Frame it;

	private final VisitorInterface vis;

	public FrameOperationImpl(Frame it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}

	public Context findCurrentContext() {
		Context result;
		if(!EqualService.equals((this.it.getChildFrame()), (null))) {
			result = ((FrameOperation)this.it.getChildFrame().accept(vis)).findCurrentContext();
		}
		else {
			if(!EqualService.equals((this.it.getRootContext()), (null))) {
				result = ((ContextOperation)this.it.getRootContext().accept(vis)).findCurrentContext();
			}
			else {
				result = null;
			}
		}
		return result;
	}

	public Frame findCurrentFrame() {
		Frame result;
		if(!EqualService.equals((this.it.getChildFrame()), (null))) {
			result = ((FrameOperation)this.it.getChildFrame().accept(vis)).findCurrentFrame();
		}
		else {
			result = this.it;
		}
		return result;
	}
}
