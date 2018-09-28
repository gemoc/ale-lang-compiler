package org.eclipse.emf.ecoretools.ale.compiler.ui;

import java.io.FileNotFoundException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecoretools.ale.compiler.ALECompiler;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class GenerateDslImplementation implements IObjectActionDelegate {

	private final ALECompiler compiler = new ALECompiler();

	private IFile selectedIFile;

	@Override
	public void setActivePart(final IAction action, final IWorkbenchPart targetPart) {
	}

	@Override
	public void run(final IAction action) {
		try {
			compiler.compile(this.selectedIFile.getLocation().toOSString());
		} catch (FileNotFoundException e) {
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
