package me.ederign;

public class LambdaHelloWorld {
    interface HelloWorld {
        String hello(String name);
    }

    public static void main(String[] args) {
        HelloWorld helloWorld = (String name) -> { return "Hello " + name; };
        System.out.println(helloWorld.hello("Dorinha"));
    }
}