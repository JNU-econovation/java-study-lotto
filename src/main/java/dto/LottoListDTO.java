package dto;

import model.Lotto;

import java.util.List;

public class LottoListDTO {
    private List<Lotto> lottoList;
    private int money;

    public LottoListDTO(List<Lotto> lottoList, int money) {
        this.lottoList = lottoList;
        this.money = money;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public int getMoney() {
        return money;
    }
}
