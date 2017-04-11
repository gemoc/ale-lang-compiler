/*******************************************************************************
 * Copyright (c) 2017 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.core.interpreter.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.eclipse.acceleo.query.runtime.CrossReferenceProvider;
import org.eclipse.acceleo.query.runtime.IReadOnlyQueryEnvironment;
import org.eclipse.acceleo.query.runtime.IRootEObjectProvider;
import org.eclipse.acceleo.query.services.EObjectServices;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.ale.core.interpreter.DynamicFeatureRegistry;

import com.google.common.collect.Lists;

public class DynamicEObjectServices extends EObjectServices{
	
	public static final String UNKNOWN_FEATURE = "Feature %s not found in EClass %s";
	public static final String NON_EOBJECT_FEATURE_ACCESS = "Attempt to access feature (%s) on a non ModelObject value (%s).";
	
	DynamicFeatureRegistry dynamicFeatures;

	public DynamicEObjectServices(IReadOnlyQueryEnvironment queryEnvironment, CrossReferenceProvider crossReferencer,
			IRootEObjectProvider rootProvider, DynamicFeatureRegistry dynamicFeatures) {
		super(queryEnvironment, crossReferencer, rootProvider);
		this.dynamicFeatures = dynamicFeatures;
	}

	@Override
	public Object aqlFeatureAccess(EObject self, String featureName) {
		return dynamicFeatures.aqlFeatureAccess(self, featureName);
	}
	
	@Override
	public List<EObject> eContents(EObject eObject) {
		
		List<EObject> contents = Lists.newArrayList(eObject.eContents());
		
		Optional<EObject> extension = dynamicFeatures.getRuntimeExtension(eObject);
		if(extension.isPresent()) {
			contents.addAll(extension.get().eContents());
		}
		
		return contents;
	}
	
	@Override
	public EObject eContainer(EObject eObject) {
		return dynamicFeatures.getInstanceOrSelf(eObject.eContainer());
	}
}
