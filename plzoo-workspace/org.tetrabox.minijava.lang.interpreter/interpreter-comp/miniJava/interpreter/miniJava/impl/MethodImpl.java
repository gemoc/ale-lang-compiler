package miniJava.interpreter.miniJava.impl;

import java.lang.Object;
import miniJava.interpreter.miniJava.Block;
import miniJava.interpreter.miniJava.Clazz;
import miniJava.interpreter.miniJava.Method;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.Parameter;
import miniJava.interpreter.miniJava.State;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;

public class MethodImpl extends MemberImpl implements Method {
  protected static final boolean ISABSTRACT_EDEFAULT = false;

  protected static final boolean ISSTATIC_EDEFAULT = false;

  protected boolean isabstract = ISABSTRACT_EDEFAULT;

  protected boolean isstatic = ISSTATIC_EDEFAULT;

  protected EList<Parameter> params;

  protected Block body;

  protected EMap<Clazz, Method> cache;

  protected MethodImpl() {
    super();
  }

  public boolean isIsabstract() {
    return isabstract;}

  public void setIsabstract(boolean isabstract) {
    this.isabstract = isabstract;}

  public boolean isIsstatic() {
    return isstatic;}

  public void setIsstatic(boolean isstatic) {
    this.isstatic = isstatic;}

  public EList<Parameter> getParams() {
    if(params == null) {
    	params = new EObjectContainmentEList<Parameter>(miniJava.interpreter.miniJava.Parameter.class, this, MiniJavaPackage.METHOD__PARAMS);
    }
    return params;
  }

  public void setBody(Block newBody) {
    if (newBody != body) {
    	NotificationChain msgs = null;
    	if (body != null)
    		msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.METHOD__BODY, null, msgs);
    	if (newBody != null)
    		msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.METHOD__BODY, null, msgs);
    	msgs = basicSetBody(newBody, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.METHOD__BODY, newBody, newBody));
  }

  public NotificationChain basicSetBody(Block newBody, NotificationChain msgs) {
    Block oldBody = body;
    body = newBody;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.METHOD__BODY, oldBody, newBody);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  public Block getBody() {
    return body;
  }

  public EMap<Clazz, Method> getCache() {
    if (cache == null) {
    	cache = new EcoreEMap<Clazz, Method>(MiniJavaPackage.Literals.CLAZZ_TO_METHOD_MAP, ClazzToMethodMapImpl.class, this, MiniJavaPackage.METHOD__CACHE);
    }
    return cache;
  }

  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.METHOD;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.METHOD__ISABSTRACT:
    	setIsabstract((boolean) newValue);
    return;
    case MiniJavaPackage.METHOD__ISSTATIC:
    	setIsstatic((boolean) newValue);
    return;
    case MiniJavaPackage.METHOD__PARAMS:
    	getParams().clear();
    	getParams().addAll((java.util.Collection<? extends miniJava.interpreter.miniJava.Parameter>) newValue);
    return;
    case MiniJavaPackage.METHOD__BODY:
    	setBody((miniJava.interpreter.miniJava.Block) newValue);
    return;
    case MiniJavaPackage.METHOD__CACHE:
    	((org.eclipse.emf.ecore.EStructuralFeature.Setting)getCache()).set(newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.METHOD__ISABSTRACT:
    	setIsabstract(ISABSTRACT_EDEFAULT);
    return;
    case MiniJavaPackage.METHOD__ISSTATIC:
    	setIsstatic(ISSTATIC_EDEFAULT);
    return;
    case MiniJavaPackage.METHOD__PARAMS:
    	getParams().clear();
    return;
    case MiniJavaPackage.METHOD__BODY:
    	setBody((miniJava.interpreter.miniJava.Block) null);
    return;
    case MiniJavaPackage.METHOD__CACHE:
    	getCache().clear();
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.METHOD__ISABSTRACT:
    return isIsabstract();
    case MiniJavaPackage.METHOD__ISSTATIC:
    return isIsstatic();
    case MiniJavaPackage.METHOD__PARAMS:
    return getParams();
    case MiniJavaPackage.METHOD__BODY:
    return getBody();
    case MiniJavaPackage.METHOD__CACHE:
    if (coreType)
    	return getCache();
    else
    	return getCache().map();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.METHOD__ISABSTRACT:
    	return isabstract != ISABSTRACT_EDEFAULT;
    case MiniJavaPackage.METHOD__ISSTATIC:
    	return isstatic != ISSTATIC_EDEFAULT;
    case MiniJavaPackage.METHOD__PARAMS:
    	return params != null && !params.isEmpty();
    case MiniJavaPackage.METHOD__BODY:
    	return body != null;
    case MiniJavaPackage.METHOD__CACHE:
    	return cache != null && !cache.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case miniJava.interpreter.miniJava.MiniJavaPackage.METHOD__PARAMS:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getParams()).basicRemove(otherEnd, msgs);
    case miniJava.interpreter.miniJava.MiniJavaPackage.METHOD__BODY:
    	return basicSetBody(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public void evaluateStatement(State state) {
    this.body.evaluateStatement(state);
        ;
  }

  public Method findOverride(Clazz c) {
    Method result;
    if(!(minijava.MapService.containsKey(this.getCache(), c))) {
          miniJava.interpreter.miniJava.Method that = ((miniJava.interpreter.miniJava.Method)this);
          if(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.exists(c.getMembers(), (x) -> org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService.equals((x), (that)))) {
            result = this;
          }
          else {
            int i = ((int)0);
            miniJava.interpreter.miniJava.Method found = ((miniJava.interpreter.miniJava.Method)null);
            while ((((i) < (org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(c.getMembers()))) && (org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService.equals((found), (null))))) {
              miniJava.interpreter.miniJava.Member tmpm = ((miniJava.interpreter.miniJava.Member)org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.get(c.getMembers(), i));
              if(tmpm instanceof miniJava.interpreter.miniJava.Method) {
                miniJava.interpreter.miniJava.Method m = ((miniJava.interpreter.miniJava.Method)tmpm);
                if(((org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService.equals((m.getName()), (this.name))) && (org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService.equals((org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(m.getParams())), (org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(this.getParams())))))) {
                  boolean compared = ((boolean)m.getTypeRef().compare(this.typeRef));
                  int j = ((int)0);
                  int paramlgt = ((int)org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(m.getParams()));
                  boolean alltrue = ((boolean)compared);
                  while ((((j) < (paramlgt)) && (alltrue))) {
                    miniJava.interpreter.miniJava.Parameter p1 = ((miniJava.interpreter.miniJava.Parameter)org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.get(m.getParams(), j));
                    miniJava.interpreter.miniJava.Parameter tmpp = ((miniJava.interpreter.miniJava.Parameter)org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.head(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.select(this.getParams(), (p2) -> p1.compare(p2))));
                    alltrue = (tmpp) != (null);
                    j = (j) + (1);
                  }
                  if(alltrue) {
                    found = m;
                  }
                }
              }
              i = (i) + (1);
            }
            if((found) != (null)) {
              result = found;
            }
            else {
              if((c.getSuperClass()) != (null)) {
                result = this.findOverride(c.getSuperClass());
              }
              else {
                result = null;
              }
            }
          }
          minijava.MapService.put(this.getCache(), c, result);
        }
        else {
          result = this.getCache().get(c);
        }
        ;
    return result;
  }

  public void call(State state) {
    this.body.evaluateStatement(state);
        ;
  }
}
