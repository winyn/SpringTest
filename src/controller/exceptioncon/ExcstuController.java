package controller.exceptioncon;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

@Controller
public class ExcstuController {

    @RequestMapping(value = "excepjsp/exstudent", method = RequestMethod.GET)
    public ModelAndView Student(){
        return new ModelAndView("exstudent","command",new Extrastudent());
    }

    @RequestMapping(value = "/addExstudent",method = RequestMethod.POST)
    @ExceptionHandler(SpringException.class)
    public String addExstudent(@ModelAttribute("SpringTest")Extrastudent exstu, ModelMap model){
        if(exstu.getName().length() < 5){
            throw new SpringException("Given name is too short");
        }else{
            model.addAttribute("name",exstu.getName());
        }

        if(exstu.getAge() < 10){
            throw new SpringException("Given age is too low");
        }else{
            model.addAttribute("age",exstu.getAge());
        }
        model.addAttribute("id",exstu.getId());
        return  "excepjsp/exresult";
    }


}

