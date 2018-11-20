package view;


import dto.LottoDTO;
import dto.ResultDTO;
import model.Rank;

import java.util.Scanner;

public class ResultView {
    public static void printLottos(LottoDTO lottoDTO) {
        System.out.println(String.format("\n%d개를 구매하였습니다.", lottoDTO.getLottos().size()));
        for (int i = 0; i < lottoDTO.getLottos().size(); i++) {
            System.out.print(lottoDTO.getLottos().get(i).printLotto());
        }
    }

    public static String inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }


    public static void printProfit(ResultDTO resultDTO) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + resultDTO.getWinningInformation().get(Rank.FIFTH)+ "개");
        System.out.println("4개 일치 (50000원)- " + resultDTO.getWinningInformation().get(Rank.FOURTH) + "개");
        System.out.println("5개 일치 (150000원)- " + resultDTO.getWinningInformation().get(Rank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30000000원)- " + resultDTO.getWinningInformation().get(Rank.SECOND) + "개");
        System.out.println("6개 일치 (200000000원)- " + resultDTO.getWinningInformation().get(Rank.FIRST) + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.", resultDTO.getProfit());
    }

}
