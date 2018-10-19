package petrinet_exec.impl.operation;

public interface Arc {
  boolean canFire();

  void removeToken();

  void addToken();
}
