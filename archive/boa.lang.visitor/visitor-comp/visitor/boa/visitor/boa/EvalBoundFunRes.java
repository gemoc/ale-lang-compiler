package visitor.boa.visitor.boa;

import java.lang.String;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import visitor.visitor.AcceptInterface;

public interface EvalBoundFunRes extends EObject, AcceptInterface, EvalFunRes {
  EMap<String, EvalRes> getTh();
}
