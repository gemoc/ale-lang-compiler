package visitor.operation.imp.impl;

import imp.visitor.imp.Binary;
import imp.visitor.imp.BoolValue;
import imp.visitor.imp.ImpFactory;
import imp.visitor.imp.IntValue;
import imp.visitor.imp.Store;
import imp.visitor.imp.Value;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;
import visitor.VisitorInterface;
import visitor.operation.imp.BinaryOperation;
import visitor.operation.imp.ExprOperation;

public class BinaryOperationImpl extends ExprOperationImpl implements BinaryOperation {
	private final Binary it;

	private final VisitorInterface vis;

	public BinaryOperationImpl(Binary it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public Value evaluate(Store s) {
		Value result;
		Value lv = ((Value) (((ExprOperation)this.it.getLhs().accept(vis)).evaluate((Store) (s))));
		Value rv = ((Value) (((ExprOperation)this.it.getRhs().accept(vis)).evaluate((Store) (s))));
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
