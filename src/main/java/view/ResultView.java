package view;

import dto.AutoLottoDTO;
import dto.AutoLottoResultDTO;

public class ResultView {

    public static void printTicket(AutoLottoDTO autoLottoDTO) {
        System.out.println(String.format("%d개를 구매하였습니다.", autoLottoDTO.getNumberOfLottoTicket()));

        for (int i = 0; i < autoLottoDTO.getLottoTickets().size(); i++) {
            System.out.println(autoLottoDTO.getLottoTickets().get(i));
        }

        System.out.println();
    }

    public static void printStatistics(AutoLottoResultDTO autoLottoResultDTO) {
        int[] match = autoLottoResultDTO.getMatchNumCount();

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(String.format("3개 일치 (5000원)- %d개", match[3]));
        System.out.println(String.format("4개 일치 (50000원)- %d개", match[4]));
        System.out.println(String.format("5개 일치 (150000원)- %d개", match[5]));
        System.out.println(String.format("6개 일치 (2000000000원)- %d개", match[6]));
        System.out.println(String.format("총 수익률은 %.2f입니다.", autoLottoResultDTO.getEarningRate()));
    }
}
