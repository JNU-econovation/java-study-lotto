package model;

import java.util.Map;
import java.util.TreeMap;

public class LottoGame {

    private Lottos lottos = new Lottos();

    private int numberOfLottos;

    public int insertMoney(int putPrice) {
        return numberOfLottos = putPrice / 1000;
    }

    public Lottos generateLottos() {
        for (int i = 0; i < numberOfLottos; i++) {
            lottos.setLotto(LottoGenerator.generate());
        }

        return lottos;
    }

    public Map<Rank, Integer> scoreStatistics(WinningLotto winningLotto) {
        Map<Rank, Integer> statisticsMap = initStatisticsMap();
        statisticsMap = lottos.makeStatisticsMap(statisticsMap, winningLotto);
        return statisticsMap;
    }

    private Map<Rank, Integer> initStatisticsMap() {
        Map<Rank, Integer> statisticsMap = new TreeMap<>();

        for (int i = 0; i < Rank.WIN_MAX; i++) {
            statisticsMap.put(Rank.of(i), 0);
        }

        return statisticsMap;
    }

    public String calculateEarningRate(WinningLotto winningLotto) {
        int investMoney = numberOfLottos * 1000;
        int totalPrize;

        totalPrize = lottos.calculateTotalPrize(winningLotto);

        return String.format("%.1f", ((double) totalPrize / investMoney) * 100);
    }
}
