package dto;

import java.util.List;

public class ResultDTO {
    private List<Integer> winningNumbers;
    private int matchingCount;

    public ResultDTO(List<Integer> winningNumbers, int matchingCount) {
        this.winningNumbers = winningNumbers;
        this.matchingCount = matchingCount;
    }

    public List getWinningNumbers() {
        return winningNumbers;
    }
    public int getMatchingCount(){
        return matchingCount;
    }
}
