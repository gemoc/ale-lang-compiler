package interpreter.visitor;

import interpreter.boa.visitor.boa.App;
import interpreter.boa.visitor.boa.ArithOpDivide;
import interpreter.boa.visitor.boa.ArithOpMinus;
import interpreter.boa.visitor.boa.ArithOpPlus;
import interpreter.boa.visitor.boa.ArithOpRemainder;
import interpreter.boa.visitor.boa.ArithOpTimes;
import interpreter.boa.visitor.boa.Assign;
import interpreter.boa.visitor.boa.BObject;
import interpreter.boa.visitor.boa.Bool;
import interpreter.boa.visitor.boa.BoolOpAnd;
import interpreter.boa.visitor.boa.BoolOpOr;
import interpreter.boa.visitor.boa.CmpOpEqual;
import interpreter.boa.visitor.boa.CmpOpLess;
import interpreter.boa.visitor.boa.CmpOpUnequal;
import interpreter.boa.visitor.boa.Copy;
import interpreter.boa.visitor.boa.Ctx;
import interpreter.boa.visitor.boa.Def;
import interpreter.boa.visitor.boa.EvalBoolRes;
import interpreter.boa.visitor.boa.EvalBoundFunRes;
import interpreter.boa.visitor.boa.EvalFunRes;
import interpreter.boa.visitor.boa.EvalIntRes;
import interpreter.boa.visitor.boa.EvalMapRes;
import interpreter.boa.visitor.boa.Field;
import interpreter.boa.visitor.boa.File;
import interpreter.boa.visitor.boa.Fun;
import interpreter.boa.visitor.boa.If;
import interpreter.boa.visitor.boa.Int;
import interpreter.boa.visitor.boa.Let;
import interpreter.boa.visitor.boa.Not;
import interpreter.boa.visitor.boa.Project;
import interpreter.boa.visitor.boa.Seq;
import interpreter.boa.visitor.boa.Skip;
import interpreter.boa.visitor.boa.StringToEvalResMap;
import interpreter.boa.visitor.boa.This;
import interpreter.boa.visitor.boa.Var;
import interpreter.boa.visitor.boa.With;
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
