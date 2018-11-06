package utils;

import java.util.Arrays;

public class SearchElement {

    public static boolean isIntegerElement(int[] arr, int targetValue) {
        int targetIndex = Arrays.binarySearch(arr, targetValue);
        if (targetIndex >= 0)
            return true;
        else
            return false;
    }

}
