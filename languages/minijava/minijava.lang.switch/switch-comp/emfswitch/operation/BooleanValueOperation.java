package emfswitch.operation;

import emfswitch.SwitchImplementation;
import java.lang.String;
import miniJava.BooleanValue;
import miniJava.MiniJavaFactory;
import miniJava.Value;

public class BooleanValueOperation extends ValueOperation {
	private final BooleanValue it;

	private final SwitchImplementation emfswitch;

	public BooleanValueOperation(BooleanValue it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public String customToString() {
		String result;
		result = ((String) ((this.it.isValue()) + ("")));
		return result;
	}

	public Value copyj() {
		Value result;
		BooleanValue tmp = ((BooleanValue) (MiniJavaFactory.eINSTANCE.createBooleanValue()));
		tmp.setValue(this.it.isValue());
		result = ((BooleanValue) (tmp));
		return result;
	}
}
