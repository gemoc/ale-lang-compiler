package fsm.benchmark.truffle;

import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;

import fsm.interpreter.fsm.impl.SystemImpl;

final class MainRootNodeExtension extends RootNode {
	@Child
	private SystemImpl result;

	MainRootNodeExtension(TruffleLanguage<?> language, SystemImpl result) {
		super(language);
		this.result = result;
	}

	@Override
	public Object execute(final VirtualFrame frame) {
		LogService.MUTE = true;
		final long start = java.lang.System.currentTimeMillis();
		result.main(3000000);
		return java.lang.System.currentTimeMillis() - start;
	}
}