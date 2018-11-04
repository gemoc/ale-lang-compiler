package visitor.operation.kmLogo;

import kmLogo.visitor.kmLogo.Turtle;

public interface PlusOperation extends BinaryExpOperation {
  double eval(Turtle turtle);
}
