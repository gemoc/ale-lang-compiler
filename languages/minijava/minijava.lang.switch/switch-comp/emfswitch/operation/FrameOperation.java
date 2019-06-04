package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.Context;
import miniJava.Frame;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

public class FrameOperation {
	private final Frame it;

	private final SwitchImplementation emfswitch;

	public FrameOperation(Frame it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public Context findCurrentContext() {
		Context result;
		if(!EqualService.equals((this.it.getChildFrame()), (null))) {
			result = ((Context) (((FrameOperation) emfswitch.doSwitch(this.it.getChildFrame())).findCurrentContext()));
		}
		else {
			if(!EqualService.equals((this.it.getRootContext()), (null))) {
				result = ((Context) (((ContextOperation) emfswitch.doSwitch(this.it.getRootContext())).findCurrentContext()));
			}
			else {
				result = ((Context) (null));
			}
		}
		return result;
	}

	public Frame findCurrentFrame() {
		Frame result;
		if(!EqualService.equals((this.it.getChildFrame()), (null))) {
			result = ((Frame) (((FrameOperation) emfswitch.doSwitch(this.it.getChildFrame())).findCurrentFrame()));
		}
		else {
			result = ((Frame) (this.it));
		}
		return result;
	}
}
