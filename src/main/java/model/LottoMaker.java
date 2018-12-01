package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMaker {
    private static final int MIN_BOUND_NUMBER = 1;
    private static final int MAX_BOUND_NUMBER = 45;
    private static final int NUMBER_PER_LOTTO = 6;
    private static final int PRICE_OF_LOTTO = 1000;

    private List<Integer> makeNumbersInRange() {
        List<Integer> numbers = new ArrayList();
        for (int i = MIN_BOUND_NUMBER; i <= MAX_BOUND_NUMBER; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    private List<Integer> shuffleNumbers(List<Integer> numbers) {
        Collections.shuffle(numbers);

        return extractNumbers(numbers);
    }

    private List<Integer> extractNumbers(List<Integer> numbers) {
        List<Integer> extractedNumbers = new ArrayList();
        for (int i = 0; i < NUMBER_PER_LOTTO; i++) {
            extractedNumbers.add(numbers.get(i));
        }
        return extractedNumbers;
    }


    private List<LottoNo> sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);

        return convertListIntegerToLottoNo(numbers);
    }


    private List<LottoNo> convertListIntegerToLottoNo(List<Integer> integerList) {
        List<LottoNo> LottoNoList = new ArrayList();

        for (int number : integerList) {
            LottoNoList.add(new LottoNo(number));
        }

        return LottoNoList;
    }

    public LottoList makeLottoList(int money, List<Lotto> manualLottoList) {
        List<Lotto> lottoList = new ArrayList();
        lottoList.addAll(manualLottoList);
        lottoList.addAll(addAutoLottoList(money / PRICE_OF_LOTTO - manualLottoList.size()));
        return new LottoList(lottoList, money);
    }

    private List<Lotto> addAutoLottoList(int autoLottoCount) {
        List<Lotto> autoLottoList = new ArrayList<>();
        for (int i = 0; i < autoLottoCount; i++) {
            autoLottoList.add(makeLotto());
        }
        return autoLottoList;
    }

    public Lotto makeLotto() {
        return new Lotto(sortNumbers(shuffleNumbers(makeNumbersInRange())));
    }
}
