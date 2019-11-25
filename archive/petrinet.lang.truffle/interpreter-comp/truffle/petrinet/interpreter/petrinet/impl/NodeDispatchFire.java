package truffle.petrinet.interpreter.petrinet.impl;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.dsl.Cached;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.DirectCallNode;
import com.oracle.truffle.api.nodes.IndirectCallNode;
import com.oracle.truffle.api.nodes.Node;
import java.lang.Object;

public abstract class NodeDispatchFire extends Node {
  public static final int INLINE_CACHE_SIZE = 3;

  public abstract Object executeDispatch(Object function, Object[] arguments);

  @Specialization(
      limit = "INLINE_CACHE_SIZE",
      guards = "function.getCallTarget() == cachedTarget",
      assumptions = "callTargetStable"
  )
  protected static Object doDirect(NodeDispatchWrapperFire function, Object[] arguments,
      @Cached("function.getCallTargetStable()") Assumption callTargetStable,
      @Cached("function.getCallTarget()") RootCallTarget cachedTarget,
      @Cached("create(cachedTarget)") DirectCallNode callNode) {
    return callNode.call(arguments);}

  @Specialization(
      replaces = "doDirect"
  )
  protected static Object doIndirect(NodeDispatchWrapperFire function, Object[] arguments,
      @Cached("create()") IndirectCallNode callNode) {
    return callNode.call(function.getCallTarget(), arguments);}
}
