package view;

import dto.LottoListDTO;
import dto.WinningCheckerDTO;
import model.WinningInfo;

public class OutputView {

    public static void getPurchaseResult(LottoListDTO lottoListDTO, int manualLottoCount) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", manualLottoCount, lottoListDTO.getLottoList().size() - manualLottoCount);

        for (int i = 0; i < lottoListDTO.getLottoList().size(); i++) {
            System.out.println(lottoListDTO.getLottoList().get(i).toString());
        }
    }

    public static void getWinningResult(WinningCheckerDTO winningCheckerDTO) {
        System.out.println("\n당첨 통계 \n---------");

        
        for (int i = 0; i < winningCheckerDTO.getWinningList().size(); i++) {
            System.out.println(makeStatisticResult(WinningInfo.getRank(i), WinningInfo.values()[i].getCorrectCount(), winningCheckerDTO.getWinningList().get(WinningInfo.getRank(i)), WinningInfo.values()[i].getBenefit()));
        }

        System.out.printf("총 수익률은 %.1f%%입니다", winningCheckerDTO.getProfitRate());
    }

    private static String makeStatisticResult(String rank, int numberOfCorrect, int countOfCorrect, int benefit) {
        StringBuilder message = new StringBuilder();
        if (rank.equals("SECOND")) {
            message.append(numberOfCorrect).append("개 일치, 보너스 볼 일치 (")
                    .append(benefit).append("원)- ")
                    .append(countOfCorrect).append("개");

            return message.toString();
        }

        message.append(numberOfCorrect).append("개 일치 (")
                .append(benefit).append("원)- ")
                .append(countOfCorrect).append("개");

        return message.toString();
    }

}