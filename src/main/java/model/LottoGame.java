package model;

import dto.LottoGameDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LottoGame {
    public final static int PRICE = 1000;

    public static List<LottoTicket> lottoTickets = new ArrayList<>();
    public static int numberOfTicket;
    public static int numberOfManualTicket = 0;

    public LottoGame(int inputMoney) {
        numberOfTicket = inputMoney / PRICE;
    }

    public void buyManualLottoTicket(String lottoNumberStrings) {
        StringTokenizer stringTokenizer = new StringTokenizer(lottoNumberStrings, "\n");

        int count = 0;
        while (stringTokenizer.hasMoreTokens()) {
            lottoTickets.add(count, new LottoTicket(stringTokenizer.nextToken()));
            count++;
        }

        numberOfManualTicket = count;
        buyAutoLottoTicket();
    }

    public void buyAutoLottoTicket() {
        int count = numberOfManualTicket;
        while (count < numberOfTicket) {
            lottoTickets.add(new LottoTicket());
            count++;
        }
    }

    public LottoGameDTO toLottoTicketDTO() {
        return new LottoGameDTO(PRICE, numberOfManualTicket, lottoTickets);
    }

}