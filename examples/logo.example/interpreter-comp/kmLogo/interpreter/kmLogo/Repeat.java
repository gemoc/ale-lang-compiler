package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

public interface Repeat extends EObject, ControlStructure {
  Block getBlock();

  void setBlock(Block block);

  double eval(Turtle turtle);
}
