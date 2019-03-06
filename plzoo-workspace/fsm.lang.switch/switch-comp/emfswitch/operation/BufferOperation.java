package emfswitch.operation;

import emfswitch.SwitchImplementation;
import fsm.model.fsm.Buffer;
import java.lang.String;

public class BufferOperation {
  private final Buffer it;

  private final SwitchImplementation emfswitch;

  public BufferOperation(Buffer it, SwitchImplementation emfswitch) {
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public void initialize() {
    if((this.it.getInitialValue()) != (null)) {
      this.it.setCurrentValues(this.it.getInitialValue());
    }
    else {
      this.it.setCurrentValues("'empty'");
    }
  }

  public boolean bisEmpty() {
    boolean result;
    result = ((java.util.Objects.equals((org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(this.it.getCurrentValues())), (0))) || (java.util.Objects.equals((this.it.getCurrentValues()), ("'empty'"))));
    return result;
  }

  public void enqueue(String v) {
    if(/*CASEA*/((emfswitch.operation.BufferOperation) emfswitch.doSwitch(this.it)).bisEmpty()) {
      this.it.setCurrentValues(v);
    }
    else {
      this.it.setCurrentValues(((this.it.getCurrentValues()) + (",")) + (v));
    }
  }

  public String dequeue() {
    String result;
    String res = ((String)"");
    int firstComma = ((int)/*CASEF*/this.it.getCurrentValues().indexOf(","));
    if((firstComma) < (0)) {
      res = this.it.getCurrentValues();
      this.it.setCurrentValues("'empty'");
      result = res;
    }
    else {
      res = /*CASEF*/this.it.getCurrentValues().substring(0,firstComma);
      this.it.setCurrentValues(/*CASEF*/this.it.getCurrentValues().substring((firstComma) + (1),org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(this.it.getCurrentValues())));
      result = res;
    }
    return result;
  }
}
