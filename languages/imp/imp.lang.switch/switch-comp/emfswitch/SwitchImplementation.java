package emfswitch;

import emfswitch.operation.AssignOperation;
import emfswitch.operation.BinaryOperation;
import emfswitch.operation.BlockOperation;
import emfswitch.operation.BoolValueOperation;
import emfswitch.operation.ExprOperation;
import emfswitch.operation.IfOperation;
import emfswitch.operation.IntConstOperation;
import emfswitch.operation.IntValueOperation;
import emfswitch.operation.SkipOperation;
import emfswitch.operation.StmtOperation;
import emfswitch.operation.StoreOperation;
import emfswitch.operation.UnaryOperation;
import emfswitch.operation.ValueOperation;
import emfswitch.operation.VarOperation;
import emfswitch.operation.WhileOperation;
import imp.model.imp.Assign;
import imp.model.imp.Binary;
import imp.model.imp.Block;
import imp.model.imp.BoolValue;
import imp.model.imp.Expr;
import imp.model.imp.If;
import imp.model.imp.IntConst;
import imp.model.imp.IntValue;
import imp.model.imp.Skip;
import imp.model.imp.Stmt;
import imp.model.imp.Store;
import imp.model.imp.Unary;
import imp.model.imp.Value;
import imp.model.imp.Var;
import imp.model.imp.While;
import imp.model.imp.util.ImpSwitch;
import java.lang.Object;
import java.lang.Override;

public class SwitchImplementation extends ImpSwitch<Object> {
	@Override
	public Object caseStmt(Stmt it) {
		return new StmtOperation(it, this);
	}

	@Override
	public Object caseSkip(Skip it) {
		return new SkipOperation(it, this);
	}

	@Override
	public Object caseAssign(Assign it) {
		return new AssignOperation(it, this);
	}

	@Override
	public Object caseExpr(Expr it) {
		return new ExprOperation(it, this);
	}

	@Override
	public Object caseBlock(Block it) {
		return new BlockOperation(it, this);
	}

	@Override
	public Object caseIf(If it) {
		return new IfOperation(it, this);
	}

	@Override
	public Object caseWhile(While it) {
		return new WhileOperation(it, this);
	}

	@Override
	public Object caseIntConst(IntConst it) {
		return new IntConstOperation(it, this);
	}

	@Override
	public Object caseVar(Var it) {
		return new VarOperation(it, this);
	}

	@Override
	public Object caseUnary(Unary it) {
		return new UnaryOperation(it, this);
	}

	@Override
	public Object caseBinary(Binary it) {
		return new BinaryOperation(it, this);
	}

	@Override
	public Object caseStore(Store it) {
		return new StoreOperation(it, this);
	}

	@Override
	public Object caseValue(Value it) {
		return new ValueOperation(it, this);
	}

	@Override
	public Object caseIntValue(IntValue it) {
		return new IntValueOperation(it, this);
	}

	@Override
	public Object caseBoolValue(BoolValue it) {
		return new BoolValueOperation(it, this);
	}
}
