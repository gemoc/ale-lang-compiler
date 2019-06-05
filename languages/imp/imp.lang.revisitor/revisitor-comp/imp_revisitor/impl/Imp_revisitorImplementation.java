package imp_revisitor.impl;

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
import imp.model.revisitor.ImpRevisitor;
import imp_revisitor.impl.operation.AssignOp;
import imp_revisitor.impl.operation.BinaryOp;
import imp_revisitor.impl.operation.BlockOp;
import imp_revisitor.impl.operation.BoolValueOp;
import imp_revisitor.impl.operation.ExprOp;
import imp_revisitor.impl.operation.IfOp;
import imp_revisitor.impl.operation.IntConstOp;
import imp_revisitor.impl.operation.IntValueOp;
import imp_revisitor.impl.operation.SkipOp;
import imp_revisitor.impl.operation.StmtOp;
import imp_revisitor.impl.operation.StoreOp;
import imp_revisitor.impl.operation.UnaryOp;
import imp_revisitor.impl.operation.ValueOp;
import imp_revisitor.impl.operation.VarOp;
import imp_revisitor.impl.operation.WhileOp;
import imp_revisitor.impl.operation.impl.AssignOpImpl;
import imp_revisitor.impl.operation.impl.BinaryOpImpl;
import imp_revisitor.impl.operation.impl.BlockOpImpl;
import imp_revisitor.impl.operation.impl.BoolValueOpImpl;
import imp_revisitor.impl.operation.impl.ExprOpImpl;
import imp_revisitor.impl.operation.impl.IfOpImpl;
import imp_revisitor.impl.operation.impl.IntConstOpImpl;
import imp_revisitor.impl.operation.impl.IntValueOpImpl;
import imp_revisitor.impl.operation.impl.SkipOpImpl;
import imp_revisitor.impl.operation.impl.StmtOpImpl;
import imp_revisitor.impl.operation.impl.StoreOpImpl;
import imp_revisitor.impl.operation.impl.UnaryOpImpl;
import imp_revisitor.impl.operation.impl.ValueOpImpl;
import imp_revisitor.impl.operation.impl.VarOpImpl;
import imp_revisitor.impl.operation.impl.WhileOpImpl;

public interface Imp_revisitorImplementation extends ImpRevisitor<AssignOp, BinaryOp, BlockOp, BoolValueOp, ExprOp, IfOp, IntConstOp, IntValueOp, SkipOp, StmtOp, StoreOp, UnaryOp, ValueOp, VarOp, WhileOp> {
	default StmtOp imp__Stmt(Stmt it) {
		return new StmtOpImpl(it, this);
	}

	default SkipOp imp__Skip(Skip it) {
		return new SkipOpImpl(it, this);
	}

	default AssignOp imp__Assign(Assign it) {
		return new AssignOpImpl(it, this);
	}

	default ExprOp imp__Expr(Expr it) {
		return new ExprOpImpl(it, this);
	}

	default BlockOp imp__Block(Block it) {
		return new BlockOpImpl(it, this);
	}

	default IfOp imp__If(If it) {
		return new IfOpImpl(it, this);
	}

	default WhileOp imp__While(While it) {
		return new WhileOpImpl(it, this);
	}

	default IntConstOp imp__IntConst(IntConst it) {
		return new IntConstOpImpl(it, this);
	}

	default VarOp imp__Var(Var it) {
		return new VarOpImpl(it, this);
	}

	default UnaryOp imp__Unary(Unary it) {
		return new UnaryOpImpl(it, this);
	}

	default BinaryOp imp__Binary(Binary it) {
		return new BinaryOpImpl(it, this);
	}

	default StoreOp imp__Store(Store it) {
		return new StoreOpImpl(it, this);
	}

	default ValueOp imp__Value(Value it) {
		return new ValueOpImpl(it, this);
	}

	default IntValueOp imp__IntValue(IntValue it) {
		return new IntValueOpImpl(it, this);
	}

	default BoolValueOp imp__BoolValue(BoolValue it) {
		return new BoolValueOpImpl(it, this);
	}
}
