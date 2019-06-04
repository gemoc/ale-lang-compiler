package minijava_exec.impl.operation;

import miniJava.Context;
import miniJava.Symbol;
import miniJava.SymbolBinding;

public interface ContextOp {
	SymbolBinding findBinding(Symbol symbol);

	Context findCurrentContext();
}
