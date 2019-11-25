package visitor.operation.kmLogo;

import kmLogo.visitor.kmLogo.Turtle;

public interface LowerOperation extends BinaryExpOperation {
  double eval(Turtle turtle);
}
