package fsm.interpreter.fsm.impl;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.RootNode;
import java.lang.Object;
import java.lang.Override;

public class FSMRunRootNode extends RootNode {
	@Child
	private FSMImpl it;

	public FSMRunRootNode(FSMImpl it) {
		super(null);
		this.it = it;
	}

	@Override
	public Object execute(VirtualFrame frame) {
		it.run();
		return null;
	}
}
