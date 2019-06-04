package emfswitch.operation;

import emfswitch.SwitchImplementation;
import java.lang.Integer;
import miniJava.Clazz;
import miniJava.Context;
import miniJava.Expression;
import miniJava.Method;
import miniJava.MethodCall;
import miniJava.MethodCall2;
import miniJava.MiniJavaFactory;
import miniJava.ObjectInstance;
import miniJava.ObjectRefValue;
import miniJava.Parameter;
import miniJava.State;
import miniJava.SymbolBinding;
import miniJava.Value;
import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;

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
		ObjectRefValue realReceiver0 = ((ObjectRefValue) (((ObjectRefValue) (((ExpressionOperation) emfswitch.doSwitch(this.it.getReceiver())).evaluateExpression((State) (state))))));
		ObjectInstance realReceiver = ((ObjectInstance) (realReceiver0.getInstance()));
		Method realMethod = ((Method) (((Method) (((MethodOperation) emfswitch.doSwitch(this.it.getMethod())).findOverride((Clazz) (realReceiver.getType()))))));
		Context newContext = ((Context) (MiniJavaFactory.eINSTANCE.createContext()));
		int argsLength = ((int) (CollectionService.size(this.it.getArgs())));
		int i = ((int) (0));
		while ((i) < (argsLength)) {
			Expression arg = ((Expression) (CollectionService.get(this.it.getArgs(), i)));
			Parameter param = ((Parameter) (CollectionService.get(realMethod.getParams(), i)));
			SymbolBinding binding = ((SymbolBinding) (MiniJavaFactory.eINSTANCE.createSymbolBinding()));
			binding.setSymbol(param);
			binding.setValue(((ExpressionOperation) emfswitch.doSwitch(arg)).evaluateExpression((State) (state)));
			newContext.getBindings().add(binding);
			i = ((Integer) ((i) + (1)));
		}
		MethodCall2 call = ((MethodCall2) (MiniJavaFactory.eINSTANCE.createMethodCall2()));
		call.setMethodcall(this.it);
		((StateOperation) emfswitch.doSwitch(state)).pushNewFrame((ObjectInstance) (realReceiver), (MethodCall2) (call), (Context) (newContext));
		((MethodCallOperation) emfswitch.doSwitch(this.it)).call((Method) (realMethod), (State) (state));
		Value returnValue = ((Value) (((StateOperation) emfswitch.doSwitch(state)).findCurrentFrame().getReturnValue()));
		((StateOperation) emfswitch.doSwitch(state)).popCurrentFrame();
		result = ((Value) (returnValue));
		return result;
	}

	public void call(Method realMethod, State state) {
		((MethodOperation) emfswitch.doSwitch(realMethod)).call((State) (state));
	}
}
