package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LottoGameTest {

    LottoGame lottoGame;

    @Test
    public void  calculateEarningRate(){
        lottoGame = new LottoGame(3000);
        lottoGame.buyManualLottoTicket("1, 2, 3, 4, 5, 6");
        lottoGame.setNumberOfWinner("1, 2, 3, 4, 5, 6");

        assertEquals(200000000.0/3000, lottoGame.calculateEarningRate(), 0);
    }

    @Test
    public void countMatch(){
        lottoGame = new LottoGame(3000);
        lottoGame.buyManualLottoTicket("1, 2, 3, 4, 5, 6");
        lottoGame.setNumberOfWinner("1, 2, 3, 4, 5, 6");

        assertEquals(6, lottoGame.countMatch(new LottoTicket("1, 2, 3, 4, 5, 6")));
    }
}