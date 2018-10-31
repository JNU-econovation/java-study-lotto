package Model;

import Utils.SearchElement;
import Utils.Splitor;

public class Result {
    Splitor splitor = new Splitor();

    public Result(LottoStore lottoStore, int myLottos[][], String winningString) {
        this.inputMoney = lottoStore.inputMoney;
        this.myLottos = myLottos;
        this.winningNumbers = splitor.splitStringToIntegerArray(winningString);
        this.myLottoResult = new int[myLottos.length];
    }

    static final int RANK = 4;
    static final int NUMBEROFLOTTOELEMENT = 6;
    static final int[] WINNINGMONEY = {2000000000, 1500000, 50000, 5000};

    public int inputMoney;
    public int myLottos[][];
    public int winningNumbers[];
    public int sameNumberCounter;
    public int myLottoResult[];
    public int rankList[] = new int[RANK];
    public int winningMoney;


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
            ifThereTarget(observer, myLottoSeq, j);
        }
        myLottoResult[myLottoSeq] = sameNumberCounter;
    }

    public void ifThereTarget(SearchElement observer, int index, int j) {
        if (observer.searchIntegerElement(myLottos[index], winningNumbers[j])) {
            sameNumberCounter++;
        }
    }

    public void checkEachRanking(int lottoSequence) {
        if (myLottoResult[lottoSequence] == 3) {//3개맞춘 4등
            rankList[3]++;
            winningMoney += WINNINGMONEY[3] * rankList[3];
        } else if (myLottoResult[lottoSequence] == 4) {//4개맞춘 3등
            rankList[2]++;
            winningMoney += WINNINGMONEY[2] * rankList[2];
        } else if (myLottoResult[lottoSequence] == 5) {//..
            rankList[1]++;
            winningMoney += WINNINGMONEY[1] * rankList[1];
        } else if (myLottoResult[lottoSequence] == 6) {//..
            rankList[0]++;
            winningMoney += WINNINGMONEY[0] * rankList[0];
        }
    }

    public double calculateEarningRate() {
        return (double) winningMoney / (double) inputMoney;
    }
}
