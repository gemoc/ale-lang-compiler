package emfswitch.operation;

import emfswitch.SwitchImplementation;
import imp.model.imp.Assign;
import imp.model.imp.Store;
import imp.model.imp.Value;
import java.lang.String;

public class AssignOperation extends StmtOperation {
	private final Assign it;

	private final SwitchImplementation emfswitch;

	public AssignOperation(Assign it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public Store execute(Store s) {
		Store result;
		s.getValues().put((String) (this.it.getName()), (Value) (((ExprOperation) emfswitch.doSwitch(this.it.getExp())).evaluate((Store) (s))));
		result = ((Store) (s));
		return result;
	}
}
