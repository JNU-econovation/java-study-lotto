package model;

import java.util.*;

public class LottoGenerator {

    private static List<Integer> lotto;

    static {
        for (int i = 1; i <= 45; i++) {
            lotto.add(i);
        }
    }

    public static Lotto generate() {
        Collections.shuffle(lotto);
        return new Lotto(new TreeSet<>(lotto.subList(0, 6)));
    }
}
