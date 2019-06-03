package emfswitch.operation;

import emfswitch.SwitchImplementation;
import java.lang.String;
import miniJava.Call;
import miniJava.Context;
import miniJava.Frame;
import miniJava.ObjectInstance;
import miniJava.State;

public class StateOperation {
  private final State it;

  private final SwitchImplementation emfswitch;

  public StateOperation(State it, SwitchImplementation emfswitch) {
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public Frame findCurrentFrame() {
    Frame result;
    if(java.util.Objects.equals((this.it.getFrameCache()), (null))) {
      this.it.setFrameCache(/*CASEA*/((emfswitch.operation.FrameOperation) emfswitch.doSwitch(this.it.getRootFrame())).findCurrentFrame());
    }
    result = this.it.getFrameCache();
    return result;
  }

  public Context findCurrentContext() {
    Context result;
    if(java.util.Objects.equals((this.it.getContextCache()), (null))) {
      this.it.setContextCache(/*CASEA*/((emfswitch.operation.FrameOperation) emfswitch.doSwitch(this.it.getRootFrame())).findCurrentContext());
    }
    result = this.it.getContextCache();
    return result;
  }

  public void pushNewContext() {
    Context newContext = ((Context)miniJava.MiniJavaFactory.eINSTANCE.createContext());
    Context currCtx = ((Context)/*CASEA*/((emfswitch.operation.StateOperation) emfswitch.doSwitch(this.it)).findCurrentContext());
    if((currCtx) != (null)) {
      currCtx.setChildContext(newContext);
    }
    else {
      Frame cf = ((Frame)/*CASEA*/((emfswitch.operation.StateOperation) emfswitch.doSwitch(this.it)).findCurrentFrame());
      cf.setRootContext(newContext);
    }
    this.it.setContextCache(newContext);
  }

  public void popCurrentContext() {
    Context currContext = ((Context)/*CASEA*/((emfswitch.operation.StateOperation) emfswitch.doSwitch(this.it)).findCurrentContext());
    Context newCurrent = ((Context)currContext.getParentContext());
    currContext.setParentContext(null);
    this.it.setContextCache(newCurrent);
  }

  public void println(String str) {
    org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log(str);
    this.it.getOutputStream().getStream().add(str);
  }

  public void pushNewFrame(ObjectInstance receiver, Call c, Context newContext) {
    Frame newFrame = ((Frame)miniJava.MiniJavaFactory.eINSTANCE.createFrame());
    newFrame.setInstance(receiver);
    newFrame.setCall(c);
    newFrame.setRootContext(newContext);
    /*CASEA*/((emfswitch.operation.StateOperation) emfswitch.doSwitch(this.it)).findCurrentFrame().setChildFrame(newFrame);
    this.it.setFrameCache(newFrame);
    this.it.setContextCache(null);
  }

  public void popCurrentFrame() {
    Frame newCurrent = ((Frame)/*CASEA*/((emfswitch.operation.StateOperation) emfswitch.doSwitch(this.it)).findCurrentFrame().getParentFrame());
    /*CASEA*/((emfswitch.operation.StateOperation) emfswitch.doSwitch(this.it)).findCurrentFrame().setParentFrame(null);
    this.it.setContextCache(null);
    this.it.setFrameCache(newCurrent);
  }
}
