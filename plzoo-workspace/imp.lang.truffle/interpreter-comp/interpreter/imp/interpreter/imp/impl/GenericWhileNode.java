package interpreter.imp.interpreter.imp.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.RepeatingNode;
import com.oracle.truffle.api.nodes.Node.Child;

import interpreter.imp.interpreter.imp.Store;

final class GenericWhileNode extends Node implements RepeatingNode {
	public Store s;

	public boolean stop;

	public Store tmp;

	/**
	 * The condition of the loop. This in a {@link SLExpressionNode} because we
	 * require a result value. We do not have a node type that can only return a
	 * {@code boolean} value, so {@link #evaluateCondition executing the condition}
	 * can lead to a type error.
	 */
	@Child
	private ConditionNode conditionNode;

	/**
	 * Statement (or {@link SLBlockNode block}) executed as long as the condition is
	 * true.
	 */
	@Child
	private StmtContinuation bodyNode;

	public GenericWhileNode(ConditionNode conditionNode, StmtContinuation bodyNode) {
		this.conditionNode = conditionNode;
		this.bodyNode = bodyNode;
	}

	@Override
	public boolean executeRepeating(VirtualFrame frame) {
		log();
		if (!evaluateCondition(frame)) {
			/* Normal exit of the loop when loop condition is false. */
			return false;
		}

		/* Execute the loop body. */
		bodyNode.continuation(this);
		/* Continue with next loop iteration. */
		return true;

	}

	@TruffleBoundary
	private void log() {
		System.out.print('.');
	}

	private boolean evaluateCondition(VirtualFrame frame) {
		/*
		 * The condition must evaluate to a boolean value, so we call the
		 * boolean-specialized execute method.
		 */
		return conditionNode.evaluate(stop);
	}
}