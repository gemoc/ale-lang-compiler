package visitor.operation.kmLogo;

import kmLogo.visitor.kmLogo.Turtle;

public interface BackOperation extends PrimitiveOperation {
  double eval(Turtle turtle);
}
