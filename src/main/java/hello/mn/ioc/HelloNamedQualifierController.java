package hello.mn.ioc;

import hello.mn.ioc.engine.Engine;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.inject.Named;

@Controller("/hello/nq")
public class HelloNamedQualifierController {

  private final Engine v6Engine;

  private final Engine v8Engine;

  public HelloNamedQualifierController(
      @Named("v6") Engine v6Engine,
      @Named("v8") Engine v8Engine) {
    this.v6Engine = v6Engine;
    this.v8Engine = v8Engine;
  }

  @Get(produces = MediaType.TEXT_PLAIN)
  public String index() {
    return v6Engine.start() + ", " + v8Engine.start();
  }
}
