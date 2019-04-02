package test.impl;

import boa.App;
import boa.ArithOp;
import boa.ArithOpDivide;
import boa.ArithOpMinus;
import boa.ArithOpPlus;
import boa.ArithOpRemainder;
import boa.ArithOpTimes;
import boa.Assign;
import boa.BObject;
import boa.Bool;
import boa.BoolOpAnd;
import boa.BoolOpOr;
import boa.CmpOp;
import boa.CmpOpEqual;
import boa.CmpOpLess;
import boa.CmpOpUnequal;
import boa.Copy;
import boa.Ctx;
import boa.Def;
import boa.EvalBoolRes;
import boa.EvalBoundFunRes;
import boa.EvalFunRes;
import boa.EvalIntRes;
import boa.EvalMapRes;
import boa.EvalRes;
import boa.Expr;
import boa.Field;
import boa.File;
import boa.Fun;
import boa.If;
import boa.Int;
import boa.Let;
import boa.Not;
import boa.Project;
import boa.Seq;
import boa.Skip;
import boa.This;
import boa.TopLevelCmd;
import boa.Var;
import boa.With;
import boa.revisitor.BoaRevisitor;
import test.impl.operation.AppOp;
import test.impl.operation.ArithOpDivideOp;
import test.impl.operation.ArithOpMinusOp;
import test.impl.operation.ArithOpOp;
import test.impl.operation.ArithOpPlusOp;
import test.impl.operation.ArithOpRemainderOp;
import test.impl.operation.ArithOpTimesOp;
import test.impl.operation.AssignOp;
import test.impl.operation.BObjectOp;
import test.impl.operation.BoolOp;
import test.impl.operation.BoolOpAndOp;
import test.impl.operation.BoolOpOp;
import test.impl.operation.BoolOpOrOp;
import test.impl.operation.CmpOpEqualOp;
import test.impl.operation.CmpOpLessOp;
import test.impl.operation.CmpOpOp;
import test.impl.operation.CmpOpUnequalOp;
import test.impl.operation.CopyOp;
import test.impl.operation.CtxOp;
import test.impl.operation.DefOp;
import test.impl.operation.EvalBoolResOp;
import test.impl.operation.EvalBoundFunResOp;
import test.impl.operation.EvalFunResOp;
import test.impl.operation.EvalIntResOp;
import test.impl.operation.EvalMapResOp;
import test.impl.operation.EvalResOp;
import test.impl.operation.ExprOp;
import test.impl.operation.FieldOp;
import test.impl.operation.FileOp;
import test.impl.operation.FunOp;
import test.impl.operation.IfOp;
import test.impl.operation.IntOp;
import test.impl.operation.LetOp;
import test.impl.operation.NotOp;
import test.impl.operation.ProjectOp;
import test.impl.operation.SeqOp;
import test.impl.operation.SkipOp;
import test.impl.operation.ThisOp;
import test.impl.operation.TopLevelCmdOp;
import test.impl.operation.VarOp;
import test.impl.operation.WithOp;
import test.impl.operation.impl.AppOpImpl;
import test.impl.operation.impl.ArithOpDivideOpImpl;
import test.impl.operation.impl.ArithOpMinusOpImpl;
import test.impl.operation.impl.ArithOpOpImpl;
import test.impl.operation.impl.ArithOpPlusOpImpl;
import test.impl.operation.impl.ArithOpRemainderOpImpl;
import test.impl.operation.impl.ArithOpTimesOpImpl;
import test.impl.operation.impl.AssignOpImpl;
import test.impl.operation.impl.BObjectOpImpl;
import test.impl.operation.impl.BoolOpAndOpImpl;
import test.impl.operation.impl.BoolOpImpl;
import test.impl.operation.impl.BoolOpOpImpl;
import test.impl.operation.impl.BoolOpOrOpImpl;
import test.impl.operation.impl.CmpOpEqualOpImpl;
import test.impl.operation.impl.CmpOpLessOpImpl;
import test.impl.operation.impl.CmpOpOpImpl;
import test.impl.operation.impl.CmpOpUnequalOpImpl;
import test.impl.operation.impl.CopyOpImpl;
import test.impl.operation.impl.CtxOpImpl;
import test.impl.operation.impl.DefOpImpl;
import test.impl.operation.impl.EvalBoolResOpImpl;
import test.impl.operation.impl.EvalBoundFunResOpImpl;
import test.impl.operation.impl.EvalFunResOpImpl;
import test.impl.operation.impl.EvalIntResOpImpl;
import test.impl.operation.impl.EvalMapResOpImpl;
import test.impl.operation.impl.EvalResOpImpl;
import test.impl.operation.impl.ExprOpImpl;
import test.impl.operation.impl.FieldOpImpl;
import test.impl.operation.impl.FileOpImpl;
import test.impl.operation.impl.FunOpImpl;
import test.impl.operation.impl.IfOpImpl;
import test.impl.operation.impl.IntOpImpl;
import test.impl.operation.impl.LetOpImpl;
import test.impl.operation.impl.NotOpImpl;
import test.impl.operation.impl.ProjectOpImpl;
import test.impl.operation.impl.SeqOpImpl;
import test.impl.operation.impl.SkipOpImpl;
import test.impl.operation.impl.ThisOpImpl;
import test.impl.operation.impl.TopLevelCmdOpImpl;
import test.impl.operation.impl.VarOpImpl;
import test.impl.operation.impl.WithOpImpl;

public interface TestImplementation extends BoaRevisitor<AppOp, ArithOpOp, ArithOpDivideOp, ArithOpMinusOp, ArithOpPlusOp, ArithOpRemainderOp, ArithOpTimesOp, AssignOp, BObjectOp, BoolOp, BoolOpOp, BoolOpAndOp, BoolOpOrOp, CmpOpOp, CmpOpEqualOp, CmpOpLessOp, CmpOpUnequalOp, CopyOp, CtxOp, DefOp, EvalBoolResOp, EvalBoundFunResOp, EvalFunResOp, EvalIntResOp, EvalMapResOp, EvalResOp, ExprOp, FieldOp, FileOp, FunOp, IfOp, IntOp, LetOp, NotOp, ProjectOp, SeqOp, SkipOp, ThisOp, TopLevelCmdOp, VarOp, WithOp> {
	default FileOp boa__File(File it) {
		return new FileOpImpl(it, this);
	}

	default TopLevelCmdOp boa__TopLevelCmd(TopLevelCmd it) {
		return new TopLevelCmdOpImpl(it, this);
	}

	default ExprOp boa__Expr(Expr it) {
		return new ExprOpImpl(it, this);
	}

	default DefOp boa__Def(Def it) {
		return new DefOpImpl(it, this);
	}

	default AppOp boa__App(App it) {
		return new AppOpImpl(it, this);
	}

	default VarOp boa__Var(Var it) {
		return new VarOpImpl(it, this);
	}

	default ThisOp boa__This(This it) {
		return new ThisOpImpl(it, this);
	}

	default BoolOp boa__Bool(Bool it) {
		return new BoolOpImpl(it, this);
	}

	default IntOp boa__Int(Int it) {
		return new IntOpImpl(it, this);
	}

	default SkipOp boa__Skip(Skip it) {
		return new SkipOpImpl(it, this);
	}

	default ProjectOp boa__Project(Project it) {
		return new ProjectOpImpl(it, this);
	}

	default BObjectOp boa__BObject(BObject it) {
		return new BObjectOpImpl(it, this);
	}

	default FieldOp boa__Field(Field it) {
		return new FieldOpImpl(it, this);
	}

	default CopyOp boa__Copy(Copy it) {
		return new CopyOpImpl(it, this);
	}

	default WithOp boa__With(With it) {
		return new WithOpImpl(it, this);
	}

	default ArithOpOp boa__ArithOp(ArithOp it) {
		return new ArithOpOpImpl(it, this);
	}

	default NotOp boa__Not(Not it) {
		return new NotOpImpl(it, this);
	}

	default CmpOpOp boa__CmpOp(CmpOp it) {
		return new CmpOpOpImpl(it, this);
	}

	default BoolOpOp boa__BoolOp(boa.BoolOp it) {
		return new BoolOpOpImpl(it, this);
	}

	default IfOp boa__If(If it) {
		return new IfOpImpl(it, this);
	}

	default LetOp boa__Let(Let it) {
		return new LetOpImpl(it, this);
	}

	default FunOp boa__Fun(Fun it) {
		return new FunOpImpl(it, this);
	}

	default AssignOp boa__Assign(Assign it) {
		return new AssignOpImpl(it, this);
	}

	default ArithOpPlusOp boa__ArithOpPlus(ArithOpPlus it) {
		return new ArithOpPlusOpImpl(it, this);
	}

	default ArithOpMinusOp boa__ArithOpMinus(ArithOpMinus it) {
		return new ArithOpMinusOpImpl(it, this);
	}

	default ArithOpTimesOp boa__ArithOpTimes(ArithOpTimes it) {
		return new ArithOpTimesOpImpl(it, this);
	}

	default ArithOpDivideOp boa__ArithOpDivide(ArithOpDivide it) {
		return new ArithOpDivideOpImpl(it, this);
	}

	default ArithOpRemainderOp boa__ArithOpRemainder(ArithOpRemainder it) {
		return new ArithOpRemainderOpImpl(it, this);
	}

	default BoolOpAndOp boa__BoolOpAnd(BoolOpAnd it) {
		return new BoolOpAndOpImpl(it, this);
	}

	default BoolOpOrOp boa__BoolOpOr(BoolOpOr it) {
		return new BoolOpOrOpImpl(it, this);
	}

	default SeqOp boa__Seq(Seq it) {
		return new SeqOpImpl(it, this);
	}

	default CmpOpEqualOp boa__CmpOpEqual(CmpOpEqual it) {
		return new CmpOpEqualOpImpl(it, this);
	}

	default CmpOpUnequalOp boa__CmpOpUnequal(CmpOpUnequal it) {
		return new CmpOpUnequalOpImpl(it, this);
	}

	default CmpOpLessOp boa__CmpOpLess(CmpOpLess it) {
		return new CmpOpLessOpImpl(it, this);
	}

	default CtxOp boa__Ctx(Ctx it) {
		return new CtxOpImpl(it, this);
	}

	default EvalResOp boa__EvalRes(EvalRes it) {
		return new EvalResOpImpl(it, this);
	}

	default EvalMapResOp boa__EvalMapRes(EvalMapRes it) {
		return new EvalMapResOpImpl(it, this);
	}

	default EvalFunResOp boa__EvalFunRes(EvalFunRes it) {
		return new EvalFunResOpImpl(it, this);
	}

	default EvalBoundFunResOp boa__EvalBoundFunRes(EvalBoundFunRes it) {
		return new EvalBoundFunResOpImpl(it, this);
	}

	default EvalIntResOp boa__EvalIntRes(EvalIntRes it) {
		return new EvalIntResOpImpl(it, this);
	}

	default EvalBoolResOp boa__EvalBoolRes(EvalBoolRes it) {
		return new EvalBoolResOpImpl(it, this);
	}
}
