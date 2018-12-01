package model;

import dto.LottoDTO;
import dto.ResultDTO;
import utils.Splitor;

import java.util.*;

public class Result {
    private static int PRICE = 1000;
    private WinningLotto winningLotto;
    private double profit;
    private Map<Rank, Integer> winningInformation;

    public Result(String winningString, int bonusBall, LottoMachine lottoMachine) {
        this.winningLotto = new WinningLotto(Splitor.stringToIntegerArray(winningString), bonusBall);
        winningInformation = new HashMap<>();
        winningInformation.put(Rank.FIRST, 0);
        winningInformation.put(Rank.SECOND, 0);
        winningInformation.put(Rank.THIRD, 0);
        winningInformation.put(Rank.FOURTH, 0);
        winningInformation.put(Rank.FIFTH, 0);
        winningInformation.put(Rank.MISS, 0);
        calculateProfit(lottoMachine.lottoDTO(), winningInformation);
        this.profit = summationProfit(winningInformation, lottoMachine);
    }

    private boolean isBonusMatched(List<LottoNumber> lotto) {
        LottoNumber bonusNumber = winningLotto.winningLottoDTO().getBonusNumber();
        if (lotto.contains(bonusNumber))
            return true;
        else
            return false;
    }

    private Integer getMatchingCount(List<LottoNumber> lotto) {
        int count = 0;
        count = (int) lotto.stream().filter(winningLotto.winningLottoDTO().getWinningNumbers()::contains).count();
        return count;
    }

    private void calculateProfit(LottoDTO lottoDTO, Map<Rank, Integer> winningInformation) {
        for (Lotto lottos : lottoDTO.getLottos()) {
            List<LottoNumber> lotto = lottos.getLottoNumbers();
            Rank rank = Rank.valueOf(getMatchingCount(lotto), isBonusMatched(lotto));
            winningInformation.put(rank, winningInformation.get(rank) + 1);
        }
    }

    private double summationProfit(Map<Rank, Integer> winningLottoByRank, LottoMachine lottoMachine) {
        double sum = 0;
        for (Rank rank : winningLottoByRank.keySet()) {
            sum += winningLottoByRank.get(rank) * rank.getWinningMoney();
        }
        return sum / (lottoMachine.lottoDTO().getLottos().size() * PRICE);
    }

    public ResultDTO resultDTO() {
        return new ResultDTO(winningInformation, profit);
    }
}