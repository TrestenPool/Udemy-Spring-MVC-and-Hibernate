package spring_mvc_demo.driver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringApp {

    @RequestMapping("/")
    public String index(){
       return "main-menu";
    }
}
