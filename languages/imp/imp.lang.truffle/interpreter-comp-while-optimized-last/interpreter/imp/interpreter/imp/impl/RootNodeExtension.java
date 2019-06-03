package interpreter.imp.interpreter.imp.impl;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;

import interpreter.imp.interpreter.imp.impl.WhileImpl.Data;

final class RootNodeExtension extends RootNode {
	/**
	 * 
	 */
	@Child
	private  WhileImpl whileImpl;
//	private final Store s;

	RootNodeExtension(WhileImpl whileImpl) {
		super(null);
		this.whileImpl = whileImpl;
//		this.s = s;
	}

	@Override
	public Object execute(VirtualFrame frame) {
		Data it = (Data) frame.getArguments()[0];
		interpreter.imp.interpreter.imp.Value conde = ((interpreter.imp.interpreter.imp.Value) this.whileImpl.cond
				.evaluate(it.tmp));
		if (conde instanceof interpreter.imp.interpreter.imp.BoolValue) {
			interpreter.imp.interpreter.imp.BoolValue condeb = ((interpreter.imp.interpreter.imp.BoolValue) conde);
			if (condeb.isValue()) {
				it.tmp = this.whileImpl.body.execute(it.tmp);
			} else {
				it.stop = true;
			}
		} else {
			it.stop = true;
		}
		return it;
	}
}