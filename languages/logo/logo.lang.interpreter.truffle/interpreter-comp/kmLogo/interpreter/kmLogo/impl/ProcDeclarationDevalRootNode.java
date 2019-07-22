package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.RootNode;
import java.lang.Object;
import java.lang.Override;

public class ProcDeclarationDevalRootNode extends RootNode {
	@Child
	private ProcDeclarationImpl it;

	public ProcDeclarationDevalRootNode(ProcDeclarationImpl it) {
		super(null);
		this.it = it;
	}

	@Override
	public Object execute(VirtualFrame frame) {
		kmLogo.interpreter.kmLogo.impl.TurtleImpl turtle = (kmLogo.interpreter.kmLogo.impl.TurtleImpl) frame.getArguments()[0];
		return it.deval(turtle);
	}
}
