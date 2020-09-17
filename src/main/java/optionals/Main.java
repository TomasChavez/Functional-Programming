package optionals;

import java.util.Optional;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args){
        Optional.ofNullable("Hello").orElseGet(() -> "Default Value");

        Supplier<? extends IllegalStateException> exceptionSupplier = () -> new IllegalStateException("Exception");
        Optional.ofNullable("Hello").orElseThrow(exceptionSupplier);

        Optional.ofNullable(null)
            .ifPresentOrElse(
                email -> System.out.println("Sending email to "+ email),
                () -> System.out.println("Cannot Send email"));
    }
}