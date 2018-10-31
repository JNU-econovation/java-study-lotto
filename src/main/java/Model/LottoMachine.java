package Model;

import Utils.Print;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class LottoMachine {
    public LottoMachine() {
    }

    public LottoMachine(int numberOfOrder) {
        this.numberOfOrder = numberOfOrder;
    }

    List<Integer> lottoNumbers = new ArrayList<>();
    int numberOfOrder;
    static final int MINIMUMLOTTONUMBER = 1;
    static final int MAXIMUMLOTTONUMBER = 45;
    static final int NUMBEROFLOTTOELEMENT = 6;
    int Lottos[][] = null;

    public int[][] printOutLottos() {

        Lottos = new int[numberOfOrder][];

        for (int i = 0; i < numberOfOrder; i++) {
            Lottos[i] = generateLotto();
        }

        for (int i = 0; i < numberOfOrder; i++)
            Print.printIntegerArray(Lottos[i]);

        return Lottos;
    }

    public int[] generateLotto() {

        int[] selectedLottoNumbers = new int[NUMBEROFLOTTOELEMENT];

        for (int i = MINIMUMLOTTONUMBER; i < MAXIMUMLOTTONUMBER; i++) {
            lottoNumbers.add(i);
        }

        Collections.shuffle(lottoNumbers);

        for (int i = 0; i < NUMBEROFLOTTOELEMENT; i++) {
            selectedLottoNumbers[i] = this.lottoNumbers.get(i).intValue();
        }

        Arrays.sort(selectedLottoNumbers);

        return selectedLottoNumbers;
    }

}
