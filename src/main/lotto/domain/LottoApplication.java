package lotto.domain;

import java.util.*;
import java.util.Comparator;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.ToIntFunction;

public class LottoApplication {
    private int numberOfLotto;
    private int[] allLottoNumbers;
    private int LOTTO_RANGE = 45;
    private float grossProfitRate;
    List<Lotto> Lottos;

    public LottoApplication(int purchaseAmount) {
        numberOfLotto = purchaseAmount / 1000;

        for (int i = 0; i < LOTTO_RANGE; i++) {
            allLottoNumbers[i] = i+1;
        }
    }

    public List<Lotto> startApplication(int numberOfLotto) {
        for (int i = 0; i < numberOfLotto; i++) {
            Lottos.add(buyLotto());
        }
        return Lottos;
    }

    public Lotto buyLotto() {
        Collections.shuffle(Arrays.asList(allLottoNumbers));
//        Collections.sort(allLottoNumbers, new Ascending());
        // Collections.sort() 타입 맞추기
        return new Lotto(allLottoNumbers);
    }


}
