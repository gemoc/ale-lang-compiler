package visitor.boa.visitor.boa;

import java.lang.String;
import org.eclipse.emf.ecore.EObject;
import visitor.visitor.AcceptInterface;

public interface StringToEvalResMap extends EObject, AcceptInterface {
  String getKey();

  void setKey(String value);

  EvalRes getValue();

  void setValue(EvalRes value);
}
