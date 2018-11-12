package lotto.dto;

import lotto.util.PrizeMoneyEnum;

public class WinningStatisticDTO {
    private int[] winningStatistic;
    private PrizeMoneyEnum prizeMoney;
    private float grossProfitRate;

    public WinningStatisticDTO(int[] winningStatistic, float grossProfitRate) {
        this.winningStatistic = winningStatistic;
        this.grossProfitRate = grossProfitRate;
    }

    public String drawStatistic(int matchCount) {
        return drawWinningPrizeMoney(matchCount) + printSortedWinningLotto(matchCount);
    }

    public String drawWinningPrizeMoney(int matchCount) {
        String Match_Number = "MATCH_" + Integer.toString(matchCount);
        String prizeMoney = this.prizeMoney.valueOf(Match_Number).getPrizeMoney();
        return "(" + prizeMoney + ")- ";
    }

    public String printSortedWinningLotto(int matchCount) {
        return winningStatistic[matchCount] + "개";
    }

    public String drawGrossProfitRate() {
        return String.format("%.1f", this.grossProfitRate);
    }
}
