package org.tetrabox.minijava.xminijava.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.tetrabox.minijava.xminijava.miniJava.Call;
import org.tetrabox.minijava.xminijava.miniJava.Context;
import org.tetrabox.minijava.xminijava.miniJava.Frame;
import org.tetrabox.minijava.xminijava.miniJava.MiniJavaFactory;
import org.tetrabox.minijava.xminijava.miniJava.ObjectInstance;
import org.tetrabox.minijava.xminijava.miniJava.State;
import org.tetrabox.minijava.xminijava.aspects.FrameAspect;
import org.tetrabox.minijava.xminijava.aspects.StateAspectStateAspectProperties;

@Aspect(className = State.class)
@SuppressWarnings("all")
public class StateAspect {
  public static Frame findCurrentFrame(final State _self) {
	final org.tetrabox.minijava.xminijava.aspects.StateAspectStateAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.StateAspectStateAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_findCurrentFrame(_self_, _self);
	;
	return (org.tetrabox.minijava.xminijava.miniJava.Frame) result;
}
  
  public static Context findCurrentContext(final State _self) {
	final org.tetrabox.minijava.xminijava.aspects.StateAspectStateAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.StateAspectStateAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_findCurrentContext(_self_, _self);
	;
	return (org.tetrabox.minijava.xminijava.miniJava.Context) result;
}
  
  public static void println(final State _self, final String string) {
	final org.tetrabox.minijava.xminijava.aspects.StateAspectStateAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.StateAspectStateAspectContext
			.getSelf(_self);
	_privk3_println(_self_, _self, string);
	;
}
  
  public static void pushNewContext(final State _self) {
	final org.tetrabox.minijava.xminijava.aspects.StateAspectStateAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.StateAspectStateAspectContext
			.getSelf(_self);
	_privk3_pushNewContext(_self_, _self);
	;
}
  
  public static void popCurrentContext(final State _self) {
	final org.tetrabox.minijava.xminijava.aspects.StateAspectStateAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.StateAspectStateAspectContext
			.getSelf(_self);
	_privk3_popCurrentContext(_self_, _self);
	;
}
  
  public static void pushNewFrame(final State _self, final ObjectInstance receiver, final Call c, final Context newContext) {
	final org.tetrabox.minijava.xminijava.aspects.StateAspectStateAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.StateAspectStateAspectContext
			.getSelf(_self);
	_privk3_pushNewFrame(_self_, _self, receiver, c, newContext);
	;
}
  
  public static void popCurrentFrame(final State _self) {
	final org.tetrabox.minijava.xminijava.aspects.StateAspectStateAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.StateAspectStateAspectContext
			.getSelf(_self);
	_privk3_popCurrentFrame(_self_, _self);
	;
}
  
  private static Frame frameCache(final State _self) {
    final org.tetrabox.minijava.xminijava.aspects.StateAspectStateAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.StateAspectStateAspectContext.getSelf(_self);
    Object result = null;
    result = _privk3_frameCache(_self_, _self);;
    return (org.tetrabox.minijava.xminijava.miniJava.Frame)result;
  }
  
  private static void frameCache(final State _self, final Frame frameCache) {
    final org.tetrabox.minijava.xminijava.aspects.StateAspectStateAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.StateAspectStateAspectContext.getSelf(_self);
    _privk3_frameCache(_self_, _self,frameCache);;
  }
  
  private static Context contextCache(final State _self) {
    final org.tetrabox.minijava.xminijava.aspects.StateAspectStateAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.StateAspectStateAspectContext.getSelf(_self);
    Object result = null;
    result = _privk3_contextCache(_self_, _self);;
    return (org.tetrabox.minijava.xminijava.miniJava.Context)result;
  }
  
  private static void contextCache(final State _self, final Context contextCache) {
    final org.tetrabox.minijava.xminijava.aspects.StateAspectStateAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.StateAspectStateAspectContext.getSelf(_self);
    _privk3_contextCache(_self_, _self,contextCache);;
  }
  
  protected static Frame _privk3_findCurrentFrame(final StateAspectStateAspectProperties _self_, final State _self) {
    Frame _frameCache = StateAspect.frameCache(_self);
    boolean _tripleEquals = (_frameCache == null);
    if (_tripleEquals) {
      StateAspect.frameCache(_self, FrameAspect.findCurrentFrame(_self.getRootFrame()));
    }
    return StateAspect.frameCache(_self);
  }
  
  protected static Context _privk3_findCurrentContext(final StateAspectStateAspectProperties _self_, final State _self) {
    Context _contextCache = StateAspect.contextCache(_self);
    boolean _tripleEquals = (_contextCache == null);
    if (_tripleEquals) {
      StateAspect.contextCache(_self, FrameAspect.findCurrentContext(_self.getRootFrame()));
    }
    return StateAspect.contextCache(_self);
  }
  
  protected static void _privk3_println(final StateAspectStateAspectProperties _self_, final State _self, final String string) {
    InputOutput.<String>println(string);
    _self.getOutputStream().getStream().add(string);
  }
  
  protected static void _privk3_pushNewContext(final StateAspectStateAspectProperties _self_, final State _self) {
    final Context newContext = MiniJavaFactory.eINSTANCE.createContext();
    Context _findCurrentContext = StateAspect.findCurrentContext(_self);
    boolean _tripleNotEquals = (_findCurrentContext != null);
    if (_tripleNotEquals) {
      Context _findCurrentContext_1 = StateAspect.findCurrentContext(_self);
      _findCurrentContext_1.setChildContext(newContext);
    } else {
      Frame _findCurrentFrame = StateAspect.findCurrentFrame(_self);
      _findCurrentFrame.setRootContext(newContext);
    }
    StateAspect.contextCache(_self, newContext);
  }
  
  protected static void _privk3_popCurrentContext(final StateAspectStateAspectProperties _self_, final State _self) {
    final Context newCurrent = StateAspect.findCurrentContext(_self).getParentContext();
    Context _findCurrentContext = StateAspect.findCurrentContext(_self);
    _findCurrentContext.setParentContext(null);
    StateAspect.contextCache(_self, newCurrent);
  }
  
  protected static void _privk3_pushNewFrame(final StateAspectStateAspectProperties _self_, final State _self, final ObjectInstance receiver, final Call c, final Context newContext) {
    Frame _createFrame = MiniJavaFactory.eINSTANCE.createFrame();
    final Procedure1<Frame> _function = (Frame it) -> {
      it.setInstance(receiver);
      it.setCall(c);
      it.setRootContext(newContext);
    };
    final Frame newFrame = ObjectExtensions.<Frame>operator_doubleArrow(_createFrame, _function);
    Frame _findCurrentFrame = StateAspect.findCurrentFrame(_self);
    _findCurrentFrame.setChildFrame(newFrame);
    StateAspect.frameCache(_self, newFrame);
    StateAspect.contextCache(_self, null);
  }
  
  protected static void _privk3_popCurrentFrame(final StateAspectStateAspectProperties _self_, final State _self) {
    final Frame newCurrent = StateAspect.findCurrentFrame(_self).getParentFrame();
    Frame _findCurrentFrame = StateAspect.findCurrentFrame(_self);
    _findCurrentFrame.setParentFrame(null);
    StateAspect.contextCache(_self, null);
    StateAspect.frameCache(_self, newCurrent);
  }
  
  protected static Frame _privk3_frameCache(final StateAspectStateAspectProperties _self_, final State _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getFrameCache") &&
    			m.getParameterTypes().length == 0) {
    				Object ret = m.invoke(_self);
    				if (ret != null) {
    					return (org.tetrabox.minijava.xminijava.miniJava.Frame) ret;
    				} else {
    					return null;
    				}
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    return _self_.frameCache;
  }
  
  protected static void _privk3_frameCache(final StateAspectStateAspectProperties _self_, final State _self, final Frame frameCache) {
    boolean setterCalled = false;
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setFrameCache")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, frameCache);
    			setterCalled = true;
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    if (!setterCalled) {
    	_self_.frameCache = frameCache;
    }
  }
  
  protected static Context _privk3_contextCache(final StateAspectStateAspectProperties _self_, final State _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getContextCache") &&
    			m.getParameterTypes().length == 0) {
    				Object ret = m.invoke(_self);
    				if (ret != null) {
    					return (org.tetrabox.minijava.xminijava.miniJava.Context) ret;
    				} else {
    					return null;
    				}
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    return _self_.contextCache;
  }
  
  protected static void _privk3_contextCache(final StateAspectStateAspectProperties _self_, final State _self, final Context contextCache) {
    boolean setterCalled = false;
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setContextCache")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, contextCache);
    			setterCalled = true;
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    if (!setterCalled) {
    	_self_.contextCache = contextCache;
    }
  }
}
