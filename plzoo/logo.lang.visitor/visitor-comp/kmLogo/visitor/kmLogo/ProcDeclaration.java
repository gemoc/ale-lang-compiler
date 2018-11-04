package kmLogo.visitor.kmLogo;

import java.lang.String;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface ProcDeclaration extends EObject, AcceptInterface, Instruction {
  String getName();

  void setName(String value);

  EList<Parameter> getArgs();

  EList<ProcCall> getProcCall();

  EList<Instruction> getInstructions();
}
