package emfswitch.operation;

import emfswitch.SwitchImplementation;
import execboa.MapService;
import java.lang.Boolean;
import java.lang.Integer;
import miniJava.Clazz;
import miniJava.Member;
import miniJava.Method;
import miniJava.Parameter;
import miniJava.State;
import miniJava.TypeRef;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

public class MethodOperation extends MemberOperation {
	private final Method it;

	private final SwitchImplementation emfswitch;

	public MethodOperation(Method it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void evaluateStatement(State state) {
		((BlockOperation) emfswitch.doSwitch(this.it.getBody())).evaluateStatement((State) (state));
	}

	public Method findOverride(Clazz c) {
		Method result;
		if(!(MapService.containsKey((EMap) (this.it.getCache()), (Clazz) (c)))) {
			Method that = ((Method) (this.it));
			if(CollectionService.exists(c.getMembers(), (x) -> EqualService.equals((x), (that)))) {
				result = ((Method) (this.it));
			}
			else {
				int i = ((int) (0));
				Method found = ((Method) (null));
				while ((((i) < (CollectionService.size(c.getMembers()))) && (EqualService.equals((found), (null))))) {
					Member tmpm = ((Member) (CollectionService.get(c.getMembers(), i)));
					if(tmpm instanceof Method) {
						Method m = ((Method) (tmpm));
						if(((EqualService.equals((m.getName()), (this.it.getName()))) && (EqualService.equals((CollectionService.size(m.getParams())), (CollectionService.size(this.it.getParams())))))) {
							boolean compared = ((boolean) (((TypeRefOperation) emfswitch.doSwitch(m.getTypeRef())).compare((TypeRef) (this.it.getTypeRef()))));
							int j = ((int) (0));
							int paramlgt = ((int) (CollectionService.size(m.getParams())));
							boolean alltrue = ((boolean) (compared));
							while ((((j) < (paramlgt)) && (alltrue))) {
								Parameter p1 = ((Parameter) (CollectionService.get(m.getParams(), j)));
								Parameter tmpp = ((Parameter) (CollectionService.head(CollectionService.select(this.it.getParams(), (p2) -> ((ParameterOperation) emfswitch.doSwitch(p1)).compare((Parameter) (p2))))));
								alltrue = ((Boolean) (!EqualService.equals((tmpp), (null))));
								j = ((Integer) ((j) + (1)));
							}
							if(alltrue) {
								found = ((Method) (m));
							}
						}
					}
					i = ((Integer) ((i) + (1)));
				}
				if(!EqualService.equals((found), (null))) {
					result = ((Method) (found));
				}
				else {
					if(!EqualService.equals((c.getSuperClass()), (null))) {
						result = ((Method) (((MethodOperation) emfswitch.doSwitch(this.it)).findOverride((Clazz) (c.getSuperClass()))));
					}
					else {
						result = ((Method) (null));
					}
				}
			}
			MapService.put((EMap) (this.it.getCache()), (Clazz) (c), (Method) (result));
		}
		else {
			result = ((Method) (MapService.getFromMap((EMap) (this.it.getCache()), (Clazz) (c))));
		}
		return result;
	}

	public void call(State state) {
		((BlockOperation) emfswitch.doSwitch(this.it.getBody())).evaluateStatement((State) (state));
	}
}
