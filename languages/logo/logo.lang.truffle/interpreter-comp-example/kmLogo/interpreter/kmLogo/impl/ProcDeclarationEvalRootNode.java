package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;

import kmLogo.interpreter.kmLogo.Instruction;
import kmLogo.interpreter.kmLogo.ProcDeclaration;
import kmLogo.interpreter.kmLogo.Turtle;

public class ProcDeclarationEvalRootNode extends RootNode {
	private final ProcDeclaration it;

	@Children
	private Instruction[] instructions;

	public ProcDeclarationEvalRootNode(ProcDeclaration it) {
		super(null);
		this.it = it;

	}

	@Override
	// @ExplodeLoop
	public Object execute(VirtualFrame frame) {
		if (this.instructions == null) {
			CompilerDirectives.transferToInterpreterAndInvalidate();
			this.instructions = it.getInstructions().toArray(new Instruction[0]);
		}
		Turtle turtle = (Turtle) frame.getArguments()[0];
		double ret = 0.0;
		// System.out.println(instructions.length);
		for (Instruction instr : instructions) {
			ret = instr.eval(turtle);
		}
		return ret;
	}
}
