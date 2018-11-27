package interpreter.imp.interpreter.imp.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.utilities.CyclicAssumption;

import interpreter.imp.interpreter.imp.Expr;
import interpreter.imp.interpreter.imp.Stmt;

public class WhileDispatchWrapperCallInner {
	 private RootCallTarget callTarget;

	  private final CyclicAssumption callTargetStable;

	  protected WhileDispatchWrapperCallInner(Stmt body, Expr cond) {
	    this.callTargetStable = new CyclicAssumption("WhileDispatchWrapperCallInner_7.393820793045932E7");
	    this.callTarget = Truffle.getRuntime().createCallTarget(new WhileInnerRootNode(null, body, cond));
	  }

	  public RootCallTarget getCallTarget() {
	    return callTarget;}

	  public Assumption getCallTargetStable() {
	    return callTargetStable.getAssumption();}
}
