package lotto.view;

import lotto.domain.Lotto;
import lotto.dto.LottoDTO;
import lotto.dto.WinningStatisticDTO;

import java.util.HashMap;
import java.util.List;

public class ResultView {

    public static void printLottoList(List<LottoDTO> LottoList) {
        System.out.println(LottoList.size() + "개를 구매했습니다.");

        for (LottoDTO lottoDTO : LottoList) {
            System.out.println("[" + lottoDTO.drawLottoNumber() + "]");
        }
        System.out.println("");
    }

    public static void printWinningStatistic(WinningStatisticDTO winningStatisticDTO) {
        System.out.println("");
        for (int i = 3; i <= 6 ; i++) {
            System.out.print(i + "개 일치 ");
            System.out.println(winningStatisticDTO.drawStatistic(i));
        }
        System.out.print("총 수익률은 " + winningStatisticDTO.drawGrossProfitRate() + "%입니다.");
    }
}
