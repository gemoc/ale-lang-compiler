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
import java.lang.Double;
import kmLogo.KmLogoFactory;
import kmLogo.Point;
import kmLogo.Segment;
import kmLogo.Turtle;
import kmLogo.revisitor.KmLogoRevisitor;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices;

public class TurtleOpImpl implements TurtleOp {
  private KmLogoRevisitor<BackOp, BinaryExpOp, BlockOp, CallStackOp, ClearOp, ConstantOp, ControlStructureOp, CosOp, DivOp, EqualsOp, ExpressionOp, ForwardOp, GreaterOp, IfOp, InstructionOp, LeftOp, LogoProgramOp, LowerOp, MinusOp, MultOp, ParameterOp, ParameterCallOp, PenDownOp, PenUpOp, PlusOp, PointOp, PrimitiveOp, ProcCallOp, ProcDeclarationOp, RepeatOp, RightOp, SegmentOp, SinOp, StackFrameOp, TanOp, TurtleOp, UnaryExpressionOp, VariableOp, WhileOp> rev;

  private Turtle obj;

  public TurtleOpImpl(Turtle obj,
      KmLogoRevisitor<BackOp, BinaryExpOp, BlockOp, CallStackOp, ClearOp, ConstantOp, ControlStructureOp, CosOp, DivOp, EqualsOp, ExpressionOp, ForwardOp, GreaterOp, IfOp, InstructionOp, LeftOp, LogoProgramOp, LowerOp, MinusOp, MultOp, ParameterOp, ParameterCallOp, PenDownOp, PenUpOp, PlusOp, PointOp, PrimitiveOp, ProcCallOp, ProcDeclarationOp, RepeatOp, RightOp, SegmentOp, SinOp, StackFrameOp, TanOp, TurtleOp, UnaryExpressionOp, VariableOp, WhileOp> rev) {
    this.obj = obj;
    this.rev = rev;
  }

  public void move(double dx, double dy) {
    Point newPos = ((Point) (KmLogoFactory.eINSTANCE.createPoint()));
    newPos.setX((this.obj.getPosition().getX()) + (dx));
    newPos.setY((this.obj.getPosition().getY()) + (dy));
    if(this.obj.isPenUp()) {
    }
    else {
      Segment newSegment = ((Segment) (KmLogoFactory.eINSTANCE.createSegment()));
      newSegment.setBegin(this.obj.getPosition());
      newSegment.setEnd(newPos);
      this.obj.getDrawings().add(newSegment);
    }
    Point newPosCopy = ((Point) (KmLogoFactory.eINSTANCE.createPoint()));
    newPosCopy.setX(newPos.getX());
    newPosCopy.setY(newPos.getY());
    this.obj.setPosition(newPosCopy);
  }

  public void forward(double steps) {
    rev.$((Turtle)this.obj).move(((Double) ((steps) * (TrigoServices.cosinus((double) (this.obj.getHeading()))))), ((Double) ((steps) * (TrigoServices.sinus((double) (this.obj.getHeading()))))));
  }

  public void rotate(double angle) {
    double newAngle = ((double) ((this.obj.getHeading()) + (angle)));
    if((newAngle) > (360.0)) {
      newAngle = ((Double) ((newAngle) - (360.0)));
      this.obj.setHeading(newAngle);
    }
    else {
      if((newAngle) < (0.0)) {
        newAngle = ((Double) ((360.0) + (newAngle)));
        this.obj.setHeading(newAngle);
      }
      else {
        this.obj.setHeading(newAngle);
      }
    }
  }
}
