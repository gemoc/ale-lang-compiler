package visitor.operation.testoperationbody.impl;

import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import testoperationbody.visitor.testoperationbody.ChildA;
import testoperationbody.visitor.testoperationbody.ConceptA;
import testoperationbody.visitor.testoperationbody.Main;
import testoperationbody.visitor.testoperationbody.Parent;
import testoperationbody.visitor.testoperationbody.TestoperationbodyFactory;
import visitor.VisitorInterface;
import visitor.operation.testoperationbody.ChildAOperation;
import visitor.operation.testoperationbody.MainOperation;
import visitor.operation.testoperationbody.ParentOperation;

public class MainOperationImpl implements MainOperation {
	private final Main it;

	private final VisitorInterface vis;

	public MainOperationImpl(Main it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}

	public void testPolymorphism() {
		this.it.getChildren().add(testoperationbody.visitor.testoperationbody.TestoperationbodyFactory.eINSTANCE.createChildA());
		this.it.getChildren().add(testoperationbody.visitor.testoperationbody.TestoperationbodyFactory.eINSTANCE.createChildB());
		for(Parent child: this.it.getChildren()) {
			((ParentOperation)child.accept(vis)).overriden();
			((ParentOperation)child.accept(vis)).notOverriden();
			if(child instanceof ChildA) {
				((ChildAOperation)child.accept(vis)).onlyA();
			}
		}
	}

	public void main() {
		this.it.getListint().add(1);
		this.it.getListint().remove(1);
		this.it.getListconcepta().add(testoperationbody.visitor.testoperationbody.TestoperationbodyFactory.eINSTANCE.createConceptA());
		this.it.getListconcepta().remove(testoperationbody.visitor.testoperationbody.TestoperationbodyFactory.eINSTANCE.createConceptA());
		this.it.setSinglebool(false);
		this.it.setSingleconcepta(testoperationbody.visitor.testoperationbody.TestoperationbodyFactory.eINSTANCE.createConceptA());
		int a = ((int) (1));
		ConceptA b = ((ConceptA) (TestoperationbodyFactory.eINSTANCE.createConceptA()));
		EList<String> events = ((EList<String>) (CollectionService.createEList("event1", "event2")));
		EList<Integer> ax = ((EList<Integer>) (CollectionService.createEList(1)));
		for (int i1: this.it.getListint()) {
			CollectionService.size(this.it.getListint());
			CollectionService.get(this.it.getListint(), 0);
			CollectionService.head(this.it.getListint());
			CollectionService.isEmpty(this.it.getListint());
			CollectionService.select(this.it.getListint(), (x) -> (x) > (3));
			/*Call org.eclipse.acceleo.query.ast.impl.CallImpl@413a0e39 (serviceName: exists, type: COLLECTIONCALL)*/;
		}
		for(ConceptA i2: this.it.getListconcepta()) {
			CollectionService.size(this.it.getListconcepta());
			CollectionService.get(this.it.getListconcepta(), 0);
			CollectionService.head(this.it.getListconcepta());
			CollectionService.isEmpty(this.it.getListconcepta());
			CollectionService.select(this.it.getListconcepta(), (x) -> ((visitor.operation.testoperationbody.ConceptAOperation)x.accept(vis)).op());
			/*Call org.eclipse.acceleo.query.ast.impl.CallImpl@afa0d0b (serviceName: exists, type: COLLECTIONCALL)*/;
		}
		for (String i3: events) {
			CollectionService.size(events);
			CollectionService.get(events, 0);
			CollectionService.head(events);
			CollectionService.isEmpty(events);
			CollectionService.select(events, (x) -> (x) != ("ok"));
			/*Call org.eclipse.acceleo.query.ast.impl.CallImpl@15fe6a3 (serviceName: exists, type: COLLECTIONCALL)*/;
		}
		for (Integer i4: ax) {
			CollectionService.size(ax);
			CollectionService.get(ax, 0);
			CollectionService.head(ax);
			CollectionService.isEmpty(ax);
			CollectionService.select(ax, (x) -> (x) < (0));
			/*Call org.eclipse.acceleo.query.ast.impl.CallImpl@5073fffe (serviceName: exists, type: COLLECTIONCALL)*/;
		}
		LogService.log(((MainOperation)this.it.accept(vis)).ma());
		if((((visitor.operation.testoperationbody.MainOperation)this.it.accept(vis)).ma()) < (12)) {
			LogService.log("ok");
		}
		else {
			LogService.log("fail");
		}
		int cptr = ((int) (1));
		while ((cptr) < (((visitor.operation.testoperationbody.MainOperation)this.it.accept(vis)).ma())) {
			cptr = (cptr) + (1);
		}
		boolean truz = ((boolean) (!(false)));
		boolean gt = ((boolean) ((1) > (2)));
		boolean ne = ((boolean) ((((visitor.operation.testoperationbody.MainOperation)this.it.accept(vis)).ma()) != (42)));
		int x = ((int) ((org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.get(this.it.getListint(), 0)) - (1)));
		int xd = ((int) ((43) / (3)));
		boolean eq = ((boolean) (Objects.equals((((visitor.operation.testoperationbody.MainOperation)this.it.accept(vis)).ma()), (org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.head(this.it.getListint())))));
		boolean leq = ((boolean) ((12) <= (11)));
		boolean geq = ((boolean) ((12.3) >= (11)));
		double multpl = ((double) ((12.3) * (11.4)));
		int neg = ((int) (-(xd)));
	}

	public int ma() {
		int result;
		result = 452;
		return result;
	}
}
