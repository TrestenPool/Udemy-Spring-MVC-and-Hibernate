package spring_mvc_demo.driver;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import spring_mvc_demo.models.Student;

@Controller
@RequestMapping("/student")
public class StudentForms {

    // main menu
    @RequestMapping("")
    public String index(){
        return "main-menu";
    }

    // show the blank form
    @RequestMapping("/showForm")
    public String showForm(Model model){
        // create new student
        Student student = new Student();

        // bind the student as model attribute
        model.addAttribute("student", student);

        return "student_blankForm";
    }

    // show the processed form
    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student){
        System.out.println("The student form for student: " + student.getFirstName() + " " +student.getLastName()  +" is being processed...");

        return "student_processedForm";
    }

}
