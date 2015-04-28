package me.ederign;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtopianTreeTest {

    @Test
    public void utopianTree() {
        assertEquals( 1, new UtopianTree( 1, 0 ).calculate() );
        assertEquals( 2, new UtopianTree( 1, 1 ).calculate() );
        assertEquals( 7, new UtopianTree( 1, 4 ).calculate() );
    }

}