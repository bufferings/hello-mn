package hello.mn.ioc.snack;

import javax.inject.Singleton;

@Singleton
public class Chocolate implements Snack {
  @Override
  public String name() {
    return "Chocolate";
  }
}
