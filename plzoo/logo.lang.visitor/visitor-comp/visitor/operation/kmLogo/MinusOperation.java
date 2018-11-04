package visitor.operation.kmLogo;

import kmLogo.visitor.kmLogo.Turtle;

public interface MinusOperation extends BinaryExpOperation {
  double eval(Turtle turtle);
}
