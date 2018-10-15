package org.eclipse.emf.ecoretools.ale.compiler.ui

import java.io.FileWriter
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.IAdaptable
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.core.runtime.Path
import org.eclipse.jface.action.IAction
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.jface.viewers.ISelection
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.swt.widgets.Shell
import org.eclipse.ui.IObjectActionDelegate
import org.eclipse.ui.IWorkbenchPart
import org.eclipse.ui.PlatformUI
import java.io.IOException
import org.eclipse.core.runtime.CoreException
import org.eclipse.emf.ecoretools.ale.compiler.EcoreUtils
import org.eclipse.emf.ecoretools.ale.compiler.NamingUtils
import org.eclipse.emf.ecoretools.ale.compiler.RevisitorInterfaceGenerator
import org.eclipse.e4.core.services.log.Logger
import org.eclipse.emf.ecoretools.ale.compiler.AlexException

class GenerateRevisitorInterface implements IObjectActionDelegate {
	extension EcoreUtils = new EcoreUtils()
	extension NamingUtils = new NamingUtils()
	RevisitorInterfaceGenerator generator = new RevisitorInterfaceGenerator()
	Shell shell
	IFile selectedIFile

	override void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.site.shell
	}

	override void run(IAction action) {
		val gmPath = selectedIFile.fullPath.toString
		val gm = loadGenmodel(gmPath)
		val pkg = gm?.getEPackage

		if (gm === null) {
			MessageDialog.openError(shell, "Error", "Cannot find GenModel for " + gmPath);
			return
		}

		if (pkg === null) {
			MessageDialog.openError(shell, "Error", "Cannot find EPackage for " + gmPath);
			return
		}

		val project = selectedIFile.project
		val path = project.location.append(new Path(pkg.revisitorInterfacePath))
		path.toFile().mkdirs()
		val file = path.append(new Path(pkg.revisitorInterfaceName)).addFileExtension("java")

		try {
			val content = generator.generateInterface(pkg, gm)
			val fileWriter = new FileWriter(file.toFile())
			fileWriter.write(content)
			fileWriter.close()
			project.refreshLocal(IResource::DEPTH_INFINITE, new NullProgressMonitor())
		} catch (AlexException | IOException | CoreException e) {
			MessageDialog.openError(shell, "Error",
				"Couldn't generate Revisitor interface. Check Error Log for details.");
			val logger = PlatformUI.getWorkbench().getService(typeof(Logger));
			logger.error(e, e.message)
		}
	}

	override void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			val o = selection.firstElement
			if (o instanceof IFile)
				selectedIFile = o
			if (o instanceof IAdaptable) {
				val res = o.getAdapter(typeof(IFile))
				if (res !== null)
					selectedIFile = res
			}
		}
	}
}
