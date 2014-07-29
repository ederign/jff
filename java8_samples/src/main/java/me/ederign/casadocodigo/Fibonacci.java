package me.ederign.casadocodigo;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class Fibonacci implements IntSupplier {

    private int anterior = 0;
    private int proximo = 1;

    public int getAsInt() {
        proximo = proximo + anterior;
        anterior = proximo - anterior;
        return anterior;
    }

    public static void main( String... args ) {
        int maiorQue100 = IntStream.generate( new Fibonacci() ).filter( f -> f > 100 ).findFirst().getAsInt();
        System.out.println(maiorQue100);
    }
}
