package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.Context;
import miniJava.Expression;
import miniJava.Field;
import miniJava.FieldBinding;
import miniJava.Member;
import miniJava.Method;
import miniJava.NewCall;
import miniJava.NewObject;
import miniJava.ObjectInstance;
import miniJava.ObjectRefValue;
import miniJava.Parameter;
import miniJava.State;
import miniJava.SymbolBinding;
import miniJava.Value;

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
		ObjectInstance res = ((ObjectInstance) miniJava.MiniJavaFactory.eINSTANCE.createObjectInstance());
		res.setType(this.it.getType());
		state.getObjectsHeap().add(res);
		int i = ((int) 0);
		int z = ((int) org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(res.getType().getMembers()));
		while ((i) < (z)) {
			Member m = ((Member) org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService
					.get(res.getType().getMembers(), i));
			if (m instanceof miniJava.Field) {
				Field f = ((Field) m);
				if ((f.getDefaultValue()) != (null)) {
					Value v = ((Value) /* CASEA */((emfswitch.operation.ExpressionOperation) emfswitch
							.doSwitch(f.getDefaultValue())).evaluateExpression(state));
					FieldBinding fb = ((FieldBinding) miniJava.MiniJavaFactory.eINSTANCE.createFieldBinding());
					fb.setField(f);
					fb.setValue(v);
					res.getFieldbindings().add(fb);
				}
			}
			i = (i) + (1);
		}
		i = 0;
		Method constructor = ((Method) null);
		while ((((i) < (z)) && (java.util.Objects.equals((constructor), (null))))) {
			Member m = ((Member) org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService
					.get(res.getType().getMembers(), i));
			if (m instanceof miniJava.Method) {
				Method mtd = ((Method) m);
				if (((java.util.Objects.equals((mtd.getName()), (null))) && (java.util.Objects.equals(
						(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(mtd.getParams())),
						(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(this.it.getArgs())))))) {
					constructor = mtd;
				}
			}
			i = (i) + (1);
		}
		if ((constructor) != (null)) {
			Context newContext = ((Context) miniJava.MiniJavaFactory.eINSTANCE.createContext());
			i = 0;
			z = org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(this.it.getArgs());
			while ((i) < (z)) {
				Expression arg = ((Expression) org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService
						.get(this.it.getArgs(), i));
				Parameter param = ((Parameter) org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService
						.get(constructor.getParams(), i));
				SymbolBinding binding = ((SymbolBinding) miniJava.MiniJavaFactory.eINSTANCE.createSymbolBinding());
				binding.setSymbol(param);
				binding.setValue(/* CASEA */((emfswitch.operation.ExpressionOperation) emfswitch.doSwitch(arg))
						.evaluateExpression(state));
				i = (i) + (1);
				newContext.getBindings().add(binding);
			}
			NewCall call = ((NewCall) miniJava.MiniJavaFactory.eINSTANCE.createNewCall());
			call.setNewz(this.it);
			/* CASEA */((emfswitch.operation.StateOperation) emfswitch.doSwitch(state)).pushNewFrame(res, call,
					newContext);
			/* CASEF */((BlockOperation) emfswitch.caseBlock(constructor.getBody())).evaluateStatement(state);
			/* CASEA */((emfswitch.operation.StateOperation) emfswitch.doSwitch(state)).popCurrentFrame();
		}
		ObjectRefValue tmp = ((ObjectRefValue) miniJava.MiniJavaFactory.eINSTANCE.createObjectRefValue());
		tmp.setInstance(res);
		result = tmp;
		return result;
	}
}
