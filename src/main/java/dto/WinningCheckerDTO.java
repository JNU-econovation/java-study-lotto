package dto;

import java.util.Map;

public class WinningCheckerDTO {
    private float profitRate;
    private Map<String, Integer> winningList;

    public WinningCheckerDTO(float profitRate, Map<String, Integer> winningList) {
        this.profitRate = profitRate;
        this.winningList = winningList;
    }

    public float getProfitRate() {
        return profitRate;
    }

    public Map<String, Integer> getWinningList() {
        return winningList;
    }
}