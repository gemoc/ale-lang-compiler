package kmlogo.interpreter;

import org.eclipse.emf.ecore.EObject;

public interface While extends EObject, ControlStructure {
  Block getBlock();

  void setBlock(Block block);

  double eval(Turtle turtle);
}
