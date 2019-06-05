package imp.model.revisitor;

public interface ImpRevisitor<Imp__AssignT extends Imp__StmtT, Imp__BinaryT extends Imp__ExprT, Imp__BlockT extends Imp__StmtT, Imp__BoolValueT extends Imp__ValueT, Imp__ExprT, Imp__IfT extends Imp__StmtT, Imp__IntConstT extends Imp__ExprT, Imp__IntValueT extends Imp__ValueT, Imp__SkipT extends Imp__StmtT, Imp__StmtT, Imp__StoreT, Imp__UnaryT extends Imp__ExprT, Imp__ValueT, Imp__VarT extends Imp__ExprT, Imp__WhileT extends Imp__StmtT> {
	Imp__AssignT imp__Assign(final imp.model.imp.Assign it);
	Imp__BinaryT imp__Binary(final imp.model.imp.Binary it);
	Imp__BlockT imp__Block(final imp.model.imp.Block it);
	Imp__BoolValueT imp__BoolValue(final imp.model.imp.BoolValue it);
	Imp__IfT imp__If(final imp.model.imp.If it);
	Imp__IntConstT imp__IntConst(final imp.model.imp.IntConst it);
	Imp__IntValueT imp__IntValue(final imp.model.imp.IntValue it);
	Imp__SkipT imp__Skip(final imp.model.imp.Skip it);
	Imp__StoreT imp__Store(final imp.model.imp.Store it);
	Imp__UnaryT imp__Unary(final imp.model.imp.Unary it);
	Imp__VarT imp__Var(final imp.model.imp.Var it);
	Imp__WhileT imp__While(final imp.model.imp.While it);

	default Imp__AssignT $(final imp.model.imp.Assign it) {
		return imp__Assign(it);
	}
	default Imp__BinaryT $(final imp.model.imp.Binary it) {
		return imp__Binary(it);
	}
	default Imp__BlockT $(final imp.model.imp.Block it) {
		return imp__Block(it);
	}
	default Imp__BoolValueT $(final imp.model.imp.BoolValue it) {
		return imp__BoolValue(it);
	}
	default Imp__ExprT $(final imp.model.imp.Expr it) {
		if (it.getClass() == imp.model.imp.impl.BinaryImpl.class)
			return imp__Binary((imp.model.imp.Binary) it);
		if (it.getClass() == imp.model.imp.impl.IntConstImpl.class)
			return imp__IntConst((imp.model.imp.IntConst) it);
		if (it.getClass() == imp.model.imp.impl.UnaryImpl.class)
			return imp__Unary((imp.model.imp.Unary) it);
		if (it.getClass() == imp.model.imp.impl.VarImpl.class)
			return imp__Var((imp.model.imp.Var) it);
		return null;
	}
	default Imp__IfT $(final imp.model.imp.If it) {
		return imp__If(it);
	}
	default Imp__IntConstT $(final imp.model.imp.IntConst it) {
		return imp__IntConst(it);
	}
	default Imp__IntValueT $(final imp.model.imp.IntValue it) {
		return imp__IntValue(it);
	}
	default Imp__SkipT $(final imp.model.imp.Skip it) {
		return imp__Skip(it);
	}
	default Imp__StmtT $(final imp.model.imp.Stmt it) {
		if (it.getClass() == imp.model.imp.impl.AssignImpl.class)
			return imp__Assign((imp.model.imp.Assign) it);
		if (it.getClass() == imp.model.imp.impl.BlockImpl.class)
			return imp__Block((imp.model.imp.Block) it);
		if (it.getClass() == imp.model.imp.impl.IfImpl.class)
			return imp__If((imp.model.imp.If) it);
		if (it.getClass() == imp.model.imp.impl.SkipImpl.class)
			return imp__Skip((imp.model.imp.Skip) it);
		if (it.getClass() == imp.model.imp.impl.WhileImpl.class)
			return imp__While((imp.model.imp.While) it);
		return null;
	}
	default Imp__StoreT $(final imp.model.imp.Store it) {
		return imp__Store(it);
	}
	default Imp__UnaryT $(final imp.model.imp.Unary it) {
		return imp__Unary(it);
	}
	default Imp__ValueT $(final imp.model.imp.Value it) {
		if (it.getClass() == imp.model.imp.impl.BoolValueImpl.class)
			return imp__BoolValue((imp.model.imp.BoolValue) it);
		if (it.getClass() == imp.model.imp.impl.IntValueImpl.class)
			return imp__IntValue((imp.model.imp.IntValue) it);
		return null;
	}
	default Imp__VarT $(final imp.model.imp.Var it) {
		return imp__Var(it);
	}
	default Imp__WhileT $(final imp.model.imp.While it) {
		return imp__While(it);
	}
}
