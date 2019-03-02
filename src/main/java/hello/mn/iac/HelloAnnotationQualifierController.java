package hello.mn.iac;

import hello.mn.iac.engine.Engine;
import hello.mn.iac.engine.annotation.V6;
import hello.mn.iac.engine.annotation.V8;
import hello.mn.iac.engine.annotation.V8Engine;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/hello/aq")
public class HelloAnnotationQualifierController {

  private final Engine v6Engine;

  private final Engine v8Engine;

  private final Engine v8Engine2;

  public HelloAnnotationQualifierController(
      @V6 Engine v6Engine,
      @V8 Engine v8Engine,
      @V8Engine Engine v8Engine2) {
    this.v6Engine = v6Engine;
    this.v8Engine = v8Engine;
    this.v8Engine2 = v8Engine2;
  }

  @Get(produces = MediaType.TEXT_PLAIN)
  public String index() {
    return v6Engine.start() + ", "
        + v8Engine.start() + ", "
        + v8Engine2.start();
  }
}
