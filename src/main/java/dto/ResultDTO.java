package dto;

import model.Rank;
import java.util.Map;

public class ResultDTO {
    private Map<Rank, Integer> winningInformation;
    private double profit;

    public ResultDTO(Map<Rank, Integer> winningInformation, double profit) {
        this.winningInformation = winningInformation;
        this.profit = profit;
    }

    public Map<Rank, Integer> getWinningInformation() {
        return winningInformation;
    }

    public double getProfit() {
        return profit;
    }
}
