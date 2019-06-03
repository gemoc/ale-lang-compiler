package org.tetrabox.minijava.xminijava.aspects;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.tetrabox.minijava.xminijava.aspects.MethodAspectMethodAspectProperties;
import org.tetrabox.minijava.xminijava.aspects.ParameterAspect;
import org.tetrabox.minijava.xminijava.aspects.TypeRefAspect;
import org.tetrabox.minijava.xminijava.miniJava.Method;
import org.tetrabox.minijava.xminijava.miniJava.Parameter;

@Aspect(className = Method.class)
@SuppressWarnings("all")
public class MethodAspect {
  public static Method findOverride(final Method _self, final org.tetrabox.minijava.xminijava.miniJava.Class c) {
    final org.tetrabox.minijava.xminijava.aspects.MethodAspectMethodAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.MethodAspectMethodAspectContext.getSelf(_self);
    Object result = null;
    result = _privk3_findOverride(_self_, _self,c);;
    return (org.tetrabox.minijava.xminijava.miniJava.Method)result;
  }
  
  private static Map<org.tetrabox.minijava.xminijava.miniJava.Class, Method> cache(final Method _self) {
    final org.tetrabox.minijava.xminijava.aspects.MethodAspectMethodAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.MethodAspectMethodAspectContext.getSelf(_self);
    Object result = null;
    result = _privk3_cache(_self_, _self);;
    return (java.util.Map<org.tetrabox.minijava.xminijava.miniJava.Class, org.tetrabox.minijava.xminijava.miniJava.Method>)result;
  }
  
  private static void cache(final Method _self, final Map<org.tetrabox.minijava.xminijava.miniJava.Class, Method> cache) {
    final org.tetrabox.minijava.xminijava.aspects.MethodAspectMethodAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.MethodAspectMethodAspectContext.getSelf(_self);
    _privk3_cache(_self_, _self,cache);;
  }
  
  protected static Method _privk3_findOverride(final MethodAspectMethodAspectProperties _self_, final Method _self, final org.tetrabox.minijava.xminijava.miniJava.Class c) {
    boolean _containsKey = MethodAspect.cache(_self).containsKey(c);
    boolean _not = (!_containsKey);
    if (_not) {
      Method _xifexpression = null;
      boolean _contains = c.getMembers().contains(_self);
      if (_contains) {
        _xifexpression = _self;
      } else {
        Method _xblockexpression = null;
        {
          final Function1<Method, Boolean> _function = (Method it) -> {
            return Boolean.valueOf((((Objects.equal(it.getName(), _self.getName()) && (it.getParams().size() == _self.getParams().size())) && 
              TypeRefAspect.compare(it.getTypeRef(), _self.getTypeRef())) && IterableExtensions.<Parameter>forall(it.getParams(), ((Function1<Parameter, Boolean>) (Parameter p1) -> {
              final Function1<Parameter, Boolean> _function_1 = (Parameter p2) -> {
                return Boolean.valueOf(ParameterAspect.compare(p1, p2));
              };
              return Boolean.valueOf(IterableExtensions.<Parameter>exists(_self.getParams(), _function_1));
            }))));
          };
          final Method candidate = IterableExtensions.<Method>findFirst(Iterables.<Method>filter(c.getMembers(), Method.class), _function);
          Method _xifexpression_1 = null;
          if ((candidate != null)) {
            _xifexpression_1 = candidate;
          } else {
            Method _xifexpression_2 = null;
            org.tetrabox.minijava.xminijava.miniJava.Class _superClass = c.getSuperClass();
            boolean _tripleNotEquals = (_superClass != null);
            if (_tripleNotEquals) {
              _xifexpression_2 = MethodAspect.findOverride(_self, c.getSuperClass());
            } else {
              _xifexpression_2 = null;
            }
            _xifexpression_1 = _xifexpression_2;
          }
          _xblockexpression = _xifexpression_1;
        }
        _xifexpression = _xblockexpression;
      }
      final Method result = _xifexpression;
      MethodAspect.cache(_self).put(c, result);
    }
    return MethodAspect.cache(_self).get(c);
  }
  
  protected static Map<org.tetrabox.minijava.xminijava.miniJava.Class, Method> _privk3_cache(final MethodAspectMethodAspectProperties _self_, final Method _self) {
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
  
  protected static void _privk3_cache(final MethodAspectMethodAspectProperties _self_, final Method _self, final Map<org.tetrabox.minijava.xminijava.miniJava.Class, Method> cache) {
    boolean setterCalled = false;
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setCache")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, cache);
    			setterCalled = true;
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    if (!setterCalled) {
    	_self_.cache = cache;
    }
  }
}
