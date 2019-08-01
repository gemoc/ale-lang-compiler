package fr.mleduc.fsm;

import fsm.visitor.fsm.FsmPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import org.openjdk.jmh.annotations.*;
import visitor.VisitorImplementation;
import visitor.operation.fsm.SystemOperation;

import java.util.Map;

@State(Scope.Benchmark)
public class FsmVisitorBenchmark {
    @Param({"programs/buffers.xmi"})
    public String program;
    private fsm.visitor.fsm.System fsmProgram;

    private final VisitorImplementation visitor = new VisitorImplementation();

    @Setup(Level.Iteration)
    public void loadXMI() {
        EPackage.Registry.INSTANCE.put("http://www.example.org/fsm", FsmPackage.eINSTANCE);

        LogService.MUTE = true;

        final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        final Map<String, Object> m = reg.getExtensionToFactoryMap();
        m.put("xmi", new XMIResourceFactoryImpl());

        final ResourceSetImpl resSet = new ResourceSetImpl();
        final URI createFileURI = URI.createFileURI(program);
        final Resource resource = resSet.getResource(createFileURI, true);
        fsmProgram = (fsm.visitor.fsm.System) resource.getContents().get(0);
    }

    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    @Measurement(iterations = 1, time = 1)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    public void fsmInterpreter() {
        ((SystemOperation) fsmProgram.accept(visitor)).main(50000000);
    }
}
