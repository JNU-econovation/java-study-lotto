package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AutoLottoTest {

    AutoLotto autoLotto;

    @Test
    public void calculateEarningRate() {
        autoLotto = new AutoLotto();
        autoLotto.setInputMoney(3000);
        autoLotto.buyManualLottoTicket("1, 2, 3, 4, 5, 6");
        autoLotto.setNumberOfWinner("1, 2, 3, 4, 5, 6");
        autoLotto.countMatchNum();

        assertEquals(200000000.0/3000, autoLotto.calculateEarningRate(), 0);
    }
}