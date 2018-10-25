package model;

import java.util.List;

public class Result {
    List<Integer> winningNumbers;

    public Result() {}

    public Result(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int getMatchCount(List<Integer> lottery) {
        int matchCount = 0;

        for (Integer winningNumber : winningNumbers) {
            if(lottery.contains(winningNumber)) matchCount++;
        }
        return matchCount;
    }
}
