package interpreter.boa.interpreter.boa.impl;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Children;
import com.oracle.truffle.api.nodes.NodeInfo;
import execboa.MapService;
import interpreter.boa.interpreter.boa.BoaFactory;
import interpreter.boa.interpreter.boa.BoaPackage;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

@NodeInfo(
		description = "BObject"
)
public class BObjectImpl extends ExprImpl {
	protected EList<FieldImpl> fields;

	@Children
	private FieldImpl[] fieldsArr;

	protected BObjectImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return BoaPackage.Literals.BOBJECT;
	}

	@TruffleBoundary
	public EList<FieldImpl> getFields() {
		if (fields == null) {
			fields = new EObjectContainmentEList<FieldImpl>(FieldImpl.class, this, BoaPackage.BOBJECT__FIELDS);
		}
		return fields;
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case BoaPackage.BOBJECT__FIELDS :
				return ((InternalEList<?>) getFields()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BoaPackage.BOBJECT__FIELDS :
				return getFields();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BoaPackage.BOBJECT__FIELDS :
				getFields().clear();
				getFields().addAll((Collection<? extends FieldImpl>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case BoaPackage.BOBJECT__FIELDS :
				getFields().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BoaPackage.BOBJECT__FIELDS :
				return fields != null && !fields.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	public EvalResImpl eval(CtxImpl ctx) {
		EvalResImpl result;
		if (this.fieldsArr == null) {
			CompilerDirectives.transferToInterpreterAndInvalidate();
			if (this.fields != null) this.fieldsArr = this.fields.toArray(new FieldImpl[0]);
			else this.fieldsArr = new FieldImpl[] {};
		}
		EvalMapResImpl ret = ((EvalMapResImpl) (BoaFactory.eINSTANCE.createEvalMapRes()));
		for (FieldImpl x : this.fieldsArr) {
			EvalResImpl v = ((EvalResImpl) (((ExprImpl) (x.getValue())).eval((CtxImpl) (ctx))));
			MapService.put((EMap) (ret.getValues()), (String) (x.getName()), (EvalResImpl) (v));
		}
		result = (EvalResImpl) (ret) ;

		return result;
	}
}
