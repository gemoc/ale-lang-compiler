package emfswitch.operation;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;

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
		if(!(MapService.containsKey((EMap) (this.it.getCache()), (Symbol) (symbol)))) {
			SymbolBinding binding = ((SymbolBinding) (CollectionService.head(CollectionService.select(this.it.getBindings(), (x) -> EqualService.equals((x.getSymbol()), (symbol))))));
			if(!EqualService.equals((binding), (null))) {
				MapService.put((EMap) (this.it.getCache()), (Symbol) (symbol), (SymbolBinding) (binding));
			}
			else {
				if(!EqualService.equals((this.it.getParentContext()), (null))) {
					SymbolBinding binding2 = ((SymbolBinding) (((ContextOperation) emfswitch.doSwitch(this.it.getParentContext())).findBinding((Symbol) (symbol))));
					MapService.put((EMap) (this.it.getCache()), (Symbol) (symbol), (SymbolBinding) (binding2));
				}
				else {
					LogService.log(("No binding for symbol ") + (symbol));
				}
			}
		}
		result = this.it.getCache().get((Symbol) (symbol));
		return result;
	}

	public Context findCurrentContext() {
		Context result;
		if(!EqualService.equals((this.it.getChildContext()), (null))) {
			result = ((ContextOperation) emfswitch.doSwitch(this.it.getChildContext())).findCurrentContext();
		}
		else {
			result = this.it;
		}
		return result;
	}
}
