package test.impl.operation.impl;

import org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices;

import kmLogo.KmLogoFactory;
import kmLogo.Point;
import kmLogo.Segment;
import kmLogo.Turtle;
import kmLogo.revisitor.KmLogoRevisitor;
import test.impl.operation.BackOp;
import test.impl.operation.BinaryExpOp;
import test.impl.operation.BlockOp;
import test.impl.operation.CallStackOp;
import test.impl.operation.ClearOp;
import test.impl.operation.ConstantOp;
import test.impl.operation.ControlStructureOp;
import test.impl.operation.CosOp;
import test.impl.operation.DivOp;
import test.impl.operation.EqualsOp;
import test.impl.operation.ExpressionOp;
import test.impl.operation.ForwardOp;
import test.impl.operation.GreaterOp;
import test.impl.operation.IfOp;
import test.impl.operation.InstructionOp;
import test.impl.operation.LeftOp;
import test.impl.operation.LogoProgramOp;
import test.impl.operation.LowerOp;
import test.impl.operation.MinusOp;
import test.impl.operation.MultOp;
import test.impl.operation.ParameterCallOp;
import test.impl.operation.ParameterOp;
import test.impl.operation.PenDownOp;
import test.impl.operation.PenUpOp;
import test.impl.operation.PlusOp;
import test.impl.operation.PointOp;
import test.impl.operation.PrimitiveOp;
import test.impl.operation.ProcCallOp;
import test.impl.operation.ProcDeclarationOp;
import test.impl.operation.RepeatOp;
import test.impl.operation.RightOp;
import test.impl.operation.SegmentOp;
import test.impl.operation.SinOp;
import test.impl.operation.StackFrameOp;
import test.impl.operation.TanOp;
import test.impl.operation.TurtleOp;
import test.impl.operation.UnaryExpressionOp;
import test.impl.operation.VariableOp;
import test.impl.operation.WhileOp;

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
    rev.$((Turtle)this.obj).move(((Double) ((steps) * (TrigoServices.cosinus(this.obj.getHeading())))),((Double) ((steps) * (TrigoServices.sinus(this.obj.getHeading())))));
  }

  public void rotate(double angle) {
    double newAngle = ((double) ((this.obj.getHeading()) + (angle)));
    if((newAngle) > (360.0)) {
      newAngle = (newAngle) - (360.0);
      this.obj.setHeading(newAngle);
    }
    else {
      if((newAngle) < (0.0)) {
        newAngle = (360.0) + (newAngle);
        this.obj.setHeading(newAngle);
      }
      else {
        this.obj.setHeading(newAngle);
      }
    }
  }
}
