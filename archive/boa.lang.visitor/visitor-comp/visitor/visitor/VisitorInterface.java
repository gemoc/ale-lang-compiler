package visitor.visitor;

import java.lang.Object;
import visitor.boa.visitor.boa.App;
import visitor.boa.visitor.boa.ArithOpDivide;
import visitor.boa.visitor.boa.ArithOpMinus;
import visitor.boa.visitor.boa.ArithOpPlus;
import visitor.boa.visitor.boa.ArithOpRemainder;
import visitor.boa.visitor.boa.ArithOpTimes;
import visitor.boa.visitor.boa.Assign;
import visitor.boa.visitor.boa.BObject;
import visitor.boa.visitor.boa.Bool;
import visitor.boa.visitor.boa.BoolOpAnd;
import visitor.boa.visitor.boa.BoolOpOr;
import visitor.boa.visitor.boa.CmpOpEqual;
import visitor.boa.visitor.boa.CmpOpLess;
import visitor.boa.visitor.boa.CmpOpUnequal;
import visitor.boa.visitor.boa.Copy;
import visitor.boa.visitor.boa.Ctx;
import visitor.boa.visitor.boa.Def;
import visitor.boa.visitor.boa.EvalBoolRes;
import visitor.boa.visitor.boa.EvalBoundFunRes;
import visitor.boa.visitor.boa.EvalFunRes;
import visitor.boa.visitor.boa.EvalIntRes;
import visitor.boa.visitor.boa.EvalMapRes;
import visitor.boa.visitor.boa.Field;
import visitor.boa.visitor.boa.File;
import visitor.boa.visitor.boa.Fun;
import visitor.boa.visitor.boa.If;
import visitor.boa.visitor.boa.Int;
import visitor.boa.visitor.boa.Let;
import visitor.boa.visitor.boa.Not;
import visitor.boa.visitor.boa.Project;
import visitor.boa.visitor.boa.Seq;
import visitor.boa.visitor.boa.Skip;
import visitor.boa.visitor.boa.StringToEvalResMap;
import visitor.boa.visitor.boa.This;
import visitor.boa.visitor.boa.Var;
import visitor.boa.visitor.boa.With;

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
