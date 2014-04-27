package me.ederign;

import java.util.Arrays;
import java.util.List;

public class MoreSamples {

    public static void main( String[] args ) {
        new Thread( () -> System.out.println( "In Java8, Lambda expression rocks !!" ) ).start();

        List features = Arrays.asList( "Lambdas", "Default Method", "Stream API", "Date and Time API" );
        features.forEach( n -> System.out.println( n ) );

    }

}
