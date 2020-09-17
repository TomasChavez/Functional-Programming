package streams;
import static streams._Stream.Gender.MALE;
import static streams._Stream.Gender.FEMALE;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _Stream {
    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("John", MALE),
            new Person("Maria", FEMALE),
            new Person("Aisha", FEMALE),
            new Person("Alex", MALE),
            new Person("Alice", FEMALE)
        );
        /// loop -> list of genders 
        /// sort remove the duplicates from the list of genders
        // another loop to print out all the reminaing stuff within the list of genders
        people.stream()
            .map(person -> person.gender) // converts the list of person to list of genders // MALE, FEMALE, F, M, F
            .collect(Collectors.toSet()) // eliminates all duplicates Set -> // M, F, 
            .forEach(System.out::println); // prints the set: gender -> System.out.println(gender) ----> MALE, FEMALE

        people.stream()
            .map(person -> person.name) // converts the list of person to list of name
            .mapToInt(String::length) // 4, 5 , 5
            .forEach(System.out::println); // prints the set

        //1 way to achieve this    
        /* boolean containsOnlyFemales = people.stream()
            .allMatch(person -> FEMALE.equals(person.gender));
        System.out.println(containsOnlyFemales); */
        //2 way to achieve this
        Predicate<Person> femalePredicate = person -> FEMALE.equals(person.gender);
        boolean containsOnlyFemales = people.stream().allMatch(femalePredicate);
        System.out.println(containsOnlyFemales);
    }
    
    static class Person{
        private final String name;
        private final Gender gender;
        
        Person(String name, Gender gender){
            this.name = name;
            this.gender = gender;
        }
        @Override
        public String toString() {
            return "{" +
                " name='" + this.name + "'" +
                ", gender='" + this.gender + "'" +
                "}";
        }
    }  

    enum Gender{
        MALE, FEMALE
    }
}
