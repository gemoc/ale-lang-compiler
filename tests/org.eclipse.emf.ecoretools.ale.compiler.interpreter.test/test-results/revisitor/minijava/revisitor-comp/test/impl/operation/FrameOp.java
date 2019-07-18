package test.impl.operation;

import miniJava.Context;
import miniJava.Frame;

public interface FrameOp {
	Context findCurrentContext();

	Frame findCurrentFrame();
}
