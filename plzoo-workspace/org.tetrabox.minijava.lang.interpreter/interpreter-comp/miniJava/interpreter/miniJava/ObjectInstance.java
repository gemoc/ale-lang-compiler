package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface ObjectInstance extends EObject, NodeInterface {
  EList<FieldBinding> getFieldbindings();

  Clazz getType();

  void setType(Clazz value);
}
