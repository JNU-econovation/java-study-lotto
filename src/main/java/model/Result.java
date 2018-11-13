package model;

import dto.ResultDTO;

import java.util.*;

public class Result {
    private final int LOTTO_PRICE = 1000;
    private List<Integer> winningNumbers = new ArrayList<>();
    private LottoMachine lottomachine;
    private double profit;

    public Result(String winningNumbers) {
        for (String winningNumber : winningNumbers.split(", ")) {
            this.winningNumbers.add(Integer.parseInt(winningNumber));
        }
    }

    public ResultDTO resultDTO(){
        return new ResultDTO(winningNumbers);
    }
}
