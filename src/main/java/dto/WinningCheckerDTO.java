package dto;

import model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningCheckerDTO {
    private int[] winningList;
    private float profitRate;

    public WinningCheckerDTO(int[] winningList, float profitRate) {
        this.winningList = winningList;
        this.profitRate = profitRate;
    }

    public int[] getWinningList() {
        return winningList;
    }

    public float getProfitRate() {
        return profitRate;
    }
}