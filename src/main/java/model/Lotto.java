package model;

import java.util.List;

public class Lotto {
    private List<Integer> lottoNumbers;

    public Lotto(List lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
