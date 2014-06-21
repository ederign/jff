package me.ederign.annotation.examples;

import me.ederign.annotation.processor.ToString;

@ToString
public class ErrorAgain {

    public String toString(int x) {
        return "F " + x;
    }
}
