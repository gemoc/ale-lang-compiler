package visitor.operation.kmLogo;

import kmLogo.visitor.kmLogo.Turtle;

public interface MultOperation extends BinaryExpOperation {
  double eval(Turtle turtle);
}
