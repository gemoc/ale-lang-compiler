package visitor.operation.fsm.impl;

import fsm.FsmService;
import fsm.visitor.fsm.Buffer;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;
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
		result = ((Boolean) (((EqualService.equals((CollectionService.size(this.it.getCurrentValues())), (0))) || (EqualService.equals((this.it.getCurrentValues()), ("'empty'"))))));
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
		int firstComma = ((int) (FsmService.indexOf((String) (this.it.getCurrentValues()), (String) (","))));
		if((firstComma) < (0)) {
			res = ((String) (this.it.getCurrentValues()));
			this.it.setCurrentValues("'empty'");
			result = ((String) (res));
		}
		else {
			res = FsmService.substring((String) (this.it.getCurrentValues()), (Integer) (0), (int) (firstComma));
			this.it.setCurrentValues(FsmService.substring((String) (this.it.getCurrentValues()), ((firstComma) + (1)), (Integer) (CollectionService.size(this.it.getCurrentValues()))));
			result = ((String) (res));
		}
		return result;
	}
}
