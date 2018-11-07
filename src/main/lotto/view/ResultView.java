package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class ResultView {

    public static void printLottoList(List<Lotto> LottoList) {
        System.out.println(LottoList.size() + "개를 구매했습니다.");

        for (Lotto lotto : LottoList) {
            lotto.drawLottoNumber();
        }
    }
}
