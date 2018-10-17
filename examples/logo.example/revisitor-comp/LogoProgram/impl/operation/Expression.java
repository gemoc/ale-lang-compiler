package LogoProgram.impl.operation;

import kmLogo.Turtle;

public interface Expression extends Instruction {
  double eval(Turtle turtle);
}
