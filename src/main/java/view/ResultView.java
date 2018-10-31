package view;

import dto.ResultDTO;

import java.util.List;

public class ResultView {

    public static void printResult(ResultDTO resultDTO) {
        List<Integer> statistics = resultDTO.getStatistics();

        System.out.printf("\n당첨 통계\n---------\n" +
                "3개 일치 (5000원)- %d개\n" +
                "4개 일치 (50000원)- %d개\n" +
                "5개 일치 (1500000원)- %d개\n" +
                "6개 일치 (2000000000원)- %d개\n" +
                "총 수익률은 %.1f%%입니다.", statistics.get(0), statistics.get(1), statistics.get(2), statistics.get(3), resultDTO.getProfit());
    }
}
