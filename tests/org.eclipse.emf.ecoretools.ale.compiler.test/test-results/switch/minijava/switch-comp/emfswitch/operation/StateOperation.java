package emfswitch.operation;

import emfswitch.SwitchImplementation;
import java.lang.String;
import miniJava.Call;
import miniJava.Context;
import miniJava.Frame;
import miniJava.MiniJavaFactory;
import miniJava.ObjectInstance;
import miniJava.State;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;

public class StateOperation {
	private final State it;

	private final SwitchImplementation emfswitch;

	public StateOperation(State it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public Frame findCurrentFrame() {
		Frame result;
		if(EqualService.equals((this.it.getFrameCache()), (null))) {
			this.it.setFrameCache(((FrameOperation) emfswitch.doSwitch(this.it.getRootFrame())).findCurrentFrame());
		}
		result = ((Frame) (this.it.getFrameCache()));
		return result;
	}

	public Context findCurrentContext() {
		Context result;
		if(EqualService.equals((this.it.getContextCache()), (null))) {
			this.it.setContextCache(((FrameOperation) emfswitch.doSwitch(this.it.getRootFrame())).findCurrentContext());
		}
		result = ((Context) (this.it.getContextCache()));
		return result;
	}

	public void pushNewContext() {
		Context newContext = ((Context) (MiniJavaFactory.eINSTANCE.createContext()));
		Context currCtx = ((Context) (((StateOperation) emfswitch.doSwitch(this.it)).findCurrentContext()));
		if(!EqualService.equals((currCtx), (null))) {
			currCtx.setChildContext(newContext);
		}
		else {
			Frame cf = ((Frame) (((StateOperation) emfswitch.doSwitch(this.it)).findCurrentFrame()));
			cf.setRootContext(newContext);
		}
		this.it.setContextCache(newContext);
	}

	public void popCurrentContext() {
		Context currContext = ((Context) (((StateOperation) emfswitch.doSwitch(this.it)).findCurrentContext()));
		Context newCurrent = ((Context) (currContext.getParentContext()));
		currContext.setParentContext(null);
		this.it.setContextCache(newCurrent);
	}

	public void println(String str) {
		LogService.log(str);
		this.it.getOutputStream().getStream().add(str);
	}

	public void pushNewFrame(ObjectInstance receiver, Call c, Context newContext) {
		Frame newFrame = ((Frame) (MiniJavaFactory.eINSTANCE.createFrame()));
		newFrame.setInstance(receiver);
		newFrame.setCall(c);
		newFrame.setRootContext(newContext);
		((StateOperation) emfswitch.doSwitch(this.it)).findCurrentFrame().setChildFrame(newFrame);
		this.it.setFrameCache(newFrame);
		this.it.setContextCache(null);
	}

	public void popCurrentFrame() {
		Frame newCurrent = ((Frame) (((StateOperation) emfswitch.doSwitch(this.it)).findCurrentFrame().getParentFrame()));
		((StateOperation) emfswitch.doSwitch(this.it)).findCurrentFrame().setParentFrame(null);
		this.it.setContextCache(null);
		this.it.setFrameCache(newCurrent);
	}
}
