package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Children;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import java.lang.Override;
import java.util.Collection;
import miniJava.interpreter.miniJava.Block;
import miniJava.interpreter.miniJava.Frame;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.Statement;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

@NodeInfo(
		description = "Block"
)
public class BlockImpl extends StatementImpl implements Block {
	protected EList<Statement> statements;

	@Children
	private Statement[] statementsArr;

	protected BlockImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.BLOCK;
	}

	@TruffleBoundary
	public EList<Statement> getStatements() {
		if (statements == null) {
			statements = new EObjectContainmentEList<Statement>(Statement.class, this, MiniJavaPackage.BLOCK__STATEMENTS);
		}
		return statements;
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case MiniJavaPackage.BLOCK__STATEMENTS :
				return ((InternalEList<?>) getStatements()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MiniJavaPackage.BLOCK__STATEMENTS :
				return getStatements();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MiniJavaPackage.BLOCK__STATEMENTS :
				getStatements().clear();
				getStatements().addAll((Collection<? extends Statement>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.BLOCK__STATEMENTS :
				getStatements().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.BLOCK__STATEMENTS :
				return statements != null && !statements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	public void evaluateStatementKeepContext(State state) {
		if (this.statementsArr == null) {
			CompilerDirectives.transferToInterpreterAndInvalidate();
			if (this.statements != null) this.statementsArr = this.statements.toArray(new Statement[0]);
			else this.statementsArr = new Statement[] {};
		}
		((State) (state)).pushNewContext();
		Frame currentFrame = ((Frame) (((State) (state)).findCurrentFrame()));
		int lgt = ((int) (CollectionService.size(this.statementsArr)));
		int i = ((int) (0));
		while ((((i) < (lgt)) && (EqualService.equals((currentFrame.getReturnValue()), (null))))) {
			((Statement) (CollectionService.get(this.statementsArr, i))).evaluateStatement((State) (state));
			i = (i) + (1);
		}

	}

	public void evaluateStatement(State state) {
		if (this.statementsArr == null) {
			CompilerDirectives.transferToInterpreterAndInvalidate();
			if (this.statements != null) this.statementsArr = this.statements.toArray(new Statement[0]);
			else this.statementsArr = new Statement[] {};
		}
		((Block) (this)).evaluateStatementKeepContext((State) (state));
		((State) (state)).popCurrentContext();

	}
}
