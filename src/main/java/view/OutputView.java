package view;

import dto.LottoListDTO;
import dto.WinningCheckerDTO;
import model.Lotto;

import java.util.List;

public class OutputView {
    private static final int CORRECT_3NUMBERS_BENEFIT = 5000;
    private static final int CORRECT_4NUMBERS_BENEFIT = 50000;
    private static final int CORRECT_5NUMBERS_BENEFIT = 1500000;
    private static final int CORRECT_6NUMBERS_BENEFIT = 2000000000;

    public static void getPurchaseResult(LottoListDTO lottoList) {
        System.out.println(lottoList.getLottoList().size() + "개를 구매했습니다.");

        for (int i = 0; i < lottoList.getLottoList().size(); i++) {
            System.out.println(printLotto(lottoList.getLottoList().get(i)));
        }
    }

    private static String printLotto(Lotto lotto) {
        StringBuilder lottoNumbers = new StringBuilder();

        lottoNumbers.append("[").append(lotto.getLottoNumbers()[0]);

        for (int i = 1; i < lotto.getLottoNumbers().length; i++) {
            lottoNumbers.append(", ").append(lotto.getLottoNumbers()[i]);
        }
        lottoNumbers.append("]");

        return lottoNumbers.toString();
    }

    public static void getWinningInfo(WinningCheckerDTO lottoCheckerDTO, int money) {
        System.out.println("\n당첨 통계 \n---------");
        List<Lotto> lottoListCorrecting3Nubmers = lottoCheckerDTO.getLottoListCorrecting3Numbers();
        List<Lotto> lottoListCorrecting4Nubmers = lottoCheckerDTO.getLottoListCorrecting4Numbers();
        List<Lotto> lottoListCorrecting5Nubmers = lottoCheckerDTO.getLottoListCorrecting5Numbers();
        List<Lotto> lottoListCorrecting6Nubmers = lottoCheckerDTO.getLottoListCorrecting6Numbers();

        System.out.println(makeStatisticResult(3, lottoListCorrecting3Nubmers, CORRECT_3NUMBERS_BENEFIT)
                + "\n" + makeStatisticResult(4, lottoListCorrecting4Nubmers, CORRECT_4NUMBERS_BENEFIT)
                + "\n" + makeStatisticResult(5, lottoListCorrecting5Nubmers, CORRECT_5NUMBERS_BENEFIT)
                + "\n" + makeStatisticResult(6, lottoListCorrecting6Nubmers, CORRECT_6NUMBERS_BENEFIT));

        int profit = CalculateProfit(CORRECT_3NUMBERS_BENEFIT, lottoListCorrecting3Nubmers.size())
                + CalculateProfit(CORRECT_3NUMBERS_BENEFIT, lottoListCorrecting4Nubmers.size())
                + CalculateProfit(CORRECT_3NUMBERS_BENEFIT, lottoListCorrecting5Nubmers.size())
                + CalculateProfit(CORRECT_3NUMBERS_BENEFIT, lottoListCorrecting6Nubmers.size());

        System.out.printf("총 수익률은 %.2f%%입니다", (float) profit / money * 100);
    }

    private static String makeStatisticResult(int correctCount, List<Lotto> winningLottoList, int benefit) {
        StringBuilder message = new StringBuilder();
        message.append(correctCount).append("개 일치 (")
                .append(benefit).append(")- ")
                .append(winningLottoList.size()).append("개");

        return message.toString();
    }

    private static int CalculateProfit(int count, int benefit) {
        return count * benefit;
    }
}
