package Utils;

public class Splitor {

    public int[] splitStringToIntegerArray(String inputString) {
        String[] stringArray = inputString.split(",");
        int[] returnArray = new int[stringArray.length];

        for (int i = 0; i < returnArray.length; i++) {
            returnArray[i] = Integer.parseInt(stringArray[i]);
        }
        return returnArray;
    }
}
