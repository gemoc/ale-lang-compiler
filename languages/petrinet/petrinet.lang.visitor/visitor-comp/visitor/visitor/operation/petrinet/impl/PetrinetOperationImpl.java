package visitor.visitor.operation.petrinet.impl;

import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import visitor.petrinet.visitor.petrinet.Node;
import visitor.petrinet.visitor.petrinet.Petrinet;
import visitor.visitor.VisitorInterface;
import visitor.visitor.operation.petrinet.NodeOperation;
import visitor.visitor.operation.petrinet.PetrinetOperation;

public class PetrinetOperationImpl implements PetrinetOperation {
	private final Petrinet it;

	private final VisitorInterface vis;

	public PetrinetOperationImpl(Petrinet it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}

	public void run() {
		int x = ((int) (0));
		boolean stop = ((boolean) (false));
		while (!(stop)) {
			Node enabledNode = ((Node) (CollectionService.head(CollectionService.select(this.it.getNodes(), (n) -> ((NodeOperation)n.accept(vis)).canFire()))));
			if(!EqualService.equals((enabledNode), (null))) {
				x = (x) + (1);
				((NodeOperation)enabledNode.accept(vis)).fire();
			}
			else {
				stop = true;
			}
		}
		LogService.log(x);
	}
}
