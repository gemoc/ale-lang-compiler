package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.ArrayInstance;
import miniJava.ArrayRefValue;
import miniJava.BooleanValue;
import miniJava.IntegerValue;
import miniJava.NewArray;
import miniJava.NullValue;
import miniJava.State;
import miniJava.Value;

public class NewArrayOperation extends ExpressionOperation {
	private final NewArray it;

	private final SwitchImplementation emfswitch;

	public NewArrayOperation(NewArray it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public Value evaluateExpression(State state) {
		Value result;
		ArrayInstance res = ((ArrayInstance) miniJava.MiniJavaFactory.eINSTANCE.createArrayInstance());
		IntegerValue sizeArray = ((IntegerValue) /* CASEA */((emfswitch.operation.ExpressionOperation) emfswitch
				.doSwitch(this.it.getSize())).evaluateExpression(state));
		res.setSize(sizeArray.getValue());
		state.getArraysHeap().add(res);
		Value defaultValue = ((Value) null);
		if (this.it.getType() instanceof miniJava.IntegerTypeRef) {
			IntegerValue idv = ((IntegerValue) miniJava.MiniJavaFactory.eINSTANCE.createIntegerValue());
			idv.setValue(0);
			defaultValue = idv;
		} else {
			if (this.it.getType() instanceof miniJava.BooleanTypeRef) {
				BooleanValue idv = ((BooleanValue) miniJava.MiniJavaFactory.eINSTANCE.createBooleanValue());
				idv.setValue(false);
				defaultValue = idv;
			} else {
				if (this.it.getType() instanceof miniJava.StringTypeRef) {
					NullValue idv = ((NullValue) miniJava.MiniJavaFactory.eINSTANCE.createNullValue());
					defaultValue = idv;
				} else {
					if (this.it.getType() instanceof miniJava.ClassRef) {
						NullValue idv = ((NullValue) miniJava.MiniJavaFactory.eINSTANCE.createNullValue());
						defaultValue = idv;
					}
				}
			}
		}
		int i = ((int) 0);
		int sz = ((int) res.getSize());
		while ((i) < (sz)) {
			res.getValue().add(/* CASEF */((ValueOperation) emfswitch.caseValue(defaultValue)).copyj());
			i = (i) + (1);
		}
		ArrayRefValue ret = ((ArrayRefValue) miniJava.MiniJavaFactory.eINSTANCE.createArrayRefValue());
		ret.setInstance(res);
		result = ret;
		return result;
	}
}
