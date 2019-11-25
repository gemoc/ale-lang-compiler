package interpreter.boa.interpreter.boa.impl;

import interpreter.boa.interpreter.boa.BoaPackage;
import interpreter.boa.interpreter.boa.Ctx;
import interpreter.boa.interpreter.boa.TopLevelCmd;
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

	public void nextLine(Ctx ctx) {
	}
}
