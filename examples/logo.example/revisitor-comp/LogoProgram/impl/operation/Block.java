package LogoProgram.impl.operation;

import kmLogo.Turtle;

public interface Block extends Instruction {
  double eval(Turtle turtle);
}
