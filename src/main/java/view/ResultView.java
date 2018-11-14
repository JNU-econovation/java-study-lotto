package view;


import dto.LottoDTO;
import dto.ResultDTO;
import model.RankInformation;
import java.util.Scanner;

public class ResultView {
    public void printLottos(LottoDTO lottoDTO) {
        System.out.println(String.format("%d개를 구매하였습니다.", lottoDTO.getLottos().size()));
        for (int i = 0; i < lottoDTO.getLottos().size(); i++) {
            System.out.println(lottoDTO.getLottos().get(i));
        }
    }

    public String inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public void printProfit(ResultDTO resultDTO) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (int i = 3; i < 7; i++) {
            StringBuilder sentence = new StringBuilder();
            sentence.append(i).append("개 일치 (")
                    .append(RankInformation.getWinningMoney(i)).append("원)- ")
                    .append(resultDTO.getMatchingCounts()[i]);
            System.out.println(sentence);
        }
        System.out.printf("총 수익률은 %.1f%%입니다.", resultDTO.getProfit()*100);
    }
}
