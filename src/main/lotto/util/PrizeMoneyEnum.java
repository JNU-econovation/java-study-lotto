package lotto.util;

public enum PrizeMoneyEnum {
    MATCH_3("5000"), MATCH_4("50000"), MATCH_5("1500000"), MATCH_6("2000000000");

    private String prizeMoney;

    PrizeMoneyEnum(String prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public String getPrizeMoney() {
        return prizeMoney;
    }
}
