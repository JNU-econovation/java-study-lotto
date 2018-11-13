package model;

public enum RankInformation {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private int matchingCount;
    private int winningMoney;

    private RankInformation(int matchingCount, int winningMoney) {
        this.matchingCount = matchingCount;
        this.winningMoney = winningMoney;
    }

}
