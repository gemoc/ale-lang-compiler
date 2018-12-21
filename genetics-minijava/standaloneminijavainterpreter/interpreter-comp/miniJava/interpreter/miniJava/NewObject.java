package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface NewObject extends EObject, NodeInterface, Expression {
  Clazz getType();

  void setType(Clazz value);

  EList<Expression> getArgs();

  Value evaluateExpression(State state);
}
