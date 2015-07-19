package me.ederign;

public class CountSplitInversions {

    public long bruteForce(int[] inputArray) {
        long totalOfInversions=0;
        for (int i = 0; i <= inputArray.length - 1; i++) {
            for (int j = i + 1; j <= inputArray.length - 1; j++) {
                if (inputArray[j] < inputArray[i]) {
                    totalOfInversions++;
                }
            }

        }
        return totalOfInversions;
    }


    public long withMergeSort(int[] inputArray) {
        return mergeSortWithInversions(inputArray);
    }

    private long mergeSortWithInversions(int[] inputArray) {
        long totalOfInversions = 0;
        if (!needsToSort(inputArray)) {
            return 0;
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


        totalOfInversions += mergeSortWithInversions(left);
        totalOfInversions += mergeSortWithInversions(right);
        totalOfInversions += merge(left, right, inputArray);
        return totalOfInversions;
    }

    private long merge(int[] left, int[] right, int[] inputArray) {
        long totalOfInversions = 0;
        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                inputArray[k] = left[i];
                i++;
            } else {
                totalOfInversions += remainingItemsInLeft(left, i);
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
        return totalOfInversions;
    }

    private int remainingItemsInLeft(int[] left, int i) {
        return left.length - i;
    }

    private static boolean needsToSort(int[] inputArray) {
        return inputArray.length > 1;
    }
}
