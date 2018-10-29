package model;

import util.RanNumGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class LottoTicket {
    List<Integer> numbers = new ArrayList<>();

    public LottoTicket() {
        selectNumAuto();
    }

    public LottoTicket(String numString) {
        StringTokenizer stringTokenizer = new StringTokenizer(numString, ", ");
        while (stringTokenizer.hasMoreTokens()) {
            numbers.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
    }

    public void selectNumAuto() {
        while (numbers.size() < 6) {
            int ranNum = RanNumGenerator.getRanNumber();
            if (!numbers.contains(ranNum)) {
                numbers.add(ranNum);
            }
        }
        sort();
    }

    public void sort() {
        Collections.sort(numbers);
    }

    public int checkWinner(int[] winnerNum) {
        int num = 0;
        for (int i = 0; i < winnerNum.length; i++) {
            if (numbers.contains(winnerNum[i])) num++;
        }
        return num;
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
