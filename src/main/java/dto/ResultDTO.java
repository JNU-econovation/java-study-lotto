package dto;

import java.util.List;

public class ResultDTO {
    private List<Integer> winningNumbers;

    public ResultDTO(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public List getWinningNumbers() {
        return winningNumbers;
    }
}
