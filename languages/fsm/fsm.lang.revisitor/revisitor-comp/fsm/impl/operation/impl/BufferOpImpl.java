package fsm.impl.operation.impl;

import fsm.FsmService;
import fsm.impl.operation.BufferOp;
import fsm.impl.operation.FSMOp;
import fsm.impl.operation.StateOp;
import fsm.impl.operation.SystemOp;
import fsm.impl.operation.TransitionOp;
import fsm.model.fsm.Buffer;
import fsm.model.revisitor.FsmRevisitor;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

public class BufferOpImpl implements BufferOp {
  private FsmRevisitor<BufferOp, FSMOp, StateOp, SystemOp, TransitionOp> rev;

  private Buffer obj;

  public BufferOpImpl(Buffer obj,
      FsmRevisitor<BufferOp, FSMOp, StateOp, SystemOp, TransitionOp> rev) {
    this.obj = obj;
    this.rev = rev;
  }

  public void initialize() {
    if(!EqualService.equals((this.obj.getInitialValue()), (null))) {
      this.obj.setCurrentValues(this.obj.getInitialValue());
    }
    else {
      this.obj.setCurrentValues("'empty'");
    }
  }

  public boolean bisEmpty() {
    boolean result;
    result = ((Boolean) (((EqualService.equals((CollectionService.size(this.obj.getCurrentValues())), (0))) || (EqualService.equals((this.obj.getCurrentValues()), ("'empty'"))))));
    return result;
  }

  public void enqueue(String v) {
    if(rev.$((Buffer)this.obj).bisEmpty()) {
      this.obj.setCurrentValues(v);
    }
    else {
      this.obj.setCurrentValues(((this.obj.getCurrentValues()) + (",")) + (v));
    }
  }

  public String dequeue() {
    String result;
    String res = ((String) (""));
    int firstComma = ((int) (FsmService.indexOf((String) (this.obj.getCurrentValues()), (String) (","))));
    if((firstComma) < (0)) {
      res = ((String) (this.obj.getCurrentValues()));
      this.obj.setCurrentValues("'empty'");
      result = ((String) (res));
    }
    else {
      res = FsmService.substring((String) (this.obj.getCurrentValues()), (Integer) (0), (int) (firstComma));
      this.obj.setCurrentValues(FsmService.substring((String) (this.obj.getCurrentValues()), ((firstComma) + (1)), (Integer) (CollectionService.size(this.obj.getCurrentValues()))));
      result = ((String) (res));
    }
    return result;
  }
}
