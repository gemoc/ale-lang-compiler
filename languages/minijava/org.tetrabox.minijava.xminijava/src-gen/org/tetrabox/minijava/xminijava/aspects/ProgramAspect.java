package org.tetrabox.minijava.xminijava.aspects;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.InitializeModel;
import fr.inria.diverse.k3.al.annotationprocessor.Main;
import fr.inria.diverse.k3.al.annotationprocessor.Step;
import fr.inria.diverse.melange.annotation.Containment;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.tetrabox.minijava.xminijava.miniJava.ArrayInstance;
import org.tetrabox.minijava.xminijava.miniJava.ArrayRefValue;
import org.tetrabox.minijava.xminijava.miniJava.Context;
import org.tetrabox.minijava.xminijava.miniJava.Frame;
import org.tetrabox.minijava.xminijava.miniJava.MiniJavaFactory;
import org.tetrabox.minijava.xminijava.miniJava.State;
import org.tetrabox.minijava.xminijava.miniJava.StringValue;
import org.tetrabox.minijava.xminijava.miniJava.SymbolBinding;
import org.tetrabox.minijava.xminijava.aspects.BlockAspect;
import org.tetrabox.minijava.xminijava.aspects.ProgramAspectProgramAspectProperties;
import org.tetrabox.minijava.xminijava.miniJava.ArrayTypeRef;
import org.tetrabox.minijava.xminijava.miniJava.Member;
import org.tetrabox.minijava.xminijava.miniJava.Method;
import org.tetrabox.minijava.xminijava.miniJava.Parameter;
import org.tetrabox.minijava.xminijava.miniJava.Program;
import org.tetrabox.minijava.xminijava.miniJava.StringTypeRef;
import org.tetrabox.minijava.xminijava.miniJava.TypeDeclaration;

@Aspect(className = Program.class)
@SuppressWarnings("all")
public class ProgramAspect {
  @Main
  @Step
  public static void main(final Program _self) {
	final org.tetrabox.minijava.xminijava.aspects.ProgramAspectProgramAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ProgramAspectProgramAspectContext
			.getSelf(_self);
	fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand command = new fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand() {
		@Override
		public void execute() {
			_privk3_main(_self_, _self);
		}
	};
	fr.inria.diverse.k3.al.annotationprocessor.stepmanager.IStepManager manager = fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepManagerRegistry
			.getInstance().findStepManager(_self);
	if (manager != null) {
		manager.executeStep(_self, command, "Program", "main");
	} else {
		command.execute();
	}
	;
	;
}
  
  @InitializeModel
  public static void initialize(final Program _self, final List<String> args) {
    final org.tetrabox.minijava.xminijava.aspects.ProgramAspectProgramAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ProgramAspectProgramAspectContext.getSelf(_self);
    _privk3_initialize(_self_, _self,args);;
  }
  
  public static State execute(final Program _self) {
	final org.tetrabox.minijava.xminijava.aspects.ProgramAspectProgramAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ProgramAspectProgramAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_execute(_self_, _self);
	;
	return (org.tetrabox.minijava.xminijava.miniJava.State) result;
}
  
  @Containment
  public static State state(final Program _self) {
	final org.tetrabox.minijava.xminijava.aspects.ProgramAspectProgramAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ProgramAspectProgramAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_state(_self_, _self);
	;
	return (org.tetrabox.minijava.xminijava.miniJava.State) result;
}
  
  @Containment
  public static void state(final Program _self, final State state) {
	final org.tetrabox.minijava.xminijava.aspects.ProgramAspectProgramAspectProperties _self_ = org.tetrabox.minijava.xminijava.aspects.ProgramAspectProgramAspectContext
			.getSelf(_self);
	_privk3_state(_self_, _self, state);
	;
}
  
  protected static void _privk3_main(final ProgramAspectProgramAspectProperties _self_, final Program _self) {
    ProgramAspect.execute(_self);
  }
  
  protected static void _privk3_initialize(final ProgramAspectProgramAspectProperties _self_, final Program _self, final List<String> args) {
    final Function1<TypeDeclaration, EList<Member>> _function = (TypeDeclaration it) -> {
      return it.getMembers();
    };
    final Function1<Method, Boolean> _function_1 = (Method it) -> {
      return Boolean.valueOf(((((Objects.equal(it.getName(), "main") && it.isStatic()) && (it.getParams().size() == 1)) && (IterableExtensions.<Parameter>head(it.getParams()).getTypeRef() instanceof ArrayTypeRef)) && 
        (((ArrayTypeRef) IterableExtensions.<Parameter>head(it.getParams()).getTypeRef()).getTypeRef() instanceof StringTypeRef)));
    };
    final Method main = IterableExtensions.<Method>findFirst(Iterables.<Method>filter(Iterables.<Member>concat(ListExtensions.<TypeDeclaration, EList<Member>>map(_self.getClasses(), _function)), Method.class), _function_1);
    if ((main != null)) {
      final ArrayInstance argsArray = MiniJavaFactory.eINSTANCE.createArrayInstance();
      argsArray.setSize(args.size());
      for (final String arg : args) {
        {
          StringValue _createStringValue = MiniJavaFactory.eINSTANCE.createStringValue();
          final Procedure1<StringValue> _function_2 = (StringValue it) -> {
            it.setValue(arg);
          };
          final StringValue stringVal = ObjectExtensions.<StringValue>operator_doubleArrow(_createStringValue, _function_2);
          argsArray.getValue().add(stringVal);
        }
      }
      SymbolBinding _createSymbolBinding = MiniJavaFactory.eINSTANCE.createSymbolBinding();
      final Procedure1<SymbolBinding> _function_2 = (SymbolBinding it) -> {
        it.setSymbol(IterableExtensions.<Parameter>head(main.getParams()));
        ArrayRefValue _createArrayRefValue = MiniJavaFactory.eINSTANCE.createArrayRefValue();
        final Procedure1<ArrayRefValue> _function_3 = (ArrayRefValue it_1) -> {
          it_1.setInstance(argsArray);
        };
        ArrayRefValue _doubleArrow = ObjectExtensions.<ArrayRefValue>operator_doubleArrow(_createArrayRefValue, _function_3);
        it.setValue(_doubleArrow);
      };
      final SymbolBinding argsBinding = ObjectExtensions.<SymbolBinding>operator_doubleArrow(_createSymbolBinding, _function_2);
      final Context rootCont = MiniJavaFactory.eINSTANCE.createContext();
      rootCont.getBindings().add(argsBinding);
      State _createState = MiniJavaFactory.eINSTANCE.createState();
      final Procedure1<State> _function_3 = (State it) -> {
        it.setOutputStream(MiniJavaFactory.eINSTANCE.createOutputStream());
        Frame _createFrame = MiniJavaFactory.eINSTANCE.createFrame();
        final Procedure1<Frame> _function_4 = (Frame it_1) -> {
          it_1.setRootContext(rootCont);
        };
        Frame _doubleArrow = ObjectExtensions.<Frame>operator_doubleArrow(_createFrame, _function_4);
        it.setRootFrame(_doubleArrow);
      };
      final State state = ObjectExtensions.<State>operator_doubleArrow(_createState, _function_3);
      state.getArraysHeap().add(argsArray);
      ProgramAspect.state(_self, state);
    } else {
      throw new RuntimeException("No main method found.");
    }
  }
  
  protected static State _privk3_execute(final ProgramAspectProgramAspectProperties _self_, final Program _self) {
    final Function1<TypeDeclaration, EList<Member>> _function = (TypeDeclaration it) -> {
      return it.getMembers();
    };
    final Function1<Method, Boolean> _function_1 = (Method it) -> {
      return Boolean.valueOf(((((Objects.equal(it.getName(), "main") && it.isStatic()) && (it.getParams().size() == 1)) && (IterableExtensions.<Parameter>head(it.getParams()).getTypeRef() instanceof ArrayTypeRef)) && 
        (((ArrayTypeRef) IterableExtensions.<Parameter>head(it.getParams()).getTypeRef()).getTypeRef() instanceof StringTypeRef)));
    };
    final Method main = IterableExtensions.<Method>findFirst(Iterables.<Method>filter(Iterables.<Member>concat(ListExtensions.<TypeDeclaration, EList<Member>>map(_self.getClasses(), _function)), Method.class), _function_1);
    BlockAspect.evaluateStatementKeepContext(main.getBody(), ProgramAspect.state(_self));
    return ProgramAspect.state(_self);
  }
  
  protected static State _privk3_state(final ProgramAspectProgramAspectProperties _self_, final Program _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getState") &&
    			m.getParameterTypes().length == 0) {
    				Object ret = m.invoke(_self);
    				if (ret != null) {
    					return (org.tetrabox.minijava.xminijava.miniJava.State) ret;
    				} else {
    					return null;
    				}
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    return _self_.state;
  }
  
  protected static void _privk3_state(final ProgramAspectProgramAspectProperties _self_, final Program _self, final State state) {
    boolean setterCalled = false;
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setState")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, state);
    			setterCalled = true;
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    if (!setterCalled) {
    	_self_.state = state;
    }
  }
}
