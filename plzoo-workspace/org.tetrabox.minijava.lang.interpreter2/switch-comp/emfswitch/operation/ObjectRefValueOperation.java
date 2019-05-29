package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.MiniJavaFactory;
import miniJava.ObjectRefValue;
import miniJava.Value;

public class ObjectRefValueOperation extends ValueOperation {
	private final ObjectRefValue it;

	private final SwitchImplementation emfswitch;

	public ObjectRefValueOperation(ObjectRefValue it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public String customToString() {
		String result;
		result = this.it.getInstance().toString();
		return result;
	}

	public Value copyj() {
		Value result;
		ObjectRefValue tmp = ((ObjectRefValue) (MiniJavaFactory.eINSTANCE.createObjectRefValue()));
		tmp.setInstance(this.it.getInstance());
		result = tmp;
		return result;
	}
}
