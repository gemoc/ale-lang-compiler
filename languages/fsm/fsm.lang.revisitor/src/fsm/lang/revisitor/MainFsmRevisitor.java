package fsm.lang.revisitor;

import fsm.impl.FsmImplementation;
import fsm.model.fsm.Buffer;

public class MainFsmRevisitor {
	public static void main(String[] args) {
		FsmImplementation rev = new FsmImplementation() {};
		rev.$((Buffer)null);
	}
}
