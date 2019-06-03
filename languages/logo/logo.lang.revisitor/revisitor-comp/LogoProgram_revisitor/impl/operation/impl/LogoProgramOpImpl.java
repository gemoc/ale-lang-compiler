package LogoProgram_revisitor.impl.operation.impl;

import LogoProgram_revisitor.impl.operation.BackOp;
import LogoProgram_revisitor.impl.operation.BinaryExpOp;
import LogoProgram_revisitor.impl.operation.BlockOp;
import LogoProgram_revisitor.impl.operation.CallStackOp;
import LogoProgram_revisitor.impl.operation.ClearOp;
import LogoProgram_revisitor.impl.operation.ConstantOp;
import LogoProgram_revisitor.impl.operation.ControlStructureOp;
import LogoProgram_revisitor.impl.operation.CosOp;
import LogoProgram_revisitor.impl.operation.DivOp;
import LogoProgram_revisitor.impl.operation.EqualsOp;
import LogoProgram_revisitor.impl.operation.ExpressionOp;
import LogoProgram_revisitor.impl.operation.ForwardOp;
import LogoProgram_revisitor.impl.operation.GreaterOp;
import LogoProgram_revisitor.impl.operation.IfOp;
import LogoProgram_revisitor.impl.operation.InstructionOp;
import LogoProgram_revisitor.impl.operation.LeftOp;
import LogoProgram_revisitor.impl.operation.LogoProgramOp;
import LogoProgram_revisitor.impl.operation.LowerOp;
import LogoProgram_revisitor.impl.operation.MinusOp;
import LogoProgram_revisitor.impl.operation.MultOp;
import LogoProgram_revisitor.impl.operation.ParameterCallOp;
import LogoProgram_revisitor.impl.operation.ParameterOp;
import LogoProgram_revisitor.impl.operation.PenDownOp;
import LogoProgram_revisitor.impl.operation.PenUpOp;
import LogoProgram_revisitor.impl.operation.PlusOp;
import LogoProgram_revisitor.impl.operation.PointOp;
import LogoProgram_revisitor.impl.operation.PrimitiveOp;
import LogoProgram_revisitor.impl.operation.ProcCallOp;
import LogoProgram_revisitor.impl.operation.ProcDeclarationOp;
import LogoProgram_revisitor.impl.operation.RepeatOp;
import LogoProgram_revisitor.impl.operation.RightOp;
import LogoProgram_revisitor.impl.operation.SegmentOp;
import LogoProgram_revisitor.impl.operation.SinOp;
import LogoProgram_revisitor.impl.operation.StackFrameOp;
import LogoProgram_revisitor.impl.operation.TanOp;
import LogoProgram_revisitor.impl.operation.TurtleOp;
import LogoProgram_revisitor.impl.operation.UnaryExpressionOp;
import LogoProgram_revisitor.impl.operation.VariableOp;
import LogoProgram_revisitor.impl.operation.WhileOp;
import kmLogo.Instruction;
import kmLogo.KmLogoFactory;
import kmLogo.LogoProgram;
import kmLogo.Turtle;
import kmLogo.revisitor.KmLogoRevisitor;

public class LogoProgramOpImpl implements LogoProgramOp {
  private KmLogoRevisitor<BackOp, BinaryExpOp, BlockOp, CallStackOp, ClearOp, ConstantOp, ControlStructureOp, CosOp, DivOp, EqualsOp, ExpressionOp, ForwardOp, GreaterOp, IfOp, InstructionOp, LeftOp, LogoProgramOp, LowerOp, MinusOp, MultOp, ParameterOp, ParameterCallOp, PenDownOp, PenUpOp, PlusOp, PointOp, PrimitiveOp, ProcCallOp, ProcDeclarationOp, RepeatOp, RightOp, SegmentOp, SinOp, StackFrameOp, TanOp, TurtleOp, UnaryExpressionOp, VariableOp, WhileOp> rev;

  private LogoProgram obj;

  public LogoProgramOpImpl(LogoProgram obj,
      KmLogoRevisitor<BackOp, BinaryExpOp, BlockOp, CallStackOp, ClearOp, ConstantOp, ControlStructureOp, CosOp, DivOp, EqualsOp, ExpressionOp, ForwardOp, GreaterOp, IfOp, InstructionOp, LeftOp, LogoProgramOp, LowerOp, MinusOp, MultOp, ParameterOp, ParameterCallOp, PenDownOp, PenUpOp, PlusOp, PointOp, PrimitiveOp, ProcCallOp, ProcDeclarationOp, RepeatOp, RightOp, SegmentOp, SinOp, StackFrameOp, TanOp, TurtleOp, UnaryExpressionOp, VariableOp, WhileOp> rev) {
    this.obj = obj;
    this.rev = rev;
  }

  public Turtle eval() {
    Turtle result;
    Turtle turtle = ((Turtle) (rev.$((LogoProgram)this.obj).createTurtle()));
    result = turtle;
    for(Instruction it: this.obj.getInstructions()) {
      rev.$((Instruction)it).eval(((Turtle) (turtle)));
    }
    result = turtle;
    return result;
  }

  public Turtle createTurtle() {
    Turtle result;
    Turtle turtle = ((Turtle) (KmLogoFactory.eINSTANCE.createTurtle()));
    turtle.setPosition(KmLogoFactory.eINSTANCE.createPoint());
    turtle.getPosition().setX(0.0);
    turtle.getPosition().setY(0.0);
    turtle.setCallStack(KmLogoFactory.eINSTANCE.createCallStack());
    turtle.getCallStack().getFrames().add(KmLogoFactory.eINSTANCE.createStackFrame());
    result = turtle;
    return result;
  }
}
