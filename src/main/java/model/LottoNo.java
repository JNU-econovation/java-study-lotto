package model;

import java.util.InputMismatchException;

public class LottoNo {
    private int lottoNo;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public LottoNo(int lottoNo) {
        if (lottoNo < MIN_LOTTO_NUMBER || lottoNo > MAX_LOTTO_NUMBER) throw new InputMismatchException();

        this.lottoNo = lottoNo;
    }

    public int getLottoNo() {
        return lottoNo;
    }
}
