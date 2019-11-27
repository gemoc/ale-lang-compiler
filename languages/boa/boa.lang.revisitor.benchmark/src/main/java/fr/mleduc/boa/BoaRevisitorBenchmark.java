package fr.mleduc.boa;

import boa.BoaPackage;
import boa.File;
import boa_exec_revisitor.impl.Boa_exec_revisitorImplementation;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import org.openjdk.jmh.annotations.*;

import java.util.Map;

@State(Scope.Benchmark)
public class BoaRevisitorBenchmark {
    @Param({"programs/boa_fibonacci.xmi", "programs/boa_sort.xmi"})
    public String program;
    private File logoProgram;

    private final Boa_exec_revisitorImplementation revisitor = new MyBoa_exec_revisitorImplementation();

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
        this.logoProgram = (File) resource.getContents().get(0);
    }

    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    @Measurement(iterations = 1, time = 1)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    public void boaInterpreter() {

        revisitor.$(logoProgram).eval();
    }

    private static class MyBoa_exec_revisitorImplementation implements Boa_exec_revisitorImplementation {
    }

}
