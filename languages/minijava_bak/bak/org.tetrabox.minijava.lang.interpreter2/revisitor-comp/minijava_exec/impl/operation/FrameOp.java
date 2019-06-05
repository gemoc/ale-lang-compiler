package minijava_exec.impl.operation;

import miniJava.Context;
import miniJava.Frame;

public interface FrameOp {
	Context findCurrentContext();

	Frame findCurrentFrame();
}
