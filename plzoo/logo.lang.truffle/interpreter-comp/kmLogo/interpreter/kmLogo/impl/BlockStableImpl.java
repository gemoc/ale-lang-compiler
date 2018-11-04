package kmLogo.interpreter.kmLogo.impl;

import org.eclipse.emf.common.util.EList;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Children;

import kmLogo.interpreter.kmLogo.Instruction;
import kmLogo.interpreter.kmLogo.Turtle;

public class BlockStableImpl {

	@Children
	private final InstructionImpl[] instructions;

	public BlockStableImpl(EList<?> instructions) {
		this.instructions = tmp(instructions);
	}

	@TruffleBoundary
	private InstructionImpl[] tmp(EList<?> instructions) {
		return instructions.toArray(new InstructionImpl[] {});
	}

//	@ExplodeLoop
	public void execte(Turtle turtle) {
//		CompilerAsserts.compilationConstant(this.instructions.length);
		for (InstructionImpl inst : this.instructions) {
			if (inst instanceof LeftImpl) {
				((LeftImpl) inst).eval(turtle);
			} else if (inst instanceof ForwardImpl) {
				((ForwardImpl) inst).eval(turtle);
			} else if (inst instanceof PenUpImpl) {
				((PenUpImpl) inst).eval(turtle);
			} else if (inst instanceof PenDownImpl) {
				((PenDownImpl) inst).eval(turtle);
			} else if (inst instanceof RepeatImpl) {
				((RepeatImpl) inst).eval(turtle);
			} else if (inst instanceof ProcCallImpl) {
				((ProcCallImpl) inst).eval(turtle);
			} else {
				throw new RuntimeException(inst.getClass() + " not handled");
			}
		}

	}

}
