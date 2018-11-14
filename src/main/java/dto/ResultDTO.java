package dto;

import java.util.List;

public class ResultDTO {
    private List<Integer> winningNumbers;
    private int[] matchingCounts;
    private double profit;

    public ResultDTO(List<Integer> winningNumbers, int[] matchingCounts, double profit) {
        this.winningNumbers = winningNumbers;
        this.matchingCounts = matchingCounts;
        this.profit = profit;
    }

    public List getWinningNumbers() {
        return winningNumbers;
    }

    public int[] getMatchingCounts() {
        return matchingCounts;
    }

    public double getProfit(){
        return profit;
    }
}
