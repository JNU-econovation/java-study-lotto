package view;

import model.Result;


public class ResultView {
    Result result;

    public ResultView(Result result) {
        this.result = result;
    }

    public void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (int i = result.rankList.length - 1; i >= 0; i--)
            System.out.println(i + "개 일치 (" + result.WINNING_MONEY[i] + "원)" + result.rankList[i]);
        System.out.print("총 수익률은 ");
        System.out.format("%2.1f", result.calculateEarningRate() * 100);
        System.out.println("%");
    }
}
