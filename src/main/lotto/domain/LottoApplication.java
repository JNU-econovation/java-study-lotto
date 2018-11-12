package lotto.domain;

import lotto.dto.LottoListDTO;
import lotto.dto.WinningStatisticDTO;
import lotto.util.PrizeMoneyEnum;

import java.util.*;
import java.util.stream.Collectors;

public class LottoApplication {

    private final int LOTTO_RANGE = 45;
    private final int LOTTO_PRICE = 1000;
    private final int LOTTO_ENTRY_COUNT = 6;

    private List<Integer> totalLottoNumber;
    private List<Lotto> LottoList;
    private int[] MatchCount = new int[LOTTO_ENTRY_COUNT+1];

    public PrizeMoneyEnum prizeMoney;

    public LottoApplication() {
        totalLottoNumber = new ArrayList<>();
        LottoList = new ArrayList<>();

        for (int i = 0; i < LOTTO_RANGE; i++) {
            totalLottoNumber.add(i+1);
        }
    }

    public LottoListDTO buyLotto(int purchaseAmount) {
        int numberOfLotto = purchaseAmount / LOTTO_PRICE;
        for (int i = 0; i < numberOfLotto; i++) {
            LottoList.add(generateLotto());
        }
        return new LottoListDTO(LottoList.stream().map(lotto -> lotto.toLottoDTO()).collect(Collectors.toList()));
    }

    public Lotto generateLotto() {
        Collections.shuffle(totalLottoNumber);
        return new Lotto(totalLottoNumber.stream().limit(LOTTO_ENTRY_COUNT).collect(Collectors.toList()));
    }

    public WinningStatisticDTO checkWinning(ArrayList<Integer> winningLotto) {
        return new WinningStatisticDTO(checkWinningLotto(winningLotto), calculateGrossProfitRate());
    }

    public int[] checkWinningLotto(ArrayList<Integer> winningLotto) {
        for (int i = 0; i < LottoList.size(); i++) {
            sortMatches(LottoList.get(i), winningLotto);
        }
        return MatchCount;
    }

    private void sortMatches(Lotto lotto, ArrayList<Integer> winningLotto) {
        switch (lotto.checkMatches(winningLotto)) {
            case 3:
                MatchCount[3]++;
                break;
            case 4:
                MatchCount[4]++;
                break;
            case 5:
                MatchCount[5]++;
                break;
            case 6:
                MatchCount[6]++;
                break;
        }
    }

    public float calculateGrossProfitRate() {
        float grossProfit = 0;
        float purchaseAmount = LOTTO_PRICE * LottoList.size();
        for (int i = 3; i <= 6; i++) {
            String Match_Number = "MATCH_" + Integer.toString(i);
            grossProfit += MatchCount[i] * Integer.parseInt(this.prizeMoney.valueOf(Match_Number).getPrizeMoney());
        }
        return (grossProfit / purchaseAmount) * 100;
    }
}