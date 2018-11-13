package dto;

import model.Rank;

import java.util.Map;

public class ResultDTO {
    private Map<Rank, Integer> winStatistics;
    private double profit;

    public ResultDTO(Map<Rank, Integer> winStatistics, double profit) {
        this.winStatistics = winStatistics;
        this.profit = profit;
    }

    public Map<Rank, Integer> getWinStatistics() {
        return winStatistics;
    }

    public double getProfit() {
        return profit;
    }
}