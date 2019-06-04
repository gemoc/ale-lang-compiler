package emfswitch.operation;

import emfswitch.SwitchImplementation;
import java.lang.Integer;
import java.lang.String;
import miniJava.ArrayRefValue;
import miniJava.MiniJavaFactory;
import miniJava.Value;
import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;

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
		ArrayRefValue tmp = ((ArrayRefValue) (MiniJavaFactory.eINSTANCE.createArrayRefValue()));
		tmp.setInstance(this.it.getInstance());
		result = ((ArrayRefValue) (tmp));
		return result;
	}

	public String customToString() {
		String result;
		String res = ((String) ("["));
		int i = ((int) (0));
		int lgt = ((int) (CollectionService.size(this.it.getInstance().getValue())));
		while ((i) < (lgt)) {
			Value tmpv = ((Value) (CollectionService.get(this.it.getInstance().getValue(), i)));
			res = ((String) ((res) + (((ValueOperation) emfswitch.doSwitch(tmpv)).customToString())));
			if((i) < ((lgt) - (1))) {
				res = ((String) ((res) + (", ")));
			}
			i = ((Integer) ((i) + (1)));
		}
		res = ((String) ((res) + ("]")));
		result = ((String) (res));
		return result;
	}
}
