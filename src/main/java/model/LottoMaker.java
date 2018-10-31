package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMaker {
    private static final int BOUND_NUMBER = 46;
    private static final int NUMBER_PER_LOTTO = 6;

    private static List makeNumbersInRange() {
        List<Integer> numbers = new ArrayList();
        for (int i = 1; i < BOUND_NUMBER; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    private static List<Integer> shuffleNumbers(List<Integer> numbers) {
        Collections.shuffle(numbers);

        List<Integer> shuffledNumbers = new ArrayList();
        for (int i = 0; i < NUMBER_PER_LOTTO; i++) {
            shuffledNumbers.add(numbers.get(i));
        }
        return shuffledNumbers;
    }

    private static int[] sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);

        int[] sortedNumbers = new int[NUMBER_PER_LOTTO];
        for (int i = 0; i < sortedNumbers.length; i++) {
            sortedNumbers[i] = numbers.get(i);
        }
        return sortedNumbers;
    }

    public LottoList makeLottoList(int money) {
        LottoList lottoList = new LottoList();
        for (int i = 0; i < money / 1000; i++) {
            lottoList.addLottoToList(makeLotto());
        }
        return lottoList;
    }

    public static Lotto makeLotto() {
        return new Lotto(sortNumbers(shuffleNumbers(makeNumbersInRange())));
    }
}
