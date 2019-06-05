package visitor;

import imp.visitor.imp.Assign;
import imp.visitor.imp.Binary;
import imp.visitor.imp.Block;
import imp.visitor.imp.BoolValue;
import imp.visitor.imp.If;
import imp.visitor.imp.IntConst;
import imp.visitor.imp.IntValue;
import imp.visitor.imp.Skip;
import imp.visitor.imp.Store;
import imp.visitor.imp.StringToValueMap;
import imp.visitor.imp.Unary;
import imp.visitor.imp.Var;
import imp.visitor.imp.While;
import java.lang.Object;

public interface VisitorInterface {
	Object visitimp__Skip(Skip it);

	Object visitimp__Assign(Assign it);

	Object visitimp__Block(Block it);

	Object visitimp__If(If it);

	Object visitimp__While(While it);

	Object visitimp__IntConst(IntConst it);

	Object visitimp__Var(Var it);

	Object visitimp__Unary(Unary it);

	Object visitimp__Binary(Binary it);

	Object visitimp__Store(Store it);

	Object visitimp__StringToValueMap(StringToValueMap it);

	Object visitimp__IntValue(IntValue it);

	Object visitimp__BoolValue(BoolValue it);
}
