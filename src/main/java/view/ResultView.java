package view;

import dto.LottoGameDTO;
import dto.LottoResultDTO;
import model.Rank;

import java.util.HashMap;

public class ResultView {

    public static void printTicket(LottoGameDTO lottoGameDTO) {

        System.out.println(String.format("\n수동으로 %d장, 자동으로 %d개를 구매하였습니다.", lottoGameDTO.getNumberOfManualLottoTicket(),
                lottoGameDTO.getLottoTickets().size() - lottoGameDTO.getNumberOfManualLottoTicket()));

        for (int i = 0; i < lottoGameDTO.getLottoTickets().size(); i++) {
            System.out.println(lottoGameDTO.getLottoTickets().get(i));
        }
    }

    public static void printResult(LottoResultDTO lottoResultDTO) {
        HashMap<Rank, Integer> matchCount = lottoResultDTO.getMatchCount();

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(String.format("3개 일치 (5000원)- %d개", matchCount.getOrDefault(Rank.FIFTH, 0)));
        System.out.println(String.format("4개 일치 (50000원)- %d개", matchCount.getOrDefault(Rank.FORTH, 0)));
        System.out.println(String.format("5개 일치 (150000원)- %d개", matchCount.getOrDefault(Rank.THIRD,0)));
        System.out.println(String.format("5개 일치, 보너스 볼 일치(30000000)원 - %d개", matchCount.getOrDefault(Rank.SECOND, 0)));
        System.out.println(String.format("6개 일치 (2000000000원)- %d개", matchCount.getOrDefault(Rank.FIRST, 0)));
        System.out.println(String.format("총 수익률은 %.2f%%입니다.", lottoResultDTO.getEarnings()));
    }
}

