package model;

import java.util.HashMap;
import java.util.Map;

public class LottoNumber {
    private static final Map<Integer, LottoNumber> lottoNos = new HashMap<>();

    static {
        for (int i = 1; i < 46; i++) {
            lottoNos.put(i, new LottoNumber(i));
        }
    }

    private final int no;

    public LottoNumber(int no) {
        if (no < 1 || no > 45) {
            throw new IllegalArgumentException();
        }

        this.no = no;
    }

    public int getNumber(){
        return no;
    }

    @Override
    public String toString(){
        return Integer.toString(no);
    }

//TODO
}