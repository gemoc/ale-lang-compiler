package visitor;

import emapvselistentry.visitor.emapvselistentry.NewEClass1;
import emapvselistentry.visitor.emapvselistentry.NewEClass2;
import emapvselistentry.visitor.emapvselistentry.NewEClass3;
import emapvselistentry.visitor.emapvselistentry.NewEClass4;
import emapvselistentry.visitor.emapvselistentry.NewEClass5;
import visitor.operation.emapvselistentry.NewEClass1Operation;
import visitor.operation.emapvselistentry.NewEClass2Operation;
import visitor.operation.emapvselistentry.NewEClass3Operation;
import visitor.operation.emapvselistentry.NewEClass4Operation;
import visitor.operation.emapvselistentry.NewEClass5Operation;
import visitor.operation.emapvselistentry.impl.NewEClass1OperationImpl;
import visitor.operation.emapvselistentry.impl.NewEClass2OperationImpl;
import visitor.operation.emapvselistentry.impl.NewEClass3OperationImpl;
import visitor.operation.emapvselistentry.impl.NewEClass4OperationImpl;
import visitor.operation.emapvselistentry.impl.NewEClass5OperationImpl;

public class VisitorImplementation implements VisitorInterface {
	public NewEClass1Operation visitemapvselistentry__NewEClass1(NewEClass1 it) {
		return new NewEClass1OperationImpl(it, this);
	}

	public NewEClass2Operation visitemapvselistentry__NewEClass2(NewEClass2 it) {
		return new NewEClass2OperationImpl(it, this);
	}

	public NewEClass3Operation visitemapvselistentry__NewEClass3(NewEClass3 it) {
		return new NewEClass3OperationImpl(it, this);
	}

	public NewEClass4Operation visitemapvselistentry__NewEClass4(NewEClass4 it) {
		return new NewEClass4OperationImpl(it, this);
	}

	public NewEClass5Operation visitemapvselistentry__NewEClass5(NewEClass5 it) {
		return new NewEClass5OperationImpl(it, this);
	}
}
