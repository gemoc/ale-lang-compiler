package petrinet.benchmark.truffle;

import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.DirectCallNode;
import com.oracle.truffle.api.nodes.RootNode;

import truffle.petrinet.interpreter.petrinet.Petrinet;

final class SLEvalRootNode extends RootNode {
	@Child
	private DirectCallNode main;

	SLEvalRootNode(TruffleLanguage<?> language, Petrinet result) {
		super(language);
		RootCallTarget createCallTarget = Truffle.getRuntime()
				.createCallTarget(new RootNodeExtension2(language, result));
		this.main = DirectCallNode.create(createCallTarget);
	}

	@Override
	public Object execute(final VirtualFrame frame) {
		return main.call(new Object[] {});
	}
}