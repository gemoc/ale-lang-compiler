package kmLogo.interpreter.kmLogo;

import com.oracle.truffle.api.nodes.NodeInterface;
import java.lang.String;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface ProcDeclaration extends EObject, NodeInterface, Instruction {
  String getName();

  void setName(String value);

  EList<Parameter> getArgs();

  EList<ProcCall> getProcCall();

  EList<Instruction> getInstructions();

  double eval(Turtle turtle);
}
