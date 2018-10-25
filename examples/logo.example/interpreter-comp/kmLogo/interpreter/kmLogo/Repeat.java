package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

public interface Repeat extends EObject, ControlStructure {
  Block getBlock();

  void setBlock(Block value);

  double eval(Turtle turtle);
}
