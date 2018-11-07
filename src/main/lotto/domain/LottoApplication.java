package lotto.domain;

import lotto.dto.LottoResult;

import java.util.*;

public class LottoApplication {

    private int[] allLottoNumbers;
    private final int LOTTO_RANGE = 45;
    private float grossProfitRate;
    List<Lotto> LottoList;
    LottoResult lottoResult;
    HashMap<Integer, Integer> winningStatistic;

    public LottoApplication() {
        lottoResult = new LottoResult();

        allLottoNumbers = new int[LOTTO_RANGE];
        for (int i = 0; i < LOTTO_RANGE; i++) {
            allLottoNumbers[i] = i+1;
        }
    }

    public List<Lotto> enterPurchaseMoney(int purchaseAmount) {
        int numberOfLotto = purchaseAmount / 1000;
        for (int i = 0; i < numberOfLotto; i++) {
            LottoList.add(generateLotto());
        }
        return LottoList;
    }

    public Lotto generateLotto() {
        Collections.shuffle(Arrays.asList(allLottoNumbers));
        return new Lotto(allLottoNumbers);
    }

    public HashMap<Integer, Integer> checkGrossProfitRate(List<Lotto> LottoList, ArrayList<Integer> winningLotto) {
        for (int i = 0; i < LottoList.size(); i++) {
            sortMatches(LottoList.get(i), winningLotto);
        }

        return winningStatistic;
    }

    private void sortMatches(Lotto lotto, ArrayList<Integer> winningLotto) {
        switch (lotto.checkMatches(winningLotto)) {
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }
    }

}