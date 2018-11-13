package view;

import dto.LottoGameDTO;
import dto.ResultDTO;
import model.Rank;

import java.util.Map;

public class ResultView {

    public static void printResult(ResultDTO resultDTO) {
        Map<Rank, Integer> winStatistics = resultDTO.getWinStatistics();

        System.out.println("\n당첨 통계\n---------");
        System.out.printf("%d개 일치 (%d원) - %d개\n",
                Rank.FIFTH.getCountOfMatch(), Rank.FIFTH.getWinningMoney(), winStatistics.get(Rank.FIFTH));
        System.out.printf("%d개 일치 (%d원) - %d개\n",
                Rank.FOURTH.getCountOfMatch(), Rank.FOURTH.getWinningMoney(), winStatistics.get(Rank.FOURTH));
        System.out.printf("%d개 일치 (%d원) - %d개\n",
                Rank.THIRD.getCountOfMatch(), Rank.THIRD.getWinningMoney(), winStatistics.get(Rank.THIRD));
        System.out.printf("%d개 일치, 보너스 볼 일치(%d원) - %d개\n",
                Rank.SECOND.getCountOfMatch(), Rank.SECOND.getWinningMoney(), winStatistics.get(Rank.SECOND));
        System.out.printf("%d개 일치 (%d원) - %d개\n",
                Rank.FIRST.getCountOfMatch(), Rank.FIRST.getWinningMoney(), winStatistics.get(Rank.FIRST));
        System.out.printf("총 수익률은 %.1f%%입니다.", resultDTO.getProfit());
    }


    public static void printTickets(LottoGameDTO lottoGameDTO) {
        System.out.printf("\n수동으로 %d장, 자동으로 %d개를 구매했습니다.\n",
                lottoGameDTO.getManualCount(), lottoGameDTO.getAutoCount());

        for (int i = 0; i < lottoGameDTO.getLottoList().size(); i++) {
            System.out.println(lottoGameDTO.getLottoList().get(i).toLottoDTO().getTicket());
        }
    }
}