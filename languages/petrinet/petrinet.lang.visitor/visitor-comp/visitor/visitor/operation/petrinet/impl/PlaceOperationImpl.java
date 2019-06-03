package visitor.visitor.operation.petrinet.impl;

import visitor.petrinet.visitor.petrinet.Place;
import visitor.visitor.VisitorInterface;
import visitor.visitor.operation.petrinet.PlaceOperation;

public class PlaceOperationImpl extends NodeOperationImpl implements PlaceOperation {
	private final Place it;

	private final VisitorInterface vis;

	public PlaceOperationImpl(Place it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public boolean canFire() {
		boolean result;
		result = false;
		return result;
	}

	public boolean hasToken() {
		boolean result;
		result = (this.it.getTokenNb()) > (0);
		return result;
	}

	public void fire() {
	}

	public void removeToken() {
		this.it.setTokenNb((this.it.getTokenNb()) - (1));
	}

	public void addToken() {
		this.it.setTokenNb((this.it.getTokenNb()) + (1));
	}
}
