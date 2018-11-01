package dto;

import model.Lotto;

import java.util.List;

public class LottoDTO {
    private List<Lotto> lotteries;

    public LottoDTO(List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }

    public int getCount() {
        return lotteries.size();
    }
}
