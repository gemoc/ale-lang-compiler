package visitor.operation.miniJava.impl;

import miniJava.visitor.miniJava.Context;
import miniJava.visitor.miniJava.Symbol;
import miniJava.visitor.miniJava.SymbolBinding;
import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import visitor.VisitorInterface;
import visitor.operation.miniJava.ContextOperation;

public class ContextOperationImpl implements ContextOperation {
	private final Context it;

	private final VisitorInterface vis;

	public ContextOperationImpl(Context it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}

	public SymbolBinding findBinding(Symbol symbol) {
		SymbolBinding result;
		if(!(minijava.MapService.containsKey(this.it.getCache(), symbol))) {
			SymbolBinding binding = ((SymbolBinding) (CollectionService.head(CollectionService.select(this.it.getBindings(), (x) -> EqualService.equals((x.getSymbol()), (symbol))))));
			if(!EqualService.equals((binding), (null))) {
				minijava.MapService.put(this.it.getCache(), symbol, binding);
			}
			else {
				if(!EqualService.equals((this.it.getParentContext()), (null))) {
					SymbolBinding binding2 = ((SymbolBinding) (this.it.getParentContext().findBinding(symbol)));
					minijava.MapService.put(this.it.getCache(), symbol, binding2);
				}
				else {
					LogService.log(("No binding for symbol ") + (symbol));
				}
			}
		}
		result = this.it.getCache().get(symbol);
		return result;
	}

	public Context findCurrentContext() {
		Context result;
		if(!EqualService.equals((this.it.getChildContext()), (null))) {
			result = ((ContextOperation)this.it.getChildContext().accept(vis)).findCurrentContext();
		}
		else {
			result = this.it;
		}
		return result;
	}
}
