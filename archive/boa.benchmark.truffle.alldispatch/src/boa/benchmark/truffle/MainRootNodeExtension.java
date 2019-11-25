package boa.benchmark.truffle;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;

import boa.interpreter.boa.File;


final class MainRootNodeExtension extends RootNode {
	@Child
	private File result;

	MainRootNodeExtension(TruffleLanguage<?> language, File result) {
		super(language);
		this.result = result;
	}

	@Override
	public Object execute(final VirtualFrame frame) {
		final long start = System.currentTimeMillis();
		result.eval();
		return System.currentTimeMillis() - start;
	}
}