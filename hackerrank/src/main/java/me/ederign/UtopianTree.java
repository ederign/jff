package me.ederign;

import java.util.Scanner;

public class UtopianTree {

    private int currentHeight;
    private int cycles;

    public UtopianTree( int currentHeight,
                        int cycles ) {

        this.currentHeight = currentHeight;
        this.cycles = cycles;
    }

    public int calculate() {
        while ( stillHasCycles() ) {
            springCycle();
            if ( stillHasCycles() ) {
                summerCycle();
            }
        }
        return currentHeight;
    }

    private boolean stillHasCycles() {
        return cycles > 0;
    }

    private void summerCycle() {
        cycles = cycles -1;
        this.currentHeight++;
    }

    private void springCycle() {
        cycles = cycles -1;
        currentHeight = currentHeight * 2;
    }

    public static void main( String[] args ) {

        Scanner in = new Scanner( System.in );
        int numberOfCycles = in.nextInt();
        for ( int i = 0; i < numberOfCycles; i++ ) {
            int cycles = in.nextInt();
            UtopianTree tree = new UtopianTree( 1, cycles );
            System.out.println( tree.calculate() );
        }
    }
}
