package me.ederign;

import java.util.Scanner;

public class MaximizingXOR {

    public int xor( int l,
                    int r ) {
        return (int) ( l ^ r );
    }

    public int maxXor( int l,
                       int r ) {
        int max = 0;
        for ( int i = l; i <= r; i++ ) {
            for ( int k = l; k <= r; k++ ) {
                int candidate = xor( i, k );
                if ( candidate > max ) {
                    max = candidate ;
                }
            }
        }
        return max;
    }

    public static void main( String[] args ) {
        Scanner in = new Scanner( System.in );
        int l = in.nextInt();
        int r = in.nextInt();
        MaximizingXOR maximizingXOR = new MaximizingXOR();
        System.out.println( maximizingXOR.maxXor( l, r ) );
    }
}
