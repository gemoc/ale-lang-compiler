package imp.visitor.imp.impl;

import imp.visitor.imp.Block;
import imp.visitor.imp.ImpPackage;
import imp.visitor.imp.Stmt;
import java.lang.Object;
import java.lang.Override;
import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import visitor.VisitorInterface;

public class BlockImpl extends StmtImpl implements Block {
	protected EList<Stmt> stmts;

	protected BlockImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return ImpPackage.Literals.BLOCK;
	}

	public EList<Stmt> getStmts() {
		if (stmts == null) {
			stmts = new EObjectContainmentEList<Stmt>(Stmt.class, this, ImpPackage.BLOCK__STMTS);
		}
		return stmts;
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case ImpPackage.BLOCK__STMTS :
				return ((InternalEList<?>) getStmts()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImpPackage.BLOCK__STMTS :
				return getStmts();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ImpPackage.BLOCK__STMTS :
				getStmts().clear();
				getStmts().addAll((Collection<? extends Stmt>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ImpPackage.BLOCK__STMTS :
				getStmts().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ImpPackage.BLOCK__STMTS :
				return stmts != null && !stmts.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitimp__Block(this);
	}
}
