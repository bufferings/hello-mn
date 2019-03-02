package hello.mn.ioc;

import hello.mn.ioc.color.ColorPicker;
import hello.mn.ioc.engine.Engine;
import io.micronaut.context.ApplicationContext;
import io.micronaut.context.BeanContext;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.inject.qualifiers.Qualifiers;

@Controller("/hello/bc")
public class HelloBeanContextController {

  private final BeanContext beanContext;

  private final ApplicationContext applicationContext;

  public HelloBeanContextController(
      BeanContext beanContext,
      ApplicationContext applicationContext) {
    this.beanContext = beanContext;
    this.applicationContext = applicationContext;
  }

  @Get(produces = MediaType.TEXT_PLAIN)
  public String index() {
    return beanContext.getBean(Engine.class, Qualifiers.byName("v6")).start() + ", "
        + beanContext.getBean(Engine.class, Qualifiers.byName("v8")).start() + ", "
        + beanContext.getBean(ColorPicker.class).color() + ", "
        + applicationContext.getBean(Engine.class, Qualifiers.byName("v6")).start() + ", "
        + applicationContext.getBean(Engine.class, Qualifiers.byName("v8")).start() + ", "
        + applicationContext.getBean(ColorPicker.class).color();
  }
}
