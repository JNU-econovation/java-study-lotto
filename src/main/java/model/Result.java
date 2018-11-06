package model;

import utils.SearchElement;
import static utils.Splitor.stringToIntegerArray;

public class Result {
    static final int RANK = 4;
    static final int NUMBER_OF_LOTTO_ELEMENT = 6;
    public static final int[] WINNING_MONEY = {2000000000, 1500000, 50000, 5000};

    public int inputMoney;
    public int myLottos[][];
    public int winningNumbers[];
    public int sameNumberCounter;
    public int myLottoResult[];
    public int rankList[] = new int[RANK];
    public int winningMoney;


    public Result(LottoStore lottoStore, int myLottos[][], String winningString) {
        this.inputMoney = lottoStore.inputMoney;
        this.myLottos = myLottos;
        this.winningNumbers = stringToIntegerArray(winningString);
        this.myLottoResult = new int[myLottos.length];
    }

    public void checkMyLottos() {
        for (int myLottoSeq = 0; myLottoSeq < myLottos.length; myLottoSeq++) {
            checkEachLotto(myLottoSeq);
        }
        for (int myLottoSeq = 0; myLottoSeq < myLottos.length; myLottoSeq++) {
            checkEachRanking(myLottoSeq);
        }
    }

    public void checkEachLotto(int myLottoSeq) {
        SearchElement observer = new SearchElement();
        sameNumberCounter = 0;
        for (int j = 0; j < winningNumbers.length; j++) {
            isTargetHere(observer, myLottoSeq, j);
        }
        myLottoResult[myLottoSeq] = sameNumberCounter;
    }

    public void isTargetHere(SearchElement observer, int index, int j) {
        if (observer.isIntegerElement(myLottos[index], winningNumbers[j])) {
            sameNumberCounter++;
        }
    }

    public void checkEachRanking(int lottoSequence) {
        if (myLottoResult[lottoSequence] == 3) {
            rankList[3]++;
            winningMoney += WINNING_MONEY[3] * rankList[3];
        } else if (myLottoResult[lottoSequence] == 4) {
            rankList[2]++;
            winningMoney += WINNING_MONEY[2] * rankList[2];
        } else if (myLottoResult[lottoSequence] == 5) {
            rankList[1]++;
            winningMoney += WINNING_MONEY[1] * rankList[1];
        } else if (myLottoResult[lottoSequence] == 6) {
            rankList[0]++;
            winningMoney += WINNING_MONEY[0] * rankList[0];
        }
    }

    public double calculateEarningRate() {
        return (double) winningMoney / (double) inputMoney;
    }
}
