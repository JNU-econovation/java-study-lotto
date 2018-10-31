package model;

import java.util.Objects;
import java.util.Set;

public class Lotto {

    private Set<Integer> lotto;

    public Lotto(Set<Integer> lotto) {
        for (Integer integer : lotto) {
            checkLottoNumberRange(integer);
        }
        this.lotto = lotto;
    }

    private void checkLottoNumberRange(Integer integer) {
        if (integer < 0 || integer > 45) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lotto=" + lotto +
                '}';
    }

    public int match(WinningLotto winningLotto) {
        int matchCount = 0;

        for (Integer integer : lotto) {
            matchCount += winningLotto.contains(integer) ? 1 : 0;
        }

        return matchCount;
    }
}
