package functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        //Function takes 1 argument and produces 1 result
        int increment = incrementByOne(1);
        System.out.println(increment);
        int increment2 = incrementByOneFunction.apply(1); // calling the function
        System.out.println(increment2);// printing the function
        //chainging functions
        int multiFunction = multiplyBy10Function.apply(increment2);
        System.out.println(multiFunction);
        Function<Integer,Integer> addBy1AndThenMultiplyBy10 = incrementByOneFunction.andThen(multiplyBy10Function);
        System.out.println(addBy1AndThenMultiplyBy10.apply(4));
        //bifunction takes two arguments and produces one result
        System.out.println(
            incrementbyOneAndMultiplyBiFunction.apply(4, 100)
        );

        
    }
    //Establishing a function
    static Function<Integer,Integer> incrementByOneFunction = number -> number + 1;
    //chainging functions 
    static Function<Integer,Integer> multiplyBy10Function = number -> number * 10;
   
   //BiFunction declaration
   static BiFunction<Integer,Integer,Integer> incrementbyOneAndMultiplyBiFunction = 
        (numberToIncrementByOne,numberToMultiplyBy) 
            -> (numberToIncrementByOne + 1) * numberToMultiplyBy; 
    static int incrementByOne(int number){
        return number + 1;
    }
    static int incrementbyOneAndMultiply(int number, int numToMultiplyBy){
        return (number + 1) * numToMultiplyBy;
    }

}