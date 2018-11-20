package model;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

    private Rank(int matchingCount, int winningMoney) {
        this.matchingCount = matchingCount;
        this.winningMoney = winningMoney;
    }

    private int matchingCount;
    private int winningMoney;

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int matchingCount, boolean matchBonus) {
        for (Rank rank : Rank.values()) {
            if (matchingCount == 5 && matchBonus) {
                return SECOND;
            } else if (rank.getMatchingCount() == matchingCount) {
                return rank;
            }
        }
        return null;
    }
}

