package visitor.operation.kmLogo;

import kmLogo.visitor.kmLogo.Turtle;

public interface ForwardOperation extends PrimitiveOperation {
  double eval(Turtle turtle);
}
