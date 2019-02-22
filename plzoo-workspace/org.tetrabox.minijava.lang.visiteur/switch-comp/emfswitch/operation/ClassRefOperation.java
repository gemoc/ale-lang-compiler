package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.ClassRef;
import miniJava.TypeRef;

public class ClassRefOperation extends SingleTypeRefOperation {
  private final ClassRef it;

  private final SwitchImplementation emfswitch;

  public ClassRefOperation(ClassRef it, SwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public boolean compare(TypeRef other) {
    boolean result;
    if(other instanceof miniJava.ClassRef) {
      ClassRef ocr = ((ClassRef)other);
      result = java.util.Objects.equals((this.it.getReferencedClass()), (ocr.getReferencedClass()));
    }
    else {
      result = false;
    }
    return result;
  }
}
