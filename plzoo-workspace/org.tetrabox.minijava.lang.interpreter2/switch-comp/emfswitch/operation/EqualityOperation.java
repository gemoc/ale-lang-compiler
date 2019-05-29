package emfswitch.operation;

import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

import emfswitch.SwitchImplementation;
import miniJava.BooleanValue;
import miniJava.Equality;
import miniJava.IntegerValue;
import miniJava.MiniJavaFactory;
import miniJava.NullValue;
import miniJava.ObjectRefValue;
import miniJava.State;
import miniJava.StringValue;
import miniJava.Value;

public class EqualityOperation extends ExpressionOperation {
	private final Equality it;

	private final SwitchImplementation emfswitch;

	public EqualityOperation(Equality it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public Value evaluateExpression(State state) {
		Value result;
		Value left = ((Value) (((ExpressionOperation) emfswitch.doSwitch(this.it.getLeft())).evaluateExpression((State) (state))));
		Value right = ((Value) (((ExpressionOperation) emfswitch.doSwitch(this.it.getRight())).evaluateExpression((State) (state))));
		boolean tmp = ((boolean) (false));
		if(left instanceof IntegerValue) {
			if(right instanceof IntegerValue) {
				IntegerValue ileft = ((IntegerValue) (left));
				IntegerValue iright = ((IntegerValue) (right));
				tmp = EqualService.equals((ileft.getValue()), (iright.getValue()));
			}
		}
		else {
			if(left instanceof StringValue) {
				if(right instanceof StringValue) {
					StringValue ileft = ((StringValue) (left));
					StringValue iright = ((StringValue) (right));
					tmp = EqualService.equals((ileft.getValue()), (iright.getValue()));
				}
			}
			else {
				if(left instanceof BooleanValue) {
					if(right instanceof BooleanValue) {
						BooleanValue ileft = ((BooleanValue) (left));
						BooleanValue iright = ((BooleanValue) (right));
						tmp = EqualService.equals((ileft.isValue()), (iright.isValue()));
					}
				}
				else {
					if(left instanceof NullValue) {
						if(right instanceof NullValue) {
							tmp = true;
						}
					}
					else {
						if(left instanceof ObjectRefValue) {
							if(right instanceof ObjectRefValue) {
								ObjectRefValue ileft = ((ObjectRefValue) (left));
								ObjectRefValue iright = ((ObjectRefValue) (right));
								tmp = EqualService.equals((ileft.getInstance()), (iright.getInstance()));
							}
						}
					}
				}
			}
		}
		BooleanValue tmpo = ((BooleanValue) (MiniJavaFactory.eINSTANCE.createBooleanValue()));
		tmpo.setValue(tmp);
		result = tmpo;
		return result;
	}
}
