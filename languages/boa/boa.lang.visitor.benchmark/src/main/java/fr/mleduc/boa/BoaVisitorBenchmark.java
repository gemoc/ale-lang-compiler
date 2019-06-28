package fr.mleduc.boa;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import boa.visitor.boa.BoaPackage;
import boa.visitor.boa.File;
import visitor.VisitorImplementation;
import visitor.operation.boa.impl.FileOperationImpl;

@State(Scope.Benchmark)
public class BoaVisitorBenchmark {
    @Param({"programs/boa_fibonacci.xmi", "programs/boa_sort.xmi"})
    public String program;
    private File boaProgram;

    private final VisitorImplementation visitor = new VisitorImplementation();

    @Setup(Level.Iteration)
    public void loadXMI() {
        LogService.MUTE = true;
        EPackage.Registry.INSTANCE.put("http://www.example.org/boa", BoaPackage.eINSTANCE);
        final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        final Map<String, Object> m = reg.getExtensionToFactoryMap();
        m.put("xmi", new XMIResourceFactoryImpl());

        final ResourceSetImpl resSet = new ResourceSetImpl();
        final URI createFileURI = URI.createFileURI(program);
        final Resource resource = resSet.getResource(createFileURI, true);
        this.boaProgram = (File) resource.getContents().get(0);
    }

    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    @Measurement(iterations = 1, time = 1)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    public void boaInterpreter() {
        ((FileOperationImpl) boaProgram.accept(visitor)).eval();
    }
}
