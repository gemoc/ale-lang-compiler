package visitor.operation.kmLogo;

import kmLogo.visitor.kmLogo.Turtle;

public interface LeftOperation extends PrimitiveOperation {
  double eval(Turtle turtle);
}
