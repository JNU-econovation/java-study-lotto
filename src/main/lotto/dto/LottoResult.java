package lotto.dto;

import lotto.domain.Lotto;

import java.util.HashMap;
import java.util.List;

public class LottoResult {

    private List<LottoDTO> LottoList;
    public HashMap<Integer, Integer> winningStatistic;

    public LottoResult() {

    }

    public LottoResult(List<LottoDTO> LottoList) {
        this.LottoList = LottoList;
    }

    public LottoResult(List<Lotto> LottoList, HashMap<Integer, Integer> winningStatistic) {
        LottoList = LottoList;
        winningStatistic = winningStatistic;
    }



}
