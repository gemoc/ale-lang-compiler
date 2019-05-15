package visitor.operation.test1.impl;

import execboa.MapService;
import java.lang.String;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import test1.visitor.test1.ConceptA;
import test1.visitor.test1.StringToIntegerMapEntry;
import visitor.VisitorInterface;
import visitor.operation.test1.ConceptAOperation;

public class ConceptAOperationImpl implements ConceptAOperation {
	private final ConceptA it;

	private final VisitorInterface vis;

	public ConceptAOperationImpl(ConceptA it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}

	public void exec() {
		for(StringToIntegerMapEntry c: this.it.getCs()) {
			LogService.log(c.getKey());
			LogService.log(c.getValue());
		}
		LogService.log(MapService.containsKey((EMap) (this.it.getCs()), (String) ("ok")));
	}
}
