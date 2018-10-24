import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final char START_NUMBER = '0';
    private static final char END_NUMBER = '9';

    public int add(String text) {
        int number = 0;
        if (isEmptyOrNull(text)) return number;

        for (String token : getTokens(text)) {
            check(token);
            number += Integer.parseInt(token);
        }
        return number;
    }

    public String[] getTokens(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(",|:");
    }

    public boolean isEmptyOrNull(String text) {
        return text == null || text.isEmpty();
    }

    public void check(String token) {
        for (int i = 0; i < token.length(); i++) {
            char c = token.charAt(i);
            if (c < START_NUMBER || END_NUMBER < c) throw new RuntimeException();
        }
    }
}
