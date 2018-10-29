package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LottoTicketTest {

    LottoTicket lottoTicket;

    @Test
    public void checkWinner() {
        int[] numOfWinner = {1, 2, 3, 4, 5, 6};
        lottoTicket = new LottoTicket("1, 2, 3, 4, 5, 6");
        assertEquals(6, lottoTicket.checkWinner(numOfWinner));

        lottoTicket = new LottoTicket("7, 2, 3, 4, 5, 6");
        assertEquals(5, lottoTicket.checkWinner(numOfWinner));

        lottoTicket = new LottoTicket("7, 8, 3, 4, 5, 6");
        assertEquals(4, lottoTicket.checkWinner(numOfWinner));

        lottoTicket = new LottoTicket("7, 8, 9, 4, 5, 6");
        assertEquals(3, lottoTicket.checkWinner(numOfWinner));

        lottoTicket = new LottoTicket("7, 8, 9, 10, 5, 6");
        assertEquals(2, lottoTicket.checkWinner(numOfWinner));

        lottoTicket = new LottoTicket("8, 7, 10, 9, 11, 6");
        assertEquals(1, lottoTicket.checkWinner(numOfWinner));

        lottoTicket = new LottoTicket("11, 9, 13, 7, 10, 45");
        assertEquals(0, lottoTicket.checkWinner(numOfWinner));

    }
}