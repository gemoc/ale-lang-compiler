package minijava_exec.impl.operation;

import java.lang.String;
import miniJava.Value;

public interface ObjectRefValueOp extends ValueOp {
	String customToString();

	Value copyj();
}
