package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Children;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import java.lang.Override;
import java.util.Collection;
import kmLogo.interpreter.kmLogo.Expression;
import kmLogo.interpreter.kmLogo.KmLogoFactory;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.ProcCall;
import kmLogo.interpreter.kmLogo.ProcDeclaration;
import kmLogo.interpreter.kmLogo.StackFrame;
import kmLogo.interpreter.kmLogo.Turtle;
import kmLogo.interpreter.kmLogo.Variable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;

@NodeInfo(
		description = "ProcCall"
)
public class ProcCallImpl extends ExpressionImpl implements ProcCall {
	protected EList<Expression> actualArgs;

	protected ProcDeclaration declaration;

	@Children
	private Expression[] actualArgsArr;

	protected ProcCallImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.PROC_CALL;
	}

	@TruffleBoundary
	public EList<Expression> getActualArgs() {
		if (actualArgs == null) {
			actualArgs = new EObjectContainmentEList<Expression>(Expression.class, this, KmLogoPackage.PROC_CALL__ACTUAL_ARGS);
		}
		return actualArgs;
	}

	@TruffleBoundary
	public ProcDeclaration getDeclaration() {
		if (declaration != null && declaration.eIsProxy()) {
			InternalEObject oldDeclaration = (InternalEObject) declaration;
			declaration = (ProcDeclaration) eResolveProxy(oldDeclaration);
			if (declaration != oldDeclaration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KmLogoPackage.PROC_CALL__DECLARATION, oldDeclaration, declaration));
			}
		}
		return declaration;
	}

	public ProcDeclaration basicGetDeclaration() {
		return declaration;
	}

	@TruffleBoundary
	public NotificationChain basicSetDeclaration(ProcDeclaration newDeclaration,
			NotificationChain msgs) {
		ProcDeclaration oldDeclaration = declaration;
		declaration = newDeclaration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KmLogoPackage.PROC_CALL__DECLARATION, oldDeclaration, newDeclaration);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setDeclaration(ProcDeclaration newDeclaration) {
		if (newDeclaration != declaration) {
			NotificationChain msgs = null;
			if (declaration != null)
				msgs = ((InternalEObject) declaration).eInverseRemove(this, KmLogoPackage.PROC_DECLARATION__PROC_CALL, ProcDeclaration.class, msgs);
			if (newDeclaration != null)
				msgs = ((InternalEObject) newDeclaration).eInverseAdd(this, KmLogoPackage.PROC_DECLARATION__PROC_CALL, ProcDeclaration.class, msgs);
			msgs = basicSetDeclaration(newDeclaration, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.PROC_CALL__DECLARATION, newDeclaration, newDeclaration));
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case KmLogoPackage.PROC_CALL__DECLARATION :
				if (declaration != null)
					msgs = ((InternalEObject) declaration).eInverseRemove(this, KmLogoPackage.PROC_DECLARATION__PROC_CALL, ProcDeclaration.class, msgs);
				return basicSetDeclaration((ProcDeclaration) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case KmLogoPackage.PROC_CALL__ACTUAL_ARGS :
				return ((InternalEList<?>) getActualArgs()).basicRemove(otherEnd, msgs);
			case KmLogoPackage.PROC_CALL__DECLARATION :
				return basicSetDeclaration(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KmLogoPackage.PROC_CALL__ACTUAL_ARGS :
				return getActualArgs();
			case KmLogoPackage.PROC_CALL__DECLARATION :
				if (resolve)
					return getDeclaration();
				return basicGetDeclaration();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case KmLogoPackage.PROC_CALL__ACTUAL_ARGS :
				getActualArgs().clear();
				getActualArgs().addAll((Collection<? extends Expression>) newValue);
				return;
			case KmLogoPackage.PROC_CALL__DECLARATION :
				setDeclaration((ProcDeclaration) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case KmLogoPackage.PROC_CALL__ACTUAL_ARGS :
				getActualArgs().clear();
				return;
			case KmLogoPackage.PROC_CALL__DECLARATION :
				setDeclaration((ProcDeclaration) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case KmLogoPackage.PROC_CALL__ACTUAL_ARGS :
				return actualArgs != null && !actualArgs.isEmpty();
			case KmLogoPackage.PROC_CALL__DECLARATION :
				return declaration != null;
		}
		return super.eIsSet(featureID);
	}

	public double eval(Turtle turtle) {
		double result;
		if (this.actualArgsArr == null) {
			CompilerDirectives.transferToInterpreterAndInvalidate();
			if (this.actualArgs != null) this.actualArgsArr = this.actualArgs.toArray(new Expression[0]);
			else this.actualArgsArr = new Expression[] {};
		}
		LogService.log(("Calling ") + (this.getDeclaration().getName()));
		StackFrame newFrame = ((StackFrame) (KmLogoFactory.eINSTANCE.createStackFrame()));
		int i = ((int) (0));
		for (Expression exp : this.actualArgsArr) {
			Variable newVar = ((Variable) (KmLogoFactory.eINSTANCE.createVariable()));
			newVar.setName(CollectionService.get(this.getDeclaration().getArgs(), i).getName());
			newVar.setValue(((Expression) (exp)).eval((Turtle) (turtle)));
			newFrame.getVariables().add(newVar);
			i = (i) + (1);
		}
		turtle.getCallStack().getFrames().add(newFrame);
		result = (double) (0.0) ;
		if (this.getDeclaration() instanceof ProcDeclaration) {
			ProcDeclaration decl = ((ProcDeclaration) (this.getDeclaration()));
			((ProcDeclaration) (decl)).eval((Turtle) (turtle));
		}
		turtle.getCallStack().getFrames().remove(newFrame);

		return result;
	}
}
