package visitor.boa.visitor.boa;

import org.eclipse.emf.ecore.EObject;
import visitor.visitor.AcceptInterface;

public interface EvalBoolRes extends EObject, AcceptInterface, EvalRes {
  boolean isValue();

  void setValue(boolean value);
}
