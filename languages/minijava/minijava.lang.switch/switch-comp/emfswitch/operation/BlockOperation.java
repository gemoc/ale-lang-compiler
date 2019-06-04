package emfswitch.operation;

import emfswitch.SwitchImplementation;
import java.lang.Integer;
import miniJava.Block;
import miniJava.Frame;
import miniJava.State;
import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

public class BlockOperation extends StatementOperation {
	private final Block it;

	private final SwitchImplementation emfswitch;

	public BlockOperation(Block it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void evaluateStatementKeepContext(State state) {
		((StateOperation) emfswitch.doSwitch(state)).pushNewContext();
		Frame currentFrame = ((Frame) (((StateOperation) emfswitch.doSwitch(state)).findCurrentFrame()));
		int lgt = ((int) (CollectionService.size(this.it.getStatements())));
		int i = ((int) (0));
		while ((((i) < (lgt)) && (EqualService.equals((currentFrame.getReturnValue()), (null))))) {
			((StatementOperation) emfswitch.doSwitch(CollectionService.get(this.it.getStatements(), i))).evaluateStatement((State) (state));
			i = ((Integer) ((i) + (1)));
		}
	}

	public void evaluateStatement(State state) {
		((BlockOperation) emfswitch.doSwitch(this.it)).evaluateStatementKeepContext((State) (state));
		((StateOperation) emfswitch.doSwitch(state)).popCurrentContext();
	}
}
