package visitor.operation.fsm.impl;

import fsm.visitor.fsm.Buffer;
import java.lang.String;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;
import visitor.VisitorInterface;
import visitor.operation.fsm.BufferOperation;

public class BufferOperationImpl implements BufferOperation {
	private final Buffer it;

	private final VisitorInterface vis;

	public BufferOperationImpl(Buffer it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}

	public void initialize() {
		if(!EqualService.equals((this.it.getInitialValue()), (null))) {
			this.it.setCurrentValues(this.it.getInitialValue());
		}
		else {
			this.it.setCurrentValues("'empty'");
		}
	}

	public boolean bisEmpty() {
		boolean result;
		result = ((org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService.equals((org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(this.it.getCurrentValues())), (0))) || (org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService.equals((this.it.getCurrentValues()), ("'empty'"))));
		return result;
	}

	public void enqueue(String v) {
		if(((BufferOperation)this.it.accept(vis)).bisEmpty()) {
			this.it.setCurrentValues(v);
		}
		else {
			this.it.setCurrentValues(((this.it.getCurrentValues()) + (",")) + (v));
		}
	}

	public String dequeue() {
		String result;
		String res = ((String) (""));
		int firstComma = ((int) (fsm.FsmService.indexOf(this.it.getCurrentValues(), ",")));
		if((firstComma) < (0)) {
			res = this.it.getCurrentValues();
			this.it.setCurrentValues("'empty'");
			result = res;
		}
		else {
			res = fsm.FsmService.substring(this.it.getCurrentValues(), 0, firstComma);
			this.it.setCurrentValues(fsm.FsmService.substring(this.it.getCurrentValues(), (firstComma) + (1), org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(this.it.getCurrentValues())));
			result = res;
		}
		return result;
	}
}
