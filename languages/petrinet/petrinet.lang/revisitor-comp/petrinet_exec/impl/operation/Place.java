package petrinet_exec.impl.operation;

public interface Place extends Node {
  boolean canFire();

  boolean hasToken();

  void fire();

  void removeToken();

  void addToken();
}
