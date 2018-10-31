package model;

import dto.LottoDTO;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final int PRICE = 1000;
    private List<Lottery> lotteries;

    public Lotto(int money) {
        int count = money / PRICE;
        this.lotteries = buyTickets(count);
        ResultView.printBuyTickets(count);
    }

    public List<Lottery> buyTickets(int count) {
        List<Lottery> lotteries = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lotteries.add(new Lottery());
            System.out.println(lotteries.get(i).getTicket());
        }
        return lotteries;
    }

    public LottoDTO toLottoDTO() {
        return new LottoDTO(lotteries);
    }
}
