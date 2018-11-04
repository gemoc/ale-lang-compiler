package kmLogo.interpreter.kmLogo.impl;

import org.eclipse.emf.common.util.EList;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.RootNode;

import kmLogo.interpreter.kmLogo.Instruction;
import kmLogo.interpreter.kmLogo.Turtle;
import kmLogo.interpreter.kmLogo.extra.ArrayService;

final class RootNodeProcDeclaration extends RootNode {
	/**
	 * 
	 */
	@Children
	private final Instruction[] instructions;
	private final Turtle turtle;

	RootNodeProcDeclaration(EList<Instruction> eList, TruffleLanguage<?> language, Turtle turtle) {
		super(language);
		this.instructions = ArrayService.toArray(Instruction.class, eList);
		this.turtle = turtle;
	}

	@Override
//	@ExplodeLoop
	public Object execute(VirtualFrame frame) {
		double result = 0.0;
//		CompilerAsserts.compilationConstant(instructions.length);
		for (Instruction instr : this.instructions) {
			if (instr instanceof BlockImpl) {
				result = ((BlockImpl) instr).eval(turtle);
			} else if (instr instanceof ProcDeclarationImpl) {
				result = ((ProcDeclarationImpl) instr).eval(turtle);
			} else if (instr instanceof LeftImpl) {
				result = ((LeftImpl) instr).eval(turtle);
			} else if (instr instanceof ForwardImpl) {
				result = ((ForwardImpl) instr).eval(turtle);
			} else if (instr instanceof RightImpl) {
				result = ((RightImpl) instr).eval(turtle);
			} else if (instr instanceof ProcCallImpl) {
				result = ((ProcCallImpl) instr).eval(turtle);
			} else if (instr instanceof MultImpl) {
				result = ((MultImpl) instr).eval(turtle);
			} else if (instr instanceof IfImpl) {
				result = ((IfImpl) instr).eval(turtle);
			} else if (instr instanceof BackImpl) {
				result = ((BackImpl) instr).eval(turtle);
			} else {
//				throw new RuntimeException(instr.getClass() + " not handled");
			}
//			result = instr.eval(turtle);
		}
		return result;
	}
}