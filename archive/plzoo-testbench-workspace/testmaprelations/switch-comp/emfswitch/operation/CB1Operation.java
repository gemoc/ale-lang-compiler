package emfswitch.operation;

import emfswitch.SwitchImplementation;
import testmaprelations.CB1;

public class CB1Operation {
	private final CB1 it;

	private final SwitchImplementation emfswitch;

	public CB1Operation(CB1 it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
