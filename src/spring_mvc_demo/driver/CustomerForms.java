package spring_mvc_demo.driver;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import spring_mvc_demo.models.Customer;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerForms {

    @RequestMapping()
    public String index(){
       return "main-menu";
    }

    // show form
    @RequestMapping("/showForm")
    public String showForm(Model model){
        Customer customer = new Customer();

        model.addAttribute("customer", customer);

        return "customer_blankForm";
    }

    // process form
    @RequestMapping("/processForm")
    public String processForm(
            @Valid @ModelAttribute("customer") Customer customer,
            BindingResult bindingResult) {

        // check if the validator has any errors
        if(bindingResult.hasErrors()){
            return "customer_blankForm";
        }
        else{
            // print out logging message
            System.out.printf("The customer %s %s is getting processed\n", customer.getFirstName(), customer.getLastName());

            // redirect customer to the processed form
            return "customer_processedForm" ;
        }
    }


    @InitBinder
    public void initBinder(WebDataBinder dataBinder){

        // object that will trim strings
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        // adding the string trimmer to manipulate the incoming request
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

}
