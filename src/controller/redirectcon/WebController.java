package controller.redirectcon;

import controller.formcontrol.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

@Controller
public class WebController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "redirectjsp/index";
    }
    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public String redirect(){
        return "redirect:finalPage";
    }
    @RequestMapping(value = "/finalPage", method = RequestMethod.GET)
    public String finalPage(){
        return "redirectjsp/final";
    }
}

