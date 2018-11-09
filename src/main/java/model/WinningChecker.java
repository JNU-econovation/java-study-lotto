package model;

import dto.WinningCheckerDTO;
import util.StringConverter;
import java.util.List;

public class WinningChecker {
    private static int[] winningList = new int[7];
    private static float profitRate;

    public void checkWinningLotto(List<Lotto> lottoList, String winningNumbers, int money) {
        for (int i = 0; i < lottoList.size(); i++) {
            adaptWinningList(checkCorrectCounts(lottoList.get(i), StringConverter.splitNumbers(winningNumbers)));
        }

        profitRate = calculateProfitRate(money);
        toLottoCheckerDTO();
    }

    private void adaptWinningList(int checkCorrectCounts) {
        winningList[checkCorrectCounts]++;
    }


    public int checkCorrectCounts(Lotto lotto, int[] winningNumbers) {
        int correctCounts = 0;
        for (int i = 0; i < winningNumbers.length; i++) {
            correctCounts += checkContains(lotto.getLottoNumbers(), winningNumbers[i]);
        }
        return correctCounts;
    }

    private int checkContains(List numbers, int winningNumber) {
        if (!numbers.contains(winningNumber))
            return 0;
        return 1;
    }

    private float calculateProfitRate(int money) {
        int profit = 0;

        for (int i = WinningInfo.MIN_COUNT_GET_BENEFIT; i < WinningInfo.MAX_COUNT_GET_BENEFIT; i++) {
            profit += winningList[i] * WinningInfo.getBenefit(i);
        }

        return ((float) profit / money) * 100;
    }

    public WinningCheckerDTO toLottoCheckerDTO() {
        return new WinningCheckerDTO(winningList, profitRate);
    }
}