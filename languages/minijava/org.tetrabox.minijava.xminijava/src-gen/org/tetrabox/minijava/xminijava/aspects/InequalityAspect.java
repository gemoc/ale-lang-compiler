package org.tetrabox.minijava.xminijava.aspects;

import com.google.common.base.Objects;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.tetrabox.minijava.xminijava.miniJava.BooleanValue;
import org.tetrabox.minijava.xminijava.miniJava.IntegerValue;
import org.tetrabox.minijava.xminijava.miniJava.MiniJavaFactory;
import org.tetrabox.minijava.xminijava.miniJava.NullValue;
import org.tetrabox.minijava.xminijava.miniJava.ObjectRefValue;
import org.tetrabox.minijava.xminijava.miniJava.State;
import org.tetrabox.minijava.xminijava.miniJava.StringValue;
import org.tetrabox.minijava.xminijava.miniJava.Value;
import org.tetrabox.minijava.xminijava.aspects.ExpressionAspect;
import org.tetrabox.minijava.xminijava.aspects.InequalityAspectInequalityAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.Inequality;

@Aspect(className = Inequality.class)
@SuppressWarnings("all")
public class InequalityAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static Value evaluateExpression(final Inequality _self, final State state) {
	final org.tetrabox.minijava.xminijava.aspects.InequalityAspectInequalityAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.InequalityAspectInequalityAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_evaluateExpression(_self_, _self, state);
	;
	return (org.tetrabox.minijava.xminijava.miniJava.Value) result;
}
  
  private static Value super_evaluateExpression(final Inequality _self, final State state) {
    final org.tetrabox.minijava.xminijava.aspects.ExpressionAspectExpressionAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  org.tetrabox.minijava.xminijava.aspects.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final InequalityAspectInequalityAspectProperties _self_, final Inequality _self, final State state) {
    final Value left = ExpressionAspect.evaluateExpression(_self.getLeft(), state);
    final Value right = ExpressionAspect.evaluateExpression(_self.getRight(), state);
    boolean _xifexpression = false;
    if ((left instanceof IntegerValue)) {
      int _value = ((IntegerValue)left).getValue();
      int _value_1 = ((IntegerValue) right).getValue();
      _xifexpression = (_value != _value_1);
    } else {
      boolean _xifexpression_1 = false;
      if ((left instanceof StringValue)) {
        String _value_2 = ((StringValue)left).getValue();
        String _value_3 = ((StringValue) right).getValue();
        _xifexpression_1 = (!Objects.equal(_value_2, _value_3));
      } else {
        boolean _xifexpression_2 = false;
        if ((left instanceof BooleanValue)) {
          boolean _isValue = ((BooleanValue)left).isValue();
          boolean _isValue_1 = ((BooleanValue) right).isValue();
          _xifexpression_2 = (Boolean.valueOf(_isValue) != Boolean.valueOf(_isValue_1));
        } else {
          boolean _xifexpression_3 = false;
          if ((left instanceof NullValue)) {
            _xifexpression_3 = (!(right instanceof NullValue));
          } else {
            boolean _xifexpression_4 = false;
            if ((left instanceof ObjectRefValue)) {
              _xifexpression_4 = ((!(right instanceof ObjectRefValue)) || (((ObjectRefValue)left).getInstance() != ((ObjectRefValue) right).getInstance()));
            } else {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("Type unsupported for inequality operator: ");
              Class<? extends Value> _class = left.getClass();
              _builder.append(_class);
              throw new RuntimeException(_builder.toString());
            }
            _xifexpression_3 = _xifexpression_4;
          }
          _xifexpression_2 = _xifexpression_3;
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    final boolean result = _xifexpression;
    BooleanValue _createBooleanValue = MiniJavaFactory.eINSTANCE.createBooleanValue();
    final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
      it.setValue(result);
    };
    return ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
  }
}
