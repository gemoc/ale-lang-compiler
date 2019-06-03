package org.tetrabox.minijava.xminijava.aspects;

import com.google.common.base.Objects;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.tetrabox.minijava.xminijava.aspects.ParameterAspectParameterAspectProperties;
import org.tetrabox.minijava.xminijava.aspects.TypeRefAspect;
import org.tetrabox.minijava.xminijava.miniJava.Parameter;

@Aspect(className = Parameter.class)
@SuppressWarnings("all")
public class ParameterAspect {
  public static boolean compare(final Parameter _self, final Parameter other) {
	final org.tetrabox.minijava.xminijava.aspects.ParameterAspectParameterAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ParameterAspectParameterAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_compare(_self_, _self, other);
	;
	return (boolean) result;
}
  
  protected static boolean _privk3_compare(final ParameterAspectParameterAspectProperties _self_, final Parameter _self, final Parameter other) {
    return (Objects.equal(_self.getName(), other.getName()) && TypeRefAspect.compare(_self.getTypeRef(), other.getTypeRef()));
  }
}
