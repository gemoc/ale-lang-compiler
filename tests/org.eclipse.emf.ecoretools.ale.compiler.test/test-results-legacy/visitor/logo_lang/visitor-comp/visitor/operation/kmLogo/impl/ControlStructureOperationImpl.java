package visitor.operation.kmLogo.impl;

import kmLogo.visitor.kmLogo.ControlStructure;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.ControlStructureOperation;

public class ControlStructureOperationImpl extends InstructionOperationImpl implements ControlStructureOperation {
	private final ControlStructure it;

	private final VisitorInterface vis;

	public ControlStructureOperationImpl(ControlStructure it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}
}
