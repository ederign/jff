package me.ederign;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountSplitInversionsTest {


    @Test
    public void bruteForceTest() throws Exception {
        int[] sample = {1, 3, 5, 2, 4, 6};
        CountSplitInversions c = new CountSplitInversions();
        assertEquals(3, c.bruteForce(sample));
    }

    @Test
    public void withSmallArrayBrute() throws Exception {
        CountSplitInversions c = new CountSplitInversions();
        assertEquals(121, c.bruteForce(FileReader.readToIntArray("SmallArray.txt")));
    }

//    @Test too slow
    public void withBigArrayBrute() throws Exception {
        CountSplitInversions c = new CountSplitInversions();
        assertEquals(2407905288l, c.bruteForce(FileReader.readToIntArray("IntegerArray.txt")));
    }

    @Test
    public void oneInversion() throws Exception {
        int[] sample = {3, 1};
        CountSplitInversions c = new CountSplitInversions();
        assertEquals(1, c.withMergeSort(sample));
    }

    @Test
    public void threeInversions() throws Exception {
        int[] sample = {1, 3, 5, 2, 4, 6};
        CountSplitInversions c = new CountSplitInversions();
        assertEquals(3, c.withMergeSort(sample));
    }

    @Test
    public void withSmallArray() throws Exception {
        CountSplitInversions c = new CountSplitInversions();
        assertEquals(121, c.withMergeSort(FileReader.readToIntArray("SmallArray.txt")));
    }
    @Test
    public void withBigArray() throws Exception {
        CountSplitInversions c = new CountSplitInversions();
        assertEquals(2407905288l, c.withMergeSort(FileReader.readToIntArray("IntegerArray.txt")));
    }
}