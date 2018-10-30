package model;

import dto.LottoDTO;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<Lottery> lotteries;

    public Lotto(int count) {
        this.lotteries = buyTickets(count);
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
