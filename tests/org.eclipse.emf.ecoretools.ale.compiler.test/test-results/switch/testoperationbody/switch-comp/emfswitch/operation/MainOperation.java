package emfswitch.operation;

import emfswitch.SwitchImplementation;
import java.lang.Integer;
import java.lang.String;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import testoperationbody.ChildA;
import testoperationbody.ConceptA;
import testoperationbody.Main;
import testoperationbody.Parent;
import testoperationbody.TestoperationbodyFactory;

public class MainOperation {
	private final Main it;

	private final SwitchImplementation emfswitch;

	public MainOperation(Main it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void testPolymorphism() {
		this.it.getChildren().add(TestoperationbodyFactory.eINSTANCE.createChildA());
		this.it.getChildren().add(TestoperationbodyFactory.eINSTANCE.createChildB());
		for (Parent child: this.it.getChildren()) {
			((ParentOperation) emfswitch.doSwitch(child)).overriden();
			((ParentOperation) emfswitch.doSwitch(child)).notOverriden();
			if(child instanceof ChildA) {
				((ChildAOperation) emfswitch.doSwitch(child)).onlyA();
			}
		}
	}

	public void main() {
		this.it.getListint().add(1);
		this.it.getListint().remove(1);
		this.it.getListconcepta().add(TestoperationbodyFactory.eINSTANCE.createConceptA());
		this.it.getListconcepta().remove(TestoperationbodyFactory.eINSTANCE.createConceptA());
		this.it.setSinglebool(false);
		this.it.setSingleconcepta(TestoperationbodyFactory.eINSTANCE.createConceptA());
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
			CollectionService.exists(this.it.getListint(), (x) -> (x) > (3));
		}
		for (ConceptA i2: this.it.getListconcepta()) {
			CollectionService.size(this.it.getListconcepta());
			CollectionService.get(this.it.getListconcepta(), 0);
			CollectionService.head(this.it.getListconcepta());
			CollectionService.isEmpty(this.it.getListconcepta());
			CollectionService.select(this.it.getListconcepta(), (x) -> ((ConceptAOperation) emfswitch.doSwitch(x)).op());
			CollectionService.exists(this.it.getListconcepta(), (x) -> ((ConceptAOperation) emfswitch.doSwitch(x)).op());
		}
		for (String i3: events) {
			CollectionService.size(events);
			CollectionService.get(events, 0);
			CollectionService.head(events);
			CollectionService.isEmpty(events);
			CollectionService.select(events, (x) -> !EqualService.equals((x), ("ok")));
			CollectionService.exists(events, (x) -> !EqualService.equals((x), ("ok")));
		}
		for (Integer i4: ax) {
			CollectionService.size(ax);
			CollectionService.get(ax, 0);
			CollectionService.head(ax);
			CollectionService.isEmpty(ax);
			CollectionService.select(ax, (x) -> (x) < (0));
			CollectionService.exists(ax, (x) -> (x) < (0));
		}
		LogService.log(((MainOperation) emfswitch.doSwitch(this.it)).ma());
		if((((MainOperation) emfswitch.doSwitch(this.it)).ma()) < (12)) {
			LogService.log("ok");
		}
		else {
			LogService.log("fail");
		}
		int cptr = ((int) (1));
		while ((cptr) < (((MainOperation) emfswitch.doSwitch(this.it)).ma())) {
			cptr = (cptr) + (1);
		}
		boolean truz = ((boolean) (!(false)));
		boolean gt = ((boolean) ((1) > (2)));
		boolean ne = ((boolean) (!EqualService.equals((((MainOperation) emfswitch.doSwitch(this.it)).ma()), (42))));
		int x = ((int) ((CollectionService.get(this.it.getListint(), 0)) - (1)));
		int xd = ((int) ((43) / (3)));
		boolean eq = ((boolean) (EqualService.equals((((MainOperation) emfswitch.doSwitch(this.it)).ma()), (CollectionService.head(this.it.getListint())))));
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
