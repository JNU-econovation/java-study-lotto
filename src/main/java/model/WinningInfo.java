package model;

public enum WinningInfo {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private final int correctCount;
    private final int benefit;
    private static String[] rank = {"FIRST","SECOND","THIRD","FOURTH","FIFTH"};

    WinningInfo(int correctCount, int benefit) {
        this.correctCount = correctCount;
        this.benefit = benefit;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getBenefit() {
        return benefit;
    }

    public static String getRank(int i) {
        return rank[i];
    }
}