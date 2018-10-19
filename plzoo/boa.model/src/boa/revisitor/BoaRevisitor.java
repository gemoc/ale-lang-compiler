package boa.revisitor;

public interface BoaRevisitor<Boa__AppT extends Boa__ExprT, Boa__ArithOpT extends Boa__ExprT, Boa__ArithOpDivideT extends Boa__ArithOpT, Boa__ArithOpMinusT extends Boa__ArithOpT, Boa__ArithOpPlusT extends Boa__ArithOpT, Boa__ArithOpRemainderT extends Boa__ArithOpT, Boa__ArithOpTimesT extends Boa__ArithOpT, Boa__AssignT extends Boa__ExprT, Boa__BObjectT extends Boa__ExprT, Boa__BoolT extends Boa__ExprT, Boa__BoolOpT extends Boa__ExprT, Boa__BoolOpAndT extends Boa__BoolOpT, Boa__BoolOpOrT extends Boa__BoolOpT, Boa__CmpOpT extends Boa__ExprT, Boa__CmpOpEqualT extends Boa__CmpOpT, Boa__CmpOpLessT extends Boa__CmpOpT, Boa__CmpOpUnequalT extends Boa__CmpOpT, Boa__CopyT extends Boa__ExprT, Boa__DefT extends Boa__TopLevelCmdT, Boa__ExprT extends Boa__TopLevelCmdT, Boa__FieldT, Boa__FileT, Boa__FunT extends Boa__ExprT, Boa__IfT extends Boa__ExprT, Boa__IntT extends Boa__ExprT, Boa__LetT extends Boa__ExprT, Boa__NotT extends Boa__ExprT, Boa__ProjectT extends Boa__ExprT, Boa__SeqT extends Boa__ExprT, Boa__SkipT extends Boa__ExprT, Boa__ThisT extends Boa__ExprT, Boa__TopLevelCmdT, Boa__VarT extends Boa__ExprT, Boa__WithT extends Boa__ExprT> {
	Boa__AppT boa__App(final boa.App it);
	Boa__ArithOpDivideT boa__ArithOpDivide(final boa.ArithOpDivide it);
	Boa__ArithOpMinusT boa__ArithOpMinus(final boa.ArithOpMinus it);
	Boa__ArithOpPlusT boa__ArithOpPlus(final boa.ArithOpPlus it);
	Boa__ArithOpRemainderT boa__ArithOpRemainder(final boa.ArithOpRemainder it);
	Boa__ArithOpTimesT boa__ArithOpTimes(final boa.ArithOpTimes it);
	Boa__AssignT boa__Assign(final boa.Assign it);
	Boa__BObjectT boa__BObject(final boa.BObject it);
	Boa__BoolT boa__Bool(final boa.Bool it);
	Boa__BoolOpAndT boa__BoolOpAnd(final boa.BoolOpAnd it);
	Boa__BoolOpOrT boa__BoolOpOr(final boa.BoolOpOr it);
	Boa__CmpOpEqualT boa__CmpOpEqual(final boa.CmpOpEqual it);
	Boa__CmpOpLessT boa__CmpOpLess(final boa.CmpOpLess it);
	Boa__CmpOpUnequalT boa__CmpOpUnequal(final boa.CmpOpUnequal it);
	Boa__CopyT boa__Copy(final boa.Copy it);
	Boa__DefT boa__Def(final boa.Def it);
	Boa__FieldT boa__Field(final boa.Field it);
	Boa__FileT boa__File(final boa.File it);
	Boa__FunT boa__Fun(final boa.Fun it);
	Boa__IfT boa__If(final boa.If it);
	Boa__IntT boa__Int(final boa.Int it);
	Boa__LetT boa__Let(final boa.Let it);
	Boa__NotT boa__Not(final boa.Not it);
	Boa__ProjectT boa__Project(final boa.Project it);
	Boa__SeqT boa__Seq(final boa.Seq it);
	Boa__SkipT boa__Skip(final boa.Skip it);
	Boa__ThisT boa__This(final boa.This it);
	Boa__VarT boa__Var(final boa.Var it);
	Boa__WithT boa__With(final boa.With it);

	default Boa__AppT $(final boa.App it) {
		return boa__App(it);
	}
	default Boa__ArithOpT $(final boa.ArithOp it) {
		if (it.getClass() == boa.impl.ArithOpDivideImpl.class)
			return boa__ArithOpDivide((boa.ArithOpDivide) it);
		if (it.getClass() == boa.impl.ArithOpMinusImpl.class)
			return boa__ArithOpMinus((boa.ArithOpMinus) it);
		if (it.getClass() == boa.impl.ArithOpPlusImpl.class)
			return boa__ArithOpPlus((boa.ArithOpPlus) it);
		if (it.getClass() == boa.impl.ArithOpRemainderImpl.class)
			return boa__ArithOpRemainder((boa.ArithOpRemainder) it);
		if (it.getClass() == boa.impl.ArithOpTimesImpl.class)
			return boa__ArithOpTimes((boa.ArithOpTimes) it);
		return null;
	}
	default Boa__ArithOpDivideT $(final boa.ArithOpDivide it) {
		return boa__ArithOpDivide(it);
	}
	default Boa__ArithOpMinusT $(final boa.ArithOpMinus it) {
		return boa__ArithOpMinus(it);
	}
	default Boa__ArithOpPlusT $(final boa.ArithOpPlus it) {
		return boa__ArithOpPlus(it);
	}
	default Boa__ArithOpRemainderT $(final boa.ArithOpRemainder it) {
		return boa__ArithOpRemainder(it);
	}
	default Boa__ArithOpTimesT $(final boa.ArithOpTimes it) {
		return boa__ArithOpTimes(it);
	}
	default Boa__AssignT $(final boa.Assign it) {
		return boa__Assign(it);
	}
	default Boa__BObjectT $(final boa.BObject it) {
		return boa__BObject(it);
	}
	default Boa__BoolT $(final boa.Bool it) {
		return boa__Bool(it);
	}
	default Boa__BoolOpT $(final boa.BoolOp it) {
		if (it.getClass() == boa.impl.BoolOpAndImpl.class)
			return boa__BoolOpAnd((boa.BoolOpAnd) it);
		if (it.getClass() == boa.impl.BoolOpOrImpl.class)
			return boa__BoolOpOr((boa.BoolOpOr) it);
		return null;
	}
	default Boa__BoolOpAndT $(final boa.BoolOpAnd it) {
		return boa__BoolOpAnd(it);
	}
	default Boa__BoolOpOrT $(final boa.BoolOpOr it) {
		return boa__BoolOpOr(it);
	}
	default Boa__CmpOpT $(final boa.CmpOp it) {
		if (it.getClass() == boa.impl.CmpOpEqualImpl.class)
			return boa__CmpOpEqual((boa.CmpOpEqual) it);
		if (it.getClass() == boa.impl.CmpOpLessImpl.class)
			return boa__CmpOpLess((boa.CmpOpLess) it);
		if (it.getClass() == boa.impl.CmpOpUnequalImpl.class)
			return boa__CmpOpUnequal((boa.CmpOpUnequal) it);
		return null;
	}
	default Boa__CmpOpEqualT $(final boa.CmpOpEqual it) {
		return boa__CmpOpEqual(it);
	}
	default Boa__CmpOpLessT $(final boa.CmpOpLess it) {
		return boa__CmpOpLess(it);
	}
	default Boa__CmpOpUnequalT $(final boa.CmpOpUnequal it) {
		return boa__CmpOpUnequal(it);
	}
	default Boa__CopyT $(final boa.Copy it) {
		return boa__Copy(it);
	}
	default Boa__DefT $(final boa.Def it) {
		return boa__Def(it);
	}
	default Boa__ExprT $(final boa.Expr it) {
		if (it.getClass() == boa.impl.AppImpl.class)
			return boa__App((boa.App) it);
		if (it.getClass() == boa.impl.ArithOpDivideImpl.class)
			return boa__ArithOpDivide((boa.ArithOpDivide) it);
		if (it.getClass() == boa.impl.ArithOpMinusImpl.class)
			return boa__ArithOpMinus((boa.ArithOpMinus) it);
		if (it.getClass() == boa.impl.ArithOpPlusImpl.class)
			return boa__ArithOpPlus((boa.ArithOpPlus) it);
		if (it.getClass() == boa.impl.ArithOpRemainderImpl.class)
			return boa__ArithOpRemainder((boa.ArithOpRemainder) it);
		if (it.getClass() == boa.impl.ArithOpTimesImpl.class)
			return boa__ArithOpTimes((boa.ArithOpTimes) it);
		if (it.getClass() == boa.impl.AssignImpl.class)
			return boa__Assign((boa.Assign) it);
		if (it.getClass() == boa.impl.BObjectImpl.class)
			return boa__BObject((boa.BObject) it);
		if (it.getClass() == boa.impl.BoolImpl.class)
			return boa__Bool((boa.Bool) it);
		if (it.getClass() == boa.impl.BoolOpAndImpl.class)
			return boa__BoolOpAnd((boa.BoolOpAnd) it);
		if (it.getClass() == boa.impl.BoolOpOrImpl.class)
			return boa__BoolOpOr((boa.BoolOpOr) it);
		if (it.getClass() == boa.impl.CmpOpEqualImpl.class)
			return boa__CmpOpEqual((boa.CmpOpEqual) it);
		if (it.getClass() == boa.impl.CmpOpLessImpl.class)
			return boa__CmpOpLess((boa.CmpOpLess) it);
		if (it.getClass() == boa.impl.CmpOpUnequalImpl.class)
			return boa__CmpOpUnequal((boa.CmpOpUnequal) it);
		if (it.getClass() == boa.impl.CopyImpl.class)
			return boa__Copy((boa.Copy) it);
		if (it.getClass() == boa.impl.FunImpl.class)
			return boa__Fun((boa.Fun) it);
		if (it.getClass() == boa.impl.IfImpl.class)
			return boa__If((boa.If) it);
		if (it.getClass() == boa.impl.IntImpl.class)
			return boa__Int((boa.Int) it);
		if (it.getClass() == boa.impl.LetImpl.class)
			return boa__Let((boa.Let) it);
		if (it.getClass() == boa.impl.NotImpl.class)
			return boa__Not((boa.Not) it);
		if (it.getClass() == boa.impl.ProjectImpl.class)
			return boa__Project((boa.Project) it);
		if (it.getClass() == boa.impl.SeqImpl.class)
			return boa__Seq((boa.Seq) it);
		if (it.getClass() == boa.impl.SkipImpl.class)
			return boa__Skip((boa.Skip) it);
		if (it.getClass() == boa.impl.ThisImpl.class)
			return boa__This((boa.This) it);
		if (it.getClass() == boa.impl.VarImpl.class)
			return boa__Var((boa.Var) it);
		if (it.getClass() == boa.impl.WithImpl.class)
			return boa__With((boa.With) it);
		return null;
	}
	default Boa__FieldT $(final boa.Field it) {
		return boa__Field(it);
	}
	default Boa__FileT $(final boa.File it) {
		return boa__File(it);
	}
	default Boa__FunT $(final boa.Fun it) {
		return boa__Fun(it);
	}
	default Boa__IfT $(final boa.If it) {
		return boa__If(it);
	}
	default Boa__IntT $(final boa.Int it) {
		return boa__Int(it);
	}
	default Boa__LetT $(final boa.Let it) {
		return boa__Let(it);
	}
	default Boa__NotT $(final boa.Not it) {
		return boa__Not(it);
	}
	default Boa__ProjectT $(final boa.Project it) {
		return boa__Project(it);
	}
	default Boa__SeqT $(final boa.Seq it) {
		return boa__Seq(it);
	}
	default Boa__SkipT $(final boa.Skip it) {
		return boa__Skip(it);
	}
	default Boa__ThisT $(final boa.This it) {
		return boa__This(it);
	}
	default Boa__TopLevelCmdT $(final boa.TopLevelCmd it) {
		if (it.getClass() == boa.impl.AppImpl.class)
			return boa__App((boa.App) it);
		if (it.getClass() == boa.impl.ArithOpDivideImpl.class)
			return boa__ArithOpDivide((boa.ArithOpDivide) it);
		if (it.getClass() == boa.impl.ArithOpMinusImpl.class)
			return boa__ArithOpMinus((boa.ArithOpMinus) it);
		if (it.getClass() == boa.impl.ArithOpPlusImpl.class)
			return boa__ArithOpPlus((boa.ArithOpPlus) it);
		if (it.getClass() == boa.impl.ArithOpRemainderImpl.class)
			return boa__ArithOpRemainder((boa.ArithOpRemainder) it);
		if (it.getClass() == boa.impl.ArithOpTimesImpl.class)
			return boa__ArithOpTimes((boa.ArithOpTimes) it);
		if (it.getClass() == boa.impl.AssignImpl.class)
			return boa__Assign((boa.Assign) it);
		if (it.getClass() == boa.impl.BObjectImpl.class)
			return boa__BObject((boa.BObject) it);
		if (it.getClass() == boa.impl.BoolImpl.class)
			return boa__Bool((boa.Bool) it);
		if (it.getClass() == boa.impl.BoolOpAndImpl.class)
			return boa__BoolOpAnd((boa.BoolOpAnd) it);
		if (it.getClass() == boa.impl.BoolOpOrImpl.class)
			return boa__BoolOpOr((boa.BoolOpOr) it);
		if (it.getClass() == boa.impl.CmpOpEqualImpl.class)
			return boa__CmpOpEqual((boa.CmpOpEqual) it);
		if (it.getClass() == boa.impl.CmpOpLessImpl.class)
			return boa__CmpOpLess((boa.CmpOpLess) it);
		if (it.getClass() == boa.impl.CmpOpUnequalImpl.class)
			return boa__CmpOpUnequal((boa.CmpOpUnequal) it);
		if (it.getClass() == boa.impl.CopyImpl.class)
			return boa__Copy((boa.Copy) it);
		if (it.getClass() == boa.impl.DefImpl.class)
			return boa__Def((boa.Def) it);
		if (it.getClass() == boa.impl.FunImpl.class)
			return boa__Fun((boa.Fun) it);
		if (it.getClass() == boa.impl.IfImpl.class)
			return boa__If((boa.If) it);
		if (it.getClass() == boa.impl.IntImpl.class)
			return boa__Int((boa.Int) it);
		if (it.getClass() == boa.impl.LetImpl.class)
			return boa__Let((boa.Let) it);
		if (it.getClass() == boa.impl.NotImpl.class)
			return boa__Not((boa.Not) it);
		if (it.getClass() == boa.impl.ProjectImpl.class)
			return boa__Project((boa.Project) it);
		if (it.getClass() == boa.impl.SeqImpl.class)
			return boa__Seq((boa.Seq) it);
		if (it.getClass() == boa.impl.SkipImpl.class)
			return boa__Skip((boa.Skip) it);
		if (it.getClass() == boa.impl.ThisImpl.class)
			return boa__This((boa.This) it);
		if (it.getClass() == boa.impl.VarImpl.class)
			return boa__Var((boa.Var) it);
		if (it.getClass() == boa.impl.WithImpl.class)
			return boa__With((boa.With) it);
		return null;
	}
	default Boa__VarT $(final boa.Var it) {
		return boa__Var(it);
	}
	default Boa__WithT $(final boa.With it) {
		return boa__With(it);
	}
}
