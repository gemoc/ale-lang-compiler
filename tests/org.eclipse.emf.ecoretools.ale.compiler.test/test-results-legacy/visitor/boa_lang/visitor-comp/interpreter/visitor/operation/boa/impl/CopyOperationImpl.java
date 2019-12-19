package interpreter.visitor.operation.boa.impl;

import execboa.MapService;
import interpreter.boa.visitor.boa.BoaFactory;
import interpreter.boa.visitor.boa.Copy;
import interpreter.boa.visitor.boa.Ctx;
import interpreter.boa.visitor.boa.EvalMapRes;
import interpreter.boa.visitor.boa.EvalRes;
import interpreter.visitor.VisitorInterface;
import interpreter.visitor.operation.boa.CopyOperation;
import interpreter.visitor.operation.boa.ExprOperation;
import org.eclipse.emf.common.util.EMap;

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
			result = ((EvalMapRes) (ret));
		}
		else {
			result = ((EvalRes) (null));
		}
		return result;
	}
}
