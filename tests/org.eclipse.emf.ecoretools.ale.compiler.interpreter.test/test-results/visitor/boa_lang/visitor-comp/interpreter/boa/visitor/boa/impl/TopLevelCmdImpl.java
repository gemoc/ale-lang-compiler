package interpreter.boa.visitor.boa.impl;

import interpreter.boa.visitor.boa.BoaPackage;
import interpreter.boa.visitor.boa.TopLevelCmd;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public abstract class TopLevelCmdImpl extends MinimalEObjectImpl.Container implements TopLevelCmd {
	protected TopLevelCmdImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return BoaPackage.Literals.TOP_LEVEL_CMD;
	}
}
