package model;

import java.util.Objects;

public class LottoNo implements Comparable<LottoNo> {
    private int number;

    public LottoNo(int number) {
        // number가 1~45가 아닐 경우 예외 처리하기
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(LottoNo o) {
        return number - o.getNumber();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNo lottoNo = (LottoNo) o;
        return number == lottoNo.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
