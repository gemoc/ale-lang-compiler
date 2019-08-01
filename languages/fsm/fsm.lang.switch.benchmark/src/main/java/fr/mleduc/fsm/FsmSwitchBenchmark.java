package fr.mleduc.fsm;

import emfswitch.SwitchImplementation;
import emfswitch.operation.SystemOperation;
import fsm.model.fsm.FsmPackage;
import fsm.model.fsm.System;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import org.openjdk.jmh.annotations.*;

import java.util.Map;

@State(Scope.Benchmark)
public class FsmSwitchBenchmark {
    @Param({"programs/buffers.xmi"})
    public String program;
    private System fsmProgram;

    private final SwitchImplementation emfswitch = new SwitchImplementation();

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
        fsmProgram = (System) resource.getContents().get(0);
    }

    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    @Measurement(iterations = 1, time = 1)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    public void fsmInterpreter() {

        ((SystemOperation) emfswitch.doSwitch(fsmProgram)).main(50000000);
    }
}
