package interpreter.imp.interpreter.imp.impl;

import com.oracle.truffle.api.nodes.Node;

final class ConditionNodeImplementation extends Node implements ConditionNode {
	@Override
	public boolean evaluate(boolean stop) {
		// TODO Auto-generated method stub
		return !stop;
	}
}