package model;

import dto.ResultDTO;

import java.util.*;

public class Result {
    private final int PRICE = 1000;
    private WinningLotto winningLotto;
    private Map<Rank, Integer> winStatistics;
    private LottoGame lottoGame;
    private double profit;
    private int bonusBall;

    public Result(String winningNumbers, int bonusBall, LottoGame lottoGame) {
        winningLotto = new WinningLotto(winningNumbers);
        this.lottoGame = lottoGame;
        this.bonusBall = bonusBall;
        initWinStatistics();
        updateWinStatistics();
        profit = getProfit();
    }

    public void initWinStatistics() {
        winStatistics = new HashMap<>();
        for (Rank rank : Rank.values()) {
            winStatistics.put(rank, 0);
        }
    }

    public void updateWinStatistics() {
        for (Lotto lotto : lottoGame.getLottoList()) {
            List<LottoNo> ticket = lotto.getTicket();
            Rank rank = Rank.valueOf(getMatchCount(ticket), isMatchBonus(ticket));
            winStatistics.put(rank, winStatistics.get(rank) + 1);
        }
    }

    public boolean isMatchBonus(List<LottoNo> ticket) {
        if (ticket.contains(new LottoNo(bonusBall))) return true;
        return false;
    }

    public int getMatchCount(List<LottoNo> ticket) {
        List<LottoNo> temp = new ArrayList<>(ticket);
        temp.retainAll(winningLotto.getWinningTicket());
        return temp.size();
    }

    public double getProfit() {
        double totalWinningMoney = 0;

        for (Rank rank : Rank.values()) {
            totalWinningMoney += winStatistics.get(rank) * rank.getWinningMoney();
        }
        return totalWinningMoney / (lottoGame.getLottoList().size() * PRICE) * 100;
    }

    public ResultDTO toResultDTO() {
        return new ResultDTO(winStatistics, profit);
    }
}