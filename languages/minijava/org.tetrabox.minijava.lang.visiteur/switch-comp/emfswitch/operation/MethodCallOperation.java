package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.Context;
import miniJava.Expression;
import miniJava.Method;
import miniJava.MethodCall;
import miniJava.MethodCall2;
import miniJava.ObjectInstance;
import miniJava.ObjectRefValue;
import miniJava.Parameter;
import miniJava.State;
import miniJava.SymbolBinding;
import miniJava.Value;

public class MethodCallOperation extends ExpressionOperation {
	private final MethodCall it;

	private final SwitchImplementation emfswitch;

	public MethodCallOperation(MethodCall it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public Value evaluateExpression(State state) {
		Value result;
		ObjectRefValue realReceiver0 = ((ObjectRefValue) /* CASEA */((emfswitch.operation.ExpressionOperation) emfswitch
				.doSwitch(this.it.getReceiver())).evaluateExpression(state));
		ObjectInstance realReceiver = ((ObjectInstance) realReceiver0.getInstance());
		Method realMethod = ((Method) /* CASEF *//* CASEC */((MethodOperation) emfswitch
				.doSwitch(this.it.getMethod())).findOverride(realReceiver.getType()));
		Context newContext = ((Context) miniJava.MiniJavaFactory.eINSTANCE.createContext());
		int argsLength = ((int) org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(this.it.getArgs()));
		int i = ((int) 0);
		while ((i) < (argsLength)) {
			Expression arg = ((Expression) org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService
					.get(this.it.getArgs(), i));
			Parameter param = ((Parameter) org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService
					.get(realMethod.getParams(), i));
			SymbolBinding binding = ((SymbolBinding) miniJava.MiniJavaFactory.eINSTANCE.createSymbolBinding());
			binding.setSymbol(param);
			binding.setValue(/* CASEA */((emfswitch.operation.ExpressionOperation) emfswitch.doSwitch(arg))
					.evaluateExpression(state));
			newContext.getBindings().add(binding);
			i = (i) + (1);
		}
		MethodCall2 call = ((MethodCall2) miniJava.MiniJavaFactory.eINSTANCE.createMethodCall2());
		call.setMethodcall(this.it);
		/* CASEA */((emfswitch.operation.StateOperation) emfswitch.doSwitch(state)).pushNewFrame(realReceiver, call,
				newContext);
		/* CASEA */((emfswitch.operation.MethodCallOperation) emfswitch.doSwitch(this.it)).call(realMethod, state);
		Value returnValue = ((Value) /* CASEA */((emfswitch.operation.StateOperation) emfswitch.doSwitch(state))
				.findCurrentFrame().getReturnValue());
		/* CASEA */((emfswitch.operation.StateOperation) emfswitch.doSwitch(state)).popCurrentFrame();
		result = returnValue;
		return result;
	}

	public void call(Method realMethod, State state) {
		/* CASEA */((emfswitch.operation.MethodOperation) emfswitch.doSwitch(realMethod)).call(state);
	}
}
