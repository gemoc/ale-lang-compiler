package minijava_exec.impl.operation;

import miniJava.TypeRef;

public interface ClassRefOp extends SingleTypeRefOp {
	boolean compare(TypeRef other);
}
