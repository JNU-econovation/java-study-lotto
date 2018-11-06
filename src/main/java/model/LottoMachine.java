package model;

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
    int lottos[][] = null;

    public LottoMachine() {
    }

    public LottoMachine(int numberOfOrder) {
        this.numberOfOrder = numberOfOrder;
    }



    public int[][] printOutLottos() {
        lottos = new int[numberOfOrder][];
        for (int i = 0; i < numberOfOrder; i++) {
            lottos[i] = generateLotto();
        }

        System.out.println(numberOfOrder+ "개를 구매했습니다.");
        for(int i=0;i< numberOfOrder;i++)
            System.out.println(Arrays.toString(lottos[i]));

        return lottos;
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
