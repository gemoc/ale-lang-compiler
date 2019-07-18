package interpreter.boa.interpreter.boa.impl;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Children;
import com.oracle.truffle.api.nodes.NodeInfo;
import interpreter.boa.interpreter.boa.BoaFactory;
import interpreter.boa.interpreter.boa.BoaPackage;
import java.lang.Object;
import java.lang.Override;
import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecoretools.ale.compiler.truffle.MinimalTruffleEObjectImpl;

@NodeInfo(
		description = "File"
)
public class FileImpl extends MinimalTruffleEObjectImpl.TruffleContainer {
	protected EList<TopLevelCmdImpl> commands;

	@Children
	private TopLevelCmdImpl[] commandsArr;

	protected FileImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return BoaPackage.Literals.FILE;
	}

	@TruffleBoundary
	public EList<TopLevelCmdImpl> getCommands() {
		if (commands == null) {
			commands = new EObjectContainmentEList<TopLevelCmdImpl>(TopLevelCmdImpl.class, this, BoaPackage.FILE__COMMANDS);
		}
		return commands;
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case BoaPackage.FILE__COMMANDS :
				return ((InternalEList<?>) getCommands()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BoaPackage.FILE__COMMANDS :
				return getCommands();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BoaPackage.FILE__COMMANDS :
				getCommands().clear();
				getCommands().addAll((Collection<? extends TopLevelCmdImpl>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case BoaPackage.FILE__COMMANDS :
				getCommands().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BoaPackage.FILE__COMMANDS :
				return commands != null && !commands.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	public void eval() {
		if (this.commandsArr == null) {
			CompilerDirectives.transferToInterpreterAndInvalidate();
			if (this.commands != null) this.commandsArr = this.commands.toArray(new TopLevelCmdImpl[0]);
			else this.commandsArr = new TopLevelCmdImpl[] {};
		}
		CtxImpl ctx = ((CtxImpl) (BoaFactory.eINSTANCE.createCtx()));
		for (TopLevelCmdImpl it : this.commandsArr) {
			((TopLevelCmdImpl) (it)).nextLine((CtxImpl) (ctx));
		}

	}
}
