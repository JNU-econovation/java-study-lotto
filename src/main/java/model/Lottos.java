package model;

import java.util.List;
import java.util.Map;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos() {

        this.lottos = lottos;
    }

    public void setLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> getLottos(){
        return lottos;
    }

    public Map<Rank, Integer> makeStatisticsMap(Map<Rank, Integer> statisticMap, WinningLotto winningLotto) {
        for (Lotto lotto : lottos) {
            int matchCount =  lotto.match(winningLotto);
            Rank rank = Rank.of(matchCount);
            statisticMap.put(rank, statisticMap.get(rank) + 1);
        }

        return statisticMap;
    }

    public int calculateTotalPrize(WinningLotto winningLotto) {
        int totalPrize = 0;

        for (Lotto lotto : lottos) {
            int matchCount = lotto.match(winningLotto);
            totalPrize += Rank.prizeOf(matchCount);
        }

        return totalPrize;
    }
}
