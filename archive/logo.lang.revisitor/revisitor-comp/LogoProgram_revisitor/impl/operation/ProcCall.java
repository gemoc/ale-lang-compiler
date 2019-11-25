package LogoProgram_revisitor.impl.operation;

import kmLogo.Turtle;

public interface ProcCall extends Expression {
  double eval(Turtle turtle);
}
