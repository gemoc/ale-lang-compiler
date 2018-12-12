package interpreter.imp.interpreter.imp;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface ArrayValue extends EObject, NodeInterface, Value {
  EList<Value> getValues();
}
