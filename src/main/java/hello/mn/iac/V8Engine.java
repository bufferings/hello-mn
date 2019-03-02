package hello.mn.iac;

import javax.inject.Singleton;

@Singleton
public class V8Engine implements Engine {
  int cylinders = 8;

  @Override
  public int getCylinders() {
    return cylinders;
  }

  @Override
  public String start() {
    return "Starting V8";
  }
}