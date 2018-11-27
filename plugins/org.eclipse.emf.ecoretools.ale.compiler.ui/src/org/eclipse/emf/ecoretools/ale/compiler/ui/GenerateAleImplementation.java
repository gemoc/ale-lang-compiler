package org.eclipse.emf.ecoretools.ale.compiler.ui;

import java.io.FileNotFoundException;
import java.util.HashMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecoretools.ale.compiler.ALEImplementationCompiler;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class GenerateAleImplementation implements IObjectActionDelegate {

	private IFile selectedIFile;

	@Override
	public void setActivePart(final IAction action, final IWorkbenchPart targetPart) {
	}

	@Override
	public void run(final IAction action) {
		try {
			IPath location = this.selectedIFile.getLocation();
			new ALEImplementationCompiler().compile(location.toOSString(),
					selectedIFile.getProject().getLocation().toFile(), selectedIFile.getProject().getName(),
					new HashMap<String, Class<?>>());
			selectedIFile.getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (CoreException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void selectionChanged(final IAction action, final ISelection selection) {
		if ((selection instanceof IStructuredSelection)) {
			final Object o = ((IStructuredSelection) selection).getFirstElement();
			if ((o instanceof IFile)) {
				this.selectedIFile = ((IFile) o);
			}
			if ((o instanceof IAdaptable)) {
				final IFile res = ((IAdaptable) o).<IFile>getAdapter(IFile.class);
				if ((res != null)) {
					this.selectedIFile = res;
				}
			}
		}
	}

}
