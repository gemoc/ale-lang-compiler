package petrinet_exec.impl.operation.impl;

import petrinet.revisitor.PetrinetRevisitor;
import petrinet_exec.impl.operation.Arc;
import petrinet_exec.impl.operation.Node;
import petrinet_exec.impl.operation.Petrinet;
import petrinet_exec.impl.operation.Place;
import petrinet_exec.impl.operation.Transition;

public class PetrinetImpl implements Petrinet {
	private PetrinetRevisitor<Arc, Node, Petrinet, Place, Transition> rev;

	private petrinet.lang.petrinet.Petrinet obj;

	public PetrinetImpl(petrinet.lang.petrinet.Petrinet obj,
			PetrinetRevisitor<Arc, Node, Petrinet, Place, Transition> rev) {
		this.obj = obj;
		this.rev = rev;
	}

	public void run() {
		boolean stop = false;
		while (!(stop)) {
			petrinet.lang.petrinet.Node enabledNode = org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService
					.head(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.select(this.obj.getNodes(),
							(n) -> {
								return rev.$(n).canFire();
							}));
			if ((enabledNode) != (null)) {
				rev.$(enabledNode).fire();
			} else {
				stop = true;
			}
		}
	}
}
