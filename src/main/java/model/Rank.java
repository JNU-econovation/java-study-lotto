package model;

public enum Rank {
    FIRST(6, 200000000),
    SECOND(6, 3000000),
    THIRD(5, 1500000),
    FORTH(4, 50000),
    FIFTH(3, 5000);

    int matchCount;
    int winPrize;

    private Rank(int matchCount, int winPrize) {
        this.matchCount = matchCount;
        this.winPrize = winPrize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinPrize() {
        return winPrize;
    }

    public static Rank match(int matchCount) {
        for (Rank rank:Rank.values()) {
            if( rank.getMatchCount() == matchCount) return rank;
        }
        return null;
    }
}