package visitor;

import boa.visitor.boa.App;
import boa.visitor.boa.ArithOpDivide;
import boa.visitor.boa.ArithOpMinus;
import boa.visitor.boa.ArithOpPlus;
import boa.visitor.boa.ArithOpRemainder;
import boa.visitor.boa.ArithOpTimes;
import boa.visitor.boa.Assign;
import boa.visitor.boa.BObject;
import boa.visitor.boa.Bool;
import boa.visitor.boa.BoolOpAnd;
import boa.visitor.boa.BoolOpOr;
import boa.visitor.boa.CmpOpEqual;
import boa.visitor.boa.CmpOpLess;
import boa.visitor.boa.CmpOpUnequal;
import boa.visitor.boa.Copy;
import boa.visitor.boa.Ctx;
import boa.visitor.boa.Def;
import boa.visitor.boa.EvalBoolRes;
import boa.visitor.boa.EvalBoundFunRes;
import boa.visitor.boa.EvalFunRes;
import boa.visitor.boa.EvalIntRes;
import boa.visitor.boa.EvalMapRes;
import boa.visitor.boa.Field;
import boa.visitor.boa.File;
import boa.visitor.boa.Fun;
import boa.visitor.boa.If;
import boa.visitor.boa.Int;
import boa.visitor.boa.Let;
import boa.visitor.boa.Not;
import boa.visitor.boa.Project;
import boa.visitor.boa.Seq;
import boa.visitor.boa.Skip;
import boa.visitor.boa.StringToEvalResMap;
import boa.visitor.boa.This;
import boa.visitor.boa.Var;
import boa.visitor.boa.With;
import java.lang.Object;

public interface VisitorInterface {
	Object visitboa__File(File it);

	Object visitboa__Def(Def it);

	Object visitboa__App(App it);

	Object visitboa__Var(Var it);

	Object visitboa__This(This it);

	Object visitboa__Bool(Bool it);

	Object visitboa__Int(Int it);

	Object visitboa__Skip(Skip it);

	Object visitboa__Project(Project it);

	Object visitboa__BObject(BObject it);

	Object visitboa__Field(Field it);

	Object visitboa__Copy(Copy it);

	Object visitboa__With(With it);

	Object visitboa__Not(Not it);

	Object visitboa__If(If it);

	Object visitboa__Let(Let it);

	Object visitboa__Fun(Fun it);

	Object visitboa__Assign(Assign it);

	Object visitboa__ArithOpPlus(ArithOpPlus it);

	Object visitboa__ArithOpMinus(ArithOpMinus it);

	Object visitboa__ArithOpTimes(ArithOpTimes it);

	Object visitboa__ArithOpDivide(ArithOpDivide it);

	Object visitboa__ArithOpRemainder(ArithOpRemainder it);

	Object visitboa__BoolOpAnd(BoolOpAnd it);

	Object visitboa__BoolOpOr(BoolOpOr it);

	Object visitboa__Seq(Seq it);

	Object visitboa__CmpOpEqual(CmpOpEqual it);

	Object visitboa__CmpOpUnequal(CmpOpUnequal it);

	Object visitboa__CmpOpLess(CmpOpLess it);

	Object visitboa__Ctx(Ctx it);

	Object visitboa__StringToEvalResMap(StringToEvalResMap it);

	Object visitboa__EvalMapRes(EvalMapRes it);

	Object visitboa__EvalFunRes(EvalFunRes it);

	Object visitboa__EvalBoundFunRes(EvalBoundFunRes it);

	Object visitboa__EvalIntRes(EvalIntRes it);

	Object visitboa__EvalBoolRes(EvalBoolRes it);
}
