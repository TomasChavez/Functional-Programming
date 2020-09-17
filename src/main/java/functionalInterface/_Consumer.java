package functionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args){
       // Normal Java Function
        Customer maria = new Customer("Maria", "999-999-9999");
        greetCustomer(maria);
        // Consumer Functional Interface
        greetCustomerConsumer.accept(maria);
        greetCustomerConsumerV2.accept(maria,true);
        greetCustomerConsumerV2.accept(maria,false);

    }
    void greetCustomer(String name){
        System.out.println("Hello " + name);
    }
    static Consumer<Customer> greetCustomerConsumer =  customer -> System.out.println("Hello " + customer.customerName + ", thanks for registering phone number " 
    + customer.customerPhoneNumber);// cumsumer -> takes 1 arguments, returns (N/A)

    // BiConsumer
    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 =  (customer, showPhoneNumber) -> 
    System.out.println("Hello " + customer.customerName + ", thanks for registering phone number " 
    + (showPhoneNumber ? customer.customerPhoneNumber: "*** *** ****"));

    static void greetCustomer(Customer customer){
        System.out.println("Hello " + customer.customerName + ", thanks for registering phone number " 
        + customer.customerPhoneNumber);
    }

    static class Customer{
        private final String customerName;
        private final String customerPhoneNumber;
        Customer(String customerName, String customerPhoneNumber){
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}