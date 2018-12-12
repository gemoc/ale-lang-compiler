package org.tetrabox.minijava.xminijava.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.tetrabox.minijava.xminijava.miniJava.Context;
import org.tetrabox.minijava.xminijava.miniJava.MethodCall2;
import org.tetrabox.minijava.xminijava.miniJava.MiniJavaFactory;
import org.tetrabox.minijava.xminijava.miniJava.ObjectInstance;
import org.tetrabox.minijava.xminijava.miniJava.ObjectRefValue;
import org.tetrabox.minijava.xminijava.miniJava.State;
import org.tetrabox.minijava.xminijava.miniJava.SymbolBinding;
import org.tetrabox.minijava.xminijava.miniJava.Value;
import org.tetrabox.minijava.xminijava.aspects.ExpressionAspect;
import org.tetrabox.minijava.xminijava.aspects.MethodAspect;
import org.tetrabox.minijava.xminijava.aspects.MethodCallExpressionAspectMethodCallAspectProperties;
import org.tetrabox.minijava.xminijava.aspects.MethodSortofStatementAspect;
import org.tetrabox.minijava.xminijava.aspects.StateAspect;
import org.tetrabox.minijava.xminijava.miniJava.Expression;
import org.tetrabox.minijava.xminijava.miniJava.Method;
import org.tetrabox.minijava.xminijava.miniJava.MethodCall;
import org.tetrabox.minijava.xminijava.miniJava.Parameter;

@Aspect(className = MethodCall.class)
@SuppressWarnings("all")
public class MethodCallExpressionAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static Value evaluateExpression(final MethodCall _self, final State state) {
	final org.tetrabox.minijava.xminijava.aspects.MethodCallExpressionAspectMethodCallAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.MethodCallExpressionAspectMethodCallAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_evaluateExpression(_self_, _self, state);
	;
	return (org.tetrabox.minijava.xminijava.miniJava.Value) result;
}
  
  private static Value super_evaluateExpression(final MethodCall _self, final State state) {
    final org.tetrabox.minijava.xminijava.aspects.ExpressionAspectExpressionAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  org.tetrabox.minijava.xminijava.aspects.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final MethodCallExpressionAspectMethodCallAspectProperties _self_, final MethodCall _self, final State state) {
    Value _evaluateExpression = ExpressionAspect.evaluateExpression(_self.getReceiver(), state);
    final ObjectInstance realReceiver = ((ObjectRefValue) _evaluateExpression).getInstance();
    org.tetrabox.minijava.xminijava.miniJava.Class _type = realReceiver.getType();
    final Method realMethod = MethodAspect.findOverride(_self.getMethod(), ((org.tetrabox.minijava.xminijava.miniJava.Class) _type));
    final Context newContext = MiniJavaFactory.eINSTANCE.createContext();
    EList<Expression> _args = _self.getArgs();
    for (final Expression arg : _args) {
      {
        final Parameter param = realMethod.getParams().get(_self.getArgs().indexOf(arg));
        SymbolBinding _createSymbolBinding = MiniJavaFactory.eINSTANCE.createSymbolBinding();
        final Procedure1<SymbolBinding> _function = (SymbolBinding it) -> {
          it.setSymbol(param);
          it.setValue(ExpressionAspect.evaluateExpression(arg, state));
        };
        final SymbolBinding binding = ObjectExtensions.<SymbolBinding>operator_doubleArrow(_createSymbolBinding, _function);
        newContext.getBindings().add(binding);
      }
    }
    MethodCall2 _createMethodCall2 = MiniJavaFactory.eINSTANCE.createMethodCall2();
    final Procedure1<MethodCall2> _function = (MethodCall2 it) -> {
      it.setMethodcall(_self);
    };
    final MethodCall2 call = ObjectExtensions.<MethodCall2>operator_doubleArrow(_createMethodCall2, _function);
    StateAspect.pushNewFrame(state, realReceiver, call, newContext);
    MethodSortofStatementAspect.call(realMethod, state);
    final Value returnValue = StateAspect.findCurrentFrame(state).getReturnValue();
    StateAspect.popCurrentFrame(state);
    return returnValue;
  }
}
