package fr.mleduc.logo;

import kmLogo.visitor.kmLogo.KmLogoPackage;
import kmLogo.visitor.kmLogo.LogoProgram;
import kmLogo.visitor.kmLogo.Turtle;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import org.openjdk.jmh.annotations.*;
import visitor.VisitorImplementation;
import visitor.operation.kmLogo.impl.LogoProgramOperationImpl;

import java.util.Map;

@State(Scope.Benchmark)
public class LogoVisitorBenchmark {
    @Param({"programs/fractal.xmi"})
    public String program;
    private LogoProgram logoProgram;

    private final VisitorImplementation visitor = new VisitorImplementation();

    @Setup(Level.Iteration)
    public void loadXMI() {
        EPackage.Registry.INSTANCE.put("http://kmLogo", KmLogoPackage.eINSTANCE);
        final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        final Map<String, Object> m = reg.getExtensionToFactoryMap();
        m.put("xmi", new XMIResourceFactoryImpl());

        LogService.MUTE = true;

        final ResourceSetImpl resSet = new ResourceSetImpl();
        final URI createFileURI = URI.createFileURI(program);
        final Resource resource = resSet.getResource(createFileURI, true);
        this.logoProgram = (LogoProgram) resource.getContents().get(0);
    }

    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    @Measurement(iterations = 1, time = 1)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    public Turtle logoInterpreter() {
        return ((LogoProgramOperationImpl) logoProgram.accept(visitor)).eval();
    }
}
