package hello.mn.iac.engine;

import javax.inject.Singleton;

@Singleton
public class V6Engine implements Engine {
  int cylinders = 6;

  @Override
  public int getCylinders() {
    return cylinders;
  }

  @Override
  public String start() {
    return "Starting V6";
  }
}
