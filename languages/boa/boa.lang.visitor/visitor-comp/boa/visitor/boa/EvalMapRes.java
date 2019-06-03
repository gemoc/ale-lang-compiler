package boa.visitor.boa;

import java.lang.String;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface EvalMapRes extends EObject, AcceptInterface, EvalRes {
	EMap<String, EvalRes> getValues();
}
