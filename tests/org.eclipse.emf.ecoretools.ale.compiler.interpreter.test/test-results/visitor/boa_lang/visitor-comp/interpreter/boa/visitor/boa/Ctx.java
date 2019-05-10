package interpreter.boa.visitor.boa;

import interpreter.visitor.AcceptInterface;
import java.lang.String;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

public interface Ctx extends EObject, AcceptInterface {
	EMap<String, EvalRes> getEnv();

	EMap<String, EvalRes> getTh();
}
