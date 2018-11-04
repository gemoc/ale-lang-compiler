package boa.interpreter.boa;

import com.oracle.truffle.api.nodes.NodeInterface;
import java.lang.String;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

public interface EvalMapRes extends EObject, EvalRes {
  EMap<String, EvalRes> getValues();
}
