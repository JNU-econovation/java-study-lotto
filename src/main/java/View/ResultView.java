package View;

import Model.Result;

public class ResultView {
    Result result;

    public ResultView(Result result) {
        this.result = result;
    }

    public void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원) " + result.rankList[3] + "개");
        System.out.println("4개 일치 (50000원) " + result.rankList[2] + "개");
        System.out.println("5개 일치 (1500000원) " + result.rankList[1] + "개");
        System.out.println("6개 일치 (2000000000원) " + result.rankList[0] + "개");
        System.out.print("총 수익률은");
        System.out.format("%2.1f", result.calculateEarningRate() * 100);

    }

}
