package emfswitch.operation;

import emfswitch.SwitchImplementation;
import java.lang.String;

import miniJava.ArrayInstance;
import miniJava.ArrayRefValue;
import miniJava.Value;

public class ArrayRefValueOperation extends ValueOperation {
	private final ArrayRefValue it;

	private final SwitchImplementation emfswitch;

	public ArrayRefValueOperation(ArrayRefValue it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public Value copyj() {
		Value result;
		ArrayRefValue tmp = ((ArrayRefValue) miniJava.MiniJavaFactory.eINSTANCE.createArrayRefValue());
		tmp.setInstance(this.it.getInstance());
		result = tmp;
		return result;
	}

	public String customToString() {
		String result;
		String res = ((String) "[");
		int i = ((int) 0);
//    ArrayRefValueOperation arrayRefValueOperation = (emfswitch.operation.ArrayRefValueOperation) emfswitch.doSwitch(this.it);
		ArrayInstance inst = this.it.getInstance();
		int lgt = ((int) org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService
				.size(/* CASEF *//* CASEC */inst.getValue()));
		while ((i) < (lgt)) {
			Value tmpv = ((Value) org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService
					.get(this.it.getInstance().getValue(), i));
			res = (res) + (/* CASEA */((emfswitch.operation.ValueOperation) emfswitch.doSwitch(tmpv)).customToString());
			if ((i) < ((lgt) - (1))) {
				res = (res) + (", ");
			}
			i = (i) + (1);
		}
		res = (res) + ("]");
		result = res;
		return result;
	}
}
