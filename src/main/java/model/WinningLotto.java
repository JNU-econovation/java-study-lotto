package model;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private List<LottoNo> winningNumber;

    public WinningLotto(String s) {
        winningNumber = new ArrayList<>();
        for (String number : s.split(", ")) {
            winningNumber.add(new LottoNo(Integer.parseInt(number)));
        }
    }

}
