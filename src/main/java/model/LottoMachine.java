package model;

import utils.Print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    static final int MINIMUMLOTTONUMBER = 1;
    static final int MAXIMUMLOTTONUMBER = 45;
    static final int NUMBEROFLOTTOELEMENT = 6;

    List<Integer> lottoNumbers = new ArrayList<>();
    int numberOfOrder;
    int Lottos[][] = null;

    public LottoMachine() {
    }

    public LottoMachine(int numberOfOrder) {
        this.numberOfOrder = numberOfOrder;
    }

    public int[][] printOutLottos() {
        Lottos = new int[numberOfOrder][];
        for (int i = 0; i < numberOfOrder; i++) {
            Lottos[i] = generateLotto();
        }

        for (int i = 0; i < numberOfOrder; i++)
            Print.printIntegerArray(Lottos[i]);

        return Lottos;
    }
    public static void printIntegerArray(int array[]) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print("]\n");
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
