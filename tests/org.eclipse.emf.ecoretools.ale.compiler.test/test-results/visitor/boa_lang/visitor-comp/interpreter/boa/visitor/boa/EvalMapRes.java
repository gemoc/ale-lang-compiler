package interpreter.boa.visitor.boa;

import interpreter.visitor.AcceptInterface;
import java.lang.String;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

public interface EvalMapRes extends EObject, AcceptInterface, EvalRes {
	EMap<String, EvalRes> getValues();
}
