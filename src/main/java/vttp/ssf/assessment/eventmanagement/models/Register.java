package vttp.ssf.assessment.eventmanagement.models;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class Register {

    @NotNull
    @Size(min=5, max=50, message="5 to 50 characters")
    private String fullname;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Birthdate cannot be greater than the present date")
    private LocalDate dob;

    @Email(message = "Invalid Email Format")
    @Size(max = 50, message = "Email length exceeded 50 characters")
    @NotBlank(message = "Email is a mandatory field")
    private String email;

    @Pattern(regexp = "(8|9)[0-9]{7}", message = "Invalid phone number entered")
    private String phone;

    private String gender;

    @Min(value=1, message="Minimum 1")
    @Max(value=3, message="maximum 3")
    private Integer tickets;

    @Min(value = 21, message = "Must be above 21 years old")
    private Integer age;

    public String getFullname() {return fullname;}
    public void setFullname(String fullname) {this.fullname = fullname;}

    public LocalDate getDob() {return dob;}
    public void setDob(LocalDate dob) {
        int calculatedAge= 0;

        if(dob != null){
            calculatedAge = Period.between(dob,LocalDate.now()).getYears();
        }
        this.age = calculatedAge;
        this.dob=dob;
    }

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}

    public String getGender() {return gender;}
    public void setGender(String gender) {this.gender = gender;}

    public Integer getTickets() {return tickets;}
    public void setTickets(Integer tickets) {
        this.tickets = tickets;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Register [fullname=" + fullname + ", dob=" + dob + ", email=" + email + ", phone=" + phone + ", gender="
                + gender + ", tickets=" + tickets + ", age=" + age + "]";
    }
    public Register(String fullname,LocalDate dob,String email,String phone,String gender,Integer tickets, Integer age) {
{
        this.fullname = fullname;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.tickets = tickets;
        this.age = age;
    }

}
    public Register() {
    }
}
