package star.bucks.app.test.ctr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.file.AccessDeniedException;

@Controller
public class TestController {

    @RequestMapping(value = "/test")
    public String test() {
        return "jsp/main";
    }
}
