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

    public Result(String inputString, int bonusBall, LottoMachine lottoMachine) {
        this.winningLotto = new WinningLotto(Splitor.stringToIntegerArray(inputString), bonusBall);
        winningInformationSetting();
        calculateProfit(lottoMachine.lottoDTO(), winningInformation);
        this.profit = summationProfit(winningInformation, lottoMachine);
    }

    private void winningInformationSetting() {
        winningInformation = new HashMap<>();
        for (Rank rank : Rank.values()) {
            winningInformation.put(rank, 0);
        }
    }

    private boolean isBonusMatched(List<LottoNumber> lotto) {
        LottoNumber bonusNumber = winningLotto.winningLottoDTO().getBonusNumber();
        if (lotto.contains(bonusNumber))
            return true;
        else
            return false;
    }

    private Integer getMatchingCount(List<LottoNumber> lotto) {
        Integer matchingCount = 0;
        for (int i = 0; i < 6; i++)
            if (lotto.contains(winningLotto.winningLottoDTO().getWinningNumbers().get(i))) {
                matchingCount++;
            }
        return matchingCount;
    }

    public void calculateProfit(LottoDTO lottoDTO, Map<Rank, Integer> winningInformation) {
        for (Lotto lottos : lottoDTO.getLottos()) {
            List<LottoNumber> lotto = lottos.getLottoNumbers();
            Rank rank = Rank.valueOf(getMatchingCount(lotto), isBonusMatched(lotto));
            winningInformation.put(rank, winningInformation.get(rank));
        }
    }

    private double summationProfit(Map<Rank, Integer> winningLottoByRank, LottoMachine lottoMachine) {
        double sum = 0;
        for (Rank rank : winningLottoByRank.keySet()) {
            System.out.println(winningLottoByRank.get(rank));
            System.out.println(rank.getWinningMoney());
            sum += winningLottoByRank.get(rank) * rank.getWinningMoney();
        }
        return sum / (lottoMachine.lottoDTO().getLottos().size() * PRICE) * 100;
    }

    public ResultDTO resultDTO() {
        return new ResultDTO(winningInformation, profit);
    }
}