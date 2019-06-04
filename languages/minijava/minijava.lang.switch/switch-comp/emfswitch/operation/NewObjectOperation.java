package emfswitch.operation;

import emfswitch.SwitchImplementation;
import java.lang.Integer;
import miniJava.Context;
import miniJava.Expression;
import miniJava.Field;
import miniJava.FieldBinding;
import miniJava.Member;
import miniJava.Method;
import miniJava.MiniJavaFactory;
import miniJava.NewCall;
import miniJava.NewObject;
import miniJava.ObjectInstance;
import miniJava.ObjectRefValue;
import miniJava.Parameter;
import miniJava.State;
import miniJava.SymbolBinding;
import miniJava.Value;
import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

public class NewObjectOperation extends ExpressionOperation {
	private final NewObject it;

	private final SwitchImplementation emfswitch;

	public NewObjectOperation(NewObject it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public Value evaluateExpression(State state) {
		Value result;
		ObjectInstance res = ((ObjectInstance) (MiniJavaFactory.eINSTANCE.createObjectInstance()));
		res.setType(this.it.getType());
		state.getObjectsHeap().add(res);
		int i = ((int) (0));
		int z = ((int) (CollectionService.size(res.getType().getMembers())));
		while ((i) < (z)) {
			Member m = ((Member) (CollectionService.get(res.getType().getMembers(), i)));
			if(m instanceof Field) {
				Field f = ((Field) (m));
				if(!EqualService.equals((f.getDefaultValue()), (null))) {
					Value v = ((Value) (((ExpressionOperation) emfswitch.doSwitch(f.getDefaultValue())).evaluateExpression((State) (state))));
					FieldBinding fb = ((FieldBinding) (MiniJavaFactory.eINSTANCE.createFieldBinding()));
					fb.setField(f);
					fb.setValue(v);
					res.getFieldbindings().add(fb);
				}
			}
			i = ((Integer) ((i) + (1)));
		}
		i = ((Integer) (0));
		Method constructor = null;
		while ((((i) < (z)) && (EqualService.equals((constructor), (null))))) {
			Member m = ((Member) (CollectionService.get(res.getType().getMembers(), i)));
			if(m instanceof Method) {
				Method mtd = ((Method) (m));
				if(((EqualService.equals((mtd.getName()), (null))) && (EqualService.equals((CollectionService.size(mtd.getParams())), (CollectionService.size(this.it.getArgs())))))) {
					constructor = ((Method) (mtd));
				}
			}
			i = ((Integer) ((i) + (1)));
		}
		if(!EqualService.equals((constructor), (null))) {
			Context newContext = ((Context) (MiniJavaFactory.eINSTANCE.createContext()));
			i = ((Integer) (0));
			z = ((Integer) (CollectionService.size(this.it.getArgs())));
			while ((i) < (z)) {
				Expression arg = ((Expression) (CollectionService.get(this.it.getArgs(), i)));
				Parameter param = ((Parameter) (CollectionService.get(constructor.getParams(), i)));
				SymbolBinding binding = ((SymbolBinding) (MiniJavaFactory.eINSTANCE.createSymbolBinding()));
				binding.setSymbol(param);
				binding.setValue(((ExpressionOperation) emfswitch.doSwitch(arg)).evaluateExpression((State) (state)));
				i = ((Integer) ((i) + (1)));
				newContext.getBindings().add(binding);
			}
			NewCall call = ((NewCall) (MiniJavaFactory.eINSTANCE.createNewCall()));
			call.setNewz(this.it);
			((StateOperation) emfswitch.doSwitch(state)).pushNewFrame((ObjectInstance) (res), (NewCall) (call), (Context) (newContext));
			((BlockOperation) emfswitch.doSwitch(constructor.getBody())).evaluateStatement((State) (state));
			((StateOperation) emfswitch.doSwitch(state)).popCurrentFrame();
		}
		ObjectRefValue tmp = ((ObjectRefValue) (MiniJavaFactory.eINSTANCE.createObjectRefValue()));
		tmp.setInstance(res);
		result = ((ObjectRefValue) (tmp));
		return result;
	}
}
