package miniJava.interpreter.miniJava.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import miniJava.interpreter.miniJava.Block;
import miniJava.interpreter.miniJava.Frame;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.Statement;

public class BlockImpl extends StatementImpl implements Block {
	protected EList<Statement> statements;

	protected BlockImpl() {
		super();
	}

	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MiniJavaPackage.BLOCK__STATEMENTS:
			return getStatements();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MiniJavaPackage.BLOCK__STATEMENTS:
			return ((InternalEList<?>) getStatements()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case MiniJavaPackage.BLOCK__STATEMENTS:
			return statements != null && !statements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case MiniJavaPackage.BLOCK__STATEMENTS:
			getStatements().clear();
			getStatements().addAll((Collection<? extends Statement>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.BLOCK;
	}

	public void eUnset(int featureID) {
		switch (featureID) {
		case MiniJavaPackage.BLOCK__STATEMENTS:
			getStatements().clear();
			return;
		}
		super.eUnset(featureID);
	}

	public void evaluateStatement(State state) {
		this.evaluateStatementKeepContext(state);
		state.popCurrentContext();
		;
	}

	public void evaluateStatementKeepContext(State state) {
		state.pushNewContext();
		Frame currentFrame = ((Frame) state.findCurrentFrame());
		int lgt = ((int) org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(this.getStatements()));
		int i = ((int) 0);
		while ((((i) < (lgt)) && (java.util.Objects.equals((currentFrame.getReturnValue()), (null))))) {
			org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.get(this.getStatements(), i)
					.evaluateStatement(state);
			i = (i) + (1);
		}
		;
	}

	public EList<Statement> getStatements() {
		if (statements == null) {
			statements = new EObjectContainmentEList<Statement>(Statement.class, this,
					MiniJavaPackage.BLOCK__STATEMENTS);
		}
		return statements;
	}
}
