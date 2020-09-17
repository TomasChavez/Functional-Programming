package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {
    //basic way
    private boolean isEmailValid(String email){
        return email.contains("@");
    }
    private boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("1");
    }
    private boolean isAdult(LocalDate dob){
        return Period.between(dob, LocalDate.now()).getYears() > 18;
    }
//to add more validators will have to add additional functions and modify the method bellow
    public boolean isValid(Customer customer){
        return isEmailValid(customer.getEmail()) && 
            isPhoneNumberValid(customer.getPhoneNumber()) && 
            isAdult(customer.getDob());
    }
    
}