package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningLotto {
    private List<LottoNo> winningTicket;

    public WinningLotto(String winningNumbers) {
        winningTicket = new ArrayList<>();
        Arrays.asList(winningNumbers.split(", ")).stream()
                .map(s -> new LottoNo(Integer.parseInt(s)))
                .forEach(winningTicket::add);
    }

    public List<LottoNo> getWinningTicket() {
        return winningTicket;
    }
}