package me.ederign.java8inaction;

public class Apple {

    private String color;
    private int size;

    public Apple( String color,
                  int size ) {
        this.color = color;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", size=" + size +
                '}';
    }
}
