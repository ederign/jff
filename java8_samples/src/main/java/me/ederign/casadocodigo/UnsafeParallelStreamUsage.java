package me.ederign.casadocodigo;

import java.util.stream.LongStream;

public class UnsafeParallelStreamUsage {

    private static long total1 = 0;
    private static long total2 = 0;
    public static void main (String... args) {
        LongStream.range( 0, 1_000_000_000 )
                .filter( x -> x % 2 == 0 )
                .forEach( n -> total1 += n );
        System.out.println(total1);

        LongStream.range( 0, 1_000_000_000 )
                .parallel()
                .filter( x -> x % 2 == 0 )
                .forEach( n -> total2 += n );
        System.out.println(total2);
    }
}
