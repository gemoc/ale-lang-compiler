package emfswitch.operation;

import emfswitch.SwitchImplementation;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptA1;
import fr.mleduc.xp.emfrelations.emfrelations.ConceptB1;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;

public class ConceptA1Operation {
	private final ConceptA1 it;

	private final SwitchImplementation emfswitch;

	public ConceptA1Operation(ConceptA1 it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void logBS() {
		for (ConceptB1 b1: this.it.getConceptb1()) {
			LogService.log(b1);
		}
	}
}
