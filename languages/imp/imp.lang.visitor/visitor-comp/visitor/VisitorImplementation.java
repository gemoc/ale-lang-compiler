package visitor;

import imp.visitor.imp.Assign;
import imp.visitor.imp.Binary;
import imp.visitor.imp.Block;
import imp.visitor.imp.BoolValue;
import imp.visitor.imp.If;
import imp.visitor.imp.IntConst;
import imp.visitor.imp.IntValue;
import imp.visitor.imp.Skip;
import imp.visitor.imp.Store;
import imp.visitor.imp.StringToValueMap;
import imp.visitor.imp.Unary;
import imp.visitor.imp.Var;
import imp.visitor.imp.While;
import visitor.operation.imp.AssignOperation;
import visitor.operation.imp.BinaryOperation;
import visitor.operation.imp.BlockOperation;
import visitor.operation.imp.BoolValueOperation;
import visitor.operation.imp.IfOperation;
import visitor.operation.imp.IntConstOperation;
import visitor.operation.imp.IntValueOperation;
import visitor.operation.imp.SkipOperation;
import visitor.operation.imp.StoreOperation;
import visitor.operation.imp.StringToValueMapOperation;
import visitor.operation.imp.UnaryOperation;
import visitor.operation.imp.VarOperation;
import visitor.operation.imp.WhileOperation;
import visitor.operation.imp.impl.AssignOperationImpl;
import visitor.operation.imp.impl.BinaryOperationImpl;
import visitor.operation.imp.impl.BlockOperationImpl;
import visitor.operation.imp.impl.BoolValueOperationImpl;
import visitor.operation.imp.impl.IfOperationImpl;
import visitor.operation.imp.impl.IntConstOperationImpl;
import visitor.operation.imp.impl.IntValueOperationImpl;
import visitor.operation.imp.impl.SkipOperationImpl;
import visitor.operation.imp.impl.StoreOperationImpl;
import visitor.operation.imp.impl.StringToValueMapOperationImpl;
import visitor.operation.imp.impl.UnaryOperationImpl;
import visitor.operation.imp.impl.VarOperationImpl;
import visitor.operation.imp.impl.WhileOperationImpl;

public class VisitorImplementation implements VisitorInterface {
	public SkipOperation visitimp__Skip(Skip it) {
		return new SkipOperationImpl(it, this);
	}

	public AssignOperation visitimp__Assign(Assign it) {
		return new AssignOperationImpl(it, this);
	}

	public BlockOperation visitimp__Block(Block it) {
		return new BlockOperationImpl(it, this);
	}

	public IfOperation visitimp__If(If it) {
		return new IfOperationImpl(it, this);
	}

	public WhileOperation visitimp__While(While it) {
		return new WhileOperationImpl(it, this);
	}

	public IntConstOperation visitimp__IntConst(IntConst it) {
		return new IntConstOperationImpl(it, this);
	}

	public VarOperation visitimp__Var(Var it) {
		return new VarOperationImpl(it, this);
	}

	public UnaryOperation visitimp__Unary(Unary it) {
		return new UnaryOperationImpl(it, this);
	}

	public BinaryOperation visitimp__Binary(Binary it) {
		return new BinaryOperationImpl(it, this);
	}

	public StoreOperation visitimp__Store(Store it) {
		return new StoreOperationImpl(it, this);
	}

	public StringToValueMapOperation visitimp__StringToValueMap(StringToValueMap it) {
		return new StringToValueMapOperationImpl(it, this);
	}

	public IntValueOperation visitimp__IntValue(IntValue it) {
		return new IntValueOperationImpl(it, this);
	}

	public BoolValueOperation visitimp__BoolValue(BoolValue it) {
		return new BoolValueOperationImpl(it, this);
	}
}
