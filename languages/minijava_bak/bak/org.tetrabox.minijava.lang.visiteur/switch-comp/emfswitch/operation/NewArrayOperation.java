package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.ArrayInstance;
import miniJava.ArrayRefValue;
import miniJava.BooleanTypeRef;
import miniJava.BooleanValue;
import miniJava.ClassRef;
import miniJava.IntegerTypeRef;
import miniJava.IntegerValue;
import miniJava.MiniJavaFactory;
import miniJava.NewArray;
import miniJava.NullValue;
import miniJava.State;
import miniJava.StringTypeRef;
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
		ArrayInstance res = ((ArrayInstance) (MiniJavaFactory.eINSTANCE.createArrayInstance()));
		IntegerValue sizeArray = ((IntegerValue) (((IntegerValue) (((ExpressionOperation) emfswitch.doSwitch(this.it.getSize())).evaluateExpression((State) (state))))));
		res.setSize(sizeArray.getValue());
		state.getArraysHeap().add(res);
		Value defaultValue = ((Value) (MiniJavaFactory.eINSTANCE.createValue()));
		if(this.it.getType() instanceof IntegerTypeRef) {
			IntegerValue idv = ((IntegerValue) (MiniJavaFactory.eINSTANCE.createIntegerValue()));
			idv.setValue(0);
			defaultValue = idv;
		}
		else {
			if(this.it.getType() instanceof BooleanTypeRef) {
				BooleanValue idv = ((BooleanValue) (MiniJavaFactory.eINSTANCE.createBooleanValue()));
				idv.setValue(false);
				defaultValue = idv;
			}
			else {
				if(this.it.getType() instanceof StringTypeRef) {
					NullValue idv = ((NullValue) (MiniJavaFactory.eINSTANCE.createNullValue()));
					defaultValue = idv;
				}
				else {
					if(this.it.getType() instanceof ClassRef) {
						NullValue idv = ((NullValue) (MiniJavaFactory.eINSTANCE.createNullValue()));
						defaultValue = idv;
					}
				}
			}
		}
		int i = ((int) (0));
		int sz = ((int) (res.getSize()));
		while ((i) < (sz)) {
			res.getValue().add(((ValueOperation) emfswitch.doSwitch(defaultValue)).copyj());
			i = (i) + (1);
		}
		ArrayRefValue ret = ((ArrayRefValue) (MiniJavaFactory.eINSTANCE.createArrayRefValue()));
		ret.setInstance(res);
		result = ret;
		return result;
	}
}
