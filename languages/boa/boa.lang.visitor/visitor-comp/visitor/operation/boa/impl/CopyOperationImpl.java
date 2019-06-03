package visitor.operation.boa.impl;

import boa.visitor.boa.BoaFactory;
import boa.visitor.boa.Copy;
import boa.visitor.boa.Ctx;
import boa.visitor.boa.EvalMapRes;
import boa.visitor.boa.EvalRes;
import execboa.MapService;
import org.eclipse.emf.common.util.EMap;
import visitor.VisitorInterface;
import visitor.operation.boa.CopyOperation;
import visitor.operation.boa.ExprOperation;

public class CopyOperationImpl extends ExprOperationImpl implements CopyOperation {
	private final Copy it;

	private final VisitorInterface vis;

	public CopyOperationImpl(Copy it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalRes vcopy = ((EvalRes) (((ExprOperation)this.it.getCopy().accept(vis)).eval((Ctx) (ctx))));
		if(vcopy instanceof EvalMapRes) {
			EvalMapRes mvcopy = ((EvalMapRes) (vcopy));
			EvalMapRes ret = ((EvalMapRes) (BoaFactory.eINSTANCE.createEvalMapRes()));
			MapService.putAll((EMap) (ret.getValues()), (EMap) (mvcopy.getValues()));
			result = ret;
		}
		else {
			result = null;
		}
		return result;
	}
}
