package spring_mvc_demo.models;

import spring_mvc_demo.validation.CourseCode;

import javax.validation.constraints.*;

public class Customer {
    @NotNull(message = "is required")
    private String firstName;

    @NotNull(message = "is required")
    @Pattern(regexp = "[a-zA-z0-9]{5}", message = "only 5 chars/digits")
    private  String postalCode;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;

//    @Pattern(regexp = "^[0-9]*$", message = "This field only accepts numbers")
    @NotNull(message = "is required")
    @Min(value = 0, message = "Must be greater than or equal to zero")
    @Max(value = 10, message = "Must be less than or equal to 10")
    private Integer freePasses;

    @CourseCode
    private String courseCode;

    // empty constructor
    public Customer() {
    }

    //////// GETTERS AND SETTERS ///////
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
