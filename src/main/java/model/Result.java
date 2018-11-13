package model;

import dto.ResultDTO;

import java.util.*;

public class Result {
    private List<Integer> winningNumbers = new ArrayList<>();
    private double profit;
    private int matchingCount;

    public Result(String winningNumbers, List<Lotto> lotto) {
        for (String winningNumber : winningNumbers.split(", ")) {
            this.winningNumbers.add(Integer.parseInt(winningNumber));
        }
        this.matchingCount = getMatchingCount(lotto);
    }

    public int getMatchingCount(List<Lotto> lotto) {
        matchingCount = 0;
        for (int i = 0; i < lotto.size(); i++) {
            matchingCount += isMatched(lotto.get(i), winningNumbers.get(i));
        }
        return matchingCount;
    }

    public int isMatched(Lotto lotto, int winnungNumber) {
        if (lotto.getLottoNumbers().contains(winnungNumber))
            return 1;
        else return 0;
    }

    private double getProfit() {
        int profit = 0;
    }

    public ResultDTO resultDTO() {
        return new ResultDTO(winningNumbers, matchingCount);
    }

}
