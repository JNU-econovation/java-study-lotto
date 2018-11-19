package utils;

import model.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public class Splitor {

    public static List<LottoNumber> stringToIntegerArray(String inputString) {
        String[] stringArray = inputString.replaceAll(" ","").split(",");
        List<LottoNumber> returnArray = new ArrayList<>();
        for (int i = 0; i < stringArray.length; i++) {
            returnArray.add(new LottoNumber(Integer.parseInt(stringArray[i])));
        }
        return returnArray;
    }
}
