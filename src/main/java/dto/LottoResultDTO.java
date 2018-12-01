package dto;

import model.Rank;

import java.util.HashMap;

public class LottoResultDTO {
    private HashMap<Rank, Integer> matchCount;
    private float earnings;

    public LottoResultDTO(HashMap<Rank, Integer> matchCount, float earnings) {
        this.matchCount = matchCount;
        this.earnings = earnings;
    }

    public HashMap<Rank, Integer> getMatchCount() {
        return matchCount;
    }

    public void setMatchCount(HashMap<Rank, Integer> matchCount) {
        this.matchCount = matchCount;
    }

    public float getEarnings() {
        return earnings;
    }

    public void setEarnings(float earnings) {
        this.earnings = earnings;
    }
}
