package interpreter.imp.interpreter.imp;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface ArrayValue extends EObject, Value {
  EList<Value> getValues();
}
