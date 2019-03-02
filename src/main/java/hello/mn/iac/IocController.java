package hello.mn.iac;

import hello.mn.iac.annotation.V6;
import hello.mn.iac.annotation.V8;
import hello.mn.iac.annotation.V8Engine;
import hello.mn.iac.type.Engine;
import io.micronaut.context.ApplicationContext;
import io.micronaut.context.BeanContext;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.inject.qualifiers.Qualifiers;

import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Controller("/ioc")
public class IocController {

  private final BeanContext beanContext;

  private final ApplicationContext applicationContext;

  private final Engine v6Engine;

  private final Engine v8Engine;

  private final Engine v6Engine2;

  private final Engine v8Engine2;

  private final Engine v8Engine3;

  private final List<Engine> engines;

  public IocController(
      // Inject BeanContext
      BeanContext beanContext,
      // Inject ApplicationContext
      ApplicationContext applicationContext,
      // Named Qualifier
      @Named("v6") Engine v6Engine,
      @Named("v8") Engine v8Engine,
      // Annotation Qualifier
      @V6 Engine v6Engine2,
      @V8 Engine v8Engine2,
      @V8Engine Engine v8Engine3,
      // Container types
      List<Engine> engines) {
    this.beanContext = beanContext;
    this.applicationContext = applicationContext;
    this.v6Engine = v6Engine;
    this.v8Engine = v8Engine;
    this.v6Engine2 = v6Engine2;
    this.v8Engine2 = v8Engine2;
    this.v8Engine3 = v8Engine3;
    this.engines = engines;
  }

  @Get(produces = MediaType.TEXT_PLAIN)
  public String index() {
    return beanContext.getBean(Engine.class, Qualifiers.byName("v6")).start() + ", "
        + beanContext.getBean(Engine.class, Qualifiers.byName("v8")).start() + ", "
        + applicationContext.getBean(Engine.class, Qualifiers.byName("v6")).start() + ", "
        + applicationContext.getBean(Engine.class, Qualifiers.byName("v8")).start() + ", "
        + v6Engine.start() + ", "
        + v8Engine.start() + ", "
        + v6Engine2.start() + ", "
        + v8Engine2.start() + ", "
        + v8Engine3.start() + ", "
        + engines.stream().map(Engine::start).collect(Collectors.joining(", ", "[", "]"));
  }
}
