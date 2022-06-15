package spring_mvc_demo.driver;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring_mvc_demo.models.Student;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloForms {

    // main menu
    @RequestMapping("")
    public String index() {
        return "main-menu";
    }

    // show the hello form
    @RequestMapping("/showForm")
    public String showForm(Model model) {
        return "hello_blankForm";
    }

    // Using the @RequestParam instead
    @RequestMapping("/processForm")
    public String processForm(@RequestParam("name") String theName, Model model){

        // convert to uppercase
        theName = theName.toUpperCase();

        // create the message
        String result = "Heyyooo! " + theName;

        // add data to the model
        model.addAttribute("message", result);

        // render the page
        return "hello_processedForm";
    }

}
