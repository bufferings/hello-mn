package hello.mn.iac;

import hello.mn.iac.color.ColorPicker;
import hello.mn.iac.engine.Engine;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.List;
import java.util.stream.Collectors;

@Controller("/hello/ct")
public class HelloContainerTypeController {

  private final List<Engine> engines;

  private final List<ColorPicker> colorPickers;

  public HelloContainerTypeController(
      List<Engine> engines,
      List<ColorPicker> colorPickers) {
    this.engines = engines;
    this.colorPickers = colorPickers;
  }

  @Get(produces = MediaType.TEXT_PLAIN)
  public String index() {
    return engines.stream().map(Engine::start).collect(Collectors.joining(", ")) + ", "
        + colorPickers.stream().map(ColorPicker::color).collect(Collectors.joining(", "));
  }
}
