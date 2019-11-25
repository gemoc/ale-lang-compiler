package kmLogo.visitor.kmLogo;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface Back extends EObject, AcceptInterface, Primitive {
  Expression getSteps();

  void setSteps(Expression value);
}
