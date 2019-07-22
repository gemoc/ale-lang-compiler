package interpreter.fsm.interpreter.fsm.language;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.dsl.Cached;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.library.ExportLibrary;
import com.oracle.truffle.api.library.ExportMessage;
import com.oracle.truffle.api.nodes.DirectCallNode;
import com.oracle.truffle.api.nodes.IndirectCallNode;
import com.oracle.truffle.api.nodes.RootNode;
import com.oracle.truffle.api.utilities.CyclicAssumption;

public class Ctx {
    protected RootNode main;

    public TruffleObject getMain() {
        return new FunctionTruffleObject(main);
    }

    public void setMain(RootNode main) {
        this.main = main;
    }

    @ExportLibrary(InteropLibrary.class)
    static class FunctionTruffleObject implements TruffleObject {
        private final RootCallTarget main;
        private final CyclicAssumption callTargetStable;

        public static final int INLINE_CACHE_SIZE = 2;

        public RootCallTarget getCallTarget() {
            return main;
        }

        public Assumption getCallTargetStable() {
            return callTargetStable.getAssumption();
        }


        public FunctionTruffleObject(RootNode main) {
            this.main = Truffle.getRuntime().createCallTarget(main);
            this.callTargetStable = new CyclicAssumption("main");
        }

        @ExportMessage
        boolean isExecutable() {
            return true;
        }

        @ExportMessage
        abstract static class Execute {


            @Specialization(limit = "INLINE_CACHE_SIZE", //
                    guards = "function.getCallTarget() == cachedTarget", //
                    assumptions = "callTargetStable")
            @SuppressWarnings("unused")
            protected static Object doDirect(FunctionTruffleObject function, Object[] arguments,
                                             @Cached("function.getCallTargetStable()") Assumption callTargetStable,
                                             @Cached("function.getCallTarget()") RootCallTarget cachedTarget,
                                             @Cached("create(cachedTarget)") DirectCallNode callNode) {
                return callNode.call(arguments);
            }

            @Specialization(replaces = "doDirect")
            protected static Object doIndirect(FunctionTruffleObject function, Object[] arguments,
                                               @Cached IndirectCallNode callNode) {
                return callNode.call(function.main, arguments);
            }
        }
    }

}
