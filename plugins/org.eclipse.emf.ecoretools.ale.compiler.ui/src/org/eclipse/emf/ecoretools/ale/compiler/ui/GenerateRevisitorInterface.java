package org.eclipse.emf.ecoretools.ale.compiler.ui;

import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecoretools.ale.compiler.EcoreUtils;
import org.eclipse.emf.ecoretools.ale.compiler.NamingUtils;
import org.eclipse.emf.ecoretools.ale.compiler.RevisitorInterfaceGenerator;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class GenerateRevisitorInterface implements IObjectActionDelegate {
	private final EcoreUtils ecoreUtils = new EcoreUtils();
	private final NamingUtils _namingUtils = new NamingUtils();
	private final RevisitorInterfaceGenerator generator = new RevisitorInterfaceGenerator();

	private Shell shell;

	private IFile selectedIFile;

	@Override
	public void setActivePart(final IAction action, final IWorkbenchPart targetPart) {
		this.shell = targetPart.getSite().getShell();
	}

	@Override
	public void run(final IAction action) {
		final String ecorePath = this.selectedIFile.getFullPath().toString();
		final EPackage pkg = this.ecoreUtils.loadEPackage(ecorePath);
		final GenModel gm = this.ecoreUtils.loadCorrespondingGenmodel(ecorePath);
		if (pkg == null) {
			MessageDialog.openError(this.shell, "Error", ("Cannot find EPackage for " + ecorePath));
			return;
		}
		if ((gm == null)) {
			MessageDialog.openError(this.shell, "Error", ("Cannot find genmodel for " + ecorePath));
			return;
		}
		final IProject project = this.selectedIFile.getProject();
		final IPath location = project.getLocation();
		final String revisitorInterfacePath = this._namingUtils.getRevisitorInterfacePath(pkg);
		final IPath path = location.append(new Path(revisitorInterfacePath));
		path.toFile().mkdirs();
		final String revisitorInterfaceName = this._namingUtils.getRevisitorInterfaceName(pkg);
		final IPath file = path.append(new Path(revisitorInterfaceName)).addFileExtension("java");
		final String content = this.generator.generateInterface(pkg, gm);
		try {
			final FileWriter fileWriter = new FileWriter(file.toFile());
			fileWriter.write(content);
			fileWriter.close();
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (final Throwable t) {
			if (t instanceof IOException) {
				((IOException) t).printStackTrace();
			} else if (t instanceof CoreException) {
				((CoreException) t).printStackTrace();
			} else {
				throw new RuntimeException(t);
			}
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
