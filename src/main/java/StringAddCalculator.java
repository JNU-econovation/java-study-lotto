import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private String numberRegex = "^[0-9]*$";
    private String customDelimiterRegex = "^//(.)\n(.*)$";

    public int add(String text) {
        if (isNull(text)) return 0;
        return addNumbers(splitText(text));
    }

    private boolean isNull(String text) {
        return text == null || text.isEmpty();
    }

    private int addNumbers(String[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            checkNotNumber(numbers[i]);
            checkNegative(Integer.parseInt(numbers[i]));
            sum += Integer.parseInt(numbers[i]);
        }
        return sum;
    }

    private void checkNotNumber(String text) {
        Pattern onlyNumberPattern = Pattern.compile(numberRegex);
        Matcher matchPattern = onlyNumberPattern.matcher(text);
        if (matchPattern.find()) throw new RuntimeException();
    }

    private void checkNegative(int number) {
        if (number < 0) throw new RuntimeException();
    }

    private String[] splitText(String text) {
        Pattern customDelimiterPattern = Pattern.compile(customDelimiterRegex);
        Matcher matchPattern = customDelimiterPattern.matcher(text);

        if (matchPattern.find()) {
            String customDelimiter = matchPattern.group(1);
            return matchPattern.group(2).split(customDelimiter);
        }
        return text.split(",|:");
    }
}
