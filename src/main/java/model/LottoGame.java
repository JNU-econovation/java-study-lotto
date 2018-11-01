package model;

import dto.LottoDTO;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int PRICE = 1000;
    private List<Lotto> lotteries;

    public LottoGame(int money) {
        int count = money / PRICE;
        this.lotteries = buyTickets(count);
        ResultView.printBuyTickets(count);
    }

    public List<Lotto> buyTickets(int count) {
        List<Lotto> lotteries = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lotteries.add(new Lotto());
            System.out.println(lotteries.get(i).getTicket());
        }
        return lotteries;
    }

    public LottoDTO toLottoDTO() {
        return new LottoDTO(lotteries);
    }
}
