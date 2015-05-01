package me.ederign;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaximizingXORTest {

    private MaximizingXOR maximizingXOR;

    @Before
    public void setup() {
        maximizingXOR = new MaximizingXOR();
    }

    @Test
    public void valueOfXor() {
        assertEquals( 5, maximizingXOR.xor( 10, 15 ) );
        assertEquals( 0, maximizingXOR.xor( 10, 10 ) );
    }

    @Test
    public void valueOfMaxXor() {
        assertEquals( 7, maximizingXOR.maxXor( 10, 15 ) );
        assertEquals( 15, maximizingXOR.maxXor( 1, 10 ) );
    }

}
