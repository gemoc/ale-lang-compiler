package org.tetrabox.minijava.xminijava.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.tetrabox.minijava.xminijava.miniJava.ArrayInstance;
import org.tetrabox.minijava.xminijava.miniJava.ArrayRefValue;
import org.tetrabox.minijava.xminijava.miniJava.BooleanValue;
import org.tetrabox.minijava.xminijava.miniJava.IntegerValue;
import org.tetrabox.minijava.xminijava.miniJava.MiniJavaFactory;
import org.tetrabox.minijava.xminijava.miniJava.State;
import org.tetrabox.minijava.xminijava.miniJava.Value;
import org.tetrabox.minijava.xminijava.aspects.ExpressionAspect;
import org.tetrabox.minijava.xminijava.aspects.NewArrayAspectNewArrayAspectProperties;
import org.tetrabox.minijava.xminijava.aspects.ValueAspect;
import org.tetrabox.minijava.xminijava.miniJava.BooleanTypeRef;
import org.tetrabox.minijava.xminijava.miniJava.ClassRef;
import org.tetrabox.minijava.xminijava.miniJava.IntegerTypeRef;
import org.tetrabox.minijava.xminijava.miniJava.NewArray;
import org.tetrabox.minijava.xminijava.miniJava.StringTypeRef;
import org.tetrabox.minijava.xminijava.miniJava.TypeRef;

@Aspect(className = NewArray.class)
@SuppressWarnings("all")
public class NewArrayAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static Value evaluateExpression(final NewArray _self, final State state) {
	final org.tetrabox.minijava.xminijava.aspects.NewArrayAspectNewArrayAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.NewArrayAspectNewArrayAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_evaluateExpression(_self_, _self, state);
	;
	return (org.tetrabox.minijava.xminijava.miniJava.Value) result;
}
  
  private static Value super_evaluateExpression(final NewArray _self, final State state) {
    final org.tetrabox.minijava.xminijava.aspects.ExpressionAspectExpressionAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  org.tetrabox.minijava.xminijava.aspects.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final NewArrayAspectNewArrayAspectProperties _self_, final NewArray _self, final State state) {
    final ArrayInstance result = MiniJavaFactory.eINSTANCE.createArrayInstance();
    Value _evaluateExpression = ExpressionAspect.evaluateExpression(_self.getSize(), state);
    result.setSize(((IntegerValue) _evaluateExpression).getValue());
    state.getArraysHeap().add(result);
    Value _switchResult = null;
    TypeRef _type = _self.getType();
    boolean _matched = false;
    if (_type instanceof IntegerTypeRef) {
      _matched=true;
      IntegerValue _createIntegerValue = MiniJavaFactory.eINSTANCE.createIntegerValue();
      final Procedure1<IntegerValue> _function = (IntegerValue it) -> {
        it.setValue(0);
      };
      _switchResult = ObjectExtensions.<IntegerValue>operator_doubleArrow(_createIntegerValue, _function);
    }
    if (!_matched) {
      if (_type instanceof BooleanTypeRef) {
        _matched=true;
        BooleanValue _createBooleanValue = MiniJavaFactory.eINSTANCE.createBooleanValue();
        final Procedure1<BooleanValue> _function = (BooleanValue it) -> {
          it.setValue(false);
        };
        _switchResult = ObjectExtensions.<BooleanValue>operator_doubleArrow(_createBooleanValue, _function);
      }
    }
    if (!_matched) {
      if (_type instanceof StringTypeRef) {
        _matched=true;
        _switchResult = MiniJavaFactory.eINSTANCE.createNullValue();
      }
    }
    if (!_matched) {
      if (_type instanceof ClassRef) {
        _matched=true;
        _switchResult = MiniJavaFactory.eINSTANCE.createNullValue();
      }
    }
    final Value defaultValue = _switchResult;
    int _size = result.getSize();
    IntegerRange _upTo = new IntegerRange(1, _size);
    for (final Integer i : _upTo) {
      result.getValue().add(ValueAspect.copy(defaultValue));
    }
    ArrayRefValue _createArrayRefValue = MiniJavaFactory.eINSTANCE.createArrayRefValue();
    final Procedure1<ArrayRefValue> _function = (ArrayRefValue it) -> {
      it.setInstance(result);
    };
    return ObjectExtensions.<ArrayRefValue>operator_doubleArrow(_createArrayRefValue, _function);
  }
}
