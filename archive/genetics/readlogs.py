#!/usr/bin/env python3

import os

files = os.listdir('.')
times = [f for f in files if f.startswith('times_')]

features=["boa.File.eval", "boa.TopLevelCmd.nextLine", "boa.Def.nextLine", "boa.Expr.eval", "boa.Expr.nextLine", "boa.Var.eval", "boa.BObject.eval", "boa.App.eval", "boa.App.callFunc", "boa.ArithOpDivide.eval", "boa.ArithOpMinus.eval", "boa.ArithOpPlus.eval", "boa.ArithOpRemainder.eval", "boa.ArithOpTimes.eval", "boa.Assign.eval", "boa.Bool.eval", "boa.BoolOpAnd.eval", "boa.BoolOpOr.eval", "boa.CmpOpEqual.eval", "boa.CmpOpUnequal.eval", "boa.CmpOpLess.eval", "boa.Copy.eval", "boa.Fun.eval", "boa.If.eval", "boa.Int.eval", "boa.Let.eval", "boa.Not.eval", "boa.Project.eval", "boa.Project.project", "boa.Seq.eval", "boa.Skip.eval", "boa.This.eval", "boa.With.eval"]

results=[]

for n in times:
    f = open(n, 'r')
    lines=f.readlines()
    activated_features=lines[0][:-1].split('_')
    try:
        measured_times=eval(lines[1][:-1])
    except:
        measured_times=[]
    
    #print(activated_features)
    #print(measured_times)
    entry={}

    for af in activated_features:
        entry[af]=True
    entry['times']=measured_times

    results.append(entry)

print(results)