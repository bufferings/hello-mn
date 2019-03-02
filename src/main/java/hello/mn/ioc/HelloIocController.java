package hello.mn.ioc;

import hello.mn.ioc.snack.Snack;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/hello/ioc")
public class HelloIocController {

  private final Snack snack;

  public HelloIocController(Snack snack) {
    this.snack = snack;
  }

  @Get(produces = MediaType.TEXT_PLAIN)
  public String index() {
    return snack.name();
  }
}
