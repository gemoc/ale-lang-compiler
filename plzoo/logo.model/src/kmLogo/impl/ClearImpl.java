/**
 */
package kmLogo.impl;

import kmLogo.Clear;
import kmLogo.KmLogoPackage;

import org.eclipse.emf.ecore.EClass;

public class ClearImpl extends PrimitiveImpl implements Clear {
	protected ClearImpl() {
		super();
	}

	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.CLEAR;
	}

} // ClearImpl
