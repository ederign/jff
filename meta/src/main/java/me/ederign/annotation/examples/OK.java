package me.ederign.annotation.examples;


import me.ederign.annotation.processor.ToString;

@ToString
public class OK {


    @Override
    public String toString()
    {
        return "E";
    }
}
