package LogoProgram_revisitor.impl.operation;

import kmLogo.Turtle;

public interface ParameterCall extends Expression {
  double eval(Turtle turtle);
}
