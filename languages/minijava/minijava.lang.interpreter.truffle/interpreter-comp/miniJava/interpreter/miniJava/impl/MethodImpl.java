package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.Node.Children;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.util.Collection;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

@NodeInfo(
		description = "Method"
)
public class MethodImpl extends MemberImpl {
	protected static final boolean ISABSTRACT_EDEFAULT = false;

	protected static final boolean ISSTATIC_EDEFAULT = false;

	protected boolean isabstract = ISABSTRACT_EDEFAULT;

	protected boolean isstatic = ISSTATIC_EDEFAULT;

	protected EList<ParameterImpl> params;

	@Child
	protected BlockImpl body;

	protected EMap<ClazzImpl, MethodImpl> cache;

	@Children
	private ParameterImpl[] paramsArr;

	protected MethodImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.METHOD;
	}

	@TruffleBoundary
	public boolean isIsabstract() {
		return isabstract;
	}

	@TruffleBoundary
	public void setIsabstract(boolean newIsabstract) {
		boolean oldIsabstract = isabstract;
		isabstract = newIsabstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.METHOD__ISABSTRACT, oldIsabstract, isabstract));
	}

	@TruffleBoundary
	public boolean isIsstatic() {
		return isstatic;
	}

	@TruffleBoundary
	public void setIsstatic(boolean newIsstatic) {
		boolean oldIsstatic = isstatic;
		isstatic = newIsstatic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.METHOD__ISSTATIC, oldIsstatic, isstatic));
	}

	@TruffleBoundary
	public EList<ParameterImpl> getParams() {
		if (params == null) {
			params = new EObjectContainmentEList<ParameterImpl>(ParameterImpl.class, this, MiniJavaPackage.METHOD__PARAMS);
		}
		return params;
	}

	@TruffleBoundary
	public BlockImpl getBody() {
		return body;
	}

	@TruffleBoundary
	public NotificationChain basicSetBody(BlockImpl newBody, NotificationChain msgs) {
		BlockImpl oldBody = body;
		body = newBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniJavaPackage.METHOD__BODY, oldBody, newBody);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setBody(BlockImpl newBody) {
		if (newBody != body) {
			NotificationChain msgs = null;
			if (body != null)
				msgs = ((InternalEObject) body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.METHOD__BODY, null, msgs);
			if (newBody != null)
				msgs = ((InternalEObject) newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.METHOD__BODY, null, msgs);
			msgs = basicSetBody(newBody, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.METHOD__BODY, newBody, newBody));
	}

	@TruffleBoundary
	public EMap<ClazzImpl, MethodImpl> getCache() {
		if (cache == null) {
			cache = new EcoreEMap<ClazzImpl, MethodImpl>(MiniJavaPackage.Literals.CLAZZ_TO_METHOD_MAP, ClazzToMethodMapImpl.class, this, MiniJavaPackage.METHOD__CACHE);
		}
		return cache;
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case MiniJavaPackage.METHOD__PARAMS :
				return ((InternalEList<?>) getParams()).basicRemove(otherEnd, msgs);
			case MiniJavaPackage.METHOD__BODY :
				return basicSetBody(null, msgs);
			case MiniJavaPackage.METHOD__CACHE :
				return ((InternalEList<?>) getCache()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MiniJavaPackage.METHOD__ISABSTRACT :
				return isIsabstract();
			case MiniJavaPackage.METHOD__ISSTATIC :
				return isIsstatic();
			case MiniJavaPackage.METHOD__PARAMS :
				return getParams();
			case MiniJavaPackage.METHOD__BODY :
				return getBody();
			case MiniJavaPackage.METHOD__CACHE :
				if (coreType) return getCache();
				else return getCache().map();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MiniJavaPackage.METHOD__ISABSTRACT :
				setIsabstract((Boolean) newValue);
				return;
			case MiniJavaPackage.METHOD__ISSTATIC :
				setIsstatic((Boolean) newValue);
				return;
			case MiniJavaPackage.METHOD__PARAMS :
				getParams().clear();
				getParams().addAll((Collection<? extends ParameterImpl>) newValue);
				return;
			case MiniJavaPackage.METHOD__BODY :
				setBody((BlockImpl) newValue);
				return;
			case MiniJavaPackage.METHOD__CACHE :
				((Setting)getCache()).set(newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.METHOD__ISABSTRACT :
				setIsabstract(ISABSTRACT_EDEFAULT);
				return;
			case MiniJavaPackage.METHOD__ISSTATIC :
				setIsstatic(ISSTATIC_EDEFAULT);
				return;
			case MiniJavaPackage.METHOD__PARAMS :
				getParams().clear();
				return;
			case MiniJavaPackage.METHOD__BODY :
				setBody((BlockImpl) null);
				return;
			case MiniJavaPackage.METHOD__CACHE :
				getCache().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.METHOD__ISABSTRACT :
				return isabstract != ISABSTRACT_EDEFAULT;
			case MiniJavaPackage.METHOD__ISSTATIC :
				return isstatic != ISSTATIC_EDEFAULT;
			case MiniJavaPackage.METHOD__PARAMS :
				return params != null && !params.isEmpty();
			case MiniJavaPackage.METHOD__BODY :
				return body != null;
			case MiniJavaPackage.METHOD__CACHE :
				return cache != null && !cache.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	public void evaluateStatement(StateImpl state) {
		((BlockImpl) (this.getBody())).evaluateStatement((StateImpl) (state));
	}

	public MethodImpl findOverride(ClazzImpl c) {
		MethodImpl result;
		if (this.paramsArr == null) {
			CompilerDirectives.transferToInterpreterAndInvalidate();
			if (this.params != null) this.paramsArr = this.params.toArray(new ParameterImpl[0]);
			else this.paramsArr = new ParameterImpl[] {};
		}
		if (!(this.getCache().containsKey((ClazzImpl) (c)))) {
			MethodImpl that = ((MethodImpl) (this));
			if (CollectionService.exists(c.getMembers(), (x) -> EqualService.equals((x), (that)))) {
				result = (MethodImpl) (this) ;
			}
			else {
				int i = ((int) (0));
				MethodImpl found = ((MethodImpl) (null));
				while ((((i) < (CollectionService.size(c.getMembers()))) && (EqualService.equals((found), (null))))) {
					MemberImpl tmpm = ((MemberImpl) (CollectionService.get(c.getMembers(), i)));
					if (tmpm instanceof MethodImpl) {
						MethodImpl m = ((MethodImpl) (tmpm));
						if (((EqualService.equals((m.getName()), (this.name))) && (EqualService.equals((CollectionService.size(m.getParams())), (CollectionService.size(this.paramsArr)))))) {
							boolean compared = ((boolean) (((TypeRefImpl) (m.getTypeRef())).compare((TypeRefImpl) (this.typeRef))));
							int j = ((int) (0));
							int paramlgt = ((int) (CollectionService.size(m.getParams())));
							boolean alltrue = ((boolean) (compared));
							while ((((j) < (paramlgt)) && (alltrue))) {
								ParameterImpl p1 = ((ParameterImpl) (CollectionService.get(m.getParams(), j)));
								ParameterImpl tmpp = ((ParameterImpl) (CollectionService.head(CollectionService.select(this.paramsArr, (p2) -> ((ParameterImpl) (p1)).compare((ParameterImpl) (p2))))));
								alltrue = !EqualService.equals((tmpp), (null));
								j = (j) + (1);
							}
							if (alltrue) {
								found = m;
							}
						}
					}
					i = (i) + (1);
				}
				if (!EqualService.equals((found), (null))) {
					result = (MethodImpl) (found) ;
				}
				else {
					if (!EqualService.equals((c.getSuperClass()), (null))) {
						result = (MethodImpl) (((MethodImpl) (this)).findOverride((ClazzImpl) (c.getSuperClass()))) ;
					}
					else {
						result = (MethodImpl) (null) ;
					}
				}
			}
			this.getCache().put((ClazzImpl) (c), (MethodImpl) (result));
		}
		else {
			result = (MethodImpl) (this.getCache().getFromMap((ClazzImpl) (c))) ;
		}

		return result;
	}

	public void call(StateImpl state) {
		if (this.paramsArr == null) {
			CompilerDirectives.transferToInterpreterAndInvalidate();
			if (this.params != null) this.paramsArr = this.params.toArray(new ParameterImpl[0]);
			else this.paramsArr = new ParameterImpl[] {};
		}
		((BlockImpl) (this.getBody())).evaluateStatement((StateImpl) (state));

	}
}
