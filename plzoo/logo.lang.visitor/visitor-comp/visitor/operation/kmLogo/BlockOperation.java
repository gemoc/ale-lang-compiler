package visitor.operation.kmLogo;

import kmLogo.visitor.kmLogo.Turtle;

public interface BlockOperation extends InstructionOperation {
  double eval(Turtle turtle);
}
