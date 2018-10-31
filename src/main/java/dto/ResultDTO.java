package dto;

import java.util.List;

public class ResultDTO {
    private List<Integer> statistics;
    private double profit;

    public ResultDTO(List<Integer> statistics, double profit) {
        this.statistics = statistics;
        this.profit = profit;
    }

    public List<Integer> getStatistics() {
        return statistics;
    }

    public double getProfit() {
        return profit;
    }
}
