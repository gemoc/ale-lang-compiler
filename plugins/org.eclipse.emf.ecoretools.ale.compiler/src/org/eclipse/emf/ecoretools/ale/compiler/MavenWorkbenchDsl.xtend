/** 
 * Copyright (c) 2017 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * Inria - initial API and implementation
 */
package org.eclipse.emf.ecoretools.ale.compiler

import java.io.FileNotFoundException
import java.io.File
import java.io.IOException
import java.io.InputStream
import java.net.URL
import java.util.ArrayList
import java.util.List
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.IWorkspace
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.FileLocator
import org.eclipse.core.runtime.Platform
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl
import org.osgi.framework.Bundle

class MavenWorkbenchDsl extends Dsl {
	new(List<String> syntaxes, List<String> semantics, String platformLocation) {
		super(syntaxes, semantics)
		resolveUris(platformLocation)
	}

	new(String dslFile, String platformLocation) throws FileNotFoundException {
		super(dslFile)
		resolveUris(platformLocation)
	}

	new(InputStream input, String platformLocation) {
		super(input)
		resolveUris(platformLocation)
	}

	def private void resolveUris(String platformLocation) {
		val ArrayList<String> newSemantics = new ArrayList<String>()
		getAllSemantics().stream().forEach([ elem |
			newSemantics.add(URI::createFileURI(elem.replace("platform:/resource/", platformLocation)).toFileString())
		])
		// expect system file path
		getAllSemantics().clear()
		getAllSemantics().addAll(newSemantics)
		val ArrayList<String> newSyntaxes = new ArrayList<String>()
		getAllSyntaxes().stream().forEach([ elem |
			newSyntaxes.add(URI::createFileURI(elem.replace("platform:/resource/", platformLocation)).toFileString())
		])
		// expect system file path
		getAllSyntaxes().clear()
		getAllSyntaxes().addAll(newSyntaxes)
	}

	/** 
	 * Convert platform URI to file path
	 */
	def static String convertToFile(String path) {
		var URI uri = URI::createURI(path)
		var String res = null
		if (uri.isPlatformResource()) {
			res = resourceToFile(uri)
			if (res === null) {
				res = pluginToFile(resourceToPlugin(uri))
			}
		} else if (uri.isPlatformPlugin()) {
			res = pluginToFile(uri)
		}
		if (res === null) {
			res = path
		}
		return res
	}

	def private static String resourceToFile(URI uri) {
		var IWorkspace ws = ResourcesPlugin::getWorkspace()
		if (ws !== null) {
			var IResource file = ws.getRoot().findMember(uri.toPlatformString(true))
			if (file !== null) {
				return file.getLocationURI().getRawPath()
			}
		}
		return null
	}

	def private static String pluginToFile(URI uri) {
		var String pluginName = uri.segment(1)
		var String path = uri.toPlatformString(true).substring(pluginName.length() + 1)
		var Bundle plugin = Platform::getBundle(pluginName)
		var URL pluginURL = plugin.getEntry("/")
		try {
			var String pluginFilePath = FileLocator::toFileURL(pluginURL).getFile()
			return pluginFilePath.toString() + path.substring(1)
		} catch (IOException e) {
			e.printStackTrace()
		}

		return null
	}

	/** 
	 * Convert platform:/resource/ to platform:/plugin/
	 */
	def private static URI resourceToPlugin(URI uri) {
		return URI::createPlatformPluginURI(uri.toPlatformString(true), true)
	}
}
