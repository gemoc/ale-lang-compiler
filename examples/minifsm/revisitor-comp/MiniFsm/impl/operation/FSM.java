package MiniFsm.impl.operation;

import java.lang.String;

public interface FSM {
  void handle(String event);

  void entryPoint();
}
