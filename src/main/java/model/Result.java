package model;

import dto.LottoDTO;
import dto.ResultDTO;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private final int PRICE = 1000;
    private final int FIRST_PRIZE = 2000000000;
    private final int SECOND_PRIZE = 1500000;
    private final int THIRD_PRIZE = 50000;
    private final int FOURTH_PRIZE = 5000;
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

        for (Lottery lottery : lottoDTO.getLotteries()) {
            updateStatistics(lottery);
        }
        return statistics;
    }

    public void initStatistics() {
        statistics = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            statistics.add(0);
        }
    }

    public void updateStatistics(Lottery lottery) {
        switch(getMatchCount(lottery.getTicket())) {
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

    public int getMatchCount(List<Integer> lottery) {
        int matchCount = 0;

        for (Integer winningNumber : winningNumbers) {
            if(lottery.contains(winningNumber)) matchCount++;
        }
        return matchCount;
    }

    public double getProfit() {
        double profit;
        double money = 0;

        money += statistics.get(0) * FOURTH_PRIZE;
        money += statistics.get(1) * THIRD_PRIZE;
        money += statistics.get(2) * SECOND_PRIZE;
        money += statistics.get(3) * FIRST_PRIZE;
        profit = money / (lottoDTO.getCount() * PRICE) * 100;
        return profit;
    }

    public ResultDTO toResultDTO() {
        return new ResultDTO(statistics, profit);
    }
}
