package functionalInterface;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args){
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("09000987000"));

        // using Predicate
        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
        // chaining Predicates.
        isPhoneNumberValidPredicate.and(containsNumber3).test("07000000000"); // false

        isPhoneNumberValidPredicate.or(containsNumber3).test("07000000000"); // true

    }
    // Predicate similar to this method below
    static boolean isPhoneNumberValid (String phoneNumber){
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    }
    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
    phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    static Predicate<String> containsNumber3 = phoneNumber -> phoneNumber.contains("3");
}