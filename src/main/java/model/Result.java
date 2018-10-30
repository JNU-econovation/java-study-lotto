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
    private List<Integer> stratistics;
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
        stratistics = getStratistics();
        profit = getProfit();
    }

    public List<Integer> getStratistics() {
        initStratistics();

        for (Lottery lottery : lottoDTO.getLotteries()) {
            updateStratistics(lottery);
        }
        return stratistics;
    }

    public void initStratistics() {
        stratistics = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            stratistics.add(0);
        }
    }

    public void updateStratistics(Lottery lottery) {
        switch(getMatchCount(lottery.getTicket())) {
            case 3:
                stratistics.set(0, stratistics.get(0) + 1);
                break;
            case 4:
                stratistics.set(1, stratistics.get(1) + 1);
                break;
            case 5:
                stratistics.set(2, stratistics.get(2) + 1);
                break;
            case 6:
                stratistics.set(3, stratistics.get(3) + 1);
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

        money += stratistics.get(0) * FOURTH_PRIZE;
        money += stratistics.get(1) * THIRD_PRIZE;
        money += stratistics.get(2) * SECOND_PRIZE;
        money += stratistics.get(3) * FIRST_PRIZE;
        profit = money / (lottoDTO.getCount() * PRICE) * 100;
        return profit;
    }

    public ResultDTO toResultDTO() {
        return new ResultDTO(stratistics, profit);
    }
}
