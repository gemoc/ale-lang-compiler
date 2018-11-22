package visitor.operation.kmLogo;

import kmLogo.visitor.kmLogo.Turtle;

public interface ProcCallOperation extends ExpressionOperation {
  double eval(Turtle turtle);
}
