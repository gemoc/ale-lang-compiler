package emfswitch.operation;

import emfswitch.SwitchImplementation;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import testaccessors.EAcc;

public class EAccOperation {
	private final EAcc it;

	private final SwitchImplementation emfswitch;

	public EAccOperation(EAcc it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void logacc() {
		LogService.log(this.it.isB());
		LogService.log(this.it.getI());
		LogService.log(this.it.getBs());
		LogService.log(this.it.getIs());
	}
}
