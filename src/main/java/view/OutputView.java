package view;

import model.Lotto;
import model.Lottos;
import model.Rank;

import java.util.Map;

public class OutputView {

    public static void printNumberOfLottos(int numberOfLottos) {
        System.out.println(numberOfLottos + "개를 구매했습니다.");
    }

    public static void drawLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto);
        }
    }

    public static void showStatistics(Map<Rank, Integer> statistics) {
        System.out.println("당첨 통계");
        System.out.println("----------");

        for (int i = Rank.WIN_MIN; i < Rank.WIN_MAX; i++) {
            Rank rank = Rank.of(i);
            System.out.print(rank.toString());
            System.out.println(String.format("%s - %d개", rank, statistics.get(rank)));
        }
    }

    public static void printEarningRate(String earningRate) {
        System.out.println("총 수익률은 " + earningRate + "%입니다");
    }
}
