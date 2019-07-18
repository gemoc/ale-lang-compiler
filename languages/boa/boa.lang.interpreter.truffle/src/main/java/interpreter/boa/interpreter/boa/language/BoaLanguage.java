package interpreter.boa.interpreter.boa.language;

import com.oracle.truffle.api.*;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.InvalidArrayIndexException;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.library.ExportLibrary;
import com.oracle.truffle.api.library.ExportMessage;
import com.oracle.truffle.api.nodes.RootNode;

import java.util.Collections;

@TruffleLanguage.Registration(id = "boa", name = "Boa")
public class BoaLanguage extends TruffleLanguage<Ctx> {
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
        System.out.println("parse");

        // TODO 1 - charger depuis request

        final RootNode main = new RootNode(this) {

            @Override
            public Object execute(VirtualFrame frame) {
                // TODO 2 - définir comment appeler le code
                return 43;
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
