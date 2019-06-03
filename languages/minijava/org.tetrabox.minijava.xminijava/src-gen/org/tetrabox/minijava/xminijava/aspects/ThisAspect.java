package org.tetrabox.minijava.xminijava.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.tetrabox.minijava.xminijava.miniJava.MiniJavaFactory;
import org.tetrabox.minijava.xminijava.miniJava.ObjectInstance;
import org.tetrabox.minijava.xminijava.miniJava.ObjectRefValue;
import org.tetrabox.minijava.xminijava.miniJava.State;
import org.tetrabox.minijava.xminijava.miniJava.Value;
import org.tetrabox.minijava.xminijava.aspects.ExpressionAspect;
import org.tetrabox.minijava.xminijava.aspects.StateAspect;
import org.tetrabox.minijava.xminijava.aspects.ThisAspectThisAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.This;

@Aspect(className = This.class)
@SuppressWarnings("all")
public class ThisAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static Value evaluateExpression(final This _self, final State state) {
	final org.tetrabox.minijava.xminijava.aspects.ThisAspectThisAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ThisAspectThisAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_evaluateExpression(_self_, _self, state);
	;
	return (org.tetrabox.minijava.xminijava.miniJava.Value) result;
}
  
  private static Value super_evaluateExpression(final This _self, final State state) {
    final org.tetrabox.minijava.xminijava.aspects.ExpressionAspectExpressionAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  org.tetrabox.minijava.xminijava.aspects.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final ThisAspectThisAspectProperties _self_, final This _self, final State state) {
    final ObjectInstance currentInstance = StateAspect.findCurrentFrame(state).getInstance();
    if ((currentInstance == null)) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\"this\" is not valid in the current context");
      throw new RuntimeException(_builder.toString());
    } else {
      ObjectRefValue _createObjectRefValue = MiniJavaFactory.eINSTANCE.createObjectRefValue();
      final Procedure1<ObjectRefValue> _function = (ObjectRefValue it) -> {
        it.setInstance(currentInstance);
      };
      return ObjectExtensions.<ObjectRefValue>operator_doubleArrow(_createObjectRefValue, _function);
    }
  }
}
