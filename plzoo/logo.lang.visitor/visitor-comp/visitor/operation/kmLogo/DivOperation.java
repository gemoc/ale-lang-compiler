package visitor.operation.kmLogo;

import kmLogo.visitor.kmLogo.Turtle;

public interface DivOperation extends BinaryExpOperation {
  double eval(Turtle turtle);
}
