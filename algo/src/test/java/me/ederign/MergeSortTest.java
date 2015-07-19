package me.ederign;

import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MergeSortTest {


    @Test
    public void emptyInput() {
        int[] arr = {};
        MergeSort.mergeSort(arr);
        assertEquals("[]", Arrays.toString(arr));
    }

    @Test
    public void inputWithOneEntry() {
        int[] arr = {1};
        MergeSort.mergeSort(arr);
        assertEquals("[1]", Arrays.toString(arr));
    }

    @Test
    public void reverseInput() {
        int[] arr = {22, 21, 19, 18, 15, 14, 9, 7, 5};
        MergeSort.mergeSort(arr);
        assertEquals("[5, 7, 9, 14, 15, 18, 19, 21, 22]", Arrays.toString(arr));

    }

    @Test
    public void alreadySorted() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        MergeSort.mergeSort(arr);
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", Arrays.toString(arr));
    }

    @Test
    public void loadSmallArray() throws IOException {

        int[] arr = FileReader.readToIntArray("SmallArray.txt");
        String sorted = "[2995, 4615, 9083, 9900, 14108, 16122, 25260, 25675, 29390, 29649, 40660, 45738, 46120, 49689, 53777, 54044, 58943, 60660, 79294, 80717, 85363, 90436, 91323, 92904, 95588]";
        MergeSort.mergeSort(arr);
        assertEquals(sorted, Arrays.toString(arr));
    }

    @Test
    public void smallArray() throws IOException {

        int[] arr = FileReader.readToIntArray("SmallArray.txt");
        String sorted = "[2995, 4615, 9083, 9900, 14108, 16122, 25260, 25675, 29390, 29649, 40660, 45738, 46120, 49689, 53777, 54044, 58943, 60660, 79294, 80717, 85363, 90436, 91323, 92904, 95588]";
        MergeSort.mergeSort(arr);
        assertEquals(sorted, Arrays.toString(arr));
    }


//    @Test
    public void bigArray() throws IOException {

        int[] arr = FileReader.readToIntArray("IntegerArray.txt");
        String sorted = "[2995, 4615, 9083, 9900, 14108, 16122, 25260, 25675, 29390, 29649, 40660, 45738, 46120, 49689, 53777, 54044, 58943, 60660, 79294, 80717, 85363, 90436, 91323, 92904, 95588]";
        MergeSort.mergeSort(arr);
        assertEquals(sorted, Arrays.toString(arr));
    }

}
