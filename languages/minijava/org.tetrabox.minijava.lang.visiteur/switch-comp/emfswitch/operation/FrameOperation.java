package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.Context;
import miniJava.Frame;

public class FrameOperation {
  private final Frame it;

  private final SwitchImplementation emfswitch;

  public FrameOperation(Frame it, SwitchImplementation emfswitch) {
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public Context findCurrentContext() {
    Context result;
    if((this.it.getChildFrame()) != (null)) {
      result = /*CASEA*/((emfswitch.operation.FrameOperation) emfswitch.doSwitch(this.it.getChildFrame())).findCurrentContext();
    }
    else {
      if((this.it.getRootContext()) != (null)) {
        result = /*CASEA*/((emfswitch.operation.ContextOperation) emfswitch.doSwitch(this.it.getRootContext())).findCurrentContext();
      }
      else {
        result = null;
      }
    }
    return result;
  }

  public Frame findCurrentFrame() {
    Frame result;
    if((this.it.getChildFrame()) != (null)) {
      result = /*CASEA*/((emfswitch.operation.FrameOperation) emfswitch.doSwitch(this.it.getChildFrame())).findCurrentFrame();
    }
    else {
      result = this.it;
    }
    return result;
  }
}
