package emfswitch.operation;

import org.eclipse.emf.common.util.EMap;

import emfswitch.SwitchImplementation;
import miniJava.Context;
import miniJava.Symbol;
import miniJava.SymbolBinding;
import minijava.MapService;

public class ContextOperation {
	private final Context it;

	private final SwitchImplementation emfswitch;

	public ContextOperation(Context it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public SymbolBinding findBinding(Symbol symbol) {
		SymbolBinding result;
		if (!(/* CASED */minijava.MapService.containsKey(/* CASEC */this.it.getCache(), symbol))) {
			SymbolBinding binding = ((SymbolBinding) org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService
					.head(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.select(this.it.getBindings(),
							(x) -> java.util.Objects.equals((x.getSymbol()), (symbol)))));
			if ((binding) != (null)) {
				/* CASED */minijava.MapService.put(/* CASEC */this.it.getCache(), symbol, binding);
			} else {
				if (/* CASEC */this.it.getParentContext() != (null)) {
					SymbolBinding binding2 = ((SymbolBinding) /* CASEF *//* CASEC */ ((ContextOperation) emfswitch
							.doSwitch(this.it.getParentContext())).findBinding(symbol));
					/* CASED */minijava.MapService.put(/* CASEC */this.it.getCache(), symbol, binding2);
				} else {
					org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log(("No binding for symbol ") + (symbol));
				}
			}
		}
		result = this.it.getCache().get(symbol);
		return result;
	}

	public Context findCurrentContext() {
		Context result;
		if ((this.it.getChildContext()) != (null)) {
			result = /* CASEA */((emfswitch.operation.ContextOperation) emfswitch.doSwitch(this.it.getChildContext()))
					.findCurrentContext();
		} else {
			result = this.it;
		}
		return result;
	}
}
