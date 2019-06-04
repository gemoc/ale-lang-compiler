package visitor.operation.boa.impl;

import boa.visitor.boa.BObject;
import boa.visitor.boa.BoaFactory;
import boa.visitor.boa.Ctx;
import boa.visitor.boa.EvalMapRes;
import boa.visitor.boa.EvalRes;
import boa.visitor.boa.Field;
import execboa.MapService;
import java.lang.String;
import org.eclipse.emf.common.util.EMap;
import visitor.VisitorInterface;
import visitor.operation.boa.BObjectOperation;
import visitor.operation.boa.ExprOperation;

public class BObjectOperationImpl extends ExprOperationImpl implements BObjectOperation {
	private final BObject it;

	private final VisitorInterface vis;

	public BObjectOperationImpl(BObject it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalMapRes ret = ((EvalMapRes) (BoaFactory.eINSTANCE.createEvalMapRes()));
		for(Field x: this.it.getFields()) {
			EvalRes v = ((EvalRes) (((ExprOperation)x.getValue().accept(vis)).eval((Ctx) (ctx))));
			MapService.put((EMap) (ret.getValues()), (String) (x.getName()), (EvalRes) (v));
		}
		result = ((EvalMapRes) (ret));
		return result;
	}
}
