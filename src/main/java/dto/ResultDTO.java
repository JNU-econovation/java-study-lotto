package dto;

import java.util.List;

public class ResultDTO {
    private List<Integer> stratistics;
    private double profit;

    public ResultDTO(List<Integer> stratistics, double profit) {
        this.stratistics = stratistics;
        this.profit = profit;
    }

    public List<Integer> getStratistics() {
        return stratistics;
    }

    public double getProfit() {
        return profit;
    }
}
