package lotto.domain;

import lotto.dto.LottoDTO;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class Lotto {
    private List<Integer> lottoNumbers;
    private final int LOTTO_ENTRY_COUNT = 6;

    public Lotto() {
    }

    public Lotto(int[] allLotoNumbers) {
        for (int i = 0; i < LOTTO_ENTRY_COUNT; i++) {
            this.lottoNumbers.add(allLotoNumbers[i]);
        }
        Collections.sort(this.lottoNumbers, new Ascending());
    }

    public int checkMatches(ArrayList<Integer> winningLotto) {
        int numberOfMatches = 0;
        for (int i = 0; i < winningLotto.size(); i++) {
            if (lottoNumbers.contains(winningLotto.get(i))) { numberOfMatches++;}
        }
        return numberOfMatches;
    }

    public LottoDTO toLottoDTO() {
        return new LottoDTO(lottoNumbers);
    }

    public void drawLottoNumber() {
        final String result = lottoNumbers.stream()
                .map(String::valueOf)
                .collect(joining(", "));
        System.out.println("[" + result + "]");
    }

    class Ascending implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    }
}