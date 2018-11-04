package visitor.operation.kmLogo;

import kmLogo.visitor.kmLogo.Turtle;

public interface PenUpOperation extends PrimitiveOperation {
  double eval(Turtle turtle);
}
