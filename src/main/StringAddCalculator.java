import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public int add(String text) {

        if(isNullOrEmpty(text)) { return 0; }

<<<<<<< HEAD
        int sum = 0;
        for (String token : splitText(text)) {
            checkException(token);
            sum += Integer.parseInt(token);
        }
        return sum;
    }

    private String[] splitText(String text) {
=======
        return checkRegex(text);
    }

    private int checkRegex(String text) {
>>>>>>> 9320ff2fc5ae48fd2d4ae57bec53740b9de73ec5
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if(m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
<<<<<<< HEAD
            return tokens;
        }
        String[] tokens = text.split(",|:");
        return tokens;
    }

    public boolean isNullOrEmpty(String text) {
        return (text == null || text.isEmpty());
=======
            return sum(tokens);
        }

        String[] tokens = text.split(",|:");
        return sum(tokens);
    }

    public boolean isNullOrEmpty(String text) {
        if(text == null || text.isEmpty()) {
            return true;
        }
        return false;
    }

    public int sum(String[] tokens) {
        int sum = 0;
        for (int i = 0; i < tokens.length; i++) {
            checkException(tokens[i]);
            sum += Integer.parseInt(tokens[i]);
        }
        return sum;
>>>>>>> 9320ff2fc5ae48fd2d4ae57bec53740b9de73ec5
    }

    public void checkException(String token) {
        if(Integer.parseInt(token) < 0) { throw new RuntimeException("음수는 사용할 수 없습니다."); }
    }
}
