package Utils;

import java.util.Arrays;

public class SearchElement {

    public static boolean searchIntegerElement(int[] arr, int targetValue) {
        int targetIndex = Arrays.binarySearch(arr, targetValue);
        if (targetIndex >= 0)
            return true;
        else
            return false;
    }

}
