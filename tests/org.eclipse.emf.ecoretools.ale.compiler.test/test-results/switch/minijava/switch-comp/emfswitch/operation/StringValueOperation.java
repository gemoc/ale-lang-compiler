package emfswitch.operation;

import emfswitch.SwitchImplementation;
import java.lang.String;
import miniJava.MiniJavaFactory;
import miniJava.StringValue;
import miniJava.Value;

public class StringValueOperation extends ValueOperation {
	private final StringValue it;

	private final SwitchImplementation emfswitch;

	public StringValueOperation(StringValue it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public String customToString() {
		String result;
		result = ((String) (this.it.getValue().toString()));
		return result;
	}

	public Value copyj() {
		Value result;
		StringValue tmp = ((StringValue) (MiniJavaFactory.eINSTANCE.createStringValue()));
		tmp.setValue(this.it.getValue());
		result = ((StringValue) (tmp));
		return result;
	}
}
