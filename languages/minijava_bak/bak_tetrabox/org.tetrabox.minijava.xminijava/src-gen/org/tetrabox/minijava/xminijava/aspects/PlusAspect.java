package org.tetrabox.minijava.xminijava.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.tetrabox.minijava.xminijava.miniJava.IntegerValue;
import org.tetrabox.minijava.xminijava.miniJava.MiniJavaFactory;
import org.tetrabox.minijava.xminijava.miniJava.State;
import org.tetrabox.minijava.xminijava.miniJava.StringValue;
import org.tetrabox.minijava.xminijava.miniJava.Value;
import org.tetrabox.minijava.xminijava.aspects.ExpressionAspect;
import org.tetrabox.minijava.xminijava.aspects.PlusAspectPlusAspectProperties;
import org.tetrabox.minijava.xminijava.aspects.ValueToStringAspect;
import org.tetrabox.minijava.xminijava.miniJava.Plus;

@Aspect(className = Plus.class)
@SuppressWarnings("all")
public class PlusAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static Value evaluateExpression(final Plus _self, final State state) {
	final org.tetrabox.minijava.xminijava.aspects.PlusAspectPlusAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.PlusAspectPlusAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_evaluateExpression(_self_, _self, state);
	;
	return (org.tetrabox.minijava.xminijava.miniJava.Value) result;
}
  
  private static Value super_evaluateExpression(final Plus _self, final State state) {
    final org.tetrabox.minijava.xminijava.aspects.ExpressionAspectExpressionAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  org.tetrabox.minijava.xminijava.aspects.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final PlusAspectPlusAspectProperties _self_, final Plus _self, final State state) {
    final Value left = ExpressionAspect.evaluateExpression(_self.getLeft(), state);
    final Value right = ExpressionAspect.evaluateExpression(_self.getRight(), state);
    if (((left instanceof StringValue) || (right instanceof StringValue))) {
      StringValue _createStringValue = MiniJavaFactory.eINSTANCE.createStringValue();
      final Procedure1<StringValue> _function = (StringValue it) -> {
        String _customToString = ValueToStringAspect.customToString(left);
        String _customToString_1 = ValueToStringAspect.customToString(right);
        String _plus = (_customToString + _customToString_1);
        it.setValue(_plus);
      };
      return ObjectExtensions.<StringValue>operator_doubleArrow(_createStringValue, _function);
    } else {
      if ((left instanceof IntegerValue)) {
        if ((right instanceof IntegerValue)) {
          IntegerValue _createIntegerValue = MiniJavaFactory.eINSTANCE.createIntegerValue();
          final Procedure1<IntegerValue> _function_1 = (IntegerValue it) -> {
            int _value = ((IntegerValue)left).getValue();
            int _value_1 = ((IntegerValue)right).getValue();
            int _plus = (_value + _value_1);
            it.setValue(_plus);
          };
          return ObjectExtensions.<IntegerValue>operator_doubleArrow(_createIntegerValue, _function_1);
        }
      }
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Unsupported plus operands: ");
    _builder.append(left);
    _builder.append(" + ");
    _builder.append(right);
    _builder.append(".");
    throw new RuntimeException(_builder.toString());
  }
}
