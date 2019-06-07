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
package org.eclipse.emf.ecoretools.ale.core.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class Dsl {

	String sourceFile;
	List<String> allSyntaxes = new ArrayList<String>();
	List<String> allSemantics = new ArrayList<String>();
	boolean isTruffle;
	String rootPackage;
	String compilationType;
	
	private final Properties dslProp;

	public Dsl(List<String> syntaxes, List<String> semantics) {
		this.allSyntaxes.addAll(syntaxes);
		this.allSemantics.addAll(semantics);
		this.dslProp = new Properties();
	}

	public Dsl(String dslFile) throws FileNotFoundException {
		this(new FileInputStream(dslFile));
		this.sourceFile = dslFile;
	}

	public Dsl(InputStream input) {

		this.dslProp = new Properties();
		try {
			dslProp.load(input);
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String allSyntaxes = (String) dslProp.get("syntax");
		String allBehaviors = (String) dslProp.get("behavior");
		this.isTruffle = dslProp.getOrDefault("truffle", "false").equals("true");
		this.rootPackage = (String) dslProp.getOrDefault("rootPackage", "");
		this.compilationType = (String) dslProp.getOrDefault("compilationType", "");
		
		if (allSyntaxes != null && allBehaviors != null) {
			String[] syntaxes = allSyntaxes.split(",");
			String[] behaviors = allBehaviors.split(",");

			this.allSyntaxes.addAll(Arrays.asList(syntaxes));
			this.allSemantics.addAll(Arrays.asList(behaviors));
		} else {
			// TODO: Malformed file error
		}

	}

	public List<String> getAllSemantics() {
		return allSemantics;
	}

	public List<String> getAllSyntaxes() {
		return allSyntaxes;
	}

	public void setSourceFile(String sourceFile) {
		this.sourceFile = sourceFile;
	}

	public void save() {
		if (sourceFile != null) {
			Properties dslProp = new Properties();
			dslProp.put("syntax", String.join(",", allSyntaxes));
			dslProp.put("behavior", String.join(",", allSemantics));
			try {
				FileOutputStream output = new FileOutputStream(sourceFile);
				dslProp.store(output, "");
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String getSourceFileName() {
		final String[] sections = new File(sourceFile).getName().split("\\.");
		final List<String> s = new ArrayList<>();
		for (int i = 0; i < sections.length - 1; i++) {
			s.add(sections[i]);
		}
		return s.stream().collect(Collectors.joining("."));

	}

	public boolean isTruffle() {
		return isTruffle;
	}
	
	public String getRootPackage() {
		return rootPackage;
	}

	public String getCompilationType() {
		return compilationType;
	}

	public void setTruffle(boolean isTruffle) {
		this.isTruffle = isTruffle;
	}
	
	
}
