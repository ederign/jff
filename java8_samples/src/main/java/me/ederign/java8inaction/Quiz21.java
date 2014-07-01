package me.ederign.java8inaction;

import java.util.Arrays;
import java.util.List;

public class Quiz21 {

    public static void forEachApple( List<Apple> inventory,
                                     AppleConsumer behaviour ) {
        for ( Apple apple : inventory ) {
            behaviour.accept( apple );
        }
    }

    public static void main( String... args ) {

        List<Apple> inventory = Arrays.asList(
                new Apple( "blue", 1 ),
                new Apple( "green", 2 ) );

        forEachApple( inventory, new AppleConsumer() {
            @Override
            public void accept( Apple apple ) {
                System.out.println( apple );
            }
        } );
    }

}
