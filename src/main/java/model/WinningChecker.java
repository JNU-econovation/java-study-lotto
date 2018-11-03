package model;

import dto.WinningCheckerDTO;
import java.util.ArrayList;
import java.util.List;

public class WinningChecker {
    private static int[] winningList = new int[7];
    private static float profitRate;

    public void checkWinningLotto(List<Lotto> lottoList, String winningNumbers, int money) {
        for (int i = 0; i < lottoList.size(); i++) {
            adaptWinningList(checkCorrectCounts(lottoList.get(i), Converter.splitNumbers(winningNumbers)));
        }

        calculateProfitRate(money);
        toLottoCheckerDTO();
    }

    private void adaptWinningList(int checkCorrectCounts) {
        winningList[checkCorrectCounts]++;
    }


    public int checkCorrectCounts(Lotto lotto, int[] winningNumbers) {
        int correctCounts = 0;
        for (int i = 0; i < winningNumbers.length; i++) {
            correctCounts += checkContains(convertArrayToArrayList(lotto.getLottoNumbers()), winningNumbers[i]);
        }
        return correctCounts;
    }

    private static List convertArrayToArrayList(int[] numbers) {
        List convertedList = new ArrayList();

        for (int i = 0; i < numbers.length; i++) {
            convertedList.add(numbers[i]);
        }
        return convertedList;
    }

    private static int checkContains(List numbers, int winningNumber) {
        if (!numbers.contains(winningNumber))
            return 0;
        return 1;
    }

    public static void calculateProfitRate(int money) {
        int profit = 0;

        for (int i = WinningInfo.MIN_COUNT_GET_BENEFIT; i < WinningInfo.MAX_COUNT_GET_BENEFIT; i++) {
            profit += winningList[i] * WinningInfo.getBenefit(i);
        }

        profitRate = ((float) profit / money) * 100;
    }

    public WinningCheckerDTO toLottoCheckerDTO() {
        return new WinningCheckerDTO(winningList, profitRate);
    }
}