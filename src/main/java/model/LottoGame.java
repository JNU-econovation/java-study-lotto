package model;

import dto.LottoGameDTO;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int PRICE = 1000;
    private List<Lotto> lottoList;
    private int autoCount;
    private int manualCount;

    public LottoGame(int money, int manualCount) {
        lottoList = new ArrayList<>();
        autoCount = money / PRICE - manualCount;
        this.manualCount = manualCount;
    }

    public void buyManualTickets(List<String> manualBallsList) {
        manualBallsList.stream()
                .map(s -> new Lotto(s))
                .forEach(lottoList::add);
    }

    public void buyAutoTickets() {
        for (int i = 0; i < autoCount; i++) {
            lottoList.add(new Lotto());
        }
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public LottoGameDTO toLottoGameDTO() {
        return new LottoGameDTO(lottoList, autoCount, manualCount);
    }
}