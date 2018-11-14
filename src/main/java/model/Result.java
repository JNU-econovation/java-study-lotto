package model;

import dto.LottoDTO;
import dto.ResultDTO;
import utils.Splitor;

import java.util.*;

public class Result {
    private List<Integer> winningNumbers;
    private double profit;
    private int matchingCounts[] = new int[7];

    public Result(String inputString, LottoMachine lottoMachine) {
        this.winningNumbers = Splitor.stringToIntegerArray(inputString);
        getMatchingCount(lottoMachine.lottoDTO().getLottos());
        calculateProfit(lottoMachine.lottoDTO());
    }

    private void getMatchingCount(List<Lotto> lotto) {
        int counter = 0;
        for (int i = 0; i < lotto.size(); i++) {
            counter = 0;
            counter += getEachMatchingCount(lotto.get(i), winningNumbers);
            matchingCounts[counter]++;
        }
    }

    private int getEachMatchingCount(Lotto lotto, List winnungNumber) {
        int count = 0;
        for (int i = 0; i < winnungNumber.size(); i++)
            count += isMatched(lotto, (int)winnungNumber.get(i));
        return count;
    }

    private int isMatched(Lotto lotto, int index) {
        if (lotto.getLottoNumbers().contains(index))
            return 1;
        else
            return 0;
    }

    private void calculateProfit(LottoDTO lottoDTO) {
        double winningMoney = 0;
        for (int i = 0; i < matchingCounts.length; i++)
            winningMoney += RankInformation.getWinningMoney(i) * matchingCounts[i];
        this.profit = winningMoney / (lottoDTO.getLottos().size() * 1000);
    }

    public ResultDTO resultDTO() {
        return new ResultDTO(winningNumbers, matchingCounts, profit);
    }
}
