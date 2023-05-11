package utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String email;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String address;
    private String zipCode;
    private String city;
    private String province;
    private String phoneNumber;
    private String jobCategory;
    private String jobDescription;

    @Override
    public String toString() {
        return "\n" +
                "Email = " + email + "\n" +
                "Password = " + password + "\n" +
                "First name = " + firstName + "\n" +
                "Middle name = " + middleName + "\n" +
                "Last name = " + lastName + "\n" +
                "Gender = " + gender + "\n" +
                "Address = " + address + "\n" +
                "Zip Code = " + zipCode + "\n" +
                "City = " + city + "\n" +
                "Province = " + province + "\n" +
                "Phone Number = " + phoneNumber + "\n" +
                "Job Category = " + jobCategory + "\n" +
                "Job Description = " + jobDescription + "\n";
    }
}