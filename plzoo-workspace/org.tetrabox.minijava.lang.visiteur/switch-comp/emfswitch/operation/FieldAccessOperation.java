package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.Field;
import miniJava.FieldAccess;
import miniJava.FieldBinding;
import miniJava.ObjectInstance;
import miniJava.ObjectRefValue;
import miniJava.State;
import miniJava.Value;

public class FieldAccessOperation extends ExpressionOperation {
  private final FieldAccess it;

  private final SwitchImplementation emfswitch;

  public FieldAccessOperation(FieldAccess it, SwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public Value evaluateExpression(State state) {
    Value result;
    ObjectRefValue tmp0 = ((ObjectRefValue)/*CASEA*/((emfswitch.operation.ExpressionOperation) emfswitch.doSwitch(this.it.getReceiver())).evaluateExpression(state));
    ObjectInstance realReceiver = ((ObjectInstance)tmp0.getInstance());
    Field fld = ((Field)this.it.getField());
    FieldBinding fb = ((FieldBinding)org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.head(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.select(realReceiver.getFieldbindings(), (x) -> java.util.Objects.equals((x.getField()), (fld)))));
    result = fb.getValue();
    return result;
  }
}
