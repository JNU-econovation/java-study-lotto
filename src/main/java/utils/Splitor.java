package utils;

import java.util.ArrayList;
import java.util.List;

public class Splitor {

    public static List stringToIntegerArray(String inputString) {
        String[] stringArray = inputString.split(",");
        List<Integer> returnArray = new ArrayList<>();
        for (int i = 0; i < stringArray.length; i++) {
            returnArray.add(Integer.parseInt(stringArray[i]));
        }
        return returnArray;
    }
}
