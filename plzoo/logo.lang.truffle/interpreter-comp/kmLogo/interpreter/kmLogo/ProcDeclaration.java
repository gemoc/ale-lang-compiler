package kmLogo.interpreter.kmLogo;

import com.oracle.truffle.api.nodes.NodeInterface;
import java.lang.String;
import kmLogo.interpreter.kmLogo.impl.ProcDeclarationDispatchWrapperDeval;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface ProcDeclaration extends EObject, NodeInterface, Instruction {
  String getName();

  void setName(String value);

  EList<Parameter> getArgs();

  EList<ProcCall> getProcCall();

  EList<Instruction> getInstructions();

  double eval(Turtle turtle);

  double deval(Turtle turtle);

  ProcDeclarationDispatchWrapperDeval getCachedDeval();
}
