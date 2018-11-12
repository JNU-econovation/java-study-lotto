package lotto.domain;

import lotto.dto.LottoDTO;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private List<Integer> lottoNumbers = new ArrayList<>();

    public Lotto(List<Integer> selectedLottoNumber) {
        this.lottoNumbers.addAll(selectedLottoNumber);
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

    class Ascending implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    }
}