package emfswitch.operation;

import emfswitch.SwitchImplementation;
import imp.model.imp.Binary;
import imp.model.imp.BoolValue;
import imp.model.imp.ImpFactory;
import imp.model.imp.IntValue;
import imp.model.imp.Store;
import imp.model.imp.Value;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

public class BinaryOperation extends ExprOperation {
	private final Binary it;

	private final SwitchImplementation emfswitch;

	public BinaryOperation(Binary it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public Value evaluate(Store s) {
		Value result;
		Value lv = ((Value) (((ExprOperation) emfswitch.doSwitch(this.it.getLhs())).evaluate((Store) (s))));
		Value rv = ((Value) (((ExprOperation) emfswitch.doSwitch(this.it.getRhs())).evaluate((Store) (s))));
		if(EqualService.equals((this.it.getOp().getValue()), (4))) {
			IntValue ilv = ((IntValue) (((IntValue) (lv))));
			IntValue irv = ((IntValue) (((IntValue) (rv))));
			BoolValue res = ((BoolValue) (ImpFactory.eINSTANCE.createBoolValue()));
			res.setValue((ilv.getValue()) <= (irv.getValue()));
			result = ((BoolValue) (res));
		}
		else {
			result = ((Value) (null));
		}
		return result;
	}
}
