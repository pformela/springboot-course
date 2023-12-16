package com.example.validationdemo.model;


import com.example.validationdemo.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

    private String firstName;

    @NotNull(message = "is required")
    @Size(min=1, message = "Last name must be at least 1 character long")
    private String lastName;

    @NotNull(message = "is required")
    @Min(value = 0, message = "must be greater than 0")
    @Max(value = 10, message = "must be less than 10")
    private Integer freePasses;

    @CourseCode(value = "ABC", message = "must start with ABC")
    private String courseCode;

    @Pattern(regexp = "[0-9]{2}-[0-9]{3}", message = "Postal code must be in format xx-xxx")
    private String postalCode;

    public Customer() {}

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

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
}
