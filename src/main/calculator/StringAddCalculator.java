package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public int add(String text) {

        if(isNullOrEmpty(text)) { return 0; }

        int sum = 0;
        for (String token : splitText(text)) {
            checkException(token);
            sum += Integer.parseInt(token);
        }
        return sum;
    }

    private String[] splitText(String text) {

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if(m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return tokens;
        }
        String[] tokens = text.split(",|:");
        return tokens;
    }

    public boolean isNullOrEmpty(String text) {
        return (text == null || text.isEmpty());
    }

    public void checkException(String token) {
        if(Integer.parseInt(token) < 0) { throw new RuntimeException("음수는 사용할 수 없습니다."); }
    }
}
