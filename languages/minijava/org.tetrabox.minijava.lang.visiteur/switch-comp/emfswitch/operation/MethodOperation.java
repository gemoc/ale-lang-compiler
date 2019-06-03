package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.Clazz;
import miniJava.Member;
import miniJava.Method;
import miniJava.Parameter;
import miniJava.State;
import minijava.MapService;

public class MethodOperation extends MemberOperation {
	private final Method it;

	private final SwitchImplementation emfswitch;

	public MethodOperation(Method it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void evaluateStatement(State state) {
		/* CASEA */((emfswitch.operation.BlockOperation) emfswitch.doSwitch(this.it.getBody()))
				.evaluateStatement(state);
	}

	public Method findOverride(Clazz c) {
		Method result;
		if (!(/* CASED */minijava.MapService.containsKey(/* CASEC */this.it.getCache(), c))) {
			Method that = ((Method) this.it);
			if (org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.exists(c.getMembers(),
					(x) -> java.util.Objects.equals((x), (that)))) {
				result = this.it;
			} else {
				int i = ((int) 0);
				Method found = ((Method) null);
				while ((((i) < (org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(c.getMembers())))
						&& (java.util.Objects.equals((found), (null))))) {
					Member tmpm = ((Member) org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService
							.get(c.getMembers(), i));
					if (tmpm instanceof miniJava.Method) {
						Method m = ((Method) tmpm);
						if (((java.util.Objects.equals((m.getName()), (this.it.getName())))
								&& (java.util.Objects.equals(
										(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService
												.size(m.getParams())),
										(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService
												.size(this.it.getParams())))))) {
							boolean compared = ((boolean) /* CASEA */((emfswitch.operation.TypeRefOperation) emfswitch
									.doSwitch(m.getTypeRef())).compare(this.it.getTypeRef()));
							int j = ((int) 0);
							int paramlgt = ((int) org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService
									.size(m.getParams()));
							boolean alltrue = ((boolean) compared);
							while ((((j) < (paramlgt)) && (alltrue))) {
								Parameter p1 = ((Parameter) org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService
										.get(m.getParams(), j));
								Parameter tmpp = ((Parameter) org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService
										.head(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.select(
												this.it.getParams(),
												(p2) -> /* CASEA */((emfswitch.operation.ParameterOperation) emfswitch
														.doSwitch(p1)).compare(p2))));
								alltrue = (tmpp) != (null);
								j = (j) + (1);
							}
							if (alltrue) {
								found = m;
							}
						}
					}
					i = (i) + (1);
				}
				if ((found) != (null)) {
					result = found;
				} else {
					if ((c.getSuperClass()) != (null)) {
						result = /* CASEA */((emfswitch.operation.MethodOperation) emfswitch.doSwitch(this.it))
								.findOverride(c.getSuperClass());
					} else {
						result = null;
					}
				}
			}
			/* CASED */minijava.MapService.put(/* CASEC */this.it.getCache(), c, result);
		} else {
			result = this.it.getCache().get(c);
		}
		return result;
	}

	public void call(State state) {
		/* CASEA */((emfswitch.operation.BlockOperation) emfswitch.doSwitch(this.it.getBody()))
				.evaluateStatement(state);
	}
}
