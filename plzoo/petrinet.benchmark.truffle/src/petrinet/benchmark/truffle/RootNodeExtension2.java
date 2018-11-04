package petrinet.benchmark.truffle;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;

import truffle.petrinet.interpreter.petrinet.Petrinet;

final class RootNodeExtension2 extends RootNode {
	@Child
	private Petrinet result;

	RootNodeExtension2(TruffleLanguage<?> language, Petrinet result) {
		super(language);
		this.result = result;
	}

	@Override
	public Object execute(VirtualFrame frame) {
		return result.run();
	}
}