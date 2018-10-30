package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LottoTicketTest {

    LottoTicket lottoTicket;

    @Test
    public void isContain(){
        lottoTicket = new LottoTicket("1, 2, 3, 4, 5, 6, 7");
        assertEquals(true, lottoTicket.isContain(1));
        assertEquals(true, lottoTicket.isContain(2));
        assertEquals(true, lottoTicket.isContain(3));

        assertEquals(false, lottoTicket.isContain(8));
    }

}