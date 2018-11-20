package model;

import java.util.HashMap;
import java.util.Map;

public class LottoNumber {
    private static final Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

    static {
        for (int i = 1; i < 46; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    private final int number;

    public LottoNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException();
        }

        this.number = number;
    }

    public int toInteger() {
        return number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    @Override
    public boolean equals(Object obj) {
        return this.number == ((LottoNumber) obj).toInteger();
    }

}