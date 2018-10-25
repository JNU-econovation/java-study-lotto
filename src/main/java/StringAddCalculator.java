import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    String inputString() {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        return inputString;
    }

    String foundCustomSplitor(String inputString) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(inputString);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return "|".concat(customDelimiter);
        } else
            return null;
    }

    String[] splitString(String inputString, String customSplitor) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(inputString);
        String basicSplitor = ",|:";

        if (matcher.find()) {
            return matcher.group(2).split(basicSplitor.concat(customSplitor));
        } else
            return inputString.split(basicSplitor);
    }

    void foundNegative(String inputString) {
        Matcher matcher = Pattern.compile("-(.)").matcher(inputString);
        if (matcher.find()) {
            throw new RuntimeException("RuntimeException");
        }
    }

    int calculateStringArray(String[] splittedStringArray) {
        int summation = 0;
        if (splittedStringArray == null) {
            return 0;
        }
        for (int i = 0; i < splittedStringArray.length; i++) {
            summation += Integer.parseInt(splittedStringArray[i]);
        }
        return summation;
    }
}
