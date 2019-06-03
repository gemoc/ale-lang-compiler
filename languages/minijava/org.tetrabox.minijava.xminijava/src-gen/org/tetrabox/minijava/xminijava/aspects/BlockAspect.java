package org.tetrabox.minijava.xminijava.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import java.util.Iterator;
import org.tetrabox.minijava.xminijava.miniJava.Frame;
import org.tetrabox.minijava.xminijava.miniJava.State;
import org.tetrabox.minijava.xminijava.aspects.BlockAspectBlockAspectProperties;
import org.tetrabox.minijava.xminijava.aspects.StateAspect;
import org.tetrabox.minijava.xminijava.aspects.StatementAspect;
import org.tetrabox.minijava.xminijava.miniJava.Block;
import org.tetrabox.minijava.xminijava.miniJava.Statement;

@Aspect(className = Block.class)
@SuppressWarnings("all")
public class BlockAspect extends StatementAspect {
  public static void evaluateStatementKeepContext(final Block _self, final State state) {
	final org.tetrabox.minijava.xminijava.aspects.BlockAspectBlockAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.BlockAspectBlockAspectContext
			.getSelf(_self);
	_privk3_evaluateStatementKeepContext(_self_, _self, state);
	;
}
  
  @OverrideAspectMethod
  public static void evaluateStatement(final Block _self, final State state) {
	final org.tetrabox.minijava.xminijava.aspects.BlockAspectBlockAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.BlockAspectBlockAspectContext
			.getSelf(_self);
	_privk3_evaluateStatement(_self_, _self, state);
	;
}
  
  protected static void _privk3_evaluateStatementKeepContext(final BlockAspectBlockAspectProperties _self_, final Block _self, final State state) {
    StateAspect.pushNewContext(state);
    final Frame currentFrame = StateAspect.findCurrentFrame(state);
    Iterator<Statement> i = _self.getStatements().iterator();
    while ((i.hasNext() && (currentFrame.getReturnValue() == null))) {
      StatementAspect.evaluateStatement(i.next(), state);
    }
  }
  
  private static void super_evaluateStatement(final Block _self, final State state) {
    final org.tetrabox.minijava.xminijava.aspects.StatementAspectStatementAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.StatementAspectStatementAspectContext.getSelf(_self);
     org.tetrabox.minijava.xminijava.aspects.StatementAspect._privk3_evaluateStatement(_self_, _self,state);
  }
  
  protected static void _privk3_evaluateStatement(final BlockAspectBlockAspectProperties _self_, final Block _self, final State state) {
    BlockAspect.evaluateStatementKeepContext(_self, state);
    StateAspect.popCurrentContext(state);
  }
}
