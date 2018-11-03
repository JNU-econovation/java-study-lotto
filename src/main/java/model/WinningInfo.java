package model;

public enum WinningInfo {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    FIFTH(2, 0),
    SIXTH(1, 0),
    FAIL(0, 0);

    public static final int MIN_COUNT_GET_BENEFIT = 3;
    public static final int MAX_COUNT_GET_BENEFIT = 7;
    private final int correctCount;
    private final int benefit;

    private static final WinningInfo[] winningInfo = {FAIL, SIXTH, FIFTH, FOURTH, THIRD, SECOND, FIRST};

    WinningInfo(int correctCount, int benefit) {
        this.correctCount = correctCount;
        this.benefit = benefit;
    }

    public static int getCorrectCount(int number) {
        return winningInfo[number].correctCount;
    }

    public static int getBenefit(int number) {
        return winningInfo[number].benefit;
    }
}