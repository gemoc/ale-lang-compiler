package interpreter.imp.interpreter.imp.impl;

import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.Node.Child;

import interpreter.imp.interpreter.imp.Expr;
import interpreter.imp.interpreter.imp.Stmt;

final class StmtContinuation extends Node {

	@Child
	private Expr cond;

	@Child
	private Stmt body;

	public StmtContinuation(Expr cond, Stmt body) {
		super();
		this.cond = cond;
		this.body = body;
	}

	public void continuation(GenericWhileNode self) {
		interpreter.imp.interpreter.imp.Value conde = ((interpreter.imp.interpreter.imp.Value) this.cond
				.evaluate(self.s));
		if (conde instanceof interpreter.imp.interpreter.imp.BoolValue) {
			interpreter.imp.interpreter.imp.BoolValue condeb = ((interpreter.imp.interpreter.imp.BoolValue) conde);
			boolean value = condeb.isValue();
			if (value) {
				self.tmp = this.body.execute(self.tmp);
			} else {
				self.stop = true;
			}
		} else {
			self.stop = true;
		}
	}

}