package model;

import dto.LottoDTO;
import dto.ResultDTO;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private final int PRICE = 1000;
    private Rank[] ranks = Rank.values();
    private List<Integer> winningNumbers;
    private List<Integer> statistics;
    private LottoDTO lottoDTO;
    private double profit;

    public Result(String winningNumbers, LottoDTO lottoDTO) {
        this.winningNumbers = toList(winningNumbers);
        this.lottoDTO = lottoDTO;
    }

    public List<Integer> toList(String s) {
        List<Integer> list = new ArrayList<>();

        for (String temp : s.split(", ")) {
            list.add(Integer.parseInt(temp));
        }
        return list;
    }

    public void update() {
        statistics = getStatistics();
        profit = getProfit();
    }

    public List<Integer> getStatistics() {
        initStatistics();

        for (Lotto lotto : lottoDTO.getLotteries()) {
            updateStatistics(lotto);
        }
        return statistics;
    }

    public void initStatistics() {
        statistics = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            statistics.add(0);
        }
    }

    public void updateStatistics(Lotto lotto) {
        switch(getMatchCount(lotto.getTicket())) {
            case 3:
                statistics.set(0, statistics.get(0) + 1);
                break;
            case 4:
                statistics.set(1, statistics.get(1) + 1);
                break;
            case 5:
                statistics.set(2, statistics.get(2) + 1);
                break;
            case 6:
                statistics.set(3, statistics.get(3) + 1);
                break;
            default :
                break;
        }
    }

    public int getMatchCount(List<LottoNo> ticket) {
        int matchCount = 0;

        for (Integer winningNumber : winningNumbers) {
            //if(ticket.contains(winningNumber)) matchCount++;
        }
        return matchCount;
    }

    public double getProfit() {
        double profit;
        double money = 0;

        money += statistics.get(0) * ranks[3].getWinningMoney();
        money += statistics.get(1) * ranks[2].getWinningMoney();
        money += statistics.get(2) * ranks[1].getWinningMoney();
        money += statistics.get(3) * ranks[0].getWinningMoney();
        profit = money / (lottoDTO.getCount() * PRICE) * 100;
        return profit;
    }

    public ResultDTO toResultDTO() {
        return new ResultDTO(statistics, profit);
    }
}
