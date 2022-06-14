package spring_mvc_demo;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.ContextExposingHttpServletRequest;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SpringApp {

    // index page should go to the main menu
    @RequestMapping("/")
    public String index() {
        return "main-menu";
    }

    @RequestMapping("/showForm")
    public String showForm() {
        return "blank-form";
    }

    // alternate way
    @RequestMapping("/processForm")
    public String otherPage(){
        return "processed-form";
    }

    // We are accepting the request and the model
    @RequestMapping("/processFormVersionTwo")
    public String processFormTwo(HttpServletRequest request, Model model){
        // gets the parameter studentName from the request of the form
        String theName = request.getParameter("studentName");

        // convert the name to all caps
        theName = theName.toUpperCase();

        // create the message
        String result = "YO! " + theName;

        // adds data to the model
        model.addAttribute("message", result);

        // render the page, passes "message" with the value of result to the view
        return "helloWorld";
    }

    // Using the @RequestParam instead
    @RequestMapping("/processFormVersionThree")
    public String processFormThree(@RequestParam("studentName") String theName, Model model){

        // convert to uppercase
        theName = theName.toUpperCase();

        // create the message
        String result = "Heyyooo! " + theName;

        // add data to the model
        model.addAttribute("message", result);

        // render the page
        return "helloWorld";
    }

}
