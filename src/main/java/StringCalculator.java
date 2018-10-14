import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String input){

        if(input == null || input.isEmpty()){
            return 0;
        }

        return sum(toIntArray(toStringArray(input)));
    }

    private String[] toStringArray(String input){
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if(m.find()){
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return input.split(":|,");
    }

    private int[] toIntArray(String[] strings){
        int[] ints = new int[strings.length];
        for (int i = 0; i < strings.length ; i++) {
            ints[i] = Integer.parseInt(strings[i]);
            if( ints[i] < 0){
                throw new RuntimeException();
            }
        }

        return ints;
    }

    private int sum(int[] ints){
        int ans = 0;
        for(int i = 0; i < ints.length; i++){
            ans += ints[i];
        }
        return ans;
    }
}
