package empty.interpreter.empty.impl;

import empty.interpreter.empty.Existing2;

public class ExistingImpl2 extends ExistingImpl implements Existing2 {

	private boolean y = false;

	protected ExistingImpl2() {
		super();
	}

	public int test2() {
		int result;
		if (this.y) {
			result = (int) (1);
		} else {
			result = (int) (2);
		}
		return result;
	}
}
