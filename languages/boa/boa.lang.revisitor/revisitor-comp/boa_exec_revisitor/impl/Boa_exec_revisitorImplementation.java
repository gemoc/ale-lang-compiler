package boa_exec_revisitor.impl;

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
import boa_exec_revisitor.impl.operation.AppOp;
import boa_exec_revisitor.impl.operation.ArithOpDivideOp;
import boa_exec_revisitor.impl.operation.ArithOpMinusOp;
import boa_exec_revisitor.impl.operation.ArithOpOp;
import boa_exec_revisitor.impl.operation.ArithOpPlusOp;
import boa_exec_revisitor.impl.operation.ArithOpRemainderOp;
import boa_exec_revisitor.impl.operation.ArithOpTimesOp;
import boa_exec_revisitor.impl.operation.AssignOp;
import boa_exec_revisitor.impl.operation.BObjectOp;
import boa_exec_revisitor.impl.operation.BoolOp;
import boa_exec_revisitor.impl.operation.BoolOpAndOp;
import boa_exec_revisitor.impl.operation.BoolOpOp;
import boa_exec_revisitor.impl.operation.BoolOpOrOp;
import boa_exec_revisitor.impl.operation.CmpOpEqualOp;
import boa_exec_revisitor.impl.operation.CmpOpLessOp;
import boa_exec_revisitor.impl.operation.CmpOpOp;
import boa_exec_revisitor.impl.operation.CmpOpUnequalOp;
import boa_exec_revisitor.impl.operation.CopyOp;
import boa_exec_revisitor.impl.operation.CtxOp;
import boa_exec_revisitor.impl.operation.DefOp;
import boa_exec_revisitor.impl.operation.EvalBoolResOp;
import boa_exec_revisitor.impl.operation.EvalBoundFunResOp;
import boa_exec_revisitor.impl.operation.EvalFunResOp;
import boa_exec_revisitor.impl.operation.EvalIntResOp;
import boa_exec_revisitor.impl.operation.EvalMapResOp;
import boa_exec_revisitor.impl.operation.EvalResOp;
import boa_exec_revisitor.impl.operation.ExprOp;
import boa_exec_revisitor.impl.operation.FieldOp;
import boa_exec_revisitor.impl.operation.FileOp;
import boa_exec_revisitor.impl.operation.FunOp;
import boa_exec_revisitor.impl.operation.IfOp;
import boa_exec_revisitor.impl.operation.IntOp;
import boa_exec_revisitor.impl.operation.LetOp;
import boa_exec_revisitor.impl.operation.NotOp;
import boa_exec_revisitor.impl.operation.ProjectOp;
import boa_exec_revisitor.impl.operation.SeqOp;
import boa_exec_revisitor.impl.operation.SkipOp;
import boa_exec_revisitor.impl.operation.ThisOp;
import boa_exec_revisitor.impl.operation.TopLevelCmdOp;
import boa_exec_revisitor.impl.operation.VarOp;
import boa_exec_revisitor.impl.operation.WithOp;
import boa_exec_revisitor.impl.operation.impl.AppOpImpl;
import boa_exec_revisitor.impl.operation.impl.ArithOpDivideOpImpl;
import boa_exec_revisitor.impl.operation.impl.ArithOpMinusOpImpl;
import boa_exec_revisitor.impl.operation.impl.ArithOpOpImpl;
import boa_exec_revisitor.impl.operation.impl.ArithOpPlusOpImpl;
import boa_exec_revisitor.impl.operation.impl.ArithOpRemainderOpImpl;
import boa_exec_revisitor.impl.operation.impl.ArithOpTimesOpImpl;
import boa_exec_revisitor.impl.operation.impl.AssignOpImpl;
import boa_exec_revisitor.impl.operation.impl.BObjectOpImpl;
import boa_exec_revisitor.impl.operation.impl.BoolOpAndOpImpl;
import boa_exec_revisitor.impl.operation.impl.BoolOpImpl;
import boa_exec_revisitor.impl.operation.impl.BoolOpOpImpl;
import boa_exec_revisitor.impl.operation.impl.BoolOpOrOpImpl;
import boa_exec_revisitor.impl.operation.impl.CmpOpEqualOpImpl;
import boa_exec_revisitor.impl.operation.impl.CmpOpLessOpImpl;
import boa_exec_revisitor.impl.operation.impl.CmpOpOpImpl;
import boa_exec_revisitor.impl.operation.impl.CmpOpUnequalOpImpl;
import boa_exec_revisitor.impl.operation.impl.CopyOpImpl;
import boa_exec_revisitor.impl.operation.impl.CtxOpImpl;
import boa_exec_revisitor.impl.operation.impl.DefOpImpl;
import boa_exec_revisitor.impl.operation.impl.EvalBoolResOpImpl;
import boa_exec_revisitor.impl.operation.impl.EvalBoundFunResOpImpl;
import boa_exec_revisitor.impl.operation.impl.EvalFunResOpImpl;
import boa_exec_revisitor.impl.operation.impl.EvalIntResOpImpl;
import boa_exec_revisitor.impl.operation.impl.EvalMapResOpImpl;
import boa_exec_revisitor.impl.operation.impl.EvalResOpImpl;
import boa_exec_revisitor.impl.operation.impl.ExprOpImpl;
import boa_exec_revisitor.impl.operation.impl.FieldOpImpl;
import boa_exec_revisitor.impl.operation.impl.FileOpImpl;
import boa_exec_revisitor.impl.operation.impl.FunOpImpl;
import boa_exec_revisitor.impl.operation.impl.IfOpImpl;
import boa_exec_revisitor.impl.operation.impl.IntOpImpl;
import boa_exec_revisitor.impl.operation.impl.LetOpImpl;
import boa_exec_revisitor.impl.operation.impl.NotOpImpl;
import boa_exec_revisitor.impl.operation.impl.ProjectOpImpl;
import boa_exec_revisitor.impl.operation.impl.SeqOpImpl;
import boa_exec_revisitor.impl.operation.impl.SkipOpImpl;
import boa_exec_revisitor.impl.operation.impl.ThisOpImpl;
import boa_exec_revisitor.impl.operation.impl.TopLevelCmdOpImpl;
import boa_exec_revisitor.impl.operation.impl.VarOpImpl;
import boa_exec_revisitor.impl.operation.impl.WithOpImpl;

public interface Boa_exec_revisitorImplementation extends BoaRevisitor<AppOp, ArithOpOp, ArithOpDivideOp, ArithOpMinusOp, ArithOpPlusOp, ArithOpRemainderOp, ArithOpTimesOp, AssignOp, BObjectOp, BoolOp, BoolOpOp, BoolOpAndOp, BoolOpOrOp, CmpOpOp, CmpOpEqualOp, CmpOpLessOp, CmpOpUnequalOp, CopyOp, CtxOp, DefOp, EvalBoolResOp, EvalBoundFunResOp, EvalFunResOp, EvalIntResOp, EvalMapResOp, EvalResOp, ExprOp, FieldOp, FileOp, FunOp, IfOp, IntOp, LetOp, NotOp, ProjectOp, SeqOp, SkipOp, ThisOp, TopLevelCmdOp, VarOp, WithOp> {
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
