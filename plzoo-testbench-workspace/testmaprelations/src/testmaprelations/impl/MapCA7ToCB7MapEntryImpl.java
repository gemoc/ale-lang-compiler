
package testmaprelations.impl;
import java.util.Collection;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import testmaprelations.CA7;
import testmaprelations.CB7;
import testmaprelations.TestmaprelationsPackage;

public class MapCA7ToCB7MapEntryImpl extends MinimalEObjectImpl.Container implements BasicEMap.Entry<EList<CA7>,EList<CB7>> {
	
	protected EList<CA7> key;
	
	protected EList<CB7> value;
	
	protected MapCA7ToCB7MapEntryImpl() {
		super();
	}
	
	@Override
	protected EClass eStaticClass() {
		return TestmaprelationsPackage.Literals.MAP_CA7_TO_CB7_MAP_ENTRY;
	}
	
	public EList<CA7> getTypedKey() {
		if (key == null) {
			key = new EObjectResolvingEList<CA7>(CA7.class, this, TestmaprelationsPackage.MAP_CA7_TO_CB7_MAP_ENTRY__KEY);
		}
		return key;
	}
	
	public EList<CB7> getTypedValue() {
		if (value == null) {
			value = new EObjectResolvingEList<CB7>(CB7.class, this, TestmaprelationsPackage.MAP_CA7_TO_CB7_MAP_ENTRY__VALUE);
		}
		return value;
	}
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestmaprelationsPackage.MAP_CA7_TO_CB7_MAP_ENTRY__KEY:
				return getTypedKey();
			case TestmaprelationsPackage.MAP_CA7_TO_CB7_MAP_ENTRY__VALUE:
				return getTypedValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}
	
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TestmaprelationsPackage.MAP_CA7_TO_CB7_MAP_ENTRY__KEY:
				getTypedKey().clear();
				getTypedKey().addAll((Collection<? extends CA7>)newValue);
				return;
			case TestmaprelationsPackage.MAP_CA7_TO_CB7_MAP_ENTRY__VALUE:
				getTypedValue().clear();
				getTypedValue().addAll((Collection<? extends CB7>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}
	
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TestmaprelationsPackage.MAP_CA7_TO_CB7_MAP_ENTRY__KEY:
				getTypedKey().clear();
				return;
			case TestmaprelationsPackage.MAP_CA7_TO_CB7_MAP_ENTRY__VALUE:
				getTypedValue().clear();
				return;
		}
		super.eUnset(featureID);
	}
	
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TestmaprelationsPackage.MAP_CA7_TO_CB7_MAP_ENTRY__KEY:
				return key != null && !key.isEmpty();
			case TestmaprelationsPackage.MAP_CA7_TO_CB7_MAP_ENTRY__VALUE:
				return value != null && !value.isEmpty();
		}
		return super.eIsSet(featureID);
	}
	
	protected int hash = -1;
	
	public int getHash() {
		if (hash == -1) {
			Object theKey = getKey();
			hash = (theKey == null ? 0 : theKey.hashCode());
		}
		return hash;
	}
	
	public void setHash(int hash) {
		this.hash = hash;
	}
	
	public EList<CA7> getKey() {
		return getTypedKey();
	}
	
	public void setKey(EList<CA7> key) {
		getTypedKey().addAll(key);
	}
	
	public EList<CB7> getValue() {
		return getTypedValue();
	}
	
	public EList<CB7> setValue(EList<CB7> value) {
		EList<CB7> oldValue = getValue();
		getTypedValue().clear();
		getTypedValue().addAll(value);
		return oldValue;
	}
	
	public EMap<EList<CA7>, EList<CB7>> getEMap() {
		EObject container = eContainer();
		return container == null ? null : (EMap<EList<CA7>, EList<CB7>>)container.eGet(eContainmentFeature());
	}
} //MapCA7ToCB7MapEntryImpl
