package model;

import java.util.InputMismatchException;
import java.util.List;

public class Lotto {
    private List<LottoNo> lottoNumbers;
    private static final int COUNT_OF_LOTTO_NUMBERS = 6;

    public Lotto(List<LottoNo> lottoNumbers) {
        if (lottoNumbers.size() < COUNT_OF_LOTTO_NUMBERS) throw new InputMismatchException();

        for (LottoNo lottoNo : lottoNumbers) {
            if (lottoNumbers.equals(lottoNo.getLottoNo())) throw new InputMismatchException();
        }

        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNo> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        stringBuilder.append(lottoNumbers.get(0).getLottoNo());

        for (int i = 1; i < lottoNumbers.size(); i++) {
            stringBuilder.append(", ").append(lottoNumbers.get(i).getLottoNo());
        }

        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
