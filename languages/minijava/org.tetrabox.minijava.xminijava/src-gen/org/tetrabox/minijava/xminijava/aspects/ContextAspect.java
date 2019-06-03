package org.tetrabox.minijava.xminijava.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.tetrabox.minijava.xminijava.miniJava.Context;
import org.tetrabox.minijava.xminijava.miniJava.MiniJavaFactory;
import org.tetrabox.minijava.xminijava.miniJava.SymbolBinding;
import org.tetrabox.minijava.xminijava.aspects.ContextAspectContextAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.Symbol;

@Aspect(className = Context.class)
@SuppressWarnings("all")
public class ContextAspect {
  public static Context createChildContext(final Context _self) {
	final org.tetrabox.minijava.xminijava.aspects.ContextAspectContextAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ContextAspectContextAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_createChildContext(_self_, _self);
	;
	return (org.tetrabox.minijava.xminijava.miniJava.Context) result;
}
  
  public static SymbolBinding findBinding(final Context _self, final Symbol symbol) {
	final org.tetrabox.minijava.xminijava.aspects.ContextAspectContextAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ContextAspectContextAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_findBinding(_self_, _self, symbol);
	;
	return (org.tetrabox.minijava.xminijava.miniJava.SymbolBinding) result;
}
  
  public static Context findCurrentContext(final Context _self) {
	final org.tetrabox.minijava.xminijava.aspects.ContextAspectContextAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ContextAspectContextAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_findCurrentContext(_self_, _self);
	;
	return (org.tetrabox.minijava.xminijava.miniJava.Context) result;
}
  
  private static Map<Symbol, SymbolBinding> cache(final Context _self) {
    final org.tetrabox.minijava.xminijava.aspects.ContextAspectContextAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ContextAspectContextAspectContext.getSelf(_self);
    Object result = null;
    result = _privk3_cache(_self_, _self);;
    return (java.util.Map<org.tetrabox.minijava.xminijava.miniJava.Symbol, org.tetrabox.minijava.xminijava.miniJava.SymbolBinding>)result;
  }
  
  protected static Context _privk3_createChildContext(final ContextAspectContextAspectProperties _self_, final Context _self) {
    Context _createContext = MiniJavaFactory.eINSTANCE.createContext();
    final Procedure1<Context> _function = (Context it) -> {
      it.setParentContext(_self);
    };
    return ObjectExtensions.<Context>operator_doubleArrow(_createContext, _function);
  }
  
  protected static SymbolBinding _privk3_findBinding(final ContextAspectContextAspectProperties _self_, final Context _self, final Symbol symbol) {
    try {
      boolean _containsKey = ContextAspect.cache(_self).containsKey(symbol);
      boolean _not = (!_containsKey);
      if (_not) {
        final Function1<SymbolBinding, Boolean> _function = (SymbolBinding it) -> {
          Symbol _symbol = it.getSymbol();
          return Boolean.valueOf((_symbol == symbol));
        };
        final SymbolBinding binding = IterableExtensions.<SymbolBinding>findFirst(_self.getBindings(), _function);
        if ((binding != null)) {
          ContextAspect.cache(_self).put(symbol, binding);
        } else {
          Context _parentContext = _self.getParentContext();
          boolean _tripleNotEquals = (_parentContext != null);
          if (_tripleNotEquals) {
            final SymbolBinding binding2 = ContextAspect.findBinding(_self.getParentContext(), symbol);
            ContextAspect.cache(_self).put(symbol, binding2);
          } else {
            throw new Exception(("No binding for symbol " + symbol));
          }
        }
      }
      return ContextAspect.cache(_self).get(symbol);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected static Context _privk3_findCurrentContext(final ContextAspectContextAspectProperties _self_, final Context _self) {
    Context _childContext = _self.getChildContext();
    boolean _tripleNotEquals = (_childContext != null);
    if (_tripleNotEquals) {
      return ContextAspect.findCurrentContext(_self.getChildContext());
    } else {
      return _self;
    }
  }
  
  protected static Map<Symbol, SymbolBinding> _privk3_cache(final ContextAspectContextAspectProperties _self_, final Context _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getCache") &&
    			m.getParameterTypes().length == 0) {
    				Object ret = m.invoke(_self);
    				if (ret != null) {
    					return (java.util.Map) ret;
    				} else {
    					return null;
    				}
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    return _self_.cache;
  }
}
