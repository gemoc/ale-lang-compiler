package visitor.operation.kmLogo;

import kmLogo.visitor.kmLogo.Turtle;

public interface ClearOperation extends PrimitiveOperation {
  double eval(Turtle turtle);
}
