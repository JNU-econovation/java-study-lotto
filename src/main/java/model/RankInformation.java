package model;

public enum RankInformation {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    FAIL(0, 0);

    private int matchingCount;
    private int winningMoney;
    private static final RankInformation[] RANK_INDEX = {FAIL, FAIL, FAIL, FOURTH, THIRD, SECOND, FIRST};

    RankInformation(int matchingCount, int winningMoney) {
        this.matchingCount = matchingCount;
        this.winningMoney = winningMoney;
    }

    public static int getWinningMoney(int number) {
        return RANK_INDEX[number].winningMoney;
    }

}
