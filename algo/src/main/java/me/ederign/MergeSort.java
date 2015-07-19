package me.ederign;

public class MergeSort {

    public static void mergeSort(int[] inputArray) {
        if (!needsToSort(inputArray)) {
            return;
        }
        int arraySize = inputArray.length;
        int mid = arraySize / 2;
        int leftSize = mid;
        int rightSize = arraySize - mid;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        for (int i = 0; i < mid; i++) {
            left[i] = inputArray[i];
        }
        for (int i = mid; i < arraySize; i++) {
            right[i - mid] = inputArray[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(left, right, inputArray);
    }

    private static void merge(int[] left, int[] right, int[] inputArray) {
        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                inputArray[k] = left[i];
                i++;
            } else {
                inputArray[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < leftSize) {
            inputArray[k] = left[i];
            k++;
            i++;
        }
        while (j < rightSize) {
            inputArray[k] = right[j];
            k++;
            j++;
        }
    }

    private static boolean needsToSort(int[] inputArray) {
        return inputArray.length > 1;
    }
}
