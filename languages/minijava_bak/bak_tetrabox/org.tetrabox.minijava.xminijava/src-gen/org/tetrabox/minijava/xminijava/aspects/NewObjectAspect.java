package org.tetrabox.minijava.xminijava.aspects;

import com.google.common.collect.Iterables;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.tetrabox.minijava.xminijava.miniJava.Context;
import org.tetrabox.minijava.xminijava.miniJava.FieldBinding;
import org.tetrabox.minijava.xminijava.miniJava.MiniJavaFactory;
import org.tetrabox.minijava.xminijava.miniJava.NewCall;
import org.tetrabox.minijava.xminijava.miniJava.ObjectInstance;
import org.tetrabox.minijava.xminijava.miniJava.ObjectRefValue;
import org.tetrabox.minijava.xminijava.miniJava.State;
import org.tetrabox.minijava.xminijava.miniJava.SymbolBinding;
import org.tetrabox.minijava.xminijava.miniJava.Value;
import org.tetrabox.minijava.xminijava.aspects.BlockAspect;
import org.tetrabox.minijava.xminijava.aspects.ExpressionAspect;
import org.tetrabox.minijava.xminijava.aspects.NewObjectAspectNewObjectAspectProperties;
import org.tetrabox.minijava.xminijava.aspects.StateAspect;
import org.tetrabox.minijava.xminijava.miniJava.Expression;
import org.tetrabox.minijava.xminijava.miniJava.Field;
import org.tetrabox.minijava.xminijava.miniJava.Method;
import org.tetrabox.minijava.xminijava.miniJava.NewObject;
import org.tetrabox.minijava.xminijava.miniJava.Parameter;

@Aspect(className = NewObject.class)
@SuppressWarnings("all")
public class NewObjectAspect extends ExpressionAspect {
  @OverrideAspectMethod
  public static Value evaluateExpression(final NewObject _self, final State state) {
	final org.tetrabox.minijava.xminijava.aspects.NewObjectAspectNewObjectAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.NewObjectAspectNewObjectAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_evaluateExpression(_self_, _self, state);
	;
	return (org.tetrabox.minijava.xminijava.miniJava.Value) result;
}
  
  private static Value super_evaluateExpression(final NewObject _self, final State state) {
    final org.tetrabox.minijava.xminijava.aspects.ExpressionAspectExpressionAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ExpressionAspectExpressionAspectContext.getSelf(_self);
    return  org.tetrabox.minijava.xminijava.aspects.ExpressionAspect._privk3_evaluateExpression(_self_, _self,state);
  }
  
  protected static Value _privk3_evaluateExpression(final NewObjectAspectNewObjectAspectProperties _self_, final NewObject _self, final State state) {
    ObjectInstance _createObjectInstance = MiniJavaFactory.eINSTANCE.createObjectInstance();
    final Procedure1<ObjectInstance> _function = (ObjectInstance it) -> {
      it.setType(_self.getType());
    };
    final ObjectInstance result = ObjectExtensions.<ObjectInstance>operator_doubleArrow(_createObjectInstance, _function);
    state.getObjectsHeap().add(result);
    Iterable<Field> _filter = Iterables.<Field>filter(result.getType().getMembers(), Field.class);
    for (final Field f : _filter) {
      Expression _defaultValue = f.getDefaultValue();
      boolean _tripleNotEquals = (_defaultValue != null);
      if (_tripleNotEquals) {
        final Value v = ExpressionAspect.evaluateExpression(f.getDefaultValue(), state);
        EList<FieldBinding> _fieldbindings = result.getFieldbindings();
        FieldBinding _createFieldBinding = MiniJavaFactory.eINSTANCE.createFieldBinding();
        final Procedure1<FieldBinding> _function_1 = (FieldBinding it) -> {
          it.setField(f);
          it.setValue(v);
        };
        FieldBinding _doubleArrow = ObjectExtensions.<FieldBinding>operator_doubleArrow(_createFieldBinding, _function_1);
        _fieldbindings.add(_doubleArrow);
      }
    }
    final Function1<Method, Boolean> _function_2 = (Method it) -> {
      return Boolean.valueOf(((it.getName() == null) && (it.getParams().size() == _self.getArgs().size())));
    };
    final Method constructor = IterableExtensions.<Method>findFirst(Iterables.<Method>filter(_self.getType().getMembers(), Method.class), _function_2);
    if ((constructor != null)) {
      final Context newContext = MiniJavaFactory.eINSTANCE.createContext();
      EList<Expression> _args = _self.getArgs();
      for (final Expression arg : _args) {
        {
          final Parameter param = constructor.getParams().get(_self.getArgs().indexOf(arg));
          SymbolBinding _createSymbolBinding = MiniJavaFactory.eINSTANCE.createSymbolBinding();
          final Procedure1<SymbolBinding> _function_3 = (SymbolBinding it) -> {
            it.setSymbol(param);
            it.setValue(ExpressionAspect.evaluateExpression(((Expression) arg), state));
          };
          final SymbolBinding binding = ObjectExtensions.<SymbolBinding>operator_doubleArrow(_createSymbolBinding, _function_3);
          newContext.getBindings().add(binding);
        }
      }
      NewCall _createNewCall = MiniJavaFactory.eINSTANCE.createNewCall();
      final Procedure1<NewCall> _function_3 = (NewCall it) -> {
        it.setNew(_self);
      };
      final NewCall call = ObjectExtensions.<NewCall>operator_doubleArrow(_createNewCall, _function_3);
      StateAspect.pushNewFrame(state, result, call, newContext);
      BlockAspect.evaluateStatement(constructor.getBody(), state);
      StateAspect.popCurrentFrame(state);
    }
    ObjectRefValue _createObjectRefValue = MiniJavaFactory.eINSTANCE.createObjectRefValue();
    final Procedure1<ObjectRefValue> _function_4 = (ObjectRefValue it) -> {
      it.setInstance(result);
    };
    return ObjectExtensions.<ObjectRefValue>operator_doubleArrow(_createObjectRefValue, _function_4);
  }
}
