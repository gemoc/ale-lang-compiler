package interpreter.boa.interpreter.boa.impl;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Children;
import com.oracle.truffle.api.nodes.NodeInfo;
import execboa.MapService;
import interpreter.boa.interpreter.boa.BObject;
import interpreter.boa.interpreter.boa.BoaFactory;
import interpreter.boa.interpreter.boa.BoaPackage;
import interpreter.boa.interpreter.boa.Ctx;
import interpreter.boa.interpreter.boa.EvalMapRes;
import interpreter.boa.interpreter.boa.EvalRes;
import interpreter.boa.interpreter.boa.Expr;
import interpreter.boa.interpreter.boa.Field;
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
public class BObjectImpl extends ExprImpl implements BObject {
	protected EList<Field> fields;

	@Children
	private Field[] fieldsArr;

	protected BObjectImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return BoaPackage.Literals.BOBJECT;
	}

	@TruffleBoundary
	public EList<Field> getFields() {
		if (fields == null) {
			fields = new EObjectContainmentEList<Field>(Field.class, this, BoaPackage.BOBJECT__FIELDS);
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
				getFields().addAll((Collection<? extends Field>) newValue);
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

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		if (this.fieldsArr == null) {
			CompilerDirectives.transferToInterpreterAndInvalidate();
			if (this.fields != null) this.fieldsArr = this.fields.toArray(new Field[0]);
			else this.fieldsArr = new Field[] {};
		}
		EvalMapRes ret = ((EvalMapRes) (BoaFactory.eINSTANCE.createEvalMapRes()));
		for (Field x : this.fieldsArr) {
			EvalRes v = ((EvalRes) (((Expr) (x.getValue())).eval((Ctx) (ctx))));
			MapService.put((EMap) (ret.getValues()), (String) (x.getName()), (EvalRes) (v));
		}
		result = (EvalRes) (ret) ;

		return result;
	}
}
