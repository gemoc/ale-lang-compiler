package kmLogo.interpreter.kmLogo;

import com.oracle.truffle.api.nodes.NodeInterface;
import kmLogo.interpreter.kmLogo.impl.LogoProgramDispatchWrapperCreateTurtle;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface LogoProgram extends EObject, NodeInterface {
  EList<Instruction> getInstructions();

  Turtle eval();

  Turtle createTurtle();

  LogoProgramDispatchWrapperCreateTurtle getCachedCreateTurtle();
}
