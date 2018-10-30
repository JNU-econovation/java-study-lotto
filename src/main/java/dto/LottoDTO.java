package dto;

import model.Lottery;

import java.util.List;

public class LottoDTO {
    private List<Lottery> lotteries;

    public LottoDTO(List<Lottery> lotteries) {
        this.lotteries = lotteries;
    }

    public List<Lottery> getLotteries() {
        return lotteries;
    }

    public int getCount() {
        return lotteries.size();
    }
}
