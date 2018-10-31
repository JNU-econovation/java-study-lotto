package model;

import dto.WinningCheckerDTO;

import java.util.ArrayList;
import java.util.List;

public class WinningChecker {
    private static List<Lotto> lottoListCorrecting3Numbers = new ArrayList();
    private static List<Lotto> lottoListCorrecting4Numbers = new ArrayList();
    private static List<Lotto> lottoListCorrecting5Numbers = new ArrayList();
    private static List<Lotto> lottoListCorrecting6Numbers = new ArrayList();


    public void checkWinningLotto(List<Lotto> lottoList, String winningNumbers) {
        for (int i = 0; i < lottoList.size(); i++) {
            addWinningLottoToList(lottoList.get(i), checkCorrectCounts(lottoList.get(i), Spliter.splitNumbers(winningNumbers)));
        }
    }

    private static void addWinningLottoToList(Lotto lotto, int correctCounts) {
        if (correctCounts == 3) {
            lottoListCorrecting3Numbers.add(lotto);
        }
        if (correctCounts == 4) {
            lottoListCorrecting4Numbers.add(lotto);
        }
        if (correctCounts == 5) {
            lottoListCorrecting5Numbers.add(lotto);
        }
        if (correctCounts == 6) {
            lottoListCorrecting3Numbers.add(lotto);
        }
    }


    public int checkCorrectCounts(Lotto lotto, int[] winningNumbers) {
        int correctCounts = 0;
        for (int i = 0; i < winningNumbers.length; i++) {
            correctCounts += isContains(convertArrayToArrayList(lotto.getLottoNumbers()), winningNumbers[i]);
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

    private static int isContains(List numbers, int winningNumber) {
        if (!numbers.contains(winningNumber))
            return 0;
        return 1;
    }

    public WinningCheckerDTO toLottoCheckerDTO() {
        return new WinningCheckerDTO(lottoListCorrecting3Numbers, lottoListCorrecting4Numbers, lottoListCorrecting5Numbers, lottoListCorrecting6Numbers);
    }
}