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

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

/**
 * AQL service to print objects on the output
 */
public class LogService {

	public static void log(Object o) {

//		Path path = Paths.get("/tmp/log.txt");
//		
//		if(!path.toFile().exists()) {
//			try {
//				new FileOutputStream(path.toFile()).close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			path.toFile().setLastModified(System.currentTimeMillis());
//		}
//
//		try {
//			Files.write(path, Arrays.asList(o.toString()), Charset.forName("UTF-8"), StandardOpenOption.APPEND);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		
		System.out.println(o);
	}
}