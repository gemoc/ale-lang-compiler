package org.tetrabox.minijava.xminijava.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.tetrabox.minijava.xminijava.miniJava.Context;
import org.tetrabox.minijava.xminijava.miniJava.Frame;
import org.tetrabox.minijava.xminijava.aspects.ContextAspect;
import org.tetrabox.minijava.xminijava.aspects.FrameAspectFrameAspectProperties;

@Aspect(className = Frame.class)
@SuppressWarnings("all")
public class FrameAspect {
  public static Frame findCurrentFrame(final Frame _self) {
	final org.tetrabox.minijava.xminijava.aspects.FrameAspectFrameAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.FrameAspectFrameAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_findCurrentFrame(_self_, _self);
	;
	return (org.tetrabox.minijava.xminijava.miniJava.Frame) result;
}
  
  public static Context findCurrentContext(final Frame _self) {
	final org.tetrabox.minijava.xminijava.aspects.FrameAspectFrameAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.FrameAspectFrameAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_findCurrentContext(_self_, _self);
	;
	return (org.tetrabox.minijava.xminijava.miniJava.Context) result;
}
  
  protected static Frame _privk3_findCurrentFrame(final FrameAspectFrameAspectProperties _self_, final Frame _self) {
    Frame _childFrame = _self.getChildFrame();
    boolean _tripleNotEquals = (_childFrame != null);
    if (_tripleNotEquals) {
      return FrameAspect.findCurrentFrame(_self.getChildFrame());
    } else {
      return _self;
    }
  }
  
  protected static Context _privk3_findCurrentContext(final FrameAspectFrameAspectProperties _self_, final Frame _self) {
    Frame _childFrame = _self.getChildFrame();
    boolean _tripleNotEquals = (_childFrame != null);
    if (_tripleNotEquals) {
      return FrameAspect.findCurrentContext(_self.getChildFrame());
    } else {
      Context _rootContext = _self.getRootContext();
      boolean _tripleNotEquals_1 = (_rootContext != null);
      if (_tripleNotEquals_1) {
        return ContextAspect.findCurrentContext(_self.getRootContext());
      } else {
        return null;
      }
    }
  }
}
