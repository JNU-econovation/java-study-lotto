package model;

import dto.LottoDTO;
import dto.ResultDTO;
import utils.Splitor;

import java.util.*;

public class Result {
    private List<Integer> winningNumbers;
    private double profit;
    private int matchingCounts[] = new int[7];

    public Result(String inputString) {
        this.winningNumbers = Splitor.stringToIntegerArray(inputString);
    }

    public Result(String inputString, LottoMachine lottoMachine) {
        this.winningNumbers = Splitor.stringToIntegerArray(inputString);
        getMatchingCount(lottoMachine.lottoDTO().getLottos());
        calculateProfit(lottoMachine.lottoDTO());
    }

    public void getMatchingCount(List<Lotto> lotto) {
        int counter = 0;
        for (int i = 0; i < lotto.size(); i++) {
            counter = 0;
            counter += getEachMatchingCount(lotto.get(i), winningNumbers);
            matchingCounts[counter]++;
        }
    }

    public int getEachMatchingCount(Lotto lotto, List winnungNumber) {
        int count = 0;
        for (int i = 0; i < winnungNumber.size(); i++)
            count += isMatched(lotto, (int) winnungNumber.get(i));
        return count;
    }

    public int isMatched(Lotto lotto, int index) {
        if (lotto.getLottoNumbers().contains(index))
            return 1;
        else
            return 0;
    }

    public void calculateProfit(LottoDTO lottoDTO) {
        double winningMoney = 0;
        for (int i = 0; i < matchingCounts.length; i++)
            winningMoney += RankInformation.getWinningMoney(i) * matchingCounts[i];
        this.profit = winningMoney / (lottoDTO.getLottos().size() * 1000);
    }

    public ResultDTO resultDTO() {
        return new ResultDTO(winningNumbers, matchingCounts, profit);
    }
}
