package finalsection;

import java.util.function.Function;

public class Lambdas {
    public static void main(String[] args) {
        // Function<String, String> upperCaseName = name -> name.toUpperCase();
        Function<String, String> upperCaseName = String::toUpperCase; // same as above

        /* Function<String, String> upperCaseName = name -> {
            //logic
            if(name.isBlank()) throw new IllegalArgumentException("N/A");
            return name.toUpperCase();
        }; */
        // Two argument function requires the arguments enclosed in parathensis
    }
}