package model;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private List<LottoNo> winningTicket;

    public WinningLotto(String winningNumbers) {
        winningTicket = new ArrayList<>();
        for (String winningNumber : winningNumbers.split(", ")) {
            winningTicket.add(new LottoNo(Integer.parseInt(winningNumber)));
        }
    }

    public List<LottoNo> getWinningTicket() {
        return winningTicket;
    }
}