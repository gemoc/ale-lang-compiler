package emfswitch.operation;

import emfswitch.SwitchImplementation;
import java.lang.String;
import miniJava.Value;

public class ValueOperation {
  private final Value it;

  private final SwitchImplementation emfswitch;

  public ValueOperation(Value it, SwitchImplementation emfswitch) {
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public String customToString() {
    String result;
    result = "ERROR customToString not overloaded";
    return result;
  }

  public Value copyj() {
    Value result;
    org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log("ERROR copyj not implemented");
    result = null;
    return result;
  }
}
