package visitor.boa.visitor.boa;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import visitor.visitor.AcceptInterface;

public interface File extends EObject, AcceptInterface {
  EList<TopLevelCmd> getCommands();
}
