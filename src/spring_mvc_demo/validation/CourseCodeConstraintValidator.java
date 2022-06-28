package spring_mvc_demo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator  implements ConstraintValidator<CourseCode, String> {
    private String coursePrefix;

    @Override
    public void initialize(CourseCode constraintAnnotation) {
        // initialize with what the user has passed in
        // we will use the coursePrefix to check if the value that was passed by the user, contains the prefix specified into the parens of the annotation
        this.coursePrefix = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
        // no value was passed to the code
        if(theCode == null){
           return true;
        }
        else{
            if(theCode.startsWith(this.coursePrefix)){
                return true;
            }
            else{
                return false;
            }
        }




    }
}
