package boa.interpreter.boa.impl;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;

import boa.interpreter.boa.Ctx;
import boa.interpreter.boa.Expr;

final class RootNodeExtension extends RootNode {
	/**
	 * 
	 */
	@Child
	private Expr body;

	RootNodeExtension(Expr expr, TruffleLanguage<?> language) {
		super(language);
		this.body = expr;
	}

	@Override
	public Object execute(VirtualFrame frame) {
		return this.body.eval((Ctx) frame.getArguments()[0]);
	}
}