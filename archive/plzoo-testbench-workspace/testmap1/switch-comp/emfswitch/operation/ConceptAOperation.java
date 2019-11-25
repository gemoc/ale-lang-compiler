package emfswitch.operation;

import emfswitch.SwitchImplementation;
import java.lang.Integer;
import java.lang.String;
import java.util.Map;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import test1.ConceptA;

public class ConceptAOperation {
	private final ConceptA it;

	private final SwitchImplementation emfswitch;

	public ConceptAOperation(ConceptA it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void exec() {
		for (Map.Entry<String, Integer> c: this.it.getCs()) {
			LogService.log(c.getKey());
			LogService.log(c.getValue());
		}
	}
}
