package org.eclipse.emf.ecoretools.ale.compiler;


import java.io.File;
import java.io.FileNotFoundException;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecoretools.ale.compiler.ALEImplementationCompiler;

@Mojo( name = "ale-dsl-compile", defaultPhase = LifecyclePhase.GENERATE_SOURCES )
public class MyMojo
    extends AbstractMojo
{
    /**
     * Location of the file.
     */
    @Parameter( property = "dslFile", required = true )
    private File dslFile;

    public void execute()
        throws MojoExecutionException
    {
    	try {
			IPath location = ((IResource) this.dslFile).getLocation();
			new ALEImplementationCompiler().compile(location.toOSString(),
					((IResource) dslFile).getProject().getLocation().toFile(), dslFile.getProject().getName());
			dslFile.getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (CoreException e) {
			e.printStackTrace();
		}
    }
}
