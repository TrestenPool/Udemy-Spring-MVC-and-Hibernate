package spring_mvc_demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SpringApp {

    @RequestMapping(value="/index", method = RequestMethod.GET)
    public String showPage() {
        return "index";
    }

    @RequestMapping(value = "/processForm", method = RequestMethod.GET)
    public String otherPage(){
        return "process";
    }
}
