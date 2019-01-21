package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import java.lang.String;
import miniJava.interpreter.miniJava.impl.StateDispatchWrapperPushNewContext;
import miniJava.interpreter.miniJava.impl.StateDispatchWrapperPushNewFrame;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface State extends EObject, NodeInterface {
  Frame getRootFrame();

  void setRootFrame(Frame value);

  EList<ObjectInstance> getObjectsHeap();

  OutputStream getOutputStream();

  void setOutputStream(OutputStream value);

  EList<ArrayInstance> getArraysHeap();

  Context getContextCache();

  void setContextCache(Context value);

  Frame getFrameCache();

  void setFrameCache(Frame value);

  Frame findCurrentFrame();

  Context findCurrentContext();

  void pushNewContext();

  void popCurrentContext();

  void println(String str);

  void pushNewFrame(ObjectInstance receiver, Call c, Context newContext);

  void popCurrentFrame();

  StateDispatchWrapperPushNewContext getCachedPushNewContext();

  StateDispatchWrapperPushNewFrame getCachedPushNewFrame();
}
