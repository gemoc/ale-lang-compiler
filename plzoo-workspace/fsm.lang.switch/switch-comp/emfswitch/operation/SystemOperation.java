package emfswitch.operation;

import emfswitch.SwitchImplementation;
import fsm.model.fsm.Buffer;
import fsm.model.fsm.FSM;
import fsm.model.fsm.System;

public class SystemOperation {
  private final System it;

  private final SwitchImplementation emfswitch;

  public SystemOperation(System it, SwitchImplementation emfswitch) {
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public void intialize() {
    for(FSM fsm: this.it.getOwnedFsms()) {
      /*CASEA*/((emfswitch.operation.FSMOperation) emfswitch.doSwitch(fsm)).initialize();
    }
    for(Buffer b: this.it.getOwnedBuffers()) {
      /*CASEA*/((emfswitch.operation.BufferOperation) emfswitch.doSwitch(b)).initialize();
    }
  }

  public void main() {
    /*CASEA*/((emfswitch.operation.SystemOperation) emfswitch.doSwitch(this.it)).intialize();
    boolean anFSMRan = ((boolean)true);
    int cptr = ((int)0);
    while (((anFSMRan) && ((cptr) < (50000000)))) {
      anFSMRan = false;
      for(FSM fsm: this.it.getOwnedFsms()) {
        if(!(/*CASEA*/((emfswitch.operation.BufferOperation) emfswitch.doSwitch(fsm.getInputBuffer())).bisEmpty())) {
          /*CASEA*/((emfswitch.operation.FSMOperation) emfswitch.doSwitch(fsm)).run();
          anFSMRan = true;
        }
        cptr = (cptr) + (1);
      }
    }
  }
}
