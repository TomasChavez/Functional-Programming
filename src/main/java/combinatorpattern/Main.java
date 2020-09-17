package combinatorpattern;

import java.time.LocalDate;

import combinatorpattern.CustomerRegistrationValidator.ValidationResult;
import static combinatorpattern.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
            "Alice",
            "Alice@gmail.com",
            "1-888-999-7777",
            LocalDate.of(2000,01, 17)
            );
        // CustomerValidatorService validatorService = new CustomerValidatorService();
        // System.out.println(validatorService.isValid(customer)); //true
        // if Valid We can store customer in db
        //Using combinator pattern.
        ValidationResult result = isEmailValid()
            .and(isPhoneNumberValid())
            .and(isAnAdult()).apply(customer);
        System.out.println(result);
        if(result != ValidationResult.SUCCESS){
            throw new IllegalStateException(result.name());
        }
    }
    /* Pure functional programming has a set of rules to follow
    1. No state : 
    2. Pure Functions : shouldn't depend on any other state (global)
    3. No side effects : shouldn't have an side effect outside of it
    4. Higher Order Functions
        The functions takes or or more functions as parameters 
        The function returns another function as a result */

}