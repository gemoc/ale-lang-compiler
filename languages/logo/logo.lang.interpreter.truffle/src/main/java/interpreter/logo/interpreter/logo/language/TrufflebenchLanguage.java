package interpreter.logo.interpreter.logo.language;

import com.oracle.truffle.api.*;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.InvalidArrayIndexException;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.library.ExportLibrary;
import com.oracle.truffle.api.library.ExportMessage;
import com.oracle.truffle.api.nodes.RootNode;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.impl.LogoProgramImpl;
import kmLogo.interpreter.kmLogo.impl.TurtleImpl;
import org.apache.commons.io.IOUtils;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Map;


@TruffleLanguage.Registration(id = "trufflebench", name = "TruffleBench")
public class TrufflebenchLanguage extends TruffleLanguage<Ctx> {
    @Override
    protected Ctx createContext(Env env) {
        return new Ctx();
    }

    @Override
    protected boolean isObjectOfLanguage(Object object) {
        return true;
    }

    @Override
    protected CallTarget parse(ParsingRequest request) throws Exception {
        final String program = IOUtils.toString(request.getSource().getInputStream(), Charset.defaultCharset());

        EPackage.Registry.INSTANCE.put("http://kmLogo", KmLogoPackage.eINSTANCE);
        final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        final Map<String, Object> m = reg.getExtensionToFactoryMap();
        m.put("xmi", new XMIResourceFactoryImpl());

        LogService.MUTE = true;

        final ResourceSetImpl resSet = new ResourceSetImpl();
        final URI createFileURI = URI.createFileURI(program);
        final Resource resource = resSet.getResource(createFileURI, true);
        LogoProgramImpl logoProgram = (LogoProgramImpl) resource.getContents().get(0);
        final RootNode main = new RootNode(this) {
            @Override
            public Object execute(VirtualFrame frame) {
                final TurtleImpl eval = logoProgram.eval();
                return eval.getDrawings().size();
            }
        };
        this.getContextReference().get().setMain(main);

        return Truffle.getRuntime().createCallTarget(new RootNode(this) {
            @Override
            public Object execute(VirtualFrame frame) {
                return 42;
            }
        });
    }

    @Override
    protected Iterable<Scope> findTopScopes(Ctx context) {
        return Collections.singletonList(Scope.newBuilder("global", new MyTruffleObject(context)).build());
    }

    @ExportLibrary(InteropLibrary.class)
    static final class FunctionNamesObject implements TruffleObject {

        private final Object[] names;

        FunctionNamesObject(Object[] names) {
            this.names = names;
        }

        @ExportMessage
        boolean hasArrayElements() {
            return true;
        }

        @ExportMessage
        boolean isArrayElementReadable(long index) {
            return index >= 0 && index < names.length;
        }

        @ExportMessage
        long getArraySize() {
            return names.length;
        }

        @ExportMessage
        Object readArrayElement(long index) throws InvalidArrayIndexException {
            if (!isArrayElementReadable(index)) {
                CompilerDirectives.transferToInterpreter();
                throw InvalidArrayIndexException.create(index);
            }
            return names[(int) index];
        }
    }

    @ExportLibrary(InteropLibrary.class)
    static class MyTruffleObject implements TruffleObject {
        private final Ctx context;

        public MyTruffleObject(Ctx context) {
            this.context = context;
        }

        @ExportMessage
        @CompilerDirectives.TruffleBoundary
        Object readMember(String member) {
            return context.getMain();
        }

        @ExportMessage
        boolean hasMembers() {
            return true;
        }

        @ExportMessage
        @CompilerDirectives.TruffleBoundary
        boolean isMemberReadable(String member) {
            return true;
        }

        @ExportMessage
        @CompilerDirectives.TruffleBoundary
        Object getMembers(@SuppressWarnings("unused") boolean includeInternal) {
            return new FunctionNamesObject(new Object[]{"main"});
        }
    }
}
