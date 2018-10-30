package view;

import dto.ResultDTO;

import java.util.List;

public class ResultView {

    public static void printResult(ResultDTO resultDTO) {
        List<Integer> stratistics = resultDTO.getStratistics();

        System.out.printf("\n당첨 통계\n---------\n" +
                "3개 일치 (5000원)- %d개\n" +
                "4개 일치 (50000원)- %d개\n" +
                "5개 일치 (1500000원)- %d개\n" +
                "6개 일치 (2000000000원)- %d개\n" +
                "총 수익률은 %.1f%%입니다.", stratistics.get(0), stratistics.get(1), stratistics.get(2), stratistics.get(3), resultDTO.getProfit());
    }
}
