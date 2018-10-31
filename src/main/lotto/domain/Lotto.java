package lotto.domain;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private List<Integer> lottoNumbers;
    private int numberOfMatches;
    private final int LOTTO_NUMBER = 6;

    public Lotto() {

    }

    public Lotto(int[] allLotoNumbers) {
        for (int i = 0; i < LOTTO_NUMBER; i++) {
            this.lottoNumbers.add(allLotoNumbers[i]);
        }
        Collections.sort(this.lottoNumbers, new Ascending());
    }

    public void checkMatches(int[] winningLotto) {
        // ArrayList contains()
    }

    class Ascending implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    }
}