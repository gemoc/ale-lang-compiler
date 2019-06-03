package interpreter.imp.interpreter.imp.impl;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;

import interpreter.imp.interpreter.imp.Expr;
import interpreter.imp.interpreter.imp.Stmt;
import interpreter.imp.interpreter.imp.Store;

public class WhileInnerRootNode extends RootNode {

	public static final class Data {
		public boolean stop;
		public Store tmp;
		public Store s;
		public Data(boolean stop, Store tmp, Store s) {
			super();
			this.stop = stop;
			this.tmp = tmp;
			this.s = s;
		}
		
		
	}
	
	@Child
	protected Expr cond;
	
	@Child
	protected Stmt body;

	protected WhileInnerRootNode(TruffleLanguage<?> language, Stmt body, Expr cond) {
		super(language);
		this.body = body;
		this.cond = cond;
	}

	@Override
	public Object execute(VirtualFrame frame) {
		Data it = (Data) frame.getArguments()[0]; 
		interpreter.imp.interpreter.imp.Value conde = ((interpreter.imp.interpreter.imp.Value) this.cond
				.evaluate(it.s));
		if (conde instanceof interpreter.imp.interpreter.imp.BoolValue) {
			interpreter.imp.interpreter.imp.BoolValue condeb = ((interpreter.imp.interpreter.imp.BoolValue) conde);
			if (condeb.isValue()) {
				it.tmp = this.body.execute(it.tmp);
			} else {
				it.stop = true;
			}
		} else {
			it.stop = true;
		}
		return it;
	}

}
