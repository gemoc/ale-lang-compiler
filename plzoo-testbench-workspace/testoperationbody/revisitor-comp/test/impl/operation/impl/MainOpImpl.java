package test.impl.operation.impl;

import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import test.impl.operation.ChildAOp;
import test.impl.operation.ChildBOp;
import test.impl.operation.ConceptAOp;
import test.impl.operation.MainOp;
import test.impl.operation.ParentOp;
import testoperationbody.ChildA;
import testoperationbody.ConceptA;
import testoperationbody.Main;
import testoperationbody.Parent;
import testoperationbody.TestoperationbodyFactory;
import testoperationbody.revisitor.TestoperationbodyRevisitor;

public class MainOpImpl implements MainOp {
  private TestoperationbodyRevisitor<ChildAOp, ChildBOp, ConceptAOp, MainOp, ParentOp> rev;

  private Main obj;

  public MainOpImpl(Main obj,
      TestoperationbodyRevisitor<ChildAOp, ChildBOp, ConceptAOp, MainOp, ParentOp> rev) {
    this.obj = obj;
    this.rev = rev;
  }

  public void testPolymorphism() {
    this.obj.getChildren().add(testoperationbody.TestoperationbodyFactory.eINSTANCE.createChildA());
    this.obj.getChildren().add(testoperationbody.TestoperationbodyFactory.eINSTANCE.createChildB());
    for(Parent child: this.obj.getChildren()) {
      rev.$((Parent)child).overriden();
      rev.$((Parent)child).notOverriden();
      if(child instanceof ChildA) {
        rev.$((ChildA)child).onlyA();
      }
    }
  }

  public void main() {
    this.obj.getListint().add(1);
    this.obj.getListint().remove(1);
    this.obj.getListconcepta().add(testoperationbody.TestoperationbodyFactory.eINSTANCE.createConceptA());
    this.obj.getListconcepta().remove(testoperationbody.TestoperationbodyFactory.eINSTANCE.createConceptA());
    this.obj.setSinglebool(false);
    this.obj.setSingleconcepta(testoperationbody.TestoperationbodyFactory.eINSTANCE.createConceptA());
    int a = ((int) (1));
    ConceptA b = ((ConceptA) (TestoperationbodyFactory.eINSTANCE.createConceptA()));
    EList<String> events = ((EList<String>) (CollectionService.createEList("event1", "event2")));
    EList<Integer> ax = ((EList<Integer>) (CollectionService.createEList(1)));
    for(int i1: this.obj.getListint()) {
      CollectionService.size(this.obj.getListint());
      CollectionService.get(this.obj.getListint(), 0);
      CollectionService.head(this.obj.getListint());
      CollectionService.isEmpty(this.obj.getListint());
      CollectionService.select(this.obj.getListint(), (x) -> (x) > (3));
      CollectionService.exists(this.obj.getListint(), (x) -> (x) > (3));
    }
    for(ConceptA i2: this.obj.getListconcepta()) {
      CollectionService.size(this.obj.getListconcepta());
      CollectionService.get(this.obj.getListconcepta(), 0);
      CollectionService.head(this.obj.getListconcepta());
      CollectionService.isEmpty(this.obj.getListconcepta());
      CollectionService.select(this.obj.getListconcepta(), (x) -> rev.$((ConceptA)x).op());
      CollectionService.exists(this.obj.getListconcepta(), (x) -> rev.$((ConceptA)x).op());
    }
    for(String i3: events) {
      CollectionService.size(events);
      CollectionService.get(events, 0);
      CollectionService.head(events);
      CollectionService.isEmpty(events);
      CollectionService.select(events, (x) -> (x) != ("ok"));
      CollectionService.exists(events, (x) -> (x) != ("ok"));
    }
    for(Integer i4: ax) {
      CollectionService.size(ax);
      CollectionService.get(ax, 0);
      CollectionService.head(ax);
      CollectionService.isEmpty(ax);
      CollectionService.select(ax, (x) -> (x) < (0));
      CollectionService.exists(ax, (x) -> (x) < (0));
    }
    LogService.log(rev.$((Main)this.obj).ma());
    if((rev.$((Main)this.obj).ma()) < (12)) {
      LogService.log("ok");
    }
    else {
      LogService.log("fail");
    }
    int cptr = ((int) (1));
    while ((cptr) < (rev.$((Main)this.obj).ma())) {
      cptr = (cptr) + (1);
    }
    boolean truz = ((boolean) (!(false)));
    boolean gt = ((boolean) ((1) > (2)));
    boolean ne = ((boolean) ((rev.$((Main)this.obj).ma()) != (42)));
    int x = ((int) ((CollectionService.get(this.obj.getListint(), 0)) - (1)));
    int xd = ((int) ((43) / (3)));
    boolean eq = ((boolean) (Objects.equals((rev.$((Main)this.obj).ma()), (CollectionService.head(this.obj.getListint())))));
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
