package hello.mn.iac;

import hello.mn.iac.color.ColorPicker;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/hello/pt")
public class HelloPrimaryTypeController {

  private final ColorPicker colorPicker;

  public HelloPrimaryTypeController(ColorPicker colorPicker) {
    this.colorPicker = colorPicker;
  }

  @Get(produces = MediaType.TEXT_PLAIN)
  public String index() {
    return colorPicker.color();
  }
}
