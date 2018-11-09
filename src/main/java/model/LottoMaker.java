package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMaker {
    private static final int BOUND_NUMBER = 46;
    private static final int NUMBER_PER_LOTTO = 6;

    private List makeNumbersInRange() {
        List<Integer> numbers = new ArrayList();
        for (int i = 1; i < BOUND_NUMBER; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    private List<Integer> shuffleNumbers(List<Integer> numbers) {
        Collections.shuffle(numbers);

        List<Integer> shuffledNumbers = new ArrayList();
        for (int i = 0; i < NUMBER_PER_LOTTO; i++) {
            shuffledNumbers.add(numbers.get(i));
        }
        return shuffledNumbers;
    }

    private List sortNumbers(List<Integer> numbers) {
        List sortedNumbers = new ArrayList();

        Collections.sort(numbers);
        sortedNumbers.addAll(numbers);

        return sortedNumbers;
    }

    public LottoList makeLottoList(int money) {
        LottoList lottoList = new LottoList();
        for (int i = 0; i < money / 1000; i++) {
            lottoList.addLottoToList(makeLotto());
        }
        return lottoList;
    }

    public Lotto makeLotto() {
        return new Lotto(sortNumbers(shuffleNumbers(makeNumbersInRange())));
    }
}
