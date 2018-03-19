package controller.hellocontrol;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/hello",method = RequestMethod.GET)
public class HelloController {
    @RequestMapping(value = "/mvc",method = RequestMethod.GET)
    public String hello(ModelMap mv) {
        mv.addAttribute("msg", "hello mvc");
        mv.addAttribute("name","winn");
        return "hellojsp/hello";
    }
}
