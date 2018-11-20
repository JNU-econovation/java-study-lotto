package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private List<LottoNumber> numbers;

    public Lotto() {
        numbers = new ArrayList<>();
        for (int i = 1; i < 46; i++) {
            numbers.add(new LottoNumber(i));
        }
        getRandomLotto();
    }

    public Lotto(List<LottoNumber> manualLotto) {
        this.numbers = manualLotto;
    }

    private void getRandomLotto() {
        Collections.shuffle(numbers);
        for (int i = numbers.size() - 1; i > 5; i--) {
            numbers.remove(i);
        }
        this.numbers = numbers.stream()
                .sorted(Comparator.comparing(LottoNumber::getNumber))
                .collect(Collectors.toList());
    }

    public String printLotto() {
        StringBuilder lottoPrinter = new StringBuilder();
        lottoPrinter.append("[");
        for (int i = 0; i < 5; i++) {
            lottoPrinter.append(numbers.get(i) + ", ");
        }
        lottoPrinter.append(numbers.get(5) + " ]\n");
        return lottoPrinter.toString();
    }

    public List<LottoNumber> getLottoNumbers() {
        return numbers;
    }
}