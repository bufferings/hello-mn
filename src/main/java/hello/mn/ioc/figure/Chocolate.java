package hello.mn.ioc.figure;

import javax.inject.Singleton;

@Singleton
public class Chocolate implements Snack {
  @Override
  public String name() {
    return "Chocolate";
  }
}
