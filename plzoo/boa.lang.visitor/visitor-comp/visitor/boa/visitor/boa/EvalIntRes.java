package visitor.boa.visitor.boa;

import org.eclipse.emf.ecore.EObject;
import visitor.visitor.AcceptInterface;

public interface EvalIntRes extends EObject, AcceptInterface, EvalRes {
  int getValue();

  void setValue(int value);
}
