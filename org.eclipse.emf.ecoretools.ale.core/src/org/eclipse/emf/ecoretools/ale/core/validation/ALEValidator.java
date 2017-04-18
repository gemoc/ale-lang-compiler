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
package org.eclipse.emf.ecoretools.ale.core.validation;

import java.util.List;

import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.acceleo.query.runtime.IValidationMessage;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;

import com.google.common.collect.Lists;

public class ALEValidator {
	
	List<IValidationMessage> msgs;
	IQueryEnvironment qryEnv;
	
	public ALEValidator(IQueryEnvironment qryEnv) {
		this.qryEnv = qryEnv;
	}
	
	public void validate(List<ParseResult<ModelUnit>> roots) {
		List<IValidator> validators = Lists.newArrayList(new NameValidator(), new TypeValidator());
		BaseValidator base = new BaseValidator(qryEnv, validators);
		msgs = base.validate(roots);
	}
	
	public List<IValidationMessage> getMessages() {
		return msgs;
	}
}