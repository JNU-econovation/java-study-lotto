package model;

import java.util.*;

public class LottoTicket {
    public static final int MAX_NUMBER = 6;
    public static final int[] NUMBER = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22,
            23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45};
    private List<Integer> numbers;

    public LottoTicket() {
        makeAutoNumber();
    }

    public LottoTicket(String numberString) {
        makeManualNumber(numberString);
    }

    private void makeAutoNumber() {
        ArrayList<Integer> ball = new ArrayList<>();
        for (int number : NUMBER) {
            ball.add(number);
        }
        Collections.shuffle(ball);
        numbers = ball.subList(0, MAX_NUMBER);
        sort();
    }

    private void makeManualNumber(String numberString) {
        StringTokenizer stringTokenizer = new StringTokenizer(numberString, ", ");
        while (stringTokenizer.hasMoreTokens()) {
            numbers.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        sort();
    }

    public void sort() {
        Collections.sort(numbers);
    }

    public boolean isContain(int i) {
        return numbers.contains(i);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[");
        for (int i = 0; i < numbers.size() - 1; i++) {
            stringBuilder.append(String.format("%d, ", numbers.get(i)));
        }
        stringBuilder.append(numbers.get(numbers.size() - 1) + "]");

        return stringBuilder.toString();
    }
}
