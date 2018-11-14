package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class LottoTicket {
    public static final int ENTRY_NUMBER = 6;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final List<Number> BALL = new ArrayList<>();

    static {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            BALL.add(new Number(i));
        }
    }

    private List<Number> numbers = new ArrayList<>();

    public LottoTicket() {
        makeAutoTicket();
        Collections.sort(numbers);
    }

    public LottoTicket(String numberString) {
        makeManualTicket(numberString);
        Collections.sort(numbers);
    }

    private void makeManualTicket(String numberString) {
        StringTokenizer stringTokenizer = new StringTokenizer(numberString, ", ");
        while(stringTokenizer.hasMoreTokens()){
            numbers.add(new Number(Integer.parseInt(stringTokenizer.nextToken())));
        }
    }

    private void makeAutoTicket() {
        Collections.shuffle(BALL);
        for (int i = 0; i < ENTRY_NUMBER; i++) {
            numbers.add(BALL.get(i));
        }
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[");
        for (int i = 0; i < numbers.size() - 1; i++) {
            stringBuilder.append(String.format("%d, ", numbers.get(i).toInteger()));
        }
        stringBuilder.append(numbers.get(numbers.size() - 1).toInteger() + "]");

        return stringBuilder.toString();
    }

    public boolean hasNumber(Number number) {
        for (int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i).equals(number)) return true;
        }

        return false;
    }
}
