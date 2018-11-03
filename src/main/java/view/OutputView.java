package view;

import dto.LottoListDTO;
import dto.WinningCheckerDTO;
import model.Lotto;
import model.WinningInfo;


public class OutputView {

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

    public static void getWinningResult(WinningCheckerDTO lottoCheckerDTO) {
        System.out.println("\n당첨 통계 \n---------");

        for (int i = WinningInfo.MIN_COUNT_GET_BENEFIT; i < WinningInfo.MAX_COUNT_GET_BENEFIT; i++) {
            System.out.println(makeStatisticResult(WinningInfo.getCorrectCount(i), lottoCheckerDTO.getWinningList()[i], WinningInfo.getBenefit(i)));
        }

        System.out.printf("총 수익률은 %.1f%%입니다", lottoCheckerDTO.getProfitRate());
    }

    private static String makeStatisticResult(int ranking, int correctCount, int benefit) {
        StringBuilder message = new StringBuilder();
        message.append(ranking).append("개 일치 (")
                .append(benefit).append("원)- ")
                .append(correctCount).append("개");

        return message.toString();
    }

}
